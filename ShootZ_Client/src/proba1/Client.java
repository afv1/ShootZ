package proba1;

import java.io.IOException;
import java.net.UnknownHostException;

import test.java.network.TCPConnection;
import test.java.network.TCPListener;

public class Client implements TCPListener
{
	private static final String IP = "localhost";
	private static final int PORT = 8000;
	
	private String login;
	
	public static void main(String[] args)
	{
		
	}
	
	public TCPConnection tcp;
	
	private Client() throws UnknownHostException, IOException
	{
		tcp = new TCPConnection(this, IP, PORT);
		sendLogin(login);
	}
	
	
	@Override
	public void onConnect(TCPConnection tc)
	{
		// TODO Auto-generated method stub
		//Вызвать игру
	}

	@Override
	public void onDisconnect(TCPConnection tc)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(TCPConnection tc, Exception e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGotMsg(TCPConnection tc, String msg)
	{
		// TODO Auto-generated method stub
		
		packet.pack = msg;
	}
	
	private synchronized void sendLogin(String msg)
	{
		tcp.sendMsg(login);
	}
	
}
