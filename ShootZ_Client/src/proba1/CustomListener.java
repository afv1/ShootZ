package proba1;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import proba1.Kostil;

public class CustomListener implements MouseListener 
{
	public static double mx;
	public static double my;
	
    public void mouseClicked(MouseEvent e) {
    	Point location = MouseInfo.getPointerInfo().getLocation();
    	//new Kostil();
    	Kostil.mx = location.getX();
    	Kostil.my = location.getY();
    	
    }

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void main()
	{
		while (Kostil.zhp > 0)
	    {
    		
	    for(int iz = Kostil.zx; iz <= Kostil.zx+40; iz++ )
	    {
	    	for(int jz = Kostil.zy; jz <= Kostil.zy+40; jz++)
	    	{
	    		if ((mx == iz) && (my == jz))
	    		{
	    			//mx = location.getX();
	            	//my = location.getY();
	    			Kostil.zhp -= Commons.PM;
	    			Kostil.k += 1;
	    			System.out.println("k:" + Kostil.k);
	    			System.out.println("coords:" + mx + "x" + my);
	    			
	    		}
	    	}
	    }
	    
	    }
		Kostil.zx = 0;
	    Kostil.zy = 0;
	}

}

