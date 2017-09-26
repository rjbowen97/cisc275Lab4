import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BoardTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	protected int dif = 49;
	protected boolean lst = false; // lost
	protected int timr = 150;
	private int x_y = 20;
	protected Player orig_player = new Player(x_y, x_y);
	Board test_board = new Board(dif);
	

	@Test
	public void test_easy() {
		Board test_board = new Board(dif);
		assertEquals(test_board.difficulty, dif);
		assertFalse(test_board.lost);
		assertEquals(test_board.timer, timr);

		// test timer
		int new_time = 100;
		test_board.setTimer(new_time);
		assertEquals(new_time, test_board.timer);

		// testing moveLeft()
		test_board.processChar('o');
		assertEquals(test_board.player.getX(), orig_player.getX() - 1);

		test_board.processChar('p');
		assertEquals(test_board.player.getX(), orig_player.getX());

		// testing to walls
		test_board.processChar('o');
		
		for (int i = 0; i < 60; i++) {
			test_board.processChar('p');
		}

		// test upScore()
		test_board.processChar('k');

	}
	
	@Test
	public void test_scoringTierZero() {
		
		System.setOut(new PrintStream(outContent));
		
		test_board.scoring(0, 1);
		
		assertEquals("Wow...uhm...so...wow...", outContent.toString().trim());
	}
	
	@Test
	public void test_scoringTierOne() {
		
		System.setOut(new PrintStream(outContent));
		
		test_board.scoring(151, 1);
		
		assertEquals("You tried...", outContent.toString().trim());
	}
	
	@Test
	public void test_scoringTierTwo() {
		
		System.setOut(new PrintStream(outContent));
		
		test_board.scoring(201, 1);
		
		assertEquals("Are you even using the keys?", outContent.toString().trim());
	}
	
	@Test
	public void test_scoringTierThree() {
		
		System.setOut(new PrintStream(outContent));
		
		test_board.scoring(301, 1);
		
		assertEquals("Pff *rolls eyes*", outContent.toString().trim());
	}
	
	@Test
	public void test_scoringTierFour() {
		
		System.setOut(new PrintStream(outContent));
		
		test_board.scoring(401, 1);
		
		assertEquals("You are getting better at this :D", outContent.toString().trim());
	}
	
	@Test
	public void test_scoringTierFive() {
		
		System.setOut(new PrintStream(outContent));
		
		test_board.scoring(501, 1);
		
		assertEquals("Holy Canoli, you are a monster!", outContent.toString().trim());
	}
	
	@Test
	public void test_scoringTierSix() {
		
		System.setOut(new PrintStream(outContent));
		
		test_board.scoring(651, 1);
		
		assertEquals("You are a true champion!", outContent.toString().trim());
	}

}
