package test;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import code.CodenamesList;

public class CodenamesListTest {
		
		@Test
		public void shuffleTest() throws FileNotFoundException, IOException {
			
			ArrayList<String> test1 = new ArrayList<String>();
			CodenamesList list =  new CodenamesList();
			test1 = list.getList();
			assertTrue(test1.size() == 25);
//			assertEquals("", test1.get(0));
		
	}

}
