package vehicule;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TripTest {
	
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
	
	
	private final static double diffRatio = 4.041;
	private final static int dist = 100 ;
	private final static int rpm = 3000;
	private final static double tireSize = 0.5;

	private Trip t0, t1, t2, t3, t4, t5, tr;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		t0 = createTrip(dist, createTripVehicule(tireSize, rpm, NEUTRAL_VALUE));

		t1 = createTrip(dist,
				createTripVehicule(tireSize, rpm, FIRST_VALUE));

		t2 = createTrip(dist,
				createTripVehicule(tireSize, rpm, SECOND_VALUE));

		t3 = createTrip(dist,
				createTripVehicule(tireSize, rpm, THIRD_VALUE));

		t4 = createTrip(dist,
				createTripVehicule(tireSize, rpm, FOURTH_VALUE));

		t5 = createTrip(dist,
				createTripVehicule(tireSize, rpm, FIFTH_VALUE));

		tr = createTrip(dist,
				createTripVehicule(tireSize, rpm, REVERSE_VALUE));
		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testGetExpectedTripDuration_t0() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,	NEUTRAL_RATIO,diffRatio), 
				t0.getExpectedTripDuration(),
				0.01);
		
		
	}

	
	@Test
	public void testGetExpectedTripDuration_t1() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,FIRST_RATIO,diffRatio),
				t1.getExpectedTripDuration(),
				0.01);
	}

	
	@Test
	public void testGetExpectedTripDuration_t2() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,SECOND_RATIO,diffRatio),
				t2.getExpectedTripDuration(),
				0.01);
	}
	

	@Test
	public void testGetExpectedTripDuration_t3() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,THIRD_RATIO,diffRatio),
				t3.getExpectedTripDuration(),
				0.01);
	}
	

	@Test
	public void testGetExpectedTripDuration_t4() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,FOURTH_RATIO,diffRatio),
				t4.getExpectedTripDuration(),
				0.01);
	}
	

	@Test
	public void testGetExpectedTripDuration_t5() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,FIFTH_RATIO,diffRatio),
				t5.getExpectedTripDuration(),
				0.01);
	}
	

	@Test
	public void testGetExpectedTripDuration_tR() {

		assert (t1.getExpectedTripDuration() < t5.getExpectedTripDuration());
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,REVERSE_RATIO,diffRatio),
				tr.getExpectedTripDuration(),
				0.01);
	}
	
	@Test
	public void testTripDuration_consistance() {

		assert (t0.getExpectedTripDuration() < t1.getExpectedTripDuration());
		assert (t1.getExpectedTripDuration() < t2.getExpectedTripDuration());
		assert (t2.getExpectedTripDuration() < t3.getExpectedTripDuration());
		assert (t3.getExpectedTripDuration() < t4.getExpectedTripDuration());
		assert (t4.getExpectedTripDuration() < t5.getExpectedTripDuration());
	}
	
	private double generateExpectedResult(int dist, double rpm,	double tireSize, double gearRatio, double diffRatio) {
		return dist / (( (tireSize * Math.PI) * ((rpm / gearRatio) / diffRatio) * .06));
	}

	private static Vehicule createTripVehicule(double tireSize, int rpm,
			int gear) {
		Vehicule v = new Vehicule();
		v.setTireSize(tireSize);
		v.getEngine().setRpm(rpm);
		v.getTransmission().setCurrentGear(gear);
		v.getTransmission().setDifferentialRatio(diffRatio);
		return v;
	}
	
	private static Trip createTrip(int dist, Vehicule v) {
		Trip t = new Trip(dist, v);
		return t;
	}

}
