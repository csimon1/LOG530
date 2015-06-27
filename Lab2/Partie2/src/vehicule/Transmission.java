package vehicule;

public class Transmission {
	@Deprecated
	public static final int FIRST_GEAR = 1;
	@Deprecated
	public static final int SECOND_GEAR = 2;
	@Deprecated
	public static final int THIRD_GEAR = 3;
	@Deprecated
	public static final int FOURTH_GEAR = 4;
	@Deprecated
	public static final int FIFTH_GEAR = 5;
	@Deprecated
	public static final int NEUTRAL= 0;
	@Deprecated
	public static final int REVERS_GEAR = -1;
	
	
	protected Gear currentGear;
/*	protected int currentGear = NEUTRAL;*/
	protected double differentialRatio = 4.0;
	
	
	public Transmission() {
		this.currentGear = Gear.NEUTRAL;
	}
	
	/**
	 * use instead {@link #getCurrentGearObj()} {@link Gear#getValue()} methods.
	 * @deprecated
	 * @return Gear value
	 */
	@Deprecated
	public int getCurrentGear() {
		return currentGear.getValue();
	}
	
	/**
	 * use instead {@link #setCurrentGear(Gear)} method.
	 * @deprecated
	 * @param gear
	 */
	@Deprecated
	public void setCurrentGear(int gear) {
		switch (gear) {
		case FIRST_GEAR:
			this.currentGear = Gear.FIRST;
			break;
		case SECOND_GEAR:
			this.currentGear = Gear.SECOND;
			break;
		case THIRD_GEAR:
			this.currentGear = Gear.THIRD;
			break;
		case FOURTH_GEAR:
			this.currentGear = Gear.FOURTH;
			break;
		case FIFTH_GEAR:
			this.currentGear = Gear.FIFTH;
			break;
		case NEUTRAL:
			this.currentGear = Gear.NEUTRAL;
			break;
		case REVERS_GEAR:
			this.currentGear = Gear.REVERSE;
			break;
		default:
			this.currentGear = Gear.NEUTRAL;
			break;
		}
	}

	public Gear getCurrentGearObj() {
		return currentGear;
	}
	
	public void setCurrentGear(Gear currentGear) {
		this.currentGear = currentGear;
	}

	public double getDifferentialRatio() {
		return differentialRatio;
	}
	public void setDifferentialRatio(double differentialRatio) {
		this.differentialRatio = differentialRatio;
	}
	
	
	
}
