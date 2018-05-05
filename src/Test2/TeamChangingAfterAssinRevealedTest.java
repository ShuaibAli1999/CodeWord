package Test2;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import code.assign2;

public class TeamChangingAfterAssinRevealedTest {
	@Test
	public void test1() {
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
		t3.setTurns(2);//green team's turn and blue team had revealed assassin.
		t3.RRA=true;
		t3.changeTurn();
		assertEquals(t3.turn(),1);//skipping red team and next team should be blue.
	}
	@Test
	public void test2() {
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
		t3.setTurns(0);//red team's turn and blue team had revealed assassin.
		t3.BRA=true;
		t3.changeTurn();
		assertEquals(t3.turn(),2);//skipping blue team and next team should be green.
	}
	@Test
	public void test3() {
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
		t3.setTurns(1);//blue team's turn and green team had revealed assassin.
		t3.GRA=true;
		t3.changeTurn();
		assertEquals(t3.turn(),0);//skipping green team and next team should be red.
		
	}
	}
