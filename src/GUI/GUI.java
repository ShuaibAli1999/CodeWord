package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.Timer;

import code.Model;
import code.Observer;
import code.assign;
import Driver.Driver;

public class GUI implements Observer {
	
	private assign _model;
	private Driver _windowHolder;
	
	public GUI(assign m, JPanel mp, Driver driver) {
		_windowHolder = driver;
		_model = m;
		JPanel _mainPanel = mp;
		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;
		menuBar = new JMenuBar();
		mp.add(menuBar);
		menu = new JMenu("File");
		setMenuProperties(menu);
		menuBar.add(menu);
		menuItem = new JMenuItem("New Game");
		menu.add(menuItem);
		setMenuItemProperties(menuItem);
		menuItem = new JMenuItem("Exit");
		setMenuItemProperties(menuItem);
		menu.add(menuItem);
		_windowHolder.getwindow().setJMenuBar(menuBar);
}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	public void setMenuProperties(JMenu menu) {
		menu.setFont(new Font("Courier", Font.BOLD, _model.font));
		menu.setBackground(Color.WHITE);
		menu.setForeground(Color.BLACK);
		menu.setOpaque(true);
		menu.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}
	public void setMenuItemProperties(JMenuItem item) {
		item.setFont(new Font("Courier", Font.BOLD, _model.font));
		item.setBackground(Color.WHITE);
		item.setForeground(Color.BLACK);
		item.setOpaque(true);
		item.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}
	
	public void setButtonProperties(JButton button) {
		button.setFont(new Font("Courier", Font.BOLD, _model.font));
		button.setBackground(Color.WHITE);
		button.setForeground(Color.BLACK);
		button.setOpaque(true);
		button.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}

	public void setLabelProperties(JLabel label) {
		label.setFont(new Font("Courier", Font.BOLD, _model.font));
		label.setBackground(Color.WHITE);
		label.setForeground(Color.BLACK);
		label.setOpaque(true);
		label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}
}