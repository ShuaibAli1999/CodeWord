package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import code.CodenamesList;
import code.PersonAssignments;
import code.assign;

public class GameWinningStateTest {
	@Test
	public void test1() {
		PersonAssignments t1 = new PersonAssignments();
		CodenamesList t2 = new CodenamesList();
		assign t3 = new assign();
		try {
			t3.gameStarted(t2, t1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String assas: t3.getAssignedCodeNameandValues().keySet()) {
			if(t3.getAssignedCodeNameandValues().get(assas).equals("assassin")) {
				t3.getReveal().put(assas,true);
			}
		}
		assertTrue(t3.winningState()==0);
	}
	@Test
	public void test2() {
		PersonAssignments t1 = new PersonAssignments();
		CodenamesList t2 = new CodenamesList();
		assign t3 = new assign();
		try {
			t3.gameStarted(t2, t1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String blue: t3.getAssignedCodeNameandValues().keySet()) {
			if(t3.getAssignedCodeNameandValues().get(blue).equals("blue agent")) {
				t3.getReveal().put(blue,true);
			}
		}
		assertTrue(t3.winningState()==1);
	}
	@Test
	public void test3() {
		PersonAssignments t1 = new PersonAssignments();
		CodenamesList t2 = new CodenamesList();
		assign t3 = new assign();
		try {
			t3.gameStarted(t2, t1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String red: t3.getAssignedCodeNameandValues().keySet()) {
			if(t3.getAssignedCodeNameandValues().get(red).equals("red agent")) {
				t3.getReveal().put(red,true);
			}
		}
		assertTrue(t3.winningState()==-1);
	}
	@Test
	public void test4() {
		PersonAssignments t1 = new PersonAssignments();
		CodenamesList t2 = new CodenamesList();
		assign t3 = new assign();
		try {
			t3.gameStarted(t2, t1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(t3.winningState()==10);
	}
}
