package vehicule;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class TireTest extends TestCase {

	static double diameter = 0.5;
	
	
	Tire t;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		t = new Tire(diameter);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetDiameter() {
		assertEquals(diameter, t.getDiameter(), 0.0);
	}

}
