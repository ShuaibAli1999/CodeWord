package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import code.InvalidCountException;
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
		boolean valid=true;
		int x=0;
		try {
		   x = Integer.parseInt(gui.countTF.getText());
		} catch (NumberFormatException e) {
		    valid=false;
		}
		if(valid) {
		try {
			if(a.count(x)){
				gui.validCount=true;
				gui.CountEntered=true;
			}else {
				gui.validCount=false;
				gui.CountEntered=true;
			}
		} catch (InvalidCountException e) {
			gui.validCount=false;
			gui.CountEntered=true;
		}
		}
		else {
			gui.validCount=false;
			gui.CountEntered=true;
		}
		gui.update();
	}

}
