package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import code.CodenamesList;
import code.PersonAssignments;
import code.assign;

public class TeamWonTest {

	@Test
	public void teamWonTest() throws FileNotFoundException, IOException{//test when assassin is revealed
	assign a=new assign();
	CodenamesList c=new CodenamesList();
	PersonAssignments p=new PersonAssignments();
	a.gameStarted(c, p);
	if(a.winningState()==0) {
	a.setTurns(1);
	assertEquals("blue team", a.teamWon());
	a.setTurns(0);
	assertEquals("red team", a.teamWon());
	}}
	@Test
	public void teamWonTestIfNotRevealed() throws FileNotFoundException, IOException{//test when assassin is revealed
	assign a=new assign();
	CodenamesList c=new CodenamesList();
	PersonAssignments p=new PersonAssignments();
	a.gameStarted(c, p);
	if(a.winningState()!=0) {
	a.setTurns(1);
	assertEquals(null, a.teamWon());
	a.setTurns(0);
	assertEquals(null, a.teamWon());
	}}
}

