package proba1;

import java.util.Arrays;

import javax.swing.JComponent;

public class Input extends JComponent
{
	private boolean[] map;
	
	public boolean[] getMap()
	{
		return Arrays.copyOf(map, map.length);
		
	}
	
	public Input()
	{
		int j;
		map = new boolean[256];
		
		/*for (j = 0, j < map.length, j++)
		{
			
		}*/
	}
	

	
	public boolean getKey(int keyCode)
	{
		return map[keyCode];
	}
}
