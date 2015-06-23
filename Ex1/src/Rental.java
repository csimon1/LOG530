
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

	public double determineAmount() {
		return _movie.determineAmount(_daysRented);
	}
}
