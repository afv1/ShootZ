package test.java.server;

import test.java.server.Actor;
import test.java.server.Commons;

public class Boss extends Actor implements Commons
{
	public Boss(int x, int y, int hp)
	{
        initBoss(x, y, hp);
    }
	
	private void initBoss(int x, int y, int hp)
	{

        this.x = x;
        this.y = y;
        this.hp = hp;
    }
}
