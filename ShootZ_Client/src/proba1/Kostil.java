package proba1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
//import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
//import java.util.Random;


import static java.awt.GraphicsDevice.WindowTranslucency.*;

import java.awt.BorderLayout;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import proba1.packet;
import proba1.Move;
import proba1.CustomListener;

@SuppressWarnings("serial")
public class Kostil extends JPanel implements Runnable, Commons
{

	private static Image playerImg = new ImageIcon("res/chel1.PNG").getImage();
	private static Image zombiImg = new ImageIcon("res/chel.PNG").getImage();
	private static Image medImg = new ImageIcon("res/MED.PNG").getImage();
	static int mouseX = 0, mouseY = 0;
	public static double mx, my;
    private Dimension d;
    
    static //gvjmn m m
    public String och;
    //vgv n  n
    
    static boolean b = true, flag = true, flagz = true;
    static int it, ochki, k = 0, s = 0;
    static int zx = 0, zy = 0;
    static int dropx = getRandomX(1200, 0), dropy = getRandomX(650, 0);
    static int dx = 600, dy = 325;
    static int hp = P_HP, zhp = Z_HP, oh;
    static ArrayList<Zombi> zombis;
    static ArrayList<Boss> bosses;
    static ArrayList<Drop> drops;
	static ArrayList<Shot> shots;
    static Player player;
    static Shot shot;
    static boolean gameover, prediction;
    static int score = 0;
    
    
    //iz velosiped
	private static boolean created	= false;
	private static JFrame window, frame;
	private static JPanel panel;
	private static JLabel ln;
	private static Canvas content;
    //end iz velosiped
    
	
    public static boolean ingame = true, isak = false;
    private final String explImg = "src/images/explosion.png"; //!!!
    private String message = "Game Over";
    
    static Paint p;
    static String text = "Test width text";

    private Thread animator;
    
