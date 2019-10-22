package test.java.server;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;

import test.java.server.Boss;
import test.java.server.Move;
import test.java.server.Packet;
import test.java.server.Player;
import test.java.server.Shoot;
import test.java.server.Tick;
import test.java.server.Wave;
import test.java.server.Zombie;

import test.java.network.TCPConnection;

public class Game implements Commons
{
	static TCPConnection gameTCP; 
	public static Timer timer = new Timer(500, new Tick());
	public static int ticks;

	static ArrayList<Zombie> zombies;
	static ArrayList<Boss> bosses;
	static ArrayList<Shoot> shoots;
    static Player player;
    static Shoot shoot;
    static boolean gameover, prediction;
    static int score = 0;
    
    public Game(TCPConnection tcp)
	{
        initGame();
        gameTCP = tcp;
    }
	
	private void initGame()
	{
		gameover = false;
		player = new Player();
        zombies = new ArrayList<>();
        bosses = new ArrayList<>();
        shoots = new ArrayList<>();
        timer.start();
        ticks = 0;
        
        //gameTCP.sendMsg(Packet.parseTo());

        //GameCycle();
        run();
    }
	
	public static void gameOver()
	{
		gameover = true;
		timer.stop();
		ticks = 0;
		gameTCP.sendMsg("loser " + score);
		gameTCP.disconnect();
		//Сделать запись в БД (логин + очки) //нет смысла логировать в бд!
    }
	
	public static void GameCycle()
	{
		while (player.hp > 0)
		{
			gameTCP.sendMsg(Packet.parseTo());
			
			if (Tick.timer()) 
			{
				Move.zombieMove();
				Move.bossMove();
				Wave.summon();
				
	        	//shoot

	        	if (true)
	        	{
	        		
	            	
	            	
	            	for (int i = 0; i < Packet.spX; i++)
	            	{
	            		int shotX = Packet.kX[i];
	            		for (int j = 0; j < Packet.spY; j++)
	            		{
	            			int shotY = shoot.getY();

	            	for (Zombie zombie: zombies)
	            	{
	                	int zombieX = zombie.getX();
	                	int zombieY = zombie.getY();

	                	if (zombie.isVisible()) //тут описать траекторию полёта пули и проверку на столкновение с зомби (воpможно, нужен отдельный класс)
	                	{
	                    	if (shotX >= (zombieX) && shotX <= (zombieX + P_S) && shotY >= (zombieY) && shotY <= (zombieY + P_S))
	                    	{
	                        	score++;
	                        	shoot.die();
	                        	while (zombie.hp > 0)
	                        	{
	                        		if (Packet.isAK) zombie.hp -= AK_DMG;
	                        		else zombie.hp -= PM_DMG;
	                        	}
	                        	zombie.die();
	                    	}
	                	}
	            	}
	            	
	            	gameTCP.sendMsg(Packet.parseTo());
	            	
	            	for (Boss boss: bosses)
	            	{
	                	int zombieX = boss.getX();
	                	int zombieY = boss.getY();

	                	if (boss.isVisible()) //тут описать траекторию полёта пули и проверку на столкновение с зомби (вохможно, нужен отдельный класс)
	                	{
	                    	if (shotX >= (zombieX) && shotX <= (zombieX + P_S) && shotY >= (zombieY) && shotY <= (zombieY + P_S))
	                    	{
	                        	score++;
	                        	shoot.die();
	                        	while (boss.hp > 0)
	                        	{
	                        		if (Packet.isAK) boss.hp -= AK_DMG;
	                        		else boss.hp -= PM_DMG;
	                        	}
	                        	boss.die();
	                    	}
	                	}
	            	}
	        	}
	        	}}
	        	
	        	gameTCP.sendMsg(Packet.parseTo());

	        	//zombie dmg
	        	Iterator<Zombie> it = zombies.iterator();

	        	while (it.hasNext())
	        	{      
	            	Zombie zombie = (Zombie) it.next();
	            	Move.zombieMove();
	            	
	            	if (zombie.isVisible() && player.hp > 0)
	            	{
	            		int x = zombie.getX() - 1;
	                	int y = zombie.getY() - 1;
	                	int xs = zombie.getX() + P_S + 1;
	                	int ys = zombie.getY() + P_S + 1;

	                	if ((xs == player.getX() || x == player.getX() + P_S) || (ys == player.getY() + P_S || y == player.getY())) //столкновение с игроком!
	                	{
	                		while (player.hp > 0)
	                		{
	                			player.hp -= Z_DMG;
	                		}
	                    	gameOver();
	                	}
	            	}
	        	}
	        	gameTCP.sendMsg(Packet.parseTo());
	        	
	        	
	        	//boss dmg
	        	Iterator<Boss> it1 = bosses.iterator();

	        	while (it.hasNext())
	        	{      
	            	Boss boss = (Boss) it1.next();
	            	Move.bossMove();
	            	
	            	if (boss.isVisible() && player.hp > 0)
	            	{
	            		int x = boss.getX() - 1;
	                	int y = boss.getY() - 1;
	                	int xs = boss.getX() + P_S + 1;
	                	int ys = boss.getY() + P_S + 1;

	                	if ((xs == player.getX() || x == player.getX() + P_S) || (ys == player.getY() + P_S || y == player.getY())) //столкновение с игроком!
	                	{
	                		while (player.hp > 0)
	                		{
	                			player.hp -= B_DMG;
	                		}
	                    	gameOver();
	                	}
	            	}
	        	}
	        	
	        	gameTCP.sendMsg(Packet.parseTo());
			}
		}
		gameOver();
    }
	
	public static void run()
	{
		while (true)
		{
			GameCycle();
		    Wave.summon();
		}
		
	}
}
