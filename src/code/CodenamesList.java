package code;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CodenamesList {
	
	private ArrayList<String> retVal;
	private ArrayList<String> originalList;
	
	public ArrayList<String> getList() throws FileNotFoundException, IOException {
		
		originalList = new ArrayList<String>();
		wordsListMaker words = new wordsListMaker();
		originalList = words.getList();
		
		Collections.shuffle(originalList);
		
		retVal = new ArrayList<String>();
		
		retVal.add(originalList.get(165));
		retVal.add(originalList.get(156));
		retVal.add(originalList.get(278));
		retVal.add(originalList.get(377));
		retVal.add(originalList.get(268));
		retVal.add(originalList.get(253));
		retVal.add(originalList.get(10));
		retVal.add(originalList.get(221));
		retVal.add(originalList.get(140));
		retVal.add(originalList.get(192));
		retVal.add(originalList.get(386));
		retVal.add(originalList.get(351));
		retVal.add(originalList.get(363));
		retVal.add(originalList.get(101));
		retVal.add(originalList.get(124));
		retVal.add(originalList.get(176));
		retVal.add(originalList.get(13));
		retVal.add(originalList.get(327));
		retVal.add(originalList.get(383));
		retVal.add(originalList.get(202));
		retVal.add(originalList.get(31));
		retVal.add(originalList.get(341));
		retVal.add(originalList.get(229));
		retVal.add(originalList.get(279));
		retVal.add(originalList.get(103));
		
		return retVal;
		
	}
	
//	public ArrayList<String> getList(){
//		
//		return retVal;
//		
//	}
	
}