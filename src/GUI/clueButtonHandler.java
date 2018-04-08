package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import code.assign;

public class clueButtonHandler implements ActionListener{
	private GUI gui;
	private assign a;
	
	public clueButtonHandler(GUI gui,assign assi) {
		this.gui=gui;
		this.a=assi;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String[] x=gui.clueTF.getText().split(" ");
		if(x.length==1) {
			String y=gui.clueTF.getText().toUpperCase();
		if(a.clue(y)) {
			gui.valid=true;
			gui.Entered=true;
		}else {
			gui.valid=false;
			gui.Entered=true;
		}}
		else {
			gui.valid=false;
			gui.Entered=true;
		}
		gui.update();
	}

}
