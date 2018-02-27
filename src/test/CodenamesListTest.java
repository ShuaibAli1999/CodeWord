package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import code.CodenamesList;
import code.wordsListMaker;

public class CodenamesListTest {
	
	@Test
	public void shuffleListTest() throws FileNotFoundException, IOException {
		
		ArrayList<String> test1 = new ArrayList<String>();
		CodenamesList firstTest = new CodenamesList();
		wordsListMaker words = new wordsListMaker();
		test1 = firstTest.shuffleList(test1);
		assertTrue(test1.size() == 400);
		assertEquals("AFRICA", test1.get(0));
//		assertTrue(test1.size() == 1);
		
	}

}
