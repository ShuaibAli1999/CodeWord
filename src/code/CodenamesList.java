package code;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CodenamesList{
	
	private ArrayList<String> retVal;
	private ArrayList<String> halfShuffledList;
	private ArrayList<String> shuffledList;

	public ArrayList<String> shuffleList(ArrayList<String> originalList) throws FileNotFoundException, IOException {
		
		
		wordsListMaker list =  new wordsListMaker();
		originalList = list.getList();
		String transferWord = "";
		retVal=new ArrayList<>();
		retVal.add(originalList.get(0));

		return originalList;
	}

}
