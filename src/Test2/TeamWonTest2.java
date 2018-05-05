package Test2;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import code.CodenamesList;
import code.PersonAssignments;
import code.PersonAssignments2;
import code.assign;
import code.assign2;

public class TeamWonTest2 {

	@Test
	public void teamWonTest() throws FileNotFoundException, IOException{//test when assassin is revealed
	assign2 a=new assign2();
	CodenamesList c=new CodenamesList();
	PersonAssignments2 p=new PersonAssignments2();
	a.gameStarted();
	for(String assas: a.getAssignedCodeNameandValues().keySet()) {
		if(a.getAssignedCodeNameandValues().get(assas).equals("assassin")) {
			a.getReveal().put(assas,true);
		}
	}
	a.BRA=true;
	a.GRA=true;
	assertEquals("RED TEAM", a.teamWon());
	}
	@Test
	public void teamWonTest2() throws FileNotFoundException, IOException{//test when assassin is revealed
	assign2 a=new assign2();
	CodenamesList c=new CodenamesList();
	PersonAssignments2 p=new PersonAssignments2();
	a.gameStarted();
	for(String assas: a.getAssignedCodeNameandValues().keySet()) {
		if(a.getAssignedCodeNameandValues().get(assas).equals("assassin")) {
			a.getReveal().put(assas,true);
		}
	}
	a.RRA=true;
	a.GRA=true;
	assertEquals("BLUE TEAM", a.teamWon());
	}
	@Test
	public void teamWonTest3() throws FileNotFoundException, IOException{//test when assassin is revealed
	assign2 a=new assign2();
	CodenamesList c=new CodenamesList();
	PersonAssignments2 p=new PersonAssignments2();
	a.gameStarted();
	for(String assas: a.getAssignedCodeNameandValues().keySet()) {
		if(a.getAssignedCodeNameandValues().get(assas).equals("assassin")) {
			a.getReveal().put(assas,true);
		}
	}
	a.RRA=true;
	a.BRA=true;
	assertEquals("GREEN TEAM", a.teamWon());
	}
	
	@Test
	public void teamWonTestIfNotRevealed() throws FileNotFoundException, IOException{//test when assassin is revealed
	assign2 a=new assign2();
	CodenamesList c=new CodenamesList();
	PersonAssignments2 p=new PersonAssignments2();
	a.gameStarted();
	for(String assas: a.getAssignedCodeNameandValues().keySet()) {
		if(a.getAssignedCodeNameandValues().get(assas).equals("assassin")) {
			a.getReveal().put(assas,true);
			break;
		}
	}
	
	a.setTurns(1);
	assertEquals(null, a.teamWon());
	a.setTurns(0);
	assertEquals(null, a.teamWon());
	a.setTurns(2);
	assertEquals(null, a.teamWon());
	}
	}


