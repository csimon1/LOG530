package vehicule;

public class Trip {
	private final Vehicule vehicule;
	private final int distance;
	
	public Trip(int distance, Vehicule vehicule) {
		this.vehicule = vehicule;
		this.distance = distance;
	}
	
	public double getExpectedTripDuration(){
		//calculer la vitesse
		double speed = vehicule.calculateSpeed();
		//calculer le temps n�cessaire pour parcourir la distance	
		double duree = distance / speed;
		return duree;	
	}

	
}
