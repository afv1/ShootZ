package proba1;

import java.awt.Color;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.AbstractAction;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
import proba1.Velosiped;

public class TestActionListener implements ActionListener
{
public void actionPerformed(ActionEvent e)
	{
	//Velosiped.create(1200, 650, "Igra", Color.GRAY.getRGB(), 3);	
	Kostil.create(1200, 650, "Igra", Color.GRAY.getRGB(), 3);	
	//Velosiped.create(1200, 650, "Igra", Color.GRAY.getRGB(), 3);	
	
	//new Velosiped(true);
	//Menu.close();
	//sncjdn lcndlsnc
	
	//avschskcks c,
	

	Timer t = new Timer(1000/60, new AbstractAction()
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			/*Holst.clear();
			//Holst.render(g);
			Holst.swapBuffers();*/
		}
	});
	
	//t.setRepeats(true);
	//t.start();
	}


}
//JOptionPane.showMessageDialog(new Score(), message, "joptablya", JOptionPane.ERROR_MESSAGE);