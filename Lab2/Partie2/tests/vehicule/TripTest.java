package vehicule;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TripTest {

	private final static double diffRatio = 4.041;
	private final static int dist = 100 ;
	private final static int rpm = 3000;
	private final static double tireSize = 0.5;

	private Trip t0, t1, t2, t3, t4, t5, tr;
	private Trip t0_AfterRefactor, t1_AfterRefactor, t2_AfterRefactor, t3_AfterRefactor, t4_AfterRefactor, t5_AfterRefactor, tr_AfterRefactor;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		t0 = createTrip(dist, createTripVehicule(tireSize, rpm, GearTest.NEUTRAL_VALUE));

		t1 = createTrip(dist,
				createTripVehicule(tireSize, rpm, GearTest.FIRST_VALUE));

		t2 = createTrip(dist,
				createTripVehicule(tireSize, rpm, GearTest.SECOND_VALUE));

		t3 = createTrip(dist,
				createTripVehicule(tireSize, rpm, GearTest.THIRD_VALUE));

		t4 = createTrip(dist,
				createTripVehicule(tireSize, rpm, GearTest.FOURTH_VALUE));

		t5 = createTrip(dist,
				createTripVehicule(tireSize, rpm, GearTest.FIFTH_VALUE));

		tr = createTrip(dist,
				createTripVehicule(tireSize, rpm, GearTest.REVERSE_VALUE));
		
		//AfterRefactor
		t0_AfterRefactor = createTrip(dist, createTripVehicule_AfterRefactor(tireSize, rpm, Gear.NEUTRAL));

		t1_AfterRefactor = createTrip(dist,
				createTripVehicule_AfterRefactor(tireSize, rpm, Gear.FIRST));

		t2_AfterRefactor = createTrip(dist,
				createTripVehicule_AfterRefactor(tireSize, rpm, Gear.SECOND));

		t3_AfterRefactor = createTrip(dist,
				createTripVehicule_AfterRefactor(tireSize, rpm, Gear.THIRD));

		t4_AfterRefactor = createTrip(dist,
				createTripVehicule_AfterRefactor(tireSize, rpm, Gear.FOURTH));

		t5_AfterRefactor = createTrip(dist,
				createTripVehicule_AfterRefactor(tireSize, rpm, Gear.FIFTH));

		tr_AfterRefactor = createTrip(dist,
				createTripVehicule_AfterRefactor(tireSize, rpm, Gear.REVERSE));
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testGetExpectedTripDuration_t0() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,	GearTest.NEUTRAL_RATIO,diffRatio), 
				t0.getExpectedTripDuration(),
				0.01);
		
		
	}

	
	@Test
	public void testGetExpectedTripDuration_t1() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,GearTest.FIRST_RATIO,diffRatio),
				t1.getExpectedTripDuration(),
				0.01);
	}

	
	@Test
	public void testGetExpectedTripDuration_t2() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,GearTest.SECOND_RATIO,diffRatio),
				t2.getExpectedTripDuration(),
				0.01);
	}
	

	@Test
	public void testGetExpectedTripDuration_t3() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,GearTest.THIRD_RATIO,diffRatio),
				t3.getExpectedTripDuration(),
				0.01);
	}
	

	@Test
	public void testGetExpectedTripDuration_t4() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,GearTest.FOURTH_RATIO,diffRatio),
				t4.getExpectedTripDuration(),
				0.01);
	}
	

	@Test
	public void testGetExpectedTripDuration_t5() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,GearTest.FIFTH_RATIO,diffRatio),
				t5.getExpectedTripDuration(),
				0.01);
	}
	

	@Test
	public void testGetExpectedTripDuration_tR() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,GearTest.REVERSE_RATIO,diffRatio),
				tr.getExpectedTripDuration(),
				0.01);
	}

	public void testGetExpectedTripDuration_t0_AfterRefactor() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,	Gear.NEUTRAL.getRatio(),diffRatio), 
				t0_AfterRefactor.getExpectedTripDuration(),
				0.01);
	}
	

	@Test
	public void testGetExpectedTripDuration_t1_AfterRefactor() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,Gear.FIRST.getRatio(),diffRatio),
				t1_AfterRefactor.getExpectedTripDuration(),
				0.01);
	}

	@Test
	public void testGetExpectedTripDuration_t2_AfterRefactor() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,Gear.SECOND.getRatio(),diffRatio),
				t2_AfterRefactor.getExpectedTripDuration(),
				0.01);
	}

	@Test
	public void testGetExpectedTripDuration_t3_AfterRefactor() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,Gear.THIRD.getRatio(),diffRatio),
				t3_AfterRefactor.getExpectedTripDuration(),
				0.01);
	}

	@Test
	public void testGetExpectedTripDuration_t4_AfterRefactor() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,Gear.FOURTH.getRatio(),diffRatio),
				t4_AfterRefactor.getExpectedTripDuration(),
				0.01);
	}

	@Test
	public void testGetExpectedTripDuration_t5_AfterRefactor() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,Gear.FIFTH.getRatio(),diffRatio),
				t5_AfterRefactor.getExpectedTripDuration(),
				0.01);
	}

	@Test
	public void testGetExpectedTripDuration_tR_AfterRefactor() {
		assertEquals(
				generateExpectedResult(dist, rpm, tireSize,Gear.REVERSE.getRatio(),diffRatio),
				tr_AfterRefactor.getExpectedTripDuration(),
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
	
	@Test
	public void testTripDuration_consistance_AfterRefactor() {

		assert (t0_AfterRefactor.getExpectedTripDuration() < t1_AfterRefactor.getExpectedTripDuration());
		assert (t1_AfterRefactor.getExpectedTripDuration() < t2_AfterRefactor.getExpectedTripDuration());
		assert (t2_AfterRefactor.getExpectedTripDuration() < t3_AfterRefactor.getExpectedTripDuration());
		assert (t3_AfterRefactor.getExpectedTripDuration() < t4_AfterRefactor.getExpectedTripDuration());
		assert (t4_AfterRefactor.getExpectedTripDuration() < t5_AfterRefactor.getExpectedTripDuration());
	}
	
	private double generateExpectedResult(int dist, double rpm,	double tireSize, double gearRatio, double diffRatio) {
		return dist / (( (tireSize * Math.PI) * ((rpm / gearRatio) / diffRatio) * .06));
	}

	private static Vehicule createTripVehicule(double tireSize, int rpm,
			int gear) {
		Vehicule v = new Vehicule();
		Tire t = new Tire(tireSize);
		v.setTireSize(tireSize);
		v.getEngine().setRpm(rpm);
		v.getTransmission().setCurrentGear(gear);
		v.getTransmission().setDifferentialRatio(diffRatio);
		return v;
	}
	
	private static Vehicule createTripVehicule_AfterRefactor(double tireSize, int rpm,
			Gear gear) {
		Vehicule v = new Vehicule();
		Tire t = new Tire(tireSize);
		v.setTire(t);/* v.setTireSize(tireSize); */
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
