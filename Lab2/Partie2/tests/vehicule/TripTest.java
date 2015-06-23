package vehicule;

import junit.framework.TestCase;

public class TripTest extends TestCase {
	public void testGetExpectedTripDuration() {
		//Test first gear
		Trip t1 = createTrip(100, 3000, .5, Transmission.FIRST_GEAR);
		assertEquals(generateExpectedResult(100, 3000, .5, 3.615),t1.getExpectedTripDuration());
		
		//Test the fifth gear
		Trip t5 = createTrip(100, 3000, .5, Transmission.FIFTH_GEAR);
		assertEquals(generateExpectedResult(100, 3000, .5, 0.837),t5.getExpectedTripDuration());
		
		assert(t1.getExpectedTripDuration()<t5.getExpectedTripDuration());
		
		//Test neutral
		Trip tn = createTrip(100, 3000, .5, Transmission.NEUTRAL);
		assertEquals(0.0,tn.getExpectedTripDuration());

		//Test reverse	
		Trip tr = createTrip(100, 3000, .5, Transmission.REVERS_GEAR);
		assertEquals(generateExpectedResult(100, 3000, .5, 3.583),tr.getExpectedTripDuration());	
	}
	
	private double generateExpectedResult(int dist, double rpm, double tireSize, double gearRatio){
		return dist / ((tireSize * Math.PI * (rpm / gearRatio) *.06));
	}
	
	private Trip createTrip(int dist, int rpm, double tireSize, int gear){
		Vehicule v = new Vehicule();
		v.setTireSize(tireSize);
		v.getEngine().setRpm(rpm);
		v.getTransmission().setCurrentGear(gear);
		Trip t = new Trip(dist, v);		
		return t;
	}

}
