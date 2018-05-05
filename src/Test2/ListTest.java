package Test2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import code.PersonAssignments;
import code.PersonAssignments2;

public class ListTest {
	@Test
	public void AssignmentTest() {
		ArrayList<String> test1 = new ArrayList<String>();
		PersonAssignments2 firstTest = new PersonAssignments2();
		test1 = firstTest.getList();
		assertTrue(test1.size() == 25);
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
		for(int i=0;i<5;i++) {
			assertTrue(test1.remove("green agent"));
		}
		assertTrue(test1.remove("innocent bystander"));
		assertTrue(test1.remove("innocent bystander"));
		assertTrue(test1.remove("innocent bystander"));
		assertTrue(test1.remove("innocent bystander"));
		assertTrue(test1.remove("innocent bystander"));
		assertTrue(test1.remove("innocent bystander"));
		assertTrue(test1.remove("innocent bystander"));
		assertTrue(test1.remove("assassin"));
		assertTrue(test1.remove("assassin"));
		assertEquals(0,test1.size());
	}
}
