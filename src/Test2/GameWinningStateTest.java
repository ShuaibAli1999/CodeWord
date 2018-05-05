package Test2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import code.CodenamesList;
import code.PersonAssignments;
import code.PersonAssignments2;
import code.assign;
import code.assign2;

public class GameWinningStateTest {
	@Test
	public void test1() {
		PersonAssignments2 t1 = new PersonAssignments2();
		CodenamesList t2 = new CodenamesList();
		assign2 t3 = new assign2();
		try {
			t3.gameStarted();
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
		PersonAssignments2 t1 = new PersonAssignments2();
		CodenamesList t2 = new CodenamesList();
		assign2 t3 = new assign2();
		try {
			t3.gameStarted();
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
		PersonAssignments2 t1 = new PersonAssignments2();
		CodenamesList t2 = new CodenamesList();
		assign2 t3 = new assign2();
		try {
			t3.gameStarted();
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
		PersonAssignments2 t1 = new PersonAssignments2();
		CodenamesList t2 = new CodenamesList();
		assign2 t3 = new assign2();
		try {
			t3.gameStarted();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(t3.winningState()==10);
	}
	@Test
	public void test5() {
		PersonAssignments2 t1 = new PersonAssignments2();
		CodenamesList t2 = new CodenamesList();
		assign2 t3 = new assign2();
		try {
			t3.gameStarted();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String green: t3.getAssignedCodeNameandValues().keySet()) {
			if(t3.getAssignedCodeNameandValues().get(green).equals("green agent")) {
				t3.getReveal().put(green,true);
			}
		}
		assertTrue(t3.winningState()==2);
	}
}
