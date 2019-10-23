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
public class Menu1 extends JFrame implements Commons, Runnable
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
    JPanel panel = new JPanel();
    JTextArea login = new JTextArea();
    Image playerImg = new ImageIcon("res/chel.PNG").getImage();
    static boolean closeIt = false;
    boolean b =true;
    JPanel p;
    JButton b1;
	//JButton b2;
    JLabel l;
    JLabel lo;
    JTextField tf;
    //eHandler handler = new eHandler();
    
    
    
	 public Menu1(boolean b) 
	 {
		 	if (b == true) {
		 	
		 	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 	p = new JPanel();
		 	add(p);
	        setSize(800, 600);
	        setLayout(new FlowLayout());
	        setLocationRelativeTo(null);
	        setVisible(true);
	        
	        ActionListener actionlistener = new TestActionListener();
	        initMenu();
	        //paint(getGraphics());
	        
	        p = new JPanel();
	        p.add(l);
	        
	        b1 = new JButton("Start");
	        //b2 = new JButton("Score");
	        
	        l = new JLabel("login");
	        
	        tf = new JTextField(10);
	        
	        add(l);
	        add(tf);
	        b1.addActionListener(actionlistener);
	        add(b1);
	        
	        
	        int schot;
	     //  this.set
	        //b2.addActionListener(actionlistener);
	        //add(b2);
		 	}
		 	else
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
		        
		        
		        int schot;
	        }
	        
	    }
	
	 
	 public void actionPerformed(ActionEvent e)
	 {
		 Kostil.create(1200, 650, "Nu a hule", Color.GRAY.getRGB(), 3);	
		 this.setVisible(false);
		 this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		 p.setVisible(false);
	 }
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








	

