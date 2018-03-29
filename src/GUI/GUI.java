package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.Timer;

import code.Model;
import code.Observer;
import Driver.Driver;

public class GUI implements Observer {
	
	private Model _model;
	private Driver _windowHolder;
	
	public GUI(Model m, JPanel mp, Driver driver) {
		_windowHolder = driver;
		_model = m;
		JPanel _mainPanel = mp;
}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}