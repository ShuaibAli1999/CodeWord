package GUI;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class memeMagicHandler implements WindowListener {
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		GUI g = new GUI();
		JFrame f = new JFrame();
		f.add(new JLabel(g.getMat()));
		f.pack();
		f.setVisible(true);			
		JFrame f2 = new JFrame();
		f.add(new JLabel(g.getMat()));
		f.pack();
		f.setVisible(true);
		f.addWindowListener(this);
		f2.addWindowListener(this);
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
