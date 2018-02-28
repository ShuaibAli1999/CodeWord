package test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import code.assign;
import code.Location;
import code.PersonAssignments;
import code.CodenamesList;

public class LocationAssignmentsTest{
	@Test
	public void locationAssignments1() throws FileNotFoundException, IOException{
	assign a=new assign();
	CodenamesList c=new CodenamesList();
	PersonAssignments p=new PersonAssignments();
	a.gameStarted(c, p);
	Location[][] l=new Location[5][5];
	l=a.getBoard();
	HashMap<String, String> map=a.getAssignedCodeNameandValues();
	ArrayList<String> person=a.getperson();
	assertEquals("does not getting the correct names",l[0][0].getName(),a.getcodename().get(0));
	assertEquals("does not getting the correct names",map.get(a.getcodename().get(0)),person.get(0));// checking if there is a person matching to the codenames.
	}
	
	@Test
	public void locationAssignments2() throws FileNotFoundException, IOException{
	assign a=new assign();
	CodenamesList c=new CodenamesList();
	PersonAssignments p=new PersonAssignments();
	a.gameStarted(c, p);
	Location[][] l=new Location[5][5];
	l=a.getBoard();
	HashMap<String, String> map=a.getAssignedCodeNameandValues();
	ArrayList<String> person=a.getperson();
	assertEquals("does not getting the correct names",l[0][1].getName(),a.getcodename().get(1));
	assertEquals("does not getting the correct names",map.get(a.getcodename().get(1)),person.get(1));
	}
	
	@Test
	public void turnTest() throws FileNotFoundException, IOException{
	assign a=new assign();
	CodenamesList c=new CodenamesList();
	PersonAssignments p=new PersonAssignments();
	a.gameStarted(c, p);
	assertEquals("red team should go first",1,a.turn());
	}
	
	@Test
	public void clueTest1() throws FileNotFoundException, IOException{//test when the clue doesn't contain any codenames that is not revealed.
	assign a=new assign();
	CodenamesList c=new CodenamesList();
	PersonAssignments p=new PersonAssignments();
	a.gameStarted(c, p);
	String x="It is a location.";
	assertTrue(a.clue(x));
	}
	
	@Test
	public void clueTest2() throws FileNotFoundException, IOException{//test when the clue contains a codename that is not revealed.
	assign a=new assign();
	CodenamesList c=new CodenamesList();
	PersonAssignments p=new PersonAssignments();
	a.gameStarted(c, p);
	String x="You should choose "+a.getcodename().get(1);
	assertFalse(a.clue(x));
	}
	
	@Test
	public void clueTest3() throws FileNotFoundException, IOException{// test when the clue contain a codename that is revealed.
	assign a=new assign();
	CodenamesList c=new CodenamesList();
	PersonAssignments p=new PersonAssignments();
	a.gameStarted(c, p);
	Location[][] l=new Location[5][5];
	l=a.getBoard();
	a.selected(l[0][1]);
	String x="You should choose "+a.getcodename().get(1);
	assertTrue(a.clue(x));
	}
}
