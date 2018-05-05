package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import code.InvalidCountException;
import code.assign;
import code.assign2;
/*
 * Handles the count button, and checking whether the entered count is a string or word, and updating boolean value in GUI.
 */
public class countButtonHandler implements ActionListener{
	private GUI gui;
	private assign a;
	private assign2 a2;
	public countButtonHandler(GUI gui,assign assi,assign2 assi2) {
		this.gui=gui;
		this.a=assi;
		this.a2=assi2;
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
			if(gui.teamVersion==3) {
				if(a2.count(x)){
					gui.validCount=true;
					gui.CountEntered=true;
				}else {
					gui.validCount=false;
					gui.CountEntered=true;
				}
			}else {
			if(a.count(x)){
				gui.validCount=true;
				gui.CountEntered=true;
			}else {
				gui.validCount=false;
				gui.CountEntered=true;
			}}
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
