package vehicule;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TransmissionTest {

	private Transmission transm;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		transm = new Transmission();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetCurrentGear() {
		transm.setCurrentGear(2);
		assertEquals(2, transm.getCurrentGear());
		
		transm.setCurrentGear(-52);
		assertNotEquals(-52, transm.getCurrentGear());
	}

	@Test
	public final void testGetCurrentGearObj() {
		transm.setCurrentGear(Gear.FIRST);
		assertEquals(Gear.FIRST, transm.getCurrentGearObj());
	}

	@Test
	public final void testGetDifferentialRatio() {
		transm.setDifferentialRatio(4.041);
		assertEquals(4.041, transm.getDifferentialRatio(),0.0);
	}

}
