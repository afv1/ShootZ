package test.java.server;

import test.java.server.Actor;
import test.java.server.Commons;

public class Zombie extends Actor implements Commons
{
	public Zombie(int x, int y, int hp)
	{
        initZombie(x, y, hp);
    }
	
	private void initZombie(int x, int y, int hp)
	{
        this.x = x;
        this.y = y;
        this.hp = hp;
    }
}
