package proba1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.WindowConstants;

public abstract class Holst implements Runnable, Commons 
{
	static JLabel l;
	
	private static boolean created	= false;
	private static JFrame window;
	private static Canvas content;
	private static Image playerImg = new ImageIcon("res/chel.PNG").getImage();
	//Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	
	private static BufferedImage buffer;
	private static int[] bufferData;
	private static Graphics bufferGraphics;
	private static int clearColor;
	
	private static BufferStrategy bufferStrategy;
	
	
	public static void create(int width, int height, String title, int _clearColor, int numBuffers)
	{
		if (created)
			return;
		window = new JFrame(title);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content = new Canvas();
		/*{
			public void paint(Graphics g)
			{
				super.paint(g);
				//render(g);
			}
		};*/
		
		Dimension size = new Dimension(width, height);
		content.setPreferredSize(size);
		content.setBackground(Color.GRAY);
		
		window.getContentPane().add(content);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		bufferData = ((DataBufferInt) buffer.getRaster().getDataBuffer()).getData();
		
		bufferGraphics = buffer.getGraphics();
		clearColor = _clearColor;
		
		//content.createBufferStrategy(numBuffers);
		//bufferStrategy = content.getBufferStrategy();
		
		
		
		created = true;
	}
	
	public static void clear()
	{
		Arrays.fill(bufferData, clearColor);
	}
	
	public static void render(Graphics g)
	{
		//content.repaint();
		bufferGraphics.setColor(new Color (0x0000FF));
		bufferGraphics.fillOval(600-20, 325-20, 40, 40);
		l = new JLabel("login");
		window.add(l);
		//Image scaleImage = playerImg.getScaledInstance(20, 20,Image.SCALE_DEFAULT);
		bufferGraphics.drawImage(playerImg, 600-20, 325-20, 40, 40, null);
	}
	
	public static void swapBuffers()
	{
		Graphics g = content.getGraphics();
		//Graphics g = bufferStrategy.getDrawGraphics();
		//content.repaint();
		//bufferGraphics.setColor(new Color (0x0000FF));
		g.drawImage(buffer, 0, 0, 1200, 650, null);
		//bufferGraphics.fillOval(600-20, 325-20, 40, 40);
		l = new JLabel("login");
		window.add(l);
		//bufferGraphics.drawImage(playerImg, 600-20, 325-20, 40, 40, null);
		//bufferStrategy.show();
	}
	
	
	/*public static Graphics2D getGraphics()
	{
		return (Graphics2D) bufferGraphics;
	}
	
	public static void destroy()
	{
		if (!created)
			return;
		window.dispose();
	}*/
}
