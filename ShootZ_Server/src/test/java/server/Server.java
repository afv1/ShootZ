package test.java.server;

//import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import test.java.network.TCPConnection;
import test.java.network.TCPListener;

public class Server implements TCPListener
{
	static String packet, login;
	static Socket cl;
	
	//MySQLClient client = new MySQLClient("login", "password", "dbName");
	
	public static void main(String[] args)
	{
		new Server();
	}
	
	private Server()
	{
		System.out.println("[Server] running...");
		try (ServerSocket server = new ServerSocket(8000))
		{
			while (true)
			{
				try
				{
					new TCPConnection(this, server.accept());
				}
				catch (IOException e)
				{
					System.out.println("TCPConnection exception > " + e);
				}
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public synchronized void onConnect(TCPConnection tcp)
	{
		@SuppressWarnings("unused")
		Game game = new Game(tcp);
	}

	@Override
	public synchronized void onDisconnect(TCPConnection tcp)
	{
		Game.gameOver();
	}

	@Override
	public synchronized void onException(TCPConnection tcp, Exception e)
	{
		System.out.println("TCPConnection exception > " + e);
		
		Game.gameOver();
	}

	@Override
	public synchronized void onGotMsg(TCPConnection tcp, String str)
	{
		Packet.parseFrom(str);
	}
}
