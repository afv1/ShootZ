package test.java.network;

public interface TCPListener
{
	void onConnect(TCPConnection connection);
	void onGotMsg(TCPConnection connection, String msg);
	void onDisconnect(TCPConnection connection);
	void onException(TCPConnection connection, Exception e);
}
