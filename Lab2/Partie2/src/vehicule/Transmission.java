package vehicule;

public class Transmission {
	public static final int FIRST_GEAR = 1;
	public static final int SECOND_GEAR = 2;
	public static final int THIRD_GEAR = 3;
	public static final int FOURTH_GEAR = 4;
	public static final int FIFTH_GEAR = 5;
	public static final int NEUTRAL= 0;
	public static final int REVERS_GEAR = -1;
	
	
	protected int currentGear = NEUTRAL;
	protected double differentialRatio = 4.0;
	
	public int getCurrentGear() {
		return currentGear;
	}
	public void setCurrentGear(int gear) {
		this.currentGear = gear;
	}
	
	public double getDifferentialRatio() {
		return differentialRatio;
	}
	public void setDifferentialRatio(double differentialRatio) {
		this.differentialRatio = differentialRatio;
	}
	
	
}
