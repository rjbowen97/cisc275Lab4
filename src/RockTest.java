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

}
