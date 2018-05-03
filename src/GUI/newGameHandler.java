package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.assign;
/*
 * Class that sets st to true an updates the GUI. st then creates a new randomized game board.
 */
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
