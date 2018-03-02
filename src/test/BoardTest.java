package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import code.Board;

public class BoardTest {

@Test
public void createBoardTest() {
	Board b = new Board();
	b.createBoard();
	assertNotNull(b);
}
	
	
}
