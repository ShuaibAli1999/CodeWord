package test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import code.assign;
import code.Location;
import code.PersonAssignments;
import code.CodenamesList;
import code.InvalidCountException;

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
	assertEquals("there is no person map to this codename",map.get(a.getcodename().get(0)),person.get(0));// checking if there is a person matching to the codenames.
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
	assertEquals("there is no person map to this codename",map.get(a.getcodename().get(1)),person.get(1));
	}
	
	@Test
	public void locationAssignments3() throws FileNotFoundException, IOException{
	assign a=new assign();
	CodenamesList c=new CodenamesList();
	PersonAssignments p=new PersonAssignments();
	a.gameStarted(c, p);
	Location[][] l=new Location[5][5];
	l=a.getBoard();
	HashMap<String, String> map=a.getAssignedCodeNameandValues();
	ArrayList<String> person=a.getperson();
	assertEquals("does not getting the correct names",l[4][4].getName(),a.getcodename().get(24));//check for last term.
	assertEquals("there is no person map to this codename",map.get(a.getcodename().get(24)),person.get(24));// checking if there is a person matching to the codenames.
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
	public void clueTest1() throws FileNotFoundException, IOException, InvalidCountException{//test when the clue doesn't contain any codenames that is not revealed.
	assign a=new assign();
	CodenamesList c=new CodenamesList();
	PersonAssignments p=new PersonAssignments();
	a.gameStarted(c, p);
	String x="location,3";
	assertTrue(a.clue(x));
	}
	
	@Test
	public void clueTest2() throws FileNotFoundException, IOException, InvalidCountException{//test when the clue contains a codename that is not revealed.
	assign a=new assign();
	CodenamesList c=new CodenamesList();
	PersonAssignments p=new PersonAssignments();
	a.gameStarted(c, p);
	String x=a.getcodename().get(1)+",5";
	assertFalse(a.clue(x));
	assertEquals(0,a.turn());//it becomes blue team's turn.
	}
	
	@Test
	public void clueTest3() throws FileNotFoundException, IOException, InvalidCountException{// test when the clue contain a codename that is revealed.
	assign a=new assign();
	CodenamesList c=new CodenamesList();
	PersonAssignments p=new PersonAssignments();
	a.gameStarted(c, p);
	Location[][] l=new Location[5][5];
	l=a.getBoard();
	a.updateLocation(l[0][1]);
	String x=a.getcodename().get(1)+",7";
	assertTrue(a.clue(x));
	assertTrue(a.getCount()==7);
	}	
	
	@Test(expected = InvalidCountException.class)
	public void clueTest5() throws FileNotFoundException, IOException, InvalidCountException{// test when the clue contain count number equals to zero
	assign a=new assign();
	CodenamesList c=new CodenamesList();
	PersonAssignments p=new PersonAssignments();
	a.gameStarted(c, p);
	Location[][] l=new Location[5][5];
	l=a.getBoard();
	a.updateLocation(l[0][1]);
	String x=a.getcodename().get(1)+",0";
	a.clue(x);
	}	
	
	@Test(expected = InvalidCountException.class)
	public void clueTest6() throws FileNotFoundException, IOException, InvalidCountException{// test when the clue contain count number less than zero
	assign a=new assign();
	CodenamesList c=new CodenamesList();
	PersonAssignments p=new PersonAssignments();
	a.gameStarted(c, p);
	Location[][] l=new Location[5][5];
	l=a.getBoard();
	a.updateLocation(l[0][1]);
	String x=a.getcodename().get(1)+",-1";
	a.clue(x);
	}
}

