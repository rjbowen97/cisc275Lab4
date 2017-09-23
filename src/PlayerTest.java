import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class PlayerTest {

	WaitForCharThread waitForCharThread = new WaitForCharThread();

	@Test(expected = IOException.class)
	public void testRun() {
		waitForCharThread.run();
	}
}