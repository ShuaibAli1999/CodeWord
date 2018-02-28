package code;

import java.util.ArrayList;
import java.util.Collections;

public class PersonAssignments {
	
	private ArrayList<String> retVal = new ArrayList<String>();
	
	public ArrayList<String> getList() {
		
		ArrayList<String> personList = new ArrayList<String>();
		
		personList.add("red agent 1");
		personList.add("red agent 2");
		personList.add("red agent 3");
		personList.add("red agent 4");
		personList.add("red agent 5");
		personList.add("red agent 6");
		personList.add("red agent 7");
		personList.add("red agent 8");
		personList.add("red agent 9");
		personList.add("blue agent 1");
		personList.add("blue agent 2");
		personList.add("blue agent 3");
		personList.add("blue agent 4");
		personList.add("blue agent 5");
		personList.add("blue agent 6");
		personList.add("blue agent 7");
		personList.add("blue agent 8");
		personList.add("innocent bystander 1");
		personList.add("innocent bystander 2");
		personList.add("innocent bystander 3");
		personList.add("innocent bystander 4");
		personList.add("innocent bystander 5");
		personList.add("innocent bystander 6");
		personList.add("innocent bystander 7");
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
