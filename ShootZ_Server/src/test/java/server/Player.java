package test.java.server;

import test.java.server.Actor;
import test.java.server.Commons;

public class Player extends Actor implements Commons
{
	public static boolean isAK;
	public int ammo, akammo, clip;
	
	public Player()
	{
		initPlayer();
	}
	private void initPlayer()
	{
		setX((MAX_W - MIN_W) / 2);
        setY((MAX_H - MIN_H) / 2);
        this.hp = P_HP;
        isAK = false;
        ammo = PM_AMMO;
        akammo = 0;
        clip = 0;
	}
}
