package vehicule;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EngineTest {

	private Engine eng;
	private static int rpm = 3000;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		eng = new Engine(); 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetRpm() {
		eng.setRpm(rpm);
		assertEquals(rpm, eng.getRpm());
	}

}
