package proba1;

import java.util.Iterator;

public class Move extends Sprite implements Commons
{
	
	public static void zm()
	{
	Iterator<Zombi> it = Board.zombis.iterator();
	
	while (it.hasNext())
	{      
    	Zombi zombi = (Zombi) it.next();
    	
    	int x = zombi.getX();
    	int y = zombi.getY();
    	
	
	if (x>packet.plx && y>packet.ply)
	{
		if (packet.ply  - y == x - packet.plx)
		{
			x = x - 2;
			y = y - 2;
		}
		if (packet.ply  - y > x - packet.plx)
		{
			x = x - 1;
			y = y - 2;
		}
		if (packet.ply  - y < x - packet.plx)
		{
			x = x - 2;
			y = y - 1;
		}
	}
	
	if (x>packet.plx && y<packet.ply)
	{
		if (packet.ply  - y == x - packet.plx)
		{
			x = x - 2;
			y = y + 2;
		}
		if (packet.ply  - y > x - packet.plx)
		{
			x = x - 1;
			y = y + 2;
		}
		if (packet.ply  - y < x - packet.plx)
		{
			x = x - 2;
			y = y + 1;
		}
	}
	
	if (x<packet.plx && y>packet.ply)
	{
		if (packet.ply  - y == x - packet.plx)
		{
			x = x + 2;
			y = y - 2;
		}
		if (packet.ply  - y > x - packet.plx)
		{
			x = x + 1;
			y = y - 2;
		}
		if (packet.ply  - y < x - packet.plx)
		{
			x = x + 2;
			y = y - 1;
		}
	}
	
	if (x<packet.plx && y<packet.ply)
	{
		if (packet.ply  - y == x - packet.plx)
		{
			x = x + 2;
			y = y + 2;
		}
		if (packet.ply  - y > x - packet.plx)
		{
			x = x + 1;
			y = y + 2;
		}
		if (packet.ply  - y < x - packet.plx)
		{
			x = x + 2;
			y = y + 1;
		}
	}
	
	if (x == packet.plx && y > packet.ply)
		y = y - Z_SPEED;
	
	if (x == packet.plx && y < packet.ply)
		y = y + Z_SPEED;
	
	if (x > packet.plx && y == packet.ply)
		x = x - Z_SPEED;
	
	if (x < packet.plx && y == packet.ply)
		x = x + Z_SPEED;
		
	}
	}
	public static void bm()
	{
		Iterator<Boss> it = Board.bosses.iterator();
		
		while (it.hasNext())
		{      
	    	Boss boss = (Boss) it.next();
	    	
	    	int x = boss.getX();
	    	int y = boss.getY();
	    	
		
		if (x>packet.plx && y>packet.ply)
		{
			if (packet.ply  - y == x - packet.plx)
			{
				x = x - 1;
				y = y - 1;
			}
			if (packet.ply  - y > x - packet.plx)
			{
				x = x - 1;
				y = y - 2;
			}
			if (packet.ply  - y < x - packet.plx)
			{
				x = x - 2;
				y = y - 1;
			}
		}
		
		if (x>packet.plx && y<packet.ply)
		{
			if (packet.ply  - y == x - packet.plx)
			{
				x = x - 1;
				y = y + 1;
			}
			if (packet.ply  - y > x - packet.plx)
			{
				x = x - 1;
				y = y + 2;
			}
			if (packet.ply  - y < x - packet.plx)
			{
				x = x - 2;
				y = y + 1;
			}
		}
		
		if (x<packet.plx && y>packet.ply)
		{
			if (packet.ply  - y == x - packet.plx)
			{
				x = x + 1;
				y = y - 1;
			}
			if (packet.ply  - y > x - packet.plx)
			{
				x = x + 1;
				y = y - 2;
			}
			if (packet.ply  - y < x - packet.plx)
			{
				x = x + 2;
				y = y - 1;
			}
		}
		
		if (x<packet.plx && y<packet.ply)
		{
			if (packet.ply  - y == x - packet.plx)
			{
				x = x + 1;
				y = y + 1;
			}
			if (packet.ply  - y > x - packet.plx)
			{
				x = x + 1;
				y = y + 2;
			}
			if (packet.ply  - y < x - packet.plx)
			{
				x = x + 2;
				y = y + 1;
			}
		}
		
		if (x == packet.plx && y > packet.ply)
			y = y - B_SPEED;
		
		if (x == packet.plx && y < packet.ply)
			y = y + B_SPEED;
		
		if (x > packet.plx && y == packet.ply)
			x = x - B_SPEED;
		
		if (x < packet.plx && y == packet.ply)
			x = x + B_SPEED;
			
		}
	}
	}
