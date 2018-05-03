package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.assign;

public class version2ButtonHandler implements ActionListener {
		private GUI gui;
		public version2ButtonHandler( GUI g) {
			gui=g;
		}	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.teamVersion=3;
			gui.st=true;
			gui.update();
		}

	}
