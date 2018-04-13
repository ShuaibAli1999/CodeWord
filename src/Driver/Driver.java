package Driver;
import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import code.Model;
import code.assign;
import GUI.GUI;

public class Driver implements Runnable {
	private assign _model;
	private JFrame _window;
	private JPanel _mainPanel;
	public Driver(assign m) {
		_model = m;
	}
	public JFrame getwindow() {
		return _window;
	}
	
	public static void main(String[] args) {
		assign m = new assign( );
		SwingUtilities.invokeLater(new Driver(m));
	}

	@Override
	public void run(){
			_window = new JFrame("CodeNames");
			_mainPanel = new JPanel();
			_window.getContentPane().add(_mainPanel);

			try {
				new GUI(_model, _mainPanel,this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			_window.setVisible(true);
			_window.pack();
			_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		}
	
	public void updateJFrame() {
		_window.pack();
		_window.repaint();
	}
}
