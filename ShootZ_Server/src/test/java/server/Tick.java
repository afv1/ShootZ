package test.java.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tick implements ActionListener
{
	public static final int tick = 500;
	public static int time;
	
	public Tick()
	{
		iniTime();
	}
	
	private void iniTime()
	{
		Time();
	}
	
	public void Time()
	{
		time = 0;
	}
	
	public static boolean timer()
	{
		if (time % tick == 0) return true;
		else return false;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		time += tick;
	/*	try
		{
			//Parser.handle();
		} catch (ParserException e1)
		{
			e1.printStackTrace();
		}*/
	}
}
