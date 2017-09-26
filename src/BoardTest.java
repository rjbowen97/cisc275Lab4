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
	
	@Test
	public void test_takeTurnInput_o() {
		Board test_board = new Board(dif);
		
		int preMoveX = test_board.player.getX();
		test_board.takeTurn('o');
		assertEquals(preMoveX, test_board.player.getX() + 1);
		
	}
	
	@Test
	public void test_takeTurnInput_p() {
		Board test_board = new Board(dif);
		
		int preMoveX = test_board.player.getX();
		test_board.takeTurn('p');
		assertEquals(preMoveX, test_board.player.getX() - 1);
	}
	
	@Test
	public void test_takeTurnInput_k() {
		Board test_board = new Board(dif);
		
		int preTurnScore = test_board.player.getScore();
		test_board.takeTurn('k');
		assertEquals(preTurnScore, test_board.player.getScore() - 1);
	}
	
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

		//testing moveRight()
		test_board.processChar('p');
		assertEquals(test_board.player.getX(), orig_player.getX());
	}
	
	@Test
	public void test_scoringTierZero() {
		
		Board test_board = new Board(dif);
		
		System.setOut(new PrintStream(outContent));
		
		test_board.scoring(0, 1);
		
		assertEquals("Wow...uhm...so...wow...", outContent.toString().trim());
	}
	
	@Test
	public void test_scoringTierOne() {
		Board test_board = new Board(dif);
		
		System.setOut(new PrintStream(outContent));
		
		test_board.scoring(151, 1);
		
		assertEquals("You tried...", outContent.toString().trim());
	}
	
	@Test
	public void test_scoringTierTwo() {
		Board test_board = new Board(dif);
		
		System.setOut(new PrintStream(outContent));
		
		test_board.scoring(201, 1);
		
		assertEquals("Are you even using the keys?", outContent.toString().trim());
	}
	
	@Test
	public void test_scoringTierThree() {
		Board test_board = new Board(dif);
		
		System.setOut(new PrintStream(outContent));
		
		test_board.scoring(301, 1);
		
		assertEquals("Pff *rolls eyes*", outContent.toString().trim());
	}
	
	@Test
	public void test_scoringTierFour() {
		Board test_board = new Board(dif);
		
		System.setOut(new PrintStream(outContent));
		
		test_board.scoring(401, 1);
		
		assertEquals("You are getting better at this :D", outContent.toString().trim());
	}
	
	@Test
	public void test_scoringTierFive() {
		Board test_board = new Board(dif);
		
		System.setOut(new PrintStream(outContent));
		
		test_board.scoring(501, 1);
		
		assertEquals("Holy Canoli, you are a monster!", outContent.toString().trim());
	}
	
	@Test
	public void test_scoringTierSix() {
		Board test_board = new Board(dif);
		
		System.setOut(new PrintStream(outContent));
		
		test_board.scoring(651, 1);
		
		assertEquals("You are a true champion!", outContent.toString().trim());
	}

}
