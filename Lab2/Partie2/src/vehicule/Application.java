package vehicule;

public class Application {
	public static void main(String[] args){
		Vehicule v = new Vehicule();
		v.setTire(new Tire(0.5588));/*v.setTireSize(0.5588);*/
		v.getEngine().setRpm(3500);
		v.getTransmission().setCurrentGear(Gear.FIFTH);/*v.getTransmission().setCurrentGear(Transmission.FIFTH_GEAR);*/
		v.getTransmission().setDifferentialRatio(4.041);
		Trip t = new Trip(100, v);		
		System.out.println("Car traveling at : " + v.calculateSpeed());
		System.out.println("Expected trip duration : " + t.getExpectedTripDuration());
	}
}
