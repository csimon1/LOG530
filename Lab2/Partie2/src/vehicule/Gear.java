/**
 * 
 */
package vehicule;

/**
 * @author MisterTim
 *
 */
public class Gear {
	
	public static final Gear FIRST = new Gear(1, 3.615);
	public static final Gear SECOND = new Gear(2, 2.053);
	public static final Gear THIRD = new Gear(3, 1.370);
	public static final Gear FOURTH = new Gear(4, 1.031);
	public static final Gear FIFTH = new Gear(5, 0.837);
	public static final Gear NEUTRAL= new Gear(0, 0);
	public static final Gear REVERSE = new Gear(-1, 3.583);
	
	
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
