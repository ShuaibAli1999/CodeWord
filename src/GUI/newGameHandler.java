package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.assign;

public class newGameHandler implements ActionListener {
	private GUI gui;
	public newGameHandler(GUI g) {
		gui = g;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gui.st=true;
		gui.update();
	}

}
