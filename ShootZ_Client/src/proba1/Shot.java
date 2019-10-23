package proba1;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import javax.swing.ImageIcon;

public class Shot extends Sprite implements Commons 
{

	public static Image newImg;
    private final String shotImg = "res/chel.PNG";
    private final int H_SHOT = 4;
    private final int W_SHOT = 3;
    boolean w;
    static double sin, cos;
    static int neww, newh;


    public Shot() {
    }

    public Shot(int x, int y) {

        initShot(x, y);
    }

    private void initShot(int x, int y) {

        ImageIcon ii = new ImageIcon(shotImg); 
        setImage(ii.getImage());
        
        setX(packet.plx+ P_S/2 + W_SHOT);
        setY(packet.ply+ P_S/2 + H_SHOT);
    }
    public static BufferedImage rotate(BufferedImage image, double angle)
    {
    	double tanp = 0, ang = 0;
    	
    	Iterator<Shot> it = Board.shots.iterator();
    	
    	while (it.hasNext())
    	{      
        	Shot shot = (Shot) it.next();
        	
        	int x = shot.getX();
        	int y = shot.getY();
    	
    	if (packet.plx>Board.mouseX && packet.ply>Board.mouseY)
    		tanp = (Board.mouseY-packet.ply+P_S/2)/(packet.plx+P_S/2 - Board.mouseX);
    	
    	if (packet.plx>Board.mouseX && packet.ply<Board.mouseY)
    		tanp = (packet.ply+P_S/2 - Board.mouseY)/(packet.plx+P_S/2 - Board.mouseX);
    	
    	if (packet.plx<Board.mouseX && packet.ply>Board.mouseY)
    		tanp = (Board.mouseY - packet.ply+P_S/2)/(Board.mouseX - packet.plx+P_S/2);
    	
    	if (packet.plx<Board.mouseX && packet.ply<Board.mouseY)
    		tanp = (packet.ply+P_S/2 - Board.mouseY)/(Board.mouseX - packet.plx+P_S/2);
    	
    	if (x == packet.plx && y > packet.ply)
    		ang = Math.toDegrees(0);
    	
    	if (x == packet.plx && y < packet.ply)
    		ang = Math.toDegrees(3.1416);
    	
    	if (x > packet.plx && y == packet.ply)
    		ang = Math.toDegrees(1.5708);
    	
    	if (x < packet.plx && y == packet.ply)
    		ang = Math.toDegrees(4.7124);
    	
    	
    	ang = Math.atan(tanp);
    	sin = Math.abs(Math.sin(ang));
    	cos = Math.abs(Math.cos(ang));
    	
    	neww = (int)Math.floor(P_S * cos + P_S * sin);
        newh = (int)Math.floor(P_S * cos + P_S * sin);
    	
    	GraphicsConfiguration gc = getDefaultConfiguration();
        BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
        Graphics2D g = result.createGraphics();
        g.translate((neww - P_S) / 2, (newh - P_S) / 2);
        g.rotate(angle, P_S / 2, P_S / 2);
        g.drawRenderedImage(image, null);
        g.dispose();
        newImg = image;
    	}
		return image;
    }
    private static GraphicsConfiguration getDefaultConfiguration() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return gd.getDefaultConfiguration();
    }
    
}
