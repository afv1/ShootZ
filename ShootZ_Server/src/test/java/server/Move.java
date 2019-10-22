package test.java.server;

import java.util.Iterator;

import test.java.server.Boss;
import test.java.server.Game;
import test.java.server.Packet;
import test.java.server.Shoot;
import test.java.server.Tick;
import test.java.server.Zombie;

public class Move implements Commons
{
	public static void move(int x, int y)
	{
		if (x > 0 && Game.player.x < MAX_W - P_S)	Game.player.x += P_SPEED;
		if (x < 0 && Game.player.x < MIN_H) 		Game.player.x -= P_SPEED;
		if (x == 0) 								Game.player.x += 0;
		
		if (y > 0 && Game.player.y < MAX_H - P_S) 	Game.player.y += P_SPEED;
		if (y < 0 && Game.player.y > MIN_H) 		Game.player.y -= P_SPEED;
		if (y == 0) 								Game.player.y += 0;
		
		if (x == 0 && y == 0) 						stop();
	}
	
	public static void stop()
	{
		Game.player.x += 0;
		Game.player.y += 0;
	}
	
	public static void shoot() //нормально реализовать проверку столкновения с зомби/боссами
	{
		if (Packet.mkL)
        {               
            if (!Game.gameover)
            {
            	Iterator<Shoot> it = Game.shoots.iterator();
            	int i = 0;
            	
            	while (it.hasNext())
            	{
            		Shoot shoot = new Shoot(Packet.kX[i], Packet.kY[i]);
					Game.shoots.add(shoot);
					i++;
            	}
            }
        }
	}
	
	public static void movePredict(int x, int y)
	{
		if (Tick.timer())
		{
			move(x, y);
			shoot();
		}
	}
	
	public static void zombieMove()   //движение зомби в сторону игрока
	{
		while (!Game.gameover)
		{
			Iterator<Zombie> it = Game.zombies.iterator();
		
			while (it.hasNext())
			{
				if (it.next().x > Game.player.x && it.next().y > Game.player.y)
				{
					if (Game.player.y - it.next().y == it.next().x - Game.player.x)
					{
						it.next().x += -2;
						it.next().y += -2;
					}
					if (Game.player.y - it.next().y > it.next().x - Game.player.x)
					{
						it.next().x += -1;
						it.next().y += -2;
					}
					if (Game.player.y - it.next().y < it.next().x - Game.player.x)
					{
						it.next().x += -2;
						it.next().y += -1;
					}
				}
				
				if (it.next().x > Game.player.x && it.next().y < Game.player.y)
				{
					if (Game.player.y - it.next().y == it.next().x - Game.player.x)
					{
						it.next().x += -2;
						it.next().y += 2;
					}
					if (Game.player.y - it.next().y > it.next().x - Game.player.x)
					{
						it.next().x += -1;
						it.next().y += 2;
					}
					if (Game.player.y - it.next().y < it.next().x - Game.player.x)
					{
						it.next().x += -2;
						it.next().y += 1;
					}
				}
		    	
				if (it.next().x < Game.player.x && it.next().y < Game.player.y)
				{
					if (Game.player.y - it.next().y == it.next().x - Game.player.x)
					{
						it.next().x += 2;
						it.next().y += 2;
					}
					if (Game.player.y - it.next().y > it.next().x - Game.player.x)
					{
						it.next().x += 1;
						it.next().y += 2;
					}
					if (Game.player.y - it.next().y < it.next().x - Game.player.x)
					{
						it.next().x += 2;
						it.next().y += 1;
					}
				}
				
				if (it.next().x == Game.player.x && it.next().y > Game.player.y) it.next().y -= Z_SPEED;
				if (it.next().x == Game.player.x && it.next().y > Game.player.y) it.next().y += Z_SPEED;
				if (it.next().x > Game.player.x && it.next().y == Game.player.y) it.next().y -= Z_SPEED;
				if (it.next().x < Game.player.x && it.next().y == Game.player.y) it.next().y += Z_SPEED;
			}
		}
	}
	
	public static void bossMove()   //движение босса в сторону игрока
	{
		while (!Game.gameover)
		{
			Iterator<Boss> it = Game.bosses.iterator();
		
			while (it.hasNext())
			{
				if (it.next().x > Game.player.x && it.next().y > Game.player.y)
				{
					if (Game.player.y - it.next().y == it.next().x - Game.player.x)
					{
						it.next().x += -2;
						it.next().y += -2;
					}
					if (Game.player.y - it.next().y > it.next().x - Game.player.x)
					{
						it.next().x += -1;
						it.next().y += -2;
					}
					if (Game.player.y - it.next().y < it.next().x - Game.player.x)
					{
						it.next().x += -2;
						it.next().y += -1;
					}
				}
				
				if (it.next().x > Game.player.x && it.next().y < Game.player.y)
				{
					if (Game.player.y - it.next().y == it.next().x - Game.player.x)
					{
						it.next().x += -2;
						it.next().y += 2;
					}
					if (Game.player.y - it.next().y > it.next().x - Game.player.x)
					{
						it.next().x += -1;
						it.next().y += 2;
					}
					if (Game.player.y - it.next().y < it.next().x - Game.player.x)
					{
						it.next().x += -2;
						it.next().y += 1;
					}
				}
		    	
				if (it.next().x < Game.player.x && it.next().y < Game.player.y)
				{
					if (Game.player.y - it.next().y == it.next().x - Game.player.x)
					{
						it.next().x += 2;
						it.next().y += 2;
					}
					if (Game.player.y - it.next().y > it.next().x - Game.player.x)
					{
						it.next().x += 1;
						it.next().y += 2;
					}
					if (Game.player.y - it.next().y < it.next().x - Game.player.x)
					{
						it.next().x += 2;
						it.next().y += 1;
					}
				}
				
				if (it.next().x == Game.player.x && it.next().y > Game.player.y) it.next().y -= Z_SPEED;
				if (it.next().x == Game.player.x && it.next().y > Game.player.y) it.next().y += Z_SPEED;
				if (it.next().x > Game.player.x && it.next().y == Game.player.y) it.next().y -= Z_SPEED;
				if (it.next().x < Game.player.x && it.next().y == Game.player.y) it.next().y += Z_SPEED;
			}
		}
	}
}
