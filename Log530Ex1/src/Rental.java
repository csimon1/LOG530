
class Rental {
	private Movie _movie;	
	private int _daysRented;
	
	public Rental(Movie movie, int daysRented){
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

	private String toString() {
		return "\t" + this._movie.getTitle()+ "\t" + String.valueOf(this.determineAmount()) + "\n";
	}

	private boolean hasBonus(Rental r) {
		return (this._movie.getPriceCode() == Movie.MovieType.NEW_RELEASE) && this.getDaysRented() > 1;
		 
	}
}
