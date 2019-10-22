package test.java.server;

import java.util.Iterator;

//import java.net.Socket;
//import java.util.Iterator;

//import test.java.network.TCPConnection;

public class Packet implements Commons
{
	//private Socket socket;
	static String oar;
	public static boolean predict, isntLost;
	
	//public static Message msg;
	public static boolean mU, mD, mR, mL, mkR, mkL, isAK;
	public static int[] kX, kY;
	public static String login, spr;
	public static int shots;
	
	static String[] par, sub, spray;
	static String sprX, sprY;
	static StringBuffer strbuf;
	static int x, y, spX, spY;
/*	
	public Packet(String msg)
	{
		parseFrom(msg);
	}*/
	
	public static void parseFrom(String str)
	{
		par = str.split(":");
		
		if(par[0].equalsIgnoreCase("move")) //схема: move:right/left/nox_up/down/noy_ak/pm/current
		{
			sub = par[1].split(" ");
			
			if (sub[0].equalsIgnoreCase("right")) x = 1;
			if (sub[0].equalsIgnoreCase("left")) x = -1;
			if (sub[0].equalsIgnoreCase("nox")) x = 0;
			if (sub[1].equalsIgnoreCase("up")) y = 1;
			if (sub[1].equalsIgnoreCase("down")) y = -1;
			if (sub[1].equalsIgnoreCase("noy")) y = 0;
			if (sub[2].equalsIgnoreCase("ak")) isAK = true;
			if (sub[2].equalsIgnoreCase("pm")) isAK = false;
			
			//Move.movePredict(x, y);
		}
		if(par[3].equalsIgnoreCase("spray"))
		{
			sub = par[3].split(" ");
			sprX = sub[0];
			spray = sprX.split(",");
	    	for (int i = 0; i < spray.length; i++)
	    	{
	    		kX[i] = Integer.parseInt(spray[i]);
	    	}
	    	spX = spray.length;
	    	sprY = sub[1];
	    	spray = sprY.split(",");
	    	for (int i = 0; i < spray.length; i++)
	    	{
	    		kY[i] = Integer.parseInt(spray[i]);
	    	}
	    	spY = spray.length;
		}
	}
	
	public static String parseTo()
	{
		//Отправлять сообщения только если произошло какое-либо действие на сервере (убит замби или игрок, появился ящик, закончились патроны)
		
		while (!Game.gameover)
    	{
	    	strbuf.append(Game.player.x + " ");
	    	strbuf.append(Game.player.y + " ");
	    	strbuf.append(Game.shoot.x + " ");
	    	strbuf.append(Game.shoot.y + " ");
	    	strbuf.append(Game.player.hp + " ");
	    	strbuf.append(Game.player.ammo + " ");
	    	strbuf.append(Game.player.akammo + " ");
	    	strbuf.append(Game.player.clip + " ");
	    	strbuf.append(Game.score + " ");
	    	
	    	Iterator<Zombie> it = Game.zombies.iterator();
	    	Iterator<Boss> it1 = Game.bosses.iterator();
	    	
	    	while (it.hasNext()) strbuf.append(Integer.toString(it.next().x) + ",");
	    	while (it.hasNext()) strbuf.append(Integer.toString(it.next().y) + ",");
	    	while (it.hasNext()) strbuf.append(Integer.toString(it.next().hp) + ",");
	    	strbuf.append(" ");
	    	while (it1.hasNext()) strbuf.append(Integer.toString(it1.next().x) + ",");
	    	while (it1.hasNext()) strbuf.append(Integer.toString(it1.next().y) + ",");
	    	while (it1.hasNext()) strbuf.append(Integer.toString(it1.next().hp) + ",");
	    	
	    	oar = strbuf.toString();
    	}
		return oar;
	}
}
