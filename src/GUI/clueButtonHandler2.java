package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.assign2;

public class clueButtonHandler2 implements ActionListener{
	private GUI gui;
	private assign2 a;
	public clueButtonHandler2(GUI gui,assign2 assi) {
		this.gui=gui;
		this.a=assi;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String[] x=gui.clueTF.getText().split(" ");
		if(x.length==1) {
			try {
				  int n = Integer.parseInt(gui.clueTF.getText());
				  gui.validClue=false;
				gui.ClueEntered=true;
				} catch (NumberFormatException e) {
					String y=gui.clueTF.getText().toUpperCase();
					if(a.clue(y)) {
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
