public class NewReleaseMovie extends Movie
{

	public NewReleaseMovie(String title) {
		super(title, movieType.NEW_RELEASE);
	}
	
	public double determineAmount(int _daysRented) {
		return _daysRented *3;
	}
}
