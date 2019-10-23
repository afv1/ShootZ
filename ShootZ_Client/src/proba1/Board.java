package proba1;

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
import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
//import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JPanel implements Runnable, Commons 
{

	static int mouseX = 0, mouseY = 0;
    private Dimension d;
    static ArrayList<Zombi> zombis;
    static ArrayList<Boss> bosses;
	static ArrayList<Shot> shots;
    static Player player;
    static Shot shot;
    static boolean gameover, prediction;
    static int score = 0;
    Image img = new ImageIcon("res/Fon.png").getImage();
    
    JPanel panel = new JPanel();
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    Image playerImg = new ImageIcon("res/player.PNG").getImage();
    public static boolean ingame = true, isak = false;
    private final String explImg = "src/images/explosion.png"; //!!!
    private String message = "Game Over";

    private Thread animator;

    public Board() 
    {
    	
    	setSize(screen);
        setLayout(new FlowLayout());
        //setLocationRelativeTo(null);
        setVisible(true);
        initBoard();
        main();
        //paint(getGraphics());

        
    }
    
  /*  
    public void paint(Graphics g) 
    {
    	g = (Graphics2D) g;
    	g.drawImage(playerImg, 300, 400, null);
    }
*/
    private ImageIcon ImageIcon(String string) 
    {
		// TODO Auto-generated method stub
		return null;
	}

	private void initBoard() {
 
    	isak = false;
        addKeyListener(new TAdapter());
        setFocusable(true);
        d = new Dimension(MAX_W, MAX_H);
        //setBackground(Color.gray);

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

        	g = (Graphics2D) g;
        //	g.drawImage(playerImg, 300, 400, null);
        
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
        super.paintComponent(g);

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
                    a2.setY(a2.getY());// + GO_DOWN); ///?
                }
            }
        }

        Iterator<Zombi> it = zombis.iterator();

        while (it.hasNext()) {
            
            Zombi zombi = (Zombi) it.next();
            
            if (zombi.isVisible()) {

                @SuppressWarnings("unused")
				int y = zombi.getY();

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
                    a2.setY(a2.getY());// + GO_DOWN); ///?
                }
            }
        }

        Iterator<Boss> it1 = bosses.iterator();

        while (it.hasNext()) {
            
            Boss boss = (Boss) it1.next();
            
            if (boss.isVisible()) {

                @SuppressWarnings("unused")
				int y = boss.getY();

                //if (y > GROUND - ZOMBI_HEIGHT) {  ///!!!!!
                 //   ingame = false;
                    
                //}

                Move.bm();
            }
        }

        
    }

    @Override
    public void run() {

        //long beforeTime/*, timeDiff, sleep*/;

      //  beforeTime = System.currentTimeMillis();

        while (ingame) {

            repaint();
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
			
			
			repaint();
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
			repaint();

            if (msg == "Down") {
                
                if (ingame) {
                    if (!shot.isVisible()) {
                        shot = new Shot();
                    }
                }
            }
        }
        
    }
    public void main() 
    {
    	JFrame frame = new JFrame();
        frame.setSize(screen.width,screen.height);
       // frame.setMaximumSize(screen);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ActionListener actionlistener = new TestActionListener();
        frame.add(new JLabel("Score"));
        frame.setVisible(true);
        frame.getContentPane().add(new JPanel());
        ((JPanel)frame.getContentPane().getComponent(0)).add(new JLabel(packet.scores));
        frame.getContentPane().invalidate();
        frame.add(panel);
        panel.setVisible(true);
       // panel.add(panel, new ImageIcon("res/chel.PNG").getImage());
        player.setVisible(true);
       // paint(getGraphics());
    	
    	
    	//initBoard();
    	gameInit();
    	addNotify();
    	run();
    	//drawPlayer(Graphics g);
    	//TAdapter();
    	animationCycle();
    	//gameOver();
    	//paintComponent(Graphics g);
    	
    	
    }
}
