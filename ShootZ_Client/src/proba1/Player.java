package proba1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import javax.swing.ImageIcon;

public class Player extends Sprite implements Commons 
{
    //private final String playerImg = "src/chel.jpg";
	Image playerImg = new ImageIcon("res/chel.PNG").getImage();
    public static float W, H;
    boolean w;
    static double sin, cos;
    static int hp, neww, newh;
    Player p = new Player();

    public Player() 
    {

        initPlayer();
    }
    

    private void initPlayer() {
        
        ImageIcon ii = new ImageIcon(playerImg); 

        W = ii.getImage().getWidth(null);
        H = ii.getImage().getHeight(null);

        setImage(ii.getImage());
        setX((MAX_W - MIN_W)/2+P_S/2);
        setY((MAX_H - MIN_W)/2+P_S/2);
        setVisible(true);
        //rotate(null, image);
        

    }

    public void act() {
        
        x += dx;
        
        if (x <= 2) {
            x = 2;
        }
        
        if (x >= MAX_W - 2 * P_S) {
            x = MAX_W - 2 * P_S;
        }
        
        y += dy;
        
        if (y <= 2) {
        	y = 2;
        }
        
        if (y >= MAX_H - 2 * P_S) {
        	y = MAX_H - 2 * P_S;
        }
    }

    public void keyPressed(KeyEvent e) 
    {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
        
            dx = -P_SPEED;
        }

        if (key == KeyEvent.VK_RIGHT) {
        
            dx = P_SPEED;
        }
        
        if (key == KeyEvent.VK_UP) {
            
            dy = -P_SPEED;
        }

        if (key == KeyEvent.VK_DOWN) {
        
            dy = P_SPEED;
        }
        if (key == KeyEvent.VK_1)
        {
        	Board.isak = false;
        }
        
        if (key == KeyEvent.VK_2)
        {
        	Board.isak = true;
        }
        
        if (key == KeyEvent.VK_Q)
        {
        	Board.isak = !Board.isak;
        }
    }

    public void keyReleased(KeyEvent e) 
    {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
        
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
        
            dx = 0;
        }
        
        if (key == KeyEvent.VK_UP) {
            
            dx = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
        
            dx = 0;
        }
    }
    public static BufferedImage rotate(BufferedImage image, double angle)
    {
    	double tanp = 0, ang = 0;
    	
    	if (packet.plx>Board.mouseX && packet.ply>Board.mouseY)
    		tanp = (Board.mouseY-packet.ply+P_S/2)/(packet.plx+P_S/2 - Board.mouseX);
    	
    	if (packet.plx>Board.mouseX && packet.ply<Board.mouseY)
    		tanp = (packet.ply+P_S/2 - Board.mouseY)/(packet.plx+P_S/2 - Board.mouseX);
    	
    	if (packet.plx<Board.mouseX && packet.ply>Board.mouseY)
    		tanp = (Board.mouseY - packet.ply+P_S/2)/(Board.mouseX - packet.plx+P_S/2);
    	
    	if (packet.plx<Board.mouseX && packet.ply<Board.mouseY)
    		tanp = (packet.ply+P_S/2 - Board.mouseY)/(Board.mouseX - packet.plx+P_S/2);
    	
    	if (Board.mouseX == packet.plx && Board.mouseY > packet.ply)
    		ang = Math.toDegrees(0);
    	
    	if (Board.mouseX == packet.plx && Board.mouseY < packet.ply)
    		ang = Math.toDegrees(3.1416);
    	
    	if (Board.mouseX > packet.plx && Board.mouseY == packet.ply)
    		ang = Math.toDegrees(1.5708);
    	
    	if (Board.mouseX  < packet.plx && Board.mouseY == packet.ply)
    		ang = Math.toDegrees(4.7124);
    	
    	
    	ang = Math.atan(tanp);
    	sin = Math.abs(Math.sin(ang));
    	cos = Math.abs(Math.cos(ang));
    	
    	neww = (int)Math.floor(W*cos+H*sin);
        newh = (int)Math.floor(H*cos+W*sin);
    	
    	GraphicsConfiguration gc = getDefaultConfiguration();
        BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
        Graphics2D g = result.createGraphics();
        g.translate((neww - W) / 2, (newh - H) / 2);
        g.rotate(angle, W / 2, H / 2);
        //g.drawRenderedImage(image, null);
        g.dispose();
		return image;
    }
    
    private static GraphicsConfiguration getDefaultConfiguration() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return gd.getDefaultConfiguration();
    }
}