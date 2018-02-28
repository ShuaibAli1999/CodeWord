package code;

import java.util.ArrayList;
import java.util.Collections;

public class PersonAssignments {
	
	private ArrayList<String> retVal = new ArrayList<String>();
	
	public ArrayList<String> getList() {
		
		ArrayList<String> personList = new ArrayList<String>();
		
		personList.add("red agent");
		personList.add("red agent");
		personList.add("red agent");
		personList.add("red agent");
		personList.add("red agent");
		personList.add("red agent");
		personList.add("red agent");
		personList.add("red agent");
		personList.add("red agent");
		personList.add("blue agent");
		personList.add("blue agent");
		personList.add("blue agent");
		personList.add("blue agent");
		personList.add("blue agent");
		personList.add("blue agent");
		personList.add("blue agent");
		personList.add("blue agent");
		personList.add("innocent bystander");
		personList.add("innocent bystander");
		personList.add("innocent bystander");
		personList.add("innocent bystander");
		personList.add("innocent bystander");
		personList.add("innocent bystander");
		personList.add("innocent bystander");
		personList.add("assassin");
		
		Collections.shuffle(personList);
		
		retVal = personList;
		return retVal;
		
	}
	
//	public ArrayList<String> getList(){
//		
//		return retVal;
//		
//	}

}
