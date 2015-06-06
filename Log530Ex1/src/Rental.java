
class Rental {
	private final Movie _movie;	
	private final int _daysRented;
	
	public Rental(Movie movie, int daysRented){
		if (movie == null || daysRented < 0) {
		    throw new IllegalArgumentException(
		      String.format("Parameters can't be null or below 0: movie=%s, daysRented=%s", movie, daysRented));
		}
		_movie = movie;
		_daysRented = daysRented;
	}	
	
	public int getDaysRented() {
		return _daysRented;
	}
	
	public Movie getMovie() {
		return _movie;
	}
	
	public double calcPoints(){
		double amount = 0.0;
		switch (_movie.getPriceCode()){
			case REGULAR:
				amount += 2;
				if(_daysRented > 2)
					amount += (_daysRented - 2)*1.5;
				break;
			case NEW_RELEASE:
				amount += _daysRented *3;
				break;
			case CHILDRENS:
				amount += 1.5;
				if(_daysRented > 3)
					amount += (_daysRented - 3) *1.5;
				break;
		}
		return amount;
	}
	
	public int frequentRenterPoint(){
		int frequentRenterPoints=1;
		if((_movie.getPriceCode() == Movie.movieType.NEW_RELEASE) && _daysRented > 1) 
			frequentRenterPoints++;
		
		return frequentRenterPoints;
	}
}
