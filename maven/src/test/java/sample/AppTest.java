package sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AppTest {
	@Test
	public void testAddition() {
		App app = new App();
		assertEquals(8, app.add(5, 3), "5 + 3 should be 8");
	}

}
