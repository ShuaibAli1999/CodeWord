package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.Location;
import code.assign;

public class codenameButtonHandler implements ActionListener{
	private GUI gui;
	private assign _m;
	private String codeName;
	public codenameButtonHandler(assign m , GUI g, String c) {
		gui=g;
		_m=m;
		codeName=c;
				
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i<_m.getBoard().length;i++ ) {
			for(int j = 0; j<_m.getBoard()[i].length;j++) {
				if(codeName.equals(_m.getBoard()[i][j].getName())) {
					if(_m.getAssignedCodeNameandValues().get(codeName).equals("assassin")) {
						gui.assas=true;
					}
					_m.updateLocation(_m.getBoard()[i][j]);
					if(_m.updateLocation(_m.getBoard()[i][j])==false) {
						_m.changeTurn();	
					}else {
						gui.updateCount=true;
						gui.count=gui.count-1;
					}
					gui.update();
					break;
				}
			}
		}
}
}
