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
					if(_m.getAssignedCodeNameandValues().get(codeName).equals("red agent") && _m.count==0) {
						_m.redTotal--;
					}
					if(_m.getAssignedCodeNameandValues().get(codeName).equals("blue agent") && _m.count==0) {
						_m.blueTotal--;
					}
					
					if(_m.updateLocation(_m.getBoard()[i][j])!=false) {
						gui.updateCount=true;
					}
						
					
					gui.update();
					break;
				}
			}
		}
}
}
