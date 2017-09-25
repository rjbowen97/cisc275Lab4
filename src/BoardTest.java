import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BoardTest {

	protected int dif = 1;
	protected boolean lst = false; // lost
	protected int timr = 150;
	private int x_y = 20;
	protected Player orig_player = new Player(x_y, x_y);

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
		for (int i = 0; i < 60; i++) {
			test_board.processChar('o');
		}
		for (int i = 0; i < 60; i++) {
			test_board.processChar('p');
		}

		// test upScore()
		test_board.processChar('k');

	}

}
