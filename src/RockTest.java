import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RockTest {

	int testWidth = 6;
	int testHeight = 4;	
	Rock testRock = new Rock(testWidth, testHeight);

	@Test
	public void testGetX() {
		int obtainedX = testRock.getX();
		
		boolean inRange = (obtainedX >= 0 && obtainedX < testWidth);
		boolean outOfRange = (obtainedX < 0 || obtainedX >= testWidth);
		
		assertTrue("In range", inRange);
		assertFalse("Out of range", outOfRange);
		
	}
	
	@Test
	public void testGetY() {
		int obtainedY = testRock.getY();
		
		assertEquals(0, obtainedY);
	}
	
	@Test
	public void testMoveRock() {
		testRock.moveRock();
		assertEquals(0 + 1,testRock.getY());
	}
	
	@Test
	public void testToString() {
		assertEquals("O", testRock.toString());
	}

	@Test
	public void testSetXCoord() {
		testRock.setxCoord(3);
		assertEquals(3, testRock.getX());
	}
	
}
