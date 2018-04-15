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
/*
 * GUI class which represents the game screen. 
 */
public class GUI implements Observer {
	/*
	 * The window that holds easter egg.
	 */
	private JFrame secondFrame = new JFrame("My 2nd Window!");
	/*
	 * The class that hold and keep trace of all the data information of the game. 
	 */
	private assign _model;
	/*
	 * The picture for meme.
	 */
	private ImageIcon mat= new ImageIcon("MatthewSimpson.png");
	/*
	 * The main window that displays all the feature of the game. 
	 */
	private Driver _windowHolder;
	/*
	 * The main panel that holds all the other panels, labels, and buttons. 
	 */
	private JPanel _mainPanel;
	/*
	 * The panel that holds the codenames and revealed agents. 
	 */
	private JPanel assignPanel;
	/*
	 * The panel that holds the pass button for changing turn.
	 */
	private JPanel buttom;
	/*
	 * The panel that holds information showing which turn it is. 
	 */
	private JPanel top;
	/*
	 * The panel that holds the clue and count panels. 
	 */
	private JPanel Clue;
	/*
	 * The panel that holds the valid clue that is entered by the spymaster. 
	 */
	private JPanel clueP;
	/*
	 * The panel that holds the valid count that is entered by the spymaster. 
	 */
	private JPanel countP;
	/*
	 * The panel that holds the textfield for clue and count. 
	 */
	private JPanel enterP;
	/*
	 * The textfield for spymaster to enter the clue. 
	 */
	protected JTextField clueTF;
	/*
	 * The textfield for spymaster to enter the count.
	 */
	protected JTextField countTF;
	/*
	 * The boolean value that keep track of whether the entered clue is valid or invalid.
	 */
	protected boolean validClue=false;
	/*
	 * The boolean value that keep track of whether the entered count is valid or invalid.
	 */
	protected boolean validCount=false;
	/*
	 * The boolean value that keep track of whether the NewGame button is pressed or not.
	 */
	public boolean st = false;
	/*
	 * The boolean value that keep track of whether the assassin is revealed or not.
	 */
	public boolean assas = false;
	/*
	 * The boolean value that keep track of whether clue is entered or not.
	 */
	protected boolean ClueEntered=false;
	/*
	 * The boolean value that keep track of whether count is entered or not.
	 */
	protected boolean CountEntered=false;
	/*
	 * The boolean value that keep track of whether the count should update or not.
	 */
	protected boolean updateCount=false;
	/*
	 * The button for clue textfield.
	 */
	private JButton b;
	/*
	 * The button for count textfield.
	 */
	private JButton b1;
	/*
	 * The turn value that is alias to the turn value in assign class.
	 */
	private int turn;
	/*
	 * The value that only for the first pop up window for new game.
	 */
	protected int num=0;
	/*
	 * sets up the initial framework for the GUI. Adds the JText fields, JPanels, and JButtons necessary for the game to function.
	 * Update handles further changes.
	 */
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
/*
 * (non-Javadoc)
 * @see code.Observer#update()
 * Update deals with everything that needs to be changed after an event occurs. As a result it updates the GUI after any button press happens 
 * or after any number changes. In addition it updates the GUI after the spymaster has inputed his information. 
 */
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
/*
 * Updates the JFrame so changes are displayed.
 */
	public void updateJFrameIfNotHeadless() {
		if (_windowHolder != null) {
			_windowHolder.updateJFrame();
		}
	}
	/*
	 * sets the menu properties
	 */
	public void setMenuProperties(JMenu menu) {
		menu.setFont(new Font("Courier", Font.BOLD, _model.font));
		menu.setBackground(Color.WHITE);
		menu.setForeground(Color.BLACK);
		menu.setOpaque(true);
		menu.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}
	/*
	 * sets the fun menu properties
	 */
	public void setFunMenuProperties(JMenu menu) {
		menu.setFont(new Font("Courier", Font.BOLD, _model.font));
		menu.setBackground(Color.WHITE);
		menu.setForeground(Color.BLACK);
		menu.setOpaque(true);
		menu.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}
	/*
	 * sets the Menu Item properties
	 */
	public void setMenuItemProperties(JMenuItem item) {
		item.setFont(new Font("Courier", Font.BOLD, _model.font));
		item.setBackground(Color.WHITE);
		item.setForeground(Color.BLACK);
		item.setOpaque(true);
		item.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}
	/*
	 * Sets the button properties
	 */
	public void setButtonProperties(JButton button) {
		button.setFont(new Font("Courier", Font.BOLD, _model.font));
		button.setBackground(Color.WHITE);
		button.setForeground(Color.BLACK);
		button.setOpaque(true);
		button.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}
	/*
	 * Sets the Label properties 
	 */
	public void setLabelProperties(JLabel label) {
		label.setFont(new Font("Courier", Font.BOLD, _model.font));
		label.setBackground(Color.WHITE);
		label.setForeground(Color.BLACK);
		label.setOpaque(true);
		label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}
	/*
	 * helpful for creating the memes
	 */
	public ImageIcon getMat() {
		return mat;
	}
	
	
	
}