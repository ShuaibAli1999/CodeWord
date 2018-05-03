package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.assign;

public class version1ButtonHandler implements ActionListener{
	private GUI gui;
	public version1ButtonHandler( GUI g) {
		gui=g;
	}	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.teamVersion=2;
			gui.st=true;
			gui.update(); 
		}

	}

