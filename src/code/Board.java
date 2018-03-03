package code;
/**
 * This is 5x5 grid space holder for location array.
 */
public class Board {
/**
 * Set both the row and column to 5.
 */
private int row = 5;
private int col = 5;

/**
 * This is a default constructor.
 */
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
/**
 * This is a getter method that return a location.
 * @return a specific location from location array.
 */
public Location getLoc(int x, int y){
	return b[x][y];
}
/**
 * This is a getter method that return a location array.
 * @return the location array
 */
public Location[][] getArray() {
	return b;
}


}




	

