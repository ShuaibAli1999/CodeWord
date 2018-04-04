package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.assign;

public class passHandler implements ActionListener {
	private assign _m;

	public passHandler(assign m) {
		_m=m;
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		_m.changeTurn();
	}

}