    Timer t = new Timer(1000/60, new AbstractAction()
    {
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
		}
    });


    public Kostil() 
    {
        initKostil();
        run();
        //bdscbdvcds c
        //ochki = 0;

        //dscjd c,d s,
    }
    public static int getRandomX(int minx, int maxx)
    {
        double dropx = (Math.random()*((maxx-minx)+15))+minx;
        return (int) dropx;
    }
    public static int getRandomY(int miny, int maxy)
    {
    	double dropy = (Math.random()*((maxy-miny)+15))+miny;
        return (int) dropy;
    }
    //iz velosiped
    public static void create(int width, int height, String title, int _clearColor, int numBuffers)
	{
		if (created)
			return;
		
		window = new JFrame(title);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel ln = new JLabel("Jopta");
		window.add(ln);
		
		
		
		
		content = new Canvas()
		{
			
			
			public void paint(Graphics g)
			{
				
				super.paint(g);
				render(g);
				
				window.getFocusListeners();
				
				
				
				
			}
			
		};
		content.setVisible(true);
		content.setFocusable(true);
		content.isDisplayable();
		content.requestFocusInWindow();
		//this.add( panel );
		

		/*JPanel panel = new JPanel( new BorderLayout());
		{
			
			panel.setOpaque(false);
			panel.setVisible(true);
			ln = new JLabel("Jopta");
			panel.add(ln);
			ln.setVisible(true);
			}*/
		
		//Kostil kost = new Kostil();
		//kost.setOpacity(0.55f);
		//kost.setVisible(true);
		
		
		Dimension size = new Dimension(width, height);
		content.setPreferredSize(size);
		content.setBackground(Color.GRAY);
		
		
		Thread zombieThread = new Thread()
		{
        	public void run()
        	{
        		content.addMouseListener(new MouseAdapter()
        		{
        	public void mouseClicked(MouseEvent e) 
        	{
            	Point location = MouseInfo.getPointerInfo().getLocation();
            	//mx = location.getX();
            	//my = location.getY();
            	//Point p = new Point(e.getPoint());
            	//e.getXOnScreen();
                //System.out.println("Component coords: x = " + p.x + ", y = " + p.y);
                //SwingUtilities.convertPointToScreen(p, MouseScreenCoords.this);
                //System.out.println("Screen coords: x = " + p.x + ", y = " + p.y);
            	 mx = e.getX();
            	 my = e.getY();
        	 
        	   //  for(int iz = zx; iz <= 40; iz++ )
        	  
        	   // {
        	    	//for(int jz = zy; jz <= 40; jz++)
        	    	//{
            	 
        	    		if ((mx >= zx-126 && mx <= zx+86) && (my >= zy-126 && my <= zy+86))
        	    		{
        	    			//mx = location.getX();
        	            	//my = location.getY();
        	            	
        	    			zhp -= PM;
        	    			k += 1;
        	    			ochki += 1;
	            			
        	    			System.out.println("k:" + k);
        	    			System.out.println("coords:" + mx + "x" + my);
        	    			
        	    		}
            	 if (k % 5 == 0)
            	 {
            		 //zx = 0;
            		 //zy = 0;
            		 s += 1;
            		// Menu.schot = Integer.toString(s);
         			Menu.lo.setVisible(true);
         			///uchsouahcoacnlanc
         			zx = /*random.nextInt(diffX * 2) + 1;*/ getRandomX(1200*2, 0);
					zy = /*random.nextInt(diffY * 2) + 1;*/ getRandomY(650*2, 0);
					//X
					if (zx != 0 || zx != 1200)
					{
					if (zx >= 1200)
					{
						//Zombie zombie = new Zombie(iniX / 2, MAX_H, Z_HP);
						zx = zx-1200;
						zy = 650-20;
						//Game.zombies.add(zombie);
					}
					else
					{
						//Zombie zombie = new Zombie(iniX, MIN_H, Z_HP);
						zx = zx;
						zy = 20;
						//Game.zombies.add(zombie);
					}}
					//Y
					else
					if (zy >= 650)
					{
						//Zombie zombie = new Zombie(MAX_W, iniY / 2, Z_HP);
						zy = zy-650;
						zx = 1200-20;
						//Game.zombies.add(zombie);
					}
					else
					{
						//Zombie zombie = new Zombie(MIN_W, iniY, Z_HP);
						zy = zy;
						zx = 20;
						//Game.zombies.add(zombie);
					}
         			///da cjcjancljl
            	 }
        	    	//}
        	  //  }
            	//System.out.println("-------->coords:" + e.getXOnScreen() + "x" + e.getYOnScreen() + "    " + k + "  ZX x ZY" + zx + " x " + zy + " mx&my: " + mx + " x " + my);
            	
            }
        	
        		});
        		
        		
        		
        		//int x1 = dropx + 15;
            	//int y1 = dropy + 15;
        		/*while (Kostil.zhp > 0)
        	    {
        	    for(int iz = zx; iz <= zx+40; iz++ )
        	    {
        	    	for(int jz = zy; jz <= zy+40; jz++)
        	    	{
        	    		if ((mx == iz) && (my == jz))
        	    		{
        	    			Kostil.zhp -= PM;
        	    			k += 1;
        	    			System.out.println("k:" + k);
        	    			//System.out.println("coords:" + mx + "x" + my);
        	    			
        	    		}
        	    	}
        	    }
        	    
        	    }
        		zx = 0;
        	    zy = 0;*/
        	    //content.repaint();
        	    /*if(zhp == 0)
        	    	flagz = false;*/
        	   
        	    //hsabcsca cscl lca s
        		
        		//zdes byl whil
        	 // Execute one update step
        		
        		while (hp>0)
        			
            	{
        	//hbs d,v ds,
	        
	        	if (zx<dx-20 && zy<dy-20)
	        	{
	        		/*if (dy - zy == dx - zx)
	        		{*/
	        			zx = zx + 1;
	        			zy = zy + 1;
	        		/*}
	        		if (dy - zy < dx - zx)
	        		{
	        			zx = zx + 2;
	        			zy = zy + 1;
	        		}
	        		if (dy  - zy > dx - zx)
	        		{
	        			zx = zx + 2;
	        			zy = zy + 1;
	        		}*/
	        	}
	        	if (zx>dx-20 && zy>dy-20)
	        	{
	        		/*if (dy  - zy == dx - zx)
	        		{*/
	        			zx = zx - 1;
	        			zy = zy - 1;
	        		/*}
	        		if (dy  - zy < dx - zx)
	        		{
	        			zx = zx - 1;
	        			zy = zy - 2;
	        		}
	        		if (dy  - zy > dx - zx)
	        		{
	        			zx = zx - 2;
	        			zy = zy - 1;
	        		}*/
	        	}
	        	
	        	if (zx>dx-20 && zy<dy-20)
	        	{
	        		/*if (dy  - zy == dx - zx)
	        		{*/
	        			zx = zx - 1;
	        			zy = zy + 1;
	        		/*}
	        		if (dy  - zy < dx - zx)
	        		{
	        			zx = zx - 1;
	        			zy = zy + 2;
	        		}
	        		if (dy  - zy > dx - zx)
	        		{
	        			zx = zx - 2;
	        			zy = zy + 1;
	        		}*/
	        	}
	        	
	        	if (zx<dx-20 && zy>dy-20)
	        	{
	        		/*if (dy  - zy == dx - zx)
	        		{*/
	        			zx = zx + 1;
	        			zy = zy - 1;
	        		/*}
	        		if (dy  - zy < dx - zx)
	        		{
	        			zx = zx + 1;
	        			zy = zy - 2;
	        		}
	        		if (dy  - zy > dx - zx)
	        		{
	        			zx = zx + 2;
	        			zy = zy - 1;
	        		}*/
	        	}
	        		if (zx == dx-20 && zy > dy-20)
	        			zy = zy - 2;
	        		
	        		if (zx == dx-20 && zy < dy-20)
	        			zy = zy + 2;
	        		
	        		if (zx > dx-20 && zy == dy-20)
	        			zx = zx - 2;
	        		
	        		if (zx < dx-20 && zy == dy-20)
	        			zx = zx + 2;
	        	else
	        	{
	        		zx = zx;
	        		zy = zy;
	        	}
	        		
	            	

	        		int x = zx + 20;
	            	int y = zy + 20;
	            	//.int xs = zx + P_S + 1;
	            	//int ys = zy + P_S + 1;
	            	
	            	if ((( x <= dx) && (x+P_S >= dx) && ( y <= dy) && (y+P_S >= dy)) || (( dx >= x) && (dx+P_S <= x) && ( dy >= y) && (dy+P_S <= y)) ) //столкновение с игроком!
	            	{
	            		if (hp > 0)
	            		{
	            			hp -= Z_DMG;
	            			//ochki += Z_DMG;
	            		}
	                	//gameOver();
	            	}
	            	//chgvjhbk
	            	
	            	int x1 = dropx - 1;
	            	int y1 = dropy - 1;
	            	int xs1 = dropx + P_S + 1;
	            	int ys1 = dropy + P_S + 1;
	            	
	            	if ((( x1 <= dx) && (x1+P_S >= dx) && ( y1 <= dy) && (y1+P_S >= dy)) || (( dx >= x1) && (dx+P_S <= x1) && ( dy >= y1) && (dy+P_S <= y1)) ) //столкновение с игроком!
	            	{
	            		if (hp < 150)
	            		{
	            			hp += Z_DMG;
	            			//ochki += Z_DMG*3;
	            			//Menu.schot = Integer.toString(ochki);
	            			//Menu.lo.setVisible(true);
	            			flag = false;
	            			
	            			//getRandomX(1200, 0);
	                		//getRandomY(650, 0);
	            		}
	            		dropx = getRandomX(1170, 0);
	        			dropy = getRandomY(620, 0);
	            		
	            		flag = true;
	            		content.repaint();
	                	//gameOver();
	            	}
	            	content.repaint();
//dhficudsbvkb ljvs vljds vlds vlds vjld vjld jlv dlj vld vld vd v

//dv d vld v edn vde vm.
			        
        	content.repaint(); // Callback paintComponent()
        	// Delay for timing control and give other threads a chance
        	try {
        	Thread.sleep(1000 / 30); // milliseconds
        	} catch (InterruptedException ex) { }
        	}    //c  ngccvmhvcdlsfhldnclkvdnslkvdlvbldsvlkdvkdsvjbsdvbds.kvbkdsbvk.dbsv.bsd.vbd.vb.snv.s,v  bvm s.v .vm snvm 
        	//cvgjcvhv v h
        	Menu.f = true;
        	
        	created = false;
        	window.setVisible(false);
        	hp = 100;
        	zx = 0;
        	zy = 0;
        	dx = 600;
        	dy = 325;
        	
        	Menu.schot = Integer.toString(k/5);
        	Menu.lo.repaint();
        	Menu.updateScore(Integer.toString(k/5));
        	System.out.println("ochki: " + ochki);
        	System.out.println("schot: " + Menu.schot);
        	System.out.println("flag: " + Menu.f);
        	//new Menu(false); 
        	//window.repaint();
        	
        	
        	Menu.lu.setVisible(true);
        	Menu.schot = Integer.toString(s);
        	Menu.lo.setVisible(true);
        	
        	//Menu.updateScore(och);
        	
        	/*while (zhp > 0)
    	    {
        		
            	//System.out.println("coords:" + mx + "x" + my);
    	    for(int iz = zx; iz <= 40; iz++ )
    	    {
    	    	for(int jz = zy; jz <= 40; jz++)
    	    	{
    	    		if ((mx == iz) && (my == jz))
    	    		{
    	    			//mx = location.getX();
    	            	//my = location.getY();
    	    			zhp -= PM;
    	    			k += 1;
    	    			System.out.println("k:" + k);
    	    			System.out.println("coords:" + mx + "x" + my);
    	    			
    	    		}
    	    	}
    	    }
    	    
    	    }*/
        	
        	
        	
        	ochki = 0;
        	s = 0;
        	k = 0;
        	
        	//zombieThread.stop();
        	
        	//cdjgchvhvv
        	}
        	
        	};
        	
        	zombieThread.start(); // Callback run()
        
        	
		
		window.getContentPane().add(content);
		window.getGlassPane();
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
//hdb jdbv.jd vld 
		//CustomListener customlistener = new CustomListener();
    	
		
		


//ixusbnvjeldnvldnv
		content.addKeyListener(new KeyAdapter() 
		{
			public void keyPressed(KeyEvent e) 
			{
				
				int key = e.getKeyCode();
				int key2 = e.getKeyCode();
				
				

		        if (key == KeyEvent.VK_A && dx >= 20) 
		        {
		        
		            dx += -P_SPEED;
		            
		            
		            content.repaint();
		            
		        }

		        if (key == KeyEvent.VK_D && dx <= 1180) 
		        {
		        
		        	dx += P_SPEED;    	
		        	
		        	content.repaint();
		        }
		        
		        if (key == KeyEvent.VK_W && dy >= 20) 
		        {
		            
		            dy += -P_SPEED;
		            
		            content.repaint();
		        }

		        if (key == KeyEvent.VK_S && dy <= 630) 
		        {
		        
		            dy += P_SPEED;
		            
		            content.repaint();
		        }

		        //fheidhflifdskbvusdbvjsvjsbvs
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
				
				
		        //hvlwsnvjdr jldbnvljdrbl

		        

		        
			}
		});
		
		
		//ufvnsdnldnsvl

		//cidsbvdjblvls
		
		
		
		//dhbfehkdkjd kws
        Iterator<Drop> itd = drops.iterator();

        while (itd.hasNext()) {
            
            Drop drop = (Drop) itd.next();
            
            if (drop.isVisible() && hp > 0) {

            	int x1 = dropx - 1;
            	int y1 = dropy - 1;
            	int xs1 = dropx + P_S + 1;
            	int ys1 = dropy + P_S + 1;
            	
            	if ((xs1 == dx || x1 == dx + P_S) || (ys1 == dy + P_S || y1 == dy)) //столкновение с игроком!
            	{
            		
            		window.getGraphicsConfiguration();
            		hp += 50;
            		//ochki += 50;   //fiktive
            		/*while (hp > 0)
            		{
            			hp += 50;
            			ochki ++;
            			
            		}*/
            		int huj = 0;
            		if (huj == 0)
                		System.exit(0);
                	//gameOver();
                	
                	
                	window.setVisible(false);
                	b = false;
                	
                	
            	}
            	if ((( x1 <= dx) && (x1+P_S >= dx) && ( y1 <= dy) && (y1+P_S >= dy)) || (( dx >= x1) && (dx+P_S <= x1) && ( dy >= y1) && (dy+P_S <= y1)) ) //столкновение с игроком!
            	{
            		if (hp < 150)
            		{
            			hp += Z_DMG;
            			//ochki += Z_DMG*3;
            			flag = false;
            			
            			//getRandomX(1200, 0);
                		//getRandomY(650, 0);
            		}
            		dropx = getRandomX(1200, 0)  + 15;
        			dropy = getRandomY(650, 0) + 15;
            		
            		flag = true;
                	//gameOver();
            	}

                //if (y > GROUND - ZOMBI_HEIGHT) {  ///!!!!!
                 //   ingame = false;
                    
                //}

                Move.zm();
            }
        }
        content.setVisible(b);
		window.setVisible(b);
		
		created = true;
		
		
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!		
		while (true) {
    		

    	}
	}
    
    
    //bcjlne ls 
    
    //dnn slv dv 
    /*public static void cycle()
    {
    	while(P_HP < 0)
    	{
    		
    	}
    }*/
	
	/*public static void clear()
	{
		Arrays.fill(bufferData, clearColor);
	}*/
	
	public static void render() 
	{
		
	}
	
	private static void render(Graphics g)
	{
		
		
		//g.fillOval(600-20, 325-20, 40, 40);
		//content.repaint();
		//Image scaleImage = playerImg.getScaledInstance(20, 20,Image.SCALE_DEFAULT);
		g.drawImage(playerImg, dx-20, dy-20, 40, 40, null);
		//if (zhp>0)
		//if (k<=5)
		g.drawImage(zombiImg, zx, zy, 40, 40, null);
		if (flag == true)
		g.drawImage(medImg, dropx, dropy, 30, 30, null);
		//g.drawImage(medImg, getRandomX(1200, 0)+15,  getRandomY(650, 0)+15, 30, 30, null);
		g.setColor(Color.RED);
		g.fillRect(40, 10, hp*2, 10);
		String str = Integer.toString(hp);
		//String och = Integer.toString(ochki);
		och = Integer.toString(ochki);
		g.drawString(str, 10, 20);
		g.drawString(och, 10, 40);
		
		
		//ochki = 0;
		
		
		
		
		
	}
    //end iz velosiped

    private void initKostil() {
 
    	isak = false;
        addKeyListener(new TAdapter());
        setFocusable(true);
        d = new Dimension(MAX_W, MAX_H);
        setBackground(Color.gray);
        new CustomListener();

        gameInit();
        setDoubleBuffered(true);
    }

    @Override
    public void addNotify() {

        super.addNotify();
        gameInit();
    }

    public void gameInit() {

        zombis = new ArrayList<>();
        drops = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {

                Zombi zombi = new Zombi(packet.zx[0], packet.zy[0]);
                zombis.add(zombi);
            }
        }

        player = new Player();
        shot = new Shot();

        if (animator == null || !ingame) {

            animator = new Thread(this);
            animator.start();
        }
    }

    @SuppressWarnings("unused")
	public void drawZombis(Graphics g) {

        Iterator<Zombi> it = zombis.iterator();

        for (Zombi zombi: zombis) {

            if (zombi.isVisible()) {

                g.drawImage(zombi.getImage(), zombi.getX(), zombi.getY(), this);
            }

            if (zombi.isDying()) {

            	zombi.die();
            }
        }
    }

    public void drawPlayer(Graphics g) {

        if (player.isVisible()) {
            
            g.drawImage(player.getImage(), player.getX(), player.getY(), this);
        }

        if (player.isDying()) {

            player.die();
            ingame = false;
        }
    }

    public void drawShot(Graphics g) {

        if (shot.isVisible()) {
            
            g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
        }
    }


    @Override
    public void paintComponent(Graphics g) {    //!!!!!!!!!!!!!!!!!!!!!!!!
     //   super.paintComponent(g);

        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.green);

        if (ingame) {

            
            drawZombis(g);
            drawPlayer(g);
            drawShot(g);
            
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }                                             //!!!!!!!!!!!!!!!!!!!!!!!!

    public void gameOver() {

        Graphics g = this.getGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, MAX_W, MAX_H);

        g.setColor(new Color(0, 32, 48));
        g.fillRect(50, MAX_W / 2 - 30, MAX_W - 100, 50);
        g.setColor(Color.white);
        g.drawRect(50, MAX_W / 2 - 30, MAX_W - 100, 50);

        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(message, (MAX_W - metr.stringWidth(message)) / 2,
                MAX_W / 2);
    }

    public void animationCycle() {

        if (packet.lose) {

            ingame = false;
            message = "Game over((((((";
        }

        // player
        player.act();

        // shot
        if (shot.isVisible()) {

            int shotX = shot.getX();
            int shotY = shot.getY();

            for (Zombi zombi: zombis) {

                int zombiX = zombi.getX();
                int zombiY = zombi.getY();

                if (zombi.isVisible() && shot.isVisible()) {
                    if (shotX >= (zombiX)
                            && shotX <= (zombiX + P_S)
                            && shotY >= (zombiY)
                            && shotY <= (zombiY + P_S)) {
                        ImageIcon ii
                                = new ImageIcon(explImg);
                        zombi.setImage(ii.getImage());
                        zombi.setDying(true);
                        //deaths++;
                        shot.die();
                    }
                }
            }

            int y = shot.getY();
            y -= 4;

            if (y < 0) {
                shot.die();
            } else {
                shot.setY(y);
            }
        }

        // zombis

        for (Zombi zombi: zombis) {

            int x = zombi.getX();

            if (x >= MAX_W || x <= MIN_W) {

                Iterator<Zombi> i1 = zombis.iterator();

                while (i1.hasNext()) {

                    Zombi a2 = (Zombi) i1.next();
                    a2.setY(a2.getY());
                }
            }
        }

        Iterator<Zombi> it = zombis.iterator();

        while (it.hasNext()) {
            
            Zombi zombie = (Zombi) it.next();
            
            if (zombie.isVisible() && hp > 0) {

            	int x = zx - 1;
            	int y = zy - 1;
            	int xs = zx + P_S + 1;
            	int ys = zy + P_S + 1;
            	
            	if ((xs == dx || x == dx + P_S) || (ys == dy + P_S || y == dy)) //столкновение с игроком!
            	{
            		
            		window.getGraphicsConfiguration();
            		while (hp > 0)
            		{
            			hp -= Z_DMG;
            			//ochki ++;
            			
            		}
            		int huj = 0;
            		if (huj == 0)
                		System.exit(0);
                	gameOver();
                	
                	window.setVisible(false);
                	b = false;
                	
                	
            	}

                //if (y > GROUND - ZOMBI_HEIGHT) {  ///!!!!!
                 //   ingame = false;
                    
                //}

                Move.zm();
            }
        }
        
        for (Boss boss: bosses) {

            int x = boss.getX();

            if (x >= MAX_W || x <= MIN_W) {

                Iterator<Boss> i1 = bosses.iterator();

                while (i1.hasNext()) {

                    Boss a2 = (Boss) i1.next();
                    a2.setY(a2.getY());
                }
            }
        }

        Iterator<Boss> it1 = bosses.iterator();

        while (it1.hasNext()) 
        {
            
            Boss boss = (Boss) it1.next();
            
            if (boss.isVisible()) 
            {

                @SuppressWarnings("unused")
				int y = boss.getY();

                //if (y > GROUND - ZOMBI_HEIGHT) {  ///!!!!!
                 //   ingame = false;
                    
                //}

                Move.bm();
            }
        }
        //drop


    
    
    //dobavil

    /*if (zhp == 0)
    	flagz = false;*/
    }
    //zombie.die();

    @Override
    public void run() {
    	while (Kostil.zhp > 0)
	    {
	    for(int iz = zx; iz <= zx+40; iz++ )
	    {
	    	for(int jz = zy; jz <= zy+40; jz++)
	    	{
	    		if ((mx == iz) && (my == jz))
	    		{
	    			Kostil.zhp -= PM;
	    			k += 1;
	    			System.out.println("k:" + k);
	    			System.out.println("coords:" + mx + "x" + my);
	    			
	    		}
	    	}
	    }
	    
	    }
		zx = 0;
	    zy = 0;

        //long beforeTime/*, timeDiff, sleep*/;

      //  beforeTime = System.currentTimeMillis();

        while (ingame) {

            //repaint();
            animationCycle();

           // timeDiff = System.currentTimeMillis() - beforeTime;
            //sleep = DELAY - timeDiff;

           /* if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }*/
            
           // beforeTime = System.currentTimeMillis();
        }

        gameOver();
    }

    private class TAdapter extends KeyAdapter {
    	
		String msg = "";
		//int mouseX = 0, mouseY = 0;
		
		
		public void mouseDragged(MouseEvent me) {
		
			mouseX = me.getX();
			mouseY = me.getY();
			msg = "*";
			
			
			//repaint();
		}
		

        
        @SuppressWarnings("unused")
		public void mouseReleased(MouseEvent me) 
        {

            //player.mouseReleased(me);
        }

        
        @SuppressWarnings("unused")
		public void mousePressed(MouseEvent me)
        {

           // player.mousePressed(me);

            mouseX = me.getX();
			mouseY = me.getY();
			msg = "Down"; 
			//repaint();

            if (msg == "Down") {
                
                if (ingame) {
                    if (!shot.isVisible()) {
                        shot = new Shot();
                    }
                }
            }
        }
        
    }
    
    /*public void keyPressed(KeyEvent e) 
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
    }*/

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
    public void main() 
    {
    	initKostil();
    	new TAdapter();
    	gameInit();
    	addNotify();
    	run();
    	//drawPlayer(Graphics g);
    	//TAdapter();
    	animationCycle();
    	gameOver();
    	//paintComponent(Graphics g);
    	//ochki = 0;
    	
    }
}
