package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import code.assign;
/*
 * Handles the clue button, and checking whether there is one word or more, and updating boolean value in GUI.
 */
public class clueButtonHandler implements ActionListener{
	private GUI gui;
	private assign a;
	public clueButtonHandler(GUI gui,assign assi) {
		this.gui=gui;
		this.a=assi;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String u=gui.clueTF.getText();
		String[] y=u.split("[a-zA-Z]+");
		if(y.length==0) {
			try {
				 Integer.parseInt(gui.clueTF.getText());
				 gui.validClue=false;
				gui.ClueEntered=true;
				} catch (NumberFormatException e) {
					String w=u.toUpperCase();
					if(a.clue(w)) {
						gui.validClue=true;
						gui.ClueEntered=true;
					}else {
						gui.validClue=false;
						gui.ClueEntered=true;
					}}
				}
		else {
			gui.validClue=false;
			gui.ClueEntered=true;
		}
		gui.update();
	}
}