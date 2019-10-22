package test.java.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

public class TCPConnection
{
	private final Socket socket;
	private final Thread potok;
	private final TCPListener listener;
	private final BufferedReader in;
	private final BufferedWriter out;
	
	public TCPConnection(TCPListener listener, String ip, int port) throws UnknownHostException, IOException
	{
		this(listener, new Socket(ip, port));
	}
	
	public TCPConnection(TCPListener listener, Socket socket) throws IOException
	{
		this.socket = socket;
		this.listener = listener;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream(), Charset.forName("UTF-8")));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), Charset.forName("UTF-8")));
		potok = new Thread(new Runnable() 
		{
			public void run()
			{
				try 
				{
					listener.onConnect(TCPConnection.this);
					while(!potok.isInterrupted())
					{
						listener.onGotMsg(TCPConnection.this, in.readLine());
					}
				}
				catch (IOException e)
				{
					listener.onException(TCPConnection.this, e);
				}
				finally
				{
					listener.onDisconnect(TCPConnection.this);
				}
			}
		});
	}
	
	public synchronized void sendMsg(String msg)
	{
		try
		{
			out.write(msg + "\n");
			out.flush();
		}
		catch (IOException e)
		{
			listener.onException(TCPConnection.this, e);
			disconnect();
		}
	}
	
	public synchronized void disconnect()
	{
		potok.interrupt();
		try
		{
			socket.close();
		}
		catch (IOException e)
		{
			listener.onException(TCPConnection.this, e);
		}
	}
}
