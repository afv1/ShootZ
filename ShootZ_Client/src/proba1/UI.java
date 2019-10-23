package proba1;

import proba1.Board;
import proba1.Commons;
import proba1.packet;

public class UI implements Commons
{
	public String weapon, hp, ammo, clip, score;

	public void UIinit()
	{
		hp = Integer.toString(packet.HP);
		if (Board.isak)
		{
			weapon = "AK";
			ammo = Integer.toString(packet.akm);
			clip = Integer.toString(packet.akt);
		}
		else
			{
				weapon = "PM";
				ammo = Integer.toString(packet.pm);
				clip = "OO";
			}
	}


}
