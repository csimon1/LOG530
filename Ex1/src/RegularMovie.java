public class RegularMovie extends Movie
{

	public RegularMovie(String title) {
		super(title, movieType.REGULAR);
	}
	
	public double determineAmount(int _daysRented) {
		double amount = 2;
		if(_daysRented > 2)
			amount += (_daysRented - 2)*1.5;
		return amount;
	}
}
