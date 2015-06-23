public class ChildrensMovie extends Movie
{

	public ChildrensMovie(String title) {
		super(title,movieType.CHILDRENS);
	}
	
	public double determineAmount(int _daysRented) {
		double amount = 1.5;
		if(_daysRented > 3)
			amount += (_daysRented - 3) *1.5;
		return amount;
	}
	
}
