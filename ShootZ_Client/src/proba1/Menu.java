package proba1;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.util.Iterator;
import java.util.logging.Handler;

//import proba1.Score;
//import proba1.Board;

@SuppressWarnings("serial")
public class Menu extends JFrame implements Commons, Runnable
{
	//JFrame frame = new JFrame();
	private final String startImg = "src/images/Start1.png";
	public static int butW = 300, butH = 30;
	private final String scoreImg = "src/images/Score1.png";
	public static int cordx1, cordy1, cordx2, cordy2; 
    private Image image1, image2;
    public static String nick;
    static int width = 800, hight = 600;
    public static String schot = " ";
    JTextArea login = new JTextArea();
    static Image playerImg = new ImageIcon("res/chel.PNG").getImage();
    static boolean closeIt = false;
    boolean b =true;
    static boolean f = false;
    
    JButton b1;
	//JButton b2;
    JLabel l;
    static JLabel lo, lu;
    JTextField tf;
    JPanel panel = new JPanel();
   
    
    //eHandler handler = new eHandler();
    
    
    
	 public Menu(boolean b) 
	 {
		 
		 
		 	if (b == true) {
		 	
		 	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        setSize(800, 600);
	        JPanel panel = new JPanel();
			 this.add(panel);
	        setLayout(new FlowLayout());
	        setLocationRelativeTo(null);
	        setVisible(true);
	        //schot = "";
	        
	      //this.setLayout(null);
	        
	        ActionListener actionlistener = new TestActionListener();
	        initMenu();
	        //paint(getGraphics());
	        
	        JButton b1 = new JButton("Start");
	        //b2 = new JButton("Score");
	        
	        l = new JLabel("login");
	        l.setLocation(10,10);
	        
	        tf = new JTextField(10);
	        tf.setLocation(100, 325);
	       
	        panel.add(l);
	        panel.add(tf);
	        b1.addActionListener(actionlistener);
	        panel.add(b1);
	        
	        lu = new JLabel("sdoh Score:");
	        lu.setLocation(100, 300);
	            
	        
	        panel.add(lu);
	        System.out.println("flag: " + Menu.f);
	        lu.setVisible(f);
	        //lo = new JLabel(Integer.toString(Kostil.ochki));
	        
	        lo = new JLabel(" ");
	        lo.setLocation(100, 325);	    
	       
	        panel.add(lo);
	        
	        
	        
		 	}
		 	/*JPanel panel = new JPanel();
			 this.add(panel);
			 
			 panel.setSize(800, 500);
			 panel.setLocation(400, 300);
			 //panel.setLayout(null);
			 lu = new JLabel("sdoh Score:");
		            
		        
		        panel.add(lu);
		        System.out.println("flag: " + Menu.f);
		        lu.setVisible(f);
		        lu.setLocation(100, 300);	
			 lo = new JLabel(" ");
		        lo.setLocation(100, 325);	    
		       
		        panel.add(lo);*/
	        //
	        //int schot;
	     //  this.set
	        //b2.addActionListener(actionlistener);
	        //add(b2);
		 	}
		 	/*else
	        {
	        	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		        setSize(800, 600);
		        setLayout(new FlowLayout());
		        setLocationRelativeTo(null);
		        setVisible(true);
		        
		        ActionListener actionlistener1 = new TestActionListener();
		        initMenu();
		        //paint(getGraphics());
		        
		        b1 = new JButton("Start");
		        //b2 = new JButton("Score");
		        
		        l = new JLabel("ymeeeeeeerrr:((((((((((((((");
		        
		        //tf = new JTextField(10);
		        
		        add(l);
		        //add(tf);
		        b1.addActionListener(actionlistener1);
		        add(b1);
		        lo = new JLabel(schot);
		    	add(lo);
		        
		        
		        //int schot;
	        }*/
	        
