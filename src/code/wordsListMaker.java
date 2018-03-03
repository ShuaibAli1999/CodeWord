package code;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * This is a class that make get all the words from Gamewords1.txt, and save in an arraylist.
 */
public class wordsListMaker {
private String line;
private ArrayList<String> words = new ArrayList<String>();

/**
 * This is a constructor that add words from the file to words instance variable.
 * @throws FileNotFoundException, IOException.
 */
public wordsListMaker() throws FileNotFoundException, IOException {
	try (
	    InputStream fis = new FileInputStream("Gamewords1.txt");
	    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
	    BufferedReader br = new BufferedReader(isr);
	) {
	    while ((line = br.readLine()) != null) {
	         words.add(line);
	    }
	}
}

/**
 * This is a getter method that get the words instance variable.
 * @return The arraylist of all the words.
 */
public ArrayList<String> getList() {
	
	return words;
}

}
