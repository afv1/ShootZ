package proba1;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import javax.swing.ImageIcon;

public class Boss extends Sprite implements Commons
{

    
    private final String zombiImg = "src/images/zombi.png";
    boolean w;
    static double sin, cos;
    static int neww, newh;


    public Boss(int x, int y) 
    {

        initBoss(x, y);
    }

    private void initBoss(int x, int y) {

        this.x = x;
        this.y = y;

        
        ImageIcon ii = new ImageIcon(zombiImg);
        setImage(ii.getImage());
    }

    public void act(int direction) {
        
        this.x += direction;
    }
    
    public static BufferedImage rotate(BufferedImage image, double angle)
    {
    	double tanp = 0, ang = 0;
    	
    	Iterator<Boss> it = Board.bosses.iterator();
    	
    	while (it.hasNext())
    	{      
        	Boss boss = (Boss) it.next();
        	
        	int x = boss.getX();
        	int y = boss.getY();
        	
        	
    	
    	if (x>packet.plx && y>packet.ply)
    		tanp = (packet.ply+P_S/2 - y+P_S/2)/(x+P_S/2 - packet.plx+P_S/2);
    	
    	if (x>packet.plx && y<packet.ply)
    		tanp = (y+P_S/2 - packet.ply+P_S/2)/(x+P_S/2 - packet.plx+P_S/2);
    	
    	if (x<packet.plx && y>packet.ply)
    		tanp = (packet.ply+P_S/2 - y+P_S/2)/(packet.plx+P_S/2 - x+P_S/2);
    	
    	if (x<packet.plx && y<packet.ply)
    		tanp = (y+P_S/2 - packet.ply+P_S/2)/(packet.plx+P_S/2 - x+P_S/2);
    	
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
    	
    	neww = (int)Math.floor(B_S*cos+B_S*sin);
        newh = (int)Math.floor(B_S*cos+B_S*sin);
    	
    	GraphicsConfiguration gc = getDefaultConfiguration();
        BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
        Graphics2D g = result.createGraphics();
        g.translate((neww - B_S) / 2, (newh - B_S) / 2);
        g.rotate(angle, B_S / 2, B_S / 2);
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

