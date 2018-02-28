package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
import code.PersonAssignments;

public class PersonAssignmentsTest {
	
	@Test
	public void testOne() {
		
		ArrayList<String> test1 = new ArrayList<String>();
		PersonAssignments firstTest = new PersonAssignments();
		test1 = firstTest.getList();
		assertTrue(test1.size() == 25);
		assertTrue(test1.contains("red agent 1"));
		assertTrue(test1.contains("red agent 2"));
		assertTrue(test1.contains("red agent 3"));
		assertTrue(test1.contains("red agent 4"));
		assertTrue(test1.contains("red agent 5"));
		assertTrue(test1.contains("red agent 6"));
		assertTrue(test1.contains("red agent 7"));
		assertTrue(test1.contains("red agent 8"));
		assertTrue(test1.contains("red agent 9"));
		assertTrue(test1.contains("blue agent 1"));
		assertTrue(test1.contains("blue agent 2"));
		assertTrue(test1.contains("blue agent 3"));
		assertTrue(test1.contains("blue agent 4"));
		assertTrue(test1.contains("blue agent 5"));
		assertTrue(test1.contains("blue agent 6"));
		assertTrue(test1.contains("blue agent 7"));
		assertTrue(test1.contains("blue agent 8"));
		assertTrue(test1.contains("innocent bystander 1"));
		assertTrue(test1.contains("innocent bystander 2"));
		assertTrue(test1.contains("innocent bystander 3"));
		assertTrue(test1.contains("innocent bystander 4"));
		assertTrue(test1.contains("innocent bystander 5"));
		assertTrue(test1.contains("innocent bystander 6"));
		assertTrue(test1.contains("innocent bystander 7"));
		assertTrue(test1.contains("assassin"));
////		assertEquals("", test1.get(0));
		
	}

}
