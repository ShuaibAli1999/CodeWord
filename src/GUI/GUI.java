package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	private JPanel assignPanel;
	public boolean st = false;
	
	public GUI(assign m, JPanel mp, Driver driver)throws FileNotFoundException, IOException{
		_windowHolder = driver;
		_model = m;
		JPanel _mainPanel = mp;
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.Y_AXIS));
		GridLayout experimentLayout = new GridLayout(5,5);
		assignPanel=new JPanel();
		assignPanel.setLayout(experimentLayout);
		_mainPanel.add(assignPanel);
		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;
		JMenuItem menuItem1;
		menuBar = new JMenuBar();
		mp.add(menuBar);
		menu = new JMenu("File");
		setMenuProperties(menu);
		menuBar.add(menu);
		menuItem = new JMenuItem("New Game");
		menuItem.addActionListener(new newGameHandler(this));
		setMenuItemProperties(menuItem);
		menu.add(menuItem);
		menuItem1 = new JMenuItem("Exit");
		menuItem1.addActionListener(new newCloseProgramHandler());
		setMenuItemProperties(menuItem1);
		menu.add(menuItem1);
		_windowHolder.getwindow().setJMenuBar(menuBar);		
		_model.gameStarted();
		_model.addObserver(this);
}

	@Override
	public void update() {
		
		assignPanel.removeAll();
		ArrayList<String> codenames = _model.getcodename();
		for (int i=0; i<codenames.size(); i=i+1) {
			JButton b = new JButton(""+codenames.get(i));
			setButtonProperties(b);
			assignPanel.add(b);
			b.addActionListener(new codenameButtonHandler());
		}
		if(st==true) {
			try {
				_model.gameStarted();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assignPanel.removeAll();
			
			ArrayList<String> c = _model.getcodename();
			for (int i=0; i<c.size(); i=i+1) {
				JButton b = new JButton(""+c.get(i));
				setButtonProperties(b);
				assignPanel.add(b);
				b.addActionListener(new codenameButtonHandler());
			}
			assignPanel.revalidate();
			assignPanel.repaint();
			st=false;
		}
		
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