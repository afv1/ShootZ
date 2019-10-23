package proba1;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Score extends JFrame implements Commons, Runnable
{
	JLabel l;
	public Score()
	{
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setVisible(true);
        ActionListener actionlistener = new TestActionListener();
        main();
        //initScore();
        
        /*b1 = new JButton("Start");
        b2 = new JButton("Score");
        
        l = new JLabel("Score");
        tf = new JTextField(10);
        
        add(l);
        add(tf);
        b1.addActionListener(actionlistener);
        add(b1);
        b2.addActionListener(actionlistener);
        add(b2);*/
        
	}
	private void InitScore() {}
	//буду выводить scores
	public static void main() {
        JFrame frame = new JFrame();
        frame.setSize(800,600);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ActionListener actionlistener = new TestActionListener();
        frame.add(new JLabel("Score"));
        frame.setVisible(true);
        frame.getContentPane().add(new JPanel());
        ((JPanel)frame.getContentPane().getComponent(0)).add(new JLabel(packet.scores));
        frame.getContentPane().invalidate();
    }
	public void keyPressed(KeyEvent e) 
    {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_ESCAPE) 
        {
        
            Menu menu = new Menu(true);
        }
    }
	

	@Override
	public void run() {}
}
