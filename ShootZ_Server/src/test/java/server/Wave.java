package test.java.server;

import java.util.Random;

import test.java.server.Box;
import test.java.server.Game;
import test.java.server.Tick;
import test.java.server.Zombie;
import test.java.server.Commons;

public class Wave implements Commons
{
	public static int iniX, iniY, type;
	public static int zombieCount = 8;
	public static int bossCount = 0;
	static int diffX = MAX_W - MIN_W;
	static int diffY = MAX_H - MIN_H;
	static int fib = 5, buf;
	
	public static void summon()
	{
		while (!Game.gameover) //реализовать спавн по тикам
		{
			buf = zombieCount;
			zombieCount += fib;
			fib = buf;
			bossCount = 0;
			Random random = new Random();
			
			if (Tick.time % 30000 == 0)
			{
				for (int i = 0; i < zombieCount; i++)
	            {
					iniX = random.nextInt(diffX * 2) + 1;
					iniY = random.nextInt(diffY * 2) + 1;
					//X	 первый вариант рандома. Исправлено на фронте.
					if (iniX >= diffX)
					{
						iniX -= diffX;
						Zombie zombie = new Zombie(iniX - diffX, MAX_H, Z_HP);
						Game.zombies.add(zombie);
					}
					else
					{
						//iniX = iniX;
						Zombie zombie = new Zombie(iniX, MIN_H, Z_HP);
						Game.zombies.add(zombie);
					}
			/*		//Y
					if (iniY >= diffY)
					{
						Zombie zombie = new Zombie(MAX_W, iniY - diffY, Z_HP);
						Game.zombies.add(zombie);
					}
					else
					{
						Zombie zombie = new Zombie(MIN_W, iniY, Z_HP);
						Game.zombies.add(zombie);
					}*/
	            }
			}
			
			if (Tick.time % 150000 == 0)
			{
				//ящик
				iniX = random.nextInt(diffX) + 1;
				iniY = random.nextInt(diffY) + 1;
				type = random.nextInt(1) + 1;
				@SuppressWarnings("unused")
				Box box = new Box(iniX, iniY, type);
				
				bossCount++;
				for (int i = 0; i < bossCount; i++)
	            {
					iniX = random.nextInt(diffX * 2) + 1;
					iniY = random.nextInt(diffY * 2) + 1;
					//X
					if (iniX >= diffX)
					{
						Zombie zombie = new Zombie(iniX / 2, MAX_H, P_HP);
						Game.zombies.add(zombie);
					}
					else
					{
						Zombie zombie = new Zombie(iniX, MIN_H, P_HP);
						Game.zombies.add(zombie);
					}
					//Y
					if (iniY >= diffY)
					{
						Zombie zombie = new Zombie(MAX_W, iniY / 2, P_HP);
						Game.zombies.add(zombie);
					}
					else
					{
						Zombie zombie = new Zombie(MIN_W, iniY, P_HP);
						Game.zombies.add(zombie);
					}
	            }
				
				
			}
		}
	}
}
