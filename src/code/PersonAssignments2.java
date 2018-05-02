package code;

import java.util.ArrayList;
import java.util.Collections;

/**
 * this class is used to create a shuffled arraylist of person assignments
 * 
 * @author jenny
 */

public class PersonAssignments2 {
	
	/**
	 * an arraylist that will have 25 person assignments added to it and
	 * shuffled to be returned by the method
	 */
	private ArrayList<String> retVal = new ArrayList<String>();

	/** 
	 * this method adds 9 "red agents", 8 "blue agents", 7 "innocent bystanders"
	 * and one assassin to an arraylist and then shuffles the entries into
	 * different indexes for randomness
	 * 
	 * @return a shuffled arraylist of 25 person assignments
	 */
	public ArrayList<String> getList() {
		
		// adds 25 person assignments to an array list
		retVal.add("red agent");
		retVal.add("red agent");
		retVal.add("red agent");
		retVal.add("red agent");
		retVal.add("red agent");
		retVal.add("red agent");
		retVal.add("blue agent");
		retVal.add("blue agent");
		retVal.add("blue agent");
		retVal.add("blue agent");
		retVal.add("blue agent");
		retVal.add("green agent");
		retVal.add("green agent");
		retVal.add("green agent");
		retVal.add("green agent");
		retVal.add("green agent");
		retVal.add("innocent bystander");
		retVal.add("innocent bystander");
		retVal.add("innocent bystander");
		retVal.add("innocent bystander");
		retVal.add("innocent bystander");
		retVal.add("innocent bystander");
		retVal.add("innocent bystander");
		retVal.add("assassin");
		retVal.add("assassin");
		
		// shuffles elements within the arrayList to different indexes
		Collections.shuffle(retVal);
		
		return retVal; // returns arraylist with all the persons shuffled
		
	}

}
