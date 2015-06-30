package vehicule;

public class Trip {
	Vehicule vehicule;
	int distance;
	
	public Trip(int distance, Vehicule vehicule) {
		this.vehicule = vehicule;
		this.distance = distance;
	}
	
	public double getExpectedTripDuration(){
		//Obtenir l'info pour calculer la vitesse
		int engineSpeed = vehicule.getEngine().getRpm();
		double tireDiameter = vehicule.getTireDiameter();
		double differentialRatio = vehicule.getTransmission().getDifferentialRatio();
		double gearRatio = 0;
		switch(vehicule.getTransmission().getCurrentGear()){
			case Transmission.FIRST_GEAR:
				gearRatio = 3.615;
				break;
			case Transmission.SECOND_GEAR:
				gearRatio = 2.053;
				break;
			case Transmission.THIRD_GEAR:
				gearRatio = 1.370;
				break;
			case Transmission.FOURTH_GEAR:
				gearRatio = 1.031;
				break;
			case Transmission.FIFTH_GEAR:
				gearRatio = 0.837;
				break;
			case Transmission.NEUTRAL:
				gearRatio = 0;
				break;
			case Transmission.REVERS_GEAR:
				gearRatio = 3.583;
				break;
			default:
				gearRatio = 0;
				break;
		}
		
		//calculer la vitesse
		double speed = calculateSpeed(engineSpeed, gearRatio, differentialRatio, tireDiameter);
		
		//calculer le temps nécessaire pour parcourir la distance	
		double duree = distance / speed;
		return duree;	
	}

	double calculateSpeed(int engineSpeed, double gearRatio, double differentialRatio, double tireDiameter){
		//Calculer la circonférence de la roue (en mètre)
		double circumference = tireDiameter * Math.PI;
		
		//Trouver combien de tours l'essieu fait par minute
		double wheelRPM = (engineSpeed / gearRatio) / differentialRatio;

		//Trouver la distance parcourue par minute
		double speedInMeterPerMinute = wheelRPM * circumference;
		
		//Convertir en Km/h
		double speedInKmPerHour = speedInMeterPerMinute * 0.06;
		
		return speedInKmPerHour;
	}
}
