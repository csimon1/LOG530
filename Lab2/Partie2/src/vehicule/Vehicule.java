package vehicule;

public class Vehicule {
	protected Transmission transmission = null;
	protected Engine engine = null;
	/*protected double tireSizeDiameter = 0.5;*/
	protected Tire tire;
	
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
	
	
	
}
