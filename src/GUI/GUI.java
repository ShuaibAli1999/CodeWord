package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import GUI.clueButtonHandler;
import code.InvalidCountException;
import code.Observer;
import code.assign;
import Driver.Driver;

public class GUI implements Observer {
	
	private JFrame secondFrame = new JFrame("My 2nd Window!");
	private assign _model;
	private ImageIcon mat= new ImageIcon("MatthewSimpson.png");
	private Driver _windowHolder;
	private JPanel _mainPanel;
	private JPanel assignPanel;
	private JPanel buttom;
	private JPanel top;
	private JPanel Clue;
	private JPanel clueP;
	private JPanel countP;
	private JPanel enterP;
	protected String clue;
	protected JTextField clueTF;
	protected JTextField countTF;
	protected boolean validClue=false;
	protected boolean validCount=false;
	public boolean st = false;
	public boolean assas = false;
	protected boolean ClueEntered=false;
	protected boolean CountEntered=false;
	protected boolean switchTurn=false;
	protected boolean updateCount=false;
	private JButton b;
	private JButton b1;
	private int turn;
	protected int num=0;
	
	public GUI(assign m, JPanel mp, Driver driver)throws FileNotFoundException, IOException{
		_windowHolder = driver;
		_model = m;
		_mainPanel = mp;
		
		top = new JPanel();
		_mainPanel.add(top);
		
		enterP=new JPanel();
		clueTF= new JTextField("Enter one word for clue",20);
		b=new JButton("Ok");
		b.addActionListener(new clueButtonHandler(this,_model));
		countTF= new JTextField("Enter one number for count",20);
		b1=new JButton("Ok");
		b1.addActionListener(new countButtonHandler(this,_model));
		enterP.add(clueTF);
		enterP.add(b);
		enterP.add(countTF);
		enterP.add(b1);
		_mainPanel.add(enterP);
		
		Clue=new JPanel();
		clueP=new JPanel();
		countP=new JPanel();
		Clue.setLayout(new BoxLayout(Clue, BoxLayout.X_AXIS));
		JLabel cl=new JLabel("Clue: ");
		setLabelProperties(cl);
		Clue.add(cl);
		Clue.add(clueP);
		JLabel co=new JLabel("Count: ");
		setLabelProperties(co);
		Clue.add(co);
		Clue.add(countP);
		_mainPanel.add(Clue);
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.Y_AXIS));
		
		JMenuBar menuBar=new JMenuBar();
		JMenu menu = new JMenu("File");
		setMenuProperties(menu);
		menuBar.add(menu);
		JMenuItem menuItem = new JMenuItem("New Game");
		menuItem.addActionListener(new newGameHandler(this));
		setMenuItemProperties(menuItem);
		menu.add(menuItem);
		JMenuItem fun = new JMenuItem("");
		fun.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			secondFrame.add(new JLabel(mat));
			secondFrame.pack();
			secondFrame.setVisible(true);
			
			secondFrame.addWindowListener(new memeMagicHandler());
			
		
		
		}});
		menu.add(fun);
		
		JMenuItem menuItem1 = new JMenuItem("Exit");
		menuItem1.addActionListener(new newCloseProgramHandler());
		setMenuItemProperties(menuItem1);
		menu.add(menuItem1);
		mp.add(menuBar);
		_windowHolder.getwindow().setJMenuBar(menuBar);	
		
		buttom = new JPanel();
		JButton pass = new JButton("Pass");
		pass.addActionListener(new passHandler(_model,this));
		setButtonProperties(pass);
		buttom.add(pass);
		assignPanel=new JPanel();
		assignPanel.setLayout(new GridLayout(5,5));
		_mainPanel.add(assignPanel);
		mp.add(buttom);
		
		_model.gameStarted();
		_model.addObserver(this);
}

	public GUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(){
		if(st==true) {
			try {
				_model.gameStarted();
				clueP.removeAll();
				countP.removeAll();
				clueTF.setEditable(true);
				countTF.setEditable(true);
				b.setEnabled(true);
				b1.setEnabled(true);
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
				b.addActionListener(new codenameButtonHandler(_model,this,c.get(i)));
			}
			st=false;
			num=0;
			validClue=false;
			validCount=false;
			assas = false;
			ClueEntered=false;
			CountEntered=false;
			switchTurn=false;
			updateCount=false;
		}
		if(_model.getBlueTotal()==0 || _model.getRedTotal()==0|| assas==true) {
			assas=false;
			if(_model.winningState()==-1) {
				assignPanel.removeAll();
				assignPanel.add(new JLabel("RED TEAM WINS"));
				}
			if(_model.winningState()==1) {
			assignPanel.removeAll();
			assignPanel.add(new JLabel("BLUE TEAM WINS"));
			}
			if(_model.winningState()==0) {
				assignPanel.removeAll();
				assignPanel.add(new JLabel(_model.teamWon()+""+ " "+ "WINS"));
			}
			updateJFrameIfNotHeadless();
			}else {
		if(num>0) {
			if(updateCount) {
				countP.removeAll();
				JLabel count=new JLabel(""+_model.count);
				setLabelProperties(count);
				countP.add(count);
				updateCount=false;
			}
		if(turn!=_model.turn()){
			if(_model.turn()==1) {
				JOptionPane.showMessageDialog(null, "BLUE TEAM'S TURN ENDS. Red team spymaster please enter a clue and a count number.");
			}else if(_model.turn()==0) {
				JOptionPane.showMessageDialog(null, "RED TEAM'S TURN ENDS. Blue team spymaster please enter a clue and a count number.");
			}
			countP.removeAll();
			clueP.removeAll();
			clueTF.setEditable(true);
			countTF.setEditable(true);
			b.setEnabled(true);
			b1.setEnabled(true);
		}}
		else {
			JOptionPane.showMessageDialog(null, "Game Started! Red team spymaster please enter a clue and a count number.");
		}
		num=num+1;
		
		if(_model.turn()==1) {
			top.removeAll();
			top.add(new JLabel("Red Turn"));
			turn=_model.turn();
		}
		else {
			top.removeAll();
			top.add(new JLabel("Blue Turn"));
			turn=_model.turn();
		}
		if(validClue&&ClueEntered) {
			clueP.removeAll();
			JLabel clue=new JLabel(clueTF.getText());
			setLabelProperties(clue);
			clueP.add(clue);
			clueTF.setText("");
			clueTF.setEditable(false);
			b.setEnabled(false);
			ClueEntered=false;
		}
		else if(validClue!=true&&ClueEntered){
			JOptionPane.showMessageDialog(null, "Clue cannot be a number, more than one word, or codenames that is not revealed. Please enter again.");
			ClueEntered=false;
		}
		if(validCount&&CountEntered) {
			countP.removeAll();
			JLabel count=new JLabel(countTF.getText());
			_model.count=Integer.parseInt(countTF.getText());
			setLabelProperties(count);
			countP.add(count);
			countTF.setText("");
			countTF.setEditable(false);
			b1.setEnabled(false);
			CountEntered=false;
		}
		else if(validCount!=true&&CountEntered){
			JOptionPane.showMessageDialog(null, "Count number cannot be a string, or less than or equals to zero. Please enter again.");
			CountEntered=false;
		}
		assignPanel.removeAll();
		ArrayList<String> codenames = _model.getcodename();
		if(clueP.getComponentCount()==0||countP.getComponentCount()==0) {
			for (int i=0; i<codenames.size(); i=i+1) {
				JLabel b = new JLabel(""+codenames.get(i));
				setLabelProperties(b);
				if(_model.getAssignedCodeNameandValues().get(codenames.get(i))=="red agent") {
						b.setBackground(Color.RED);
					}
				if(_model.getAssignedCodeNameandValues().get(codenames.get(i))=="blue agent") {
						b.setBackground(Color.BLUE);
					}
				if(_model.getAssignedCodeNameandValues().get(codenames.get(i))=="assassin") {
						b.setBackground(Color.DARK_GRAY);
					}
				if(_model.getReveal().get(codenames.get(i))==true) {
						JLabel label = new JLabel(""+_model.getAssignedCodeNameandValues().get(codenames.get(i)));
						setLabelProperties(label);
						assignPanel.add(label);
					}else {
						assignPanel.add(b);
					}
		}
			}
		else {
		for (int i=0; i<codenames.size(); i=i+1) {
			JButton b = new JButton(""+codenames.get(i));
			setButtonProperties(b);
			if(_model.getReveal().get(codenames.get(i))==true) {
				JLabel label = new JLabel(""+_model.getAssignedCodeNameandValues().get(codenames.get(i)));
				setLabelProperties(label);
				assignPanel.add(label);
			}
			else {
			assignPanel.add(b);
			b.addActionListener(new codenameButtonHandler(_model,this,codenames.get(i)));
			}
		}}
		updateJFrameIfNotHeadless();}
		System.out.println(_model.getRedTotal()+" red");
		System.out.println(_model.getBlueTotal()+" blue");
	}

	public void updateJFrameIfNotHeadless() {
		if (_windowHolder != null) {
			_windowHolder.updateJFrame();
		}
	}

	public void setMenuProperties(JMenu menu) {
		menu.setFont(new Font("Courier", Font.BOLD, _model.font));
		menu.setBackground(Color.WHITE);
		menu.setForeground(Color.BLACK);
		menu.setOpaque(true);
		menu.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}
	
	public void setFunMenuProperties(JMenu menu) {
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
	public ImageIcon getMat() {
		return mat;
	}
	
	
	
}