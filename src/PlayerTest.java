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
	
	
}