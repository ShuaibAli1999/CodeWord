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
		assertTrue(test1.remove("red agent"));
		assertTrue(test1.remove("red agent"));
		assertTrue(test1.remove("red agent"));
		assertTrue(test1.remove("red agent"));
		assertTrue(test1.remove("red agent"));
		assertTrue(test1.remove("red agent"));
		assertTrue(test1.remove("red agent"));
		assertTrue(test1.remove("red agent"));
		assertTrue(test1.remove("red agent"));
		assertTrue(test1.remove("blue agent"));
		assertTrue(test1.remove("blue agent"));
		assertTrue(test1.remove("blue agent"));
		assertTrue(test1.remove("blue agent"));
		assertTrue(test1.remove("blue agent"));
		assertTrue(test1.remove("blue agent"));
		assertTrue(test1.remove("blue agent"));
		assertTrue(test1.remove("blue agent"));
		assertTrue(test1.remove("innocent bystander"));
		assertTrue(test1.remove("innocent bystander"));
		assertTrue(test1.remove("innocent bystander"));
		assertTrue(test1.remove("innocent bystander"));
		assertTrue(test1.remove("innocent bystander"));
		assertTrue(test1.remove("innocent bystander"));
		assertTrue(test1.remove("innocent bystander"));
		assertTrue(test1.remove("assassin"));
////		assertEquals("", test1.get(0));
		
	}

}
