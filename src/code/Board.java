package code;
public class Board {

	
private int row = 5;
private int col = 5;
public Board() {
	
}
Location[][] b = new Location[row][col];
public void createBoard() {
	
	
	for(int i=0;i<row;i++) {
		for(int j=0;j<row;j++) {;
			b[i][j] = new Location(null);
		}
	}
}

public Location getLoc(int x, int y){
	return b[x][y];
}
}




	

