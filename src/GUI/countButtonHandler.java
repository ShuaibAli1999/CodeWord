package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import code.assign;

public class countButtonHandler implements ActionListener{
	private GUI gui;
	private assign a;
	
	public countButtonHandler(GUI gui,assign assi) {
		this.gui=gui;
		this.a=assi;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(a.clue(gui.countTF.getText())) {
			gui.valid=true;
			gui.Entered=true;
		}else {
			gui.valid=false;
			gui.Entered=true;
		}
		gui.update();
	}

}
