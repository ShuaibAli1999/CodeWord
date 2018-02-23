package code;
public class Board {

	
private int row;
private int col;
public Board() {
	
}

public void createBoard() {
	
	Location[][] b = new Location[row][col];
	for(int i=0;i<row;i++) {
		for(int j=0;j<row;j++) {;
			b[i][j] = new Location(null);
		}
	}
}




}
	

