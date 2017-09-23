import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class PlayerTest {

	int testWidth = 8;
	int testHeight = 3;
	
	Player player = new Player(testHeight, testWidth);
	private long playerCreateTime = System.currentTimeMillis();
	
	
	@Test
	public void testGetX() {
		int obtainedX = player.getX();
		assertEquals(testWidth / 2, obtainedX);
	}
	
	@Test
	public void testGetY() {
		int obtainedY = player.getY();
		assertEquals(testHeight, obtainedY);
	}
	
	@Test
	public void testGetTime() {
		assertEquals(System.currentTimeMillis() - playerCreateTime, player.getTime());
	}
	
	@Test
	public void testGetScore() {
		assertEquals(0, player.getScore());
	}
	
	@Test
	public void testSetXCoord() {
		player.setXcoord(21);
		assertEquals(21, player.getX());
	}
	
	@Test
	public void testSetYCoord() {
		player.setYcoord(19);
		assertEquals(19, player.getY());
	}
	
	@Test
	public void testMoveLeft() {
		player.moveLeft();
		
		assertEquals(1, player.getScore());
		assertEquals(testWidth / 2 - 1, 3);
	}
	
	@Test
	public void testMoveRight() {
		player.moveRight();
		
		assertEquals(1, player.getScore());
		assertEquals(testWidth / 2 + 1, 5);
	}
	
	@Test
	public void testToString() {
		assertEquals("X", player.toString());
	}
	
	@Test
	public void testUpScore() {
		player.upScore();
		assertEquals(1, player.getScore());
	}
	
	
}