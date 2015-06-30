package vehicule;

public class Vehicule {
	protected Transmission transmission = null;
	protected Engine engine = null;
	protected double tireSizeDiameter = 0.5;
	
	public Vehicule(){
		transmission = new Transmission();
		engine = new Engine();
	}
	public Transmission getTransmission() {
		return transmission;
	}
	public Engine getEngine() {
		return engine;
	}
	public double getTireDiameter() {
		return tireSizeDiameter;
	}
	public void setTireSize(double tireSize) {
		this.tireSizeDiameter = tireSize;
	}	
	
}
