package test;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import code.CodenamesList;
import code.InvalidCountException;
import code.Location;
import code.PersonAssignments;
import code.assign;

public class UpdateLocationTest {
	@Test
	public void test1() {
		PersonAssignments t1 = new PersonAssignments();
		CodenamesList t2 = new CodenamesList();
		assign t3 = new assign();
		Location te = null;
		try {
			t3.gameStarted();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String cn : t3.getAssignedCodeNameandValues().keySet()) {
			if(t3.getAssignedCodeNameandValues().get(cn).equals("red agent")) {
				te = new Location(cn);
				break;
			}
		}
			t3.clue("bannanaz,4");
		
		t3.updateLocation(te);
		assertTrue(t3.getCount() == 3);
		assertTrue(t3.getRedTotal()==8);
		assertTrue(t3.updateLocation(te));
		assertTrue(t3.getReveal().get(te.getName()));
		
	}

}