	    //}
	 public void paint(Graphics g)
		{
			
			super.paint(g);
			render(g);
			
			//window.getFocusListeners();
			
			
			
			
		}
		private static void render(Graphics g)
		{
			
			
			//g.fillOval(600-20, 325-20, 40, 40);
			//content.repaint();
			//Image scaleImage = playerImg.getScaledInstance(20, 20,Image.SCALE_DEFAULT);
			g.drawImage(playerImg, 1200-20, 650-20, 40, 40, null);
			//g.drawImage(zombiImg, zx, zy, 40, 40, null);
			//if (flag == true)
			//g.drawImage(medImg, dropx, dropy, 30, 30, null);
			//g.drawImage(medImg, getRandomX(1200, 0)+15,  getRandomY(650, 0)+15, 30, 30, null);
			g.setColor(Color.RED);
			g.fillRect(40, 10, 100*2, 10);
			//String str = Integer.toString(hp);
			//String och = Integer.toString(ochki);
			//och = Integer.toString(ochki);
			//g.drawString(str, 10, 20);
			//g.drawString(och, 10, 40);
			
			
			//ochki = 0;
			
			
			
			
			
		}
	 //d bv ds v,nnd vd ,v ,d ,v,d ,vd v,
	 public static void updateScore(String str)
	 {
		 schot = str;
		 Menu.lo.repaint();
		 
		
	        lo.setText(schot);
	        lo.repaint();
	        
	        lo.setVisible(f);
		 
	 }
	
	 
	 /*public void actionPerformed(ActionEvent e)
	 {
		 Kostil.create(1200, 650, "Nu a hule", Color.GRAY.getRGB(), 3);	
		 this.setVisible(false);
		 this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	 }*/
	 public static void TestActionListener()
	 {
		 
	 }
	 
	    /*public void paint(Graphics g) 
	    {
	    	g = (Graphics2D) g;
	    	g.drawImage(playerImg, 300, 400, null);
	    }*/
	 public  void setScore()
	 {
		 lo = new JLabel(schot);
	        add(lo);
	 }
	
private void initMenu() {
	
	
	cordy1 = hight/2 +3 ;
	cordx1 = width/2 - butW/2;
        
        ImageIcon ii1 = new ImageIcon(startImg); 

        butW = ii1.getImage().getWidth(null);
        butH = ii1.getImage().getHeight(null);

        setImage(ii1.getImage());
        
        cordy2 = hight/2 -3 ;
    	cordx2 = width/2 - butW/2;
            
       ImageIcon ii2 = new ImageIcon(startImg); 
            
        butW = ii2.getImage().getWidth(null);
        butH = ii2.getImage().getHeight(null);

        setImage(ii2.getImage());

    }
public void getlogin() 
{
	nick = login.getText();
}

public void drawStart(Graphics g) throws IOException
{
	image1 = ImageIO.read(new File(startImg));
	// устанавливается синий цвет для линий
	//g.setColor(0x0000ff);
	g.fillRect(0, 0, butW, butH);
	//try{
	//Image myimg=Image.createImage("src/images/Scor1.JPG");
	//Image myimg = startImg;
	//Image myimg1 = image1;
	//g.drawImage(image1, 40, 40, this);//}
	//catch(IOException ex){ }
}



public void drawScore(Graphics g) throws IOException
{
	image2 = ImageIO.read(new File(scoreImg));
	// устанавливается синий цвет для линий
	//g.setColor(0x0000ff);
	g.fillRect(0, 0, butW, butH);
	//try{
	//Image myimg=Image.createImage("src/images/Scor1.JPG");
	//Image myimg = startImg;
	//Image myimg2 = image2;
	//g.drawImage(image2, 40, 40, this);//}
	//catch(java.io.IOException ex){ }
}

public void setImage(Image image) 
{
    this.image1 = image;
    this.image2 = image;
}

public static void pressbutton() 
{
	/*if ( Board.mouseX >= cordx1 && Board.mouseX <= cordx1+butW)
	{
		if (Board.mouseY >= cordy2 && Board.mouseY <= cordy1+butH)
			Board board = new Board();
	
		if (Board.mouseX >= cordx2 && Board.mouseX <= cordy2+butW)
			Score score = new Score();
	}*/
}

//public void close() 
//{
	//this.setVisible(false);
	//Menu.class.getClass().
	
//}
@Override
public void run() 
{
	//lo = new JLabel(schot);
	//add(lo);
	//JTextArea textArea = new JTextArea(5, 100);
	//add(textArea);

	//textArea.
	
}




/*public class eHandler implements ActionListener
{
	
	public void menu(String []args)
	{

		
		SwingUtilities.invokeLater(new Runnable()
		{
		    public void run()
		    {
		    	JFrame f = new JFrame("Game");
		    	f.setSize(800, 600);
		        f.add(new Board());
		        f.setVisible(true);
		    }
		});
	ButtonFrame frame= new ButtonFrame();
	frame.setVisible(true);



	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			JFrame f = new JFrame("Game");
	    	f.setSize(800, 600);
	        f.add(new Board());
	        f.setVisible(true);
			new Board();
		}
		if(e.getSource()==b2)
		{
			JFrame f = new JFrame("Game");
	    	f.setSize(800, 600);
	        f.add(new Score());
	        f.setVisible(true);
			new Score();
		}
		
	}

	
}*/
}








	

