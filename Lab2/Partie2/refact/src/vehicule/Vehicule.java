package vehicule;

public class Vehicule {
	private Transmission transmission = null;
	private Engine engine = null;
	/*protected double tireSizeDiameter = 0.5;*/
	private Tire tire;
	
	public Vehicule(){
		transmission = new Transmission();
		engine = new Engine();
		tire = new Tire(0.5);
	}
	
	public Transmission getTransmission() {
		return transmission;
	}
	
	public Engine getEngine() {
		return engine;
	}
	
	/**
	 * use instead {@link #getTire()} {@link Tire#getDiameter()} method.
	 * @deprecated
	 * @return tire diameter
	 * 
	 */
	@Deprecated
	public double getTireDiameter() {
		return tire.getDiameter();
	}
	
	public Tire getTire() {
		return tire;
	}
	
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	/**
	 * use instead {@link #setTire(Tire)} method.
	 * @deprecated
	 * @param tireSize
	 */
	@Deprecated
	public void setTireSize(double tireSize) {
		this.tire = new Tire(tireSize);
	}	
	
	
	public double calculateSpeed(){
		//Calculer la circonf�rence de la roue (en m�tre)
		double circumference = tire.getDiameter() * Math.PI;
		
		//Trouver combien de tours l'essieu fait par minute
		double wheelRPM = (engine.getRpm() / transmission.getCurrentGearObj().getRatio()) / transmission.getDifferentialRatio();

		//Trouver la distance parcourue par minute
		double speedInMeterPerMinute = wheelRPM * circumference;
		
		//Convertir en Km/h
		double speedInKmPerHour = speedInMeterPerMinute * 0.06;
		
		return speedInKmPerHour;
	}
	
}
