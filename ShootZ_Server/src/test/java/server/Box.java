package test.java.server;

import test.java.server.Actor;
import test.java.server.Commons;

public class Box extends Actor implements Commons
{
	public Box(int x, int y, int hp)
	{
		initBox(x, y, hp);
	}
	
	private void initBox(int x, int y, int hp)
	{
		this.x = x;
        this.y = y;
        this.hp = hp;
	}
}
