package vehicule;

public class Vehicule {
	protected Transmission transmission = null;
	protected Engine engine = null;
	protected double tireSizeDiameter = 0.5;
	protected Tire tire;
	
	public Vehicule(){
		transmission = new Transmission();
		engine = new Engine();
		tire = new Tire();
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
		return tireSizeDiameter;
	}
	
	public Tire getTire() {
		return tire;
	}
	
	public void setTireSize(double tireSize) {
		this.tireSizeDiameter = tireSize;
	}	
	
}
