package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.assign;
/*
 * handles the pass button. allows the player to change the turn.
 */
public class passHandler implements ActionListener {
	private assign _m;
	private GUI gui;
	public passHandler(assign m, GUI g) {
		_m=m;
		gui=g;
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		_m.changeTurn();
		gui.update();
	}

}
