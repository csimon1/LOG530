package vehicule;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GearTest {

	
	public static final int NEUTRAL_VALUE =  0;
	public static final int FIRST_VALUE = 1;
	public static final int SECOND_VALUE =  2;
	public static final int THIRD_VALUE =  3;
	public static final int FOURTH_VALUE =  4;
	public static final int FIFTH_VALUE =  5;
	public static final int REVERSE_VALUE =  -1;
	
	public static final double NEUTRAL_RATIO =  0;
	public static final double FIRST_RATIO = 3.615;
	public static final double SECOND_RATIO =  2.053;
	public static final double THIRD_RATIO =  1.370;
	public static final double FOURTH_RATIO =  1.031;
	public static final double FIFTH_RATIO =  0.837;
	public static final double REVERSE_RATIO =  3.583;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetValue_0() {
		assertEquals(Gear.NEUTRAL.getRatio(), 0 ,0.01);
	}
	
	@Test
	public final void testGetValue_1() {
		assertEquals(Gear.FIRST.getValue(), 1,0.01);
	}
	@Test
	public final void testGetValue_2() {
		assertEquals(Gear.SECOND.getValue(), 2,0.01);
	}
	@Test
	public final void testGetValue_3() {
		assertEquals(Gear.THIRD.getValue(), 3,0.01);
	}
	@Test
	public final void testGetValue_4() {
		assertEquals(Gear.FOURTH.getValue(), 4,0.01);
	}
	@Test
	public final void testGetValue_5() {
		assertEquals(Gear.FIFTH.getValue(), 5,0.01);
	}
	@Test
	public final void testGetValue_R() {
		assertEquals(Gear.REVERSE.getValue(), -1,0.01);
	}
	
	@Test
	public final void testGetRatio_0() {
		assertEquals(Gear.NEUTRAL.getRatio(), 0 ,0.01);
	}
	
	@Test
	public final void testGetRatio_1() {
		assertEquals(Gear.FIRST.getRatio(), 3.615,0.01);
	}
	@Test
	public final void testGetRatio_2() {
		assertEquals(Gear.SECOND.getRatio(), 2.053,0.01);
	}
	@Test
	public final void testGetRatio_3() {
		assertEquals(Gear.THIRD.getRatio(), 1.370,0.01);
	}
	@Test
	public final void testGetRatio_4() {
		assertEquals(Gear.FOURTH.getRatio(), 1.031,0.01);
	}
	@Test
	public final void testGetRatio_5() {
		assertEquals(Gear.FIFTH.getRatio(), 0.837,0.01);
	}
	@Test
	public final void testGetRatio_R() {
		assertEquals(Gear.REVERSE.getRatio(), 3.583,0.01);
	}
	
}
