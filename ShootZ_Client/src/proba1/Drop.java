package proba1;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import javax.swing.ImageIcon;

public class Drop extends Sprite implements Commons
{
    private final String medImg = "res/MED.PNG";
    boolean w;
    static double sin, cos;
    static int neww, newh;


    public Drop(int x1, int y1) 
    {

        initDrop(x1, y1);
    }

    private void initDrop(int x1, int y1) {

        //this.x1 = x1;
        //this.y1 = y1;

        
        ImageIcon ii = new ImageIcon(medImg);
        setImage(ii.getImage());
    }

    public static BufferedImage rotate(BufferedImage image, double angle)
    {
    	double tanp = 0, ang = 0;
    	
    	Iterator<Drop> itd = Kostil.drops.iterator();
    	
    	while (itd.hasNext())
    	{      
        	Drop drop = (Drop) itd.next();
        	
        	int x1 = drop.getX();
        	int y1 = drop.getY();
        	
        	
    	
    	if (x1>packet.plx && y1>packet.ply)
    		tanp = (packet.ply+P_S/2 - y1+P_S/2)/(x1+P_S/2 - packet.plx+P_S/2);
    	
    	if (x1>packet.plx && y1<packet.ply)
    		tanp = (y1+P_S/2 - packet.ply+P_S/2)/(x1+P_S/2 - packet.plx+P_S/2);
    	
    	if (x1<packet.plx && y1>packet.ply)
    		tanp = (packet.ply+P_S/2 - y1+P_S/2)/(packet.plx+P_S/2 - x1+P_S/2);
    	
    	if (x1<packet.plx && y1<packet.ply)
    		tanp = (y1+P_S/2 - packet.ply+P_S/2)/(packet.plx+P_S/2 - x1+P_S/2);
    	
    	if (x1 == packet.plx && y1 > packet.ply)
    		ang = Math.toDegrees(0);
    	
    	if (x1 == packet.plx && y1 < packet.ply)
    		ang = Math.toDegrees(3.1416);
    	
    	if (x1 > packet.plx && y1 == packet.ply)
    		ang = Math.toDegrees(1.5708);
    	
    	if (x1 < packet.plx && y1 == packet.ply)
    		ang = Math.toDegrees(4.7124);
    	
    	
    	ang = Math.atan(tanp);
    	sin = Math.abs(Math.sin(ang));
    	cos = Math.abs(Math.cos(ang));
    	
    	neww = (int)Math.floor(P_S*cos+P_S*sin);
        newh = (int)Math.floor(P_S*cos+P_S*sin);
    	
    	GraphicsConfiguration gc = getDefaultConfiguration();
        BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
        Graphics2D g = result.createGraphics();
        g.translate((neww - P_S) / 2, (newh - P_S) / 2);
        g.rotate(angle, P_S / 2,P_S / 2);
        g.drawRenderedImage(image, null);
        g.dispose();
    }
		return image;
}
    private static GraphicsConfiguration getDefaultConfiguration() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return gd.getDefaultConfiguration();
    }
    
}

