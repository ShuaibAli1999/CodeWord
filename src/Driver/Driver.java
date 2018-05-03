package Driver;
import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import code.Model;
import code.assign;
import code.assign2;
import GUI.GUI;

public class Driver implements Runnable {
	private assign _model;
	private assign2 _model2;
	private JFrame _window;
	private JPanel _mainPanel;
	public Driver(assign m,assign2 m2) {
		_model = m;
		_model2= m2;
	}
	public JFrame getwindow() {
		return _window;
	}
	
	public static void main(String[] args) {
		assign m = new assign( );
		assign2 m2=new assign2();
		SwingUtilities.invokeLater(new Driver(m,m2));
	}

	@Override
	public void run(){
			_window = new JFrame("CodeNames");
			_mainPanel = new JPanel();
			_window.getContentPane().add(_mainPanel);

			try {
				new GUI(_model, _mainPanel,this,_model2);
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
