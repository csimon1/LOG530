/**
 * 
 */
package vehicule;

/**
 * @author MisterTim
 *
 */
public class Gear {
	
	public static final Gear FIRST_GEAR = new Gear(1, 3.615);
	public static final Gear SECOND_GEAR = new Gear(2, 2.053);
	public static final Gear THIRD_GEAR = new Gear(3, 1.370);
	public static final Gear FOURTH_GEAR = new Gear(4, 1.031);
	public static final Gear FIFTH_GEAR = new Gear(5, 0.837);
	public static final Gear NEUTRAL= new Gear(0, 0);
	public static final Gear REVERS_GEAR = new Gear(-1, 3.583);
	
	
	private double ratio;
	private int value;
	
	private Gear() {
		// TODO Auto-generated constructor stub
	}
	
	private Gear(int value, double ratio) {
		this.value = value;
		this.ratio = ratio;
	}

	public double getRatio() {
		return ratio;
	}

	public int getValue() {
		return value;
	}
	
	
}
