package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.assign;
import code.assign2;
/*
 * handles the pass button. allows the player to change the turn.
 */
public class passHandler implements ActionListener {
	private assign _m;
	private assign2 _m2;
	private GUI gui;
	public passHandler(assign m, assign2 m2,GUI g) {
		_m=m;
		_m2=m2;
		gui=g;
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(gui.teamVersion==2) {
		_m.changeTurn();}
		else if(gui.teamVersion==3) {
			_m2.changeTurn();
		}
		gui.update();
	}

}
