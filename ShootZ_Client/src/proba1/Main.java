package proba1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import proba1.Main;
import proba1.Menu;

public abstract class Main implements Runnable 
{
	private static final long serialVersionUID = 1L;
	static boolean running;

	public void start() 
	{
		running = true;
		new Thread(this).start();
	}
	
	
	private static void update(long delta) {
		// TODO Auto-generated method stub
		
	}
	private static void init() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) 
	{
		JFrame f = new JFrame("Zombiemustdie");
		//f.setSize(800, 600);
		f.setVisible(false);
		//Menu app = new Menu();
		//app.setVisible(true);
		
		 SwingUtilities.invokeLater(new Runnable()
         {
             public void run()
             {
                 new Menu(true);
                 //new Velosiped(true);
                 
                long lastTime = System.currentTimeMillis();
         		long delta;
         		
         		init();
         			
         		while(running) 
         		{
         			delta = System.currentTimeMillis() - lastTime;
         			lastTime = System.currentTimeMillis();	
         			update(delta);
         			//render();
         		}
             }
         });
	}
	

	/*private Main(String[] args) 
	{

	}*/

}
