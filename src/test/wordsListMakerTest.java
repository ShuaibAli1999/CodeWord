package test;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import code.wordsListMaker;

public class wordsListMakerTest {


 @Test
public void listCheckerTest() throws FileNotFoundException, IOException {
	ArrayList<String> test = new ArrayList<String>();
	wordsListMaker  l=  new wordsListMaker();
	test = l.getList();
	assertEquals("AFRICA",test.get(0));
	assertEquals("AIR",test.get(2));
	assertEquals("AMAZON",test.get(5));
}

}
