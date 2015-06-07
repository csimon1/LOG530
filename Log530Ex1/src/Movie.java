
public abstract class Movie {
	
	public static enum MovieType 
	{
		CHILDRENS,
		REGULAR,
		NEW_RELEASE
	}
	
	private String _title;
	private MovieType _priceCode;
	
	public Movie(String title, MovieType priceCode){
		_title = title;
		_priceCode = priceCode;
	}
	
	public MovieType getPriceCode(){
		return _priceCode;
	}
	public void setPricCode(MovieType priceCode){
		_priceCode = priceCode;
	}
	public String getTitle(){
		return _title;
	};
	
	public abstract double determineAmount(int _daysRented);
	
	
	public class ChildrensMovie extends Movie
	{

		public ChildrensMovie(String title, MovieType priceCode) {
			super(title, priceCode);
		}
		
		public double determineAmount(int _daysRented) {
			double amount = 1.5;
			if(_daysRented > 3)
				amount += (_daysRented - 3) *1.5;
			return amount;
		}
		
	}
	
	public class RegularMovie extends Movie
	{

		public RegularMovie(String title, MovieType priceCode) {
			super(title, priceCode);
		}
		
		public double determineAmount(int _daysRented) {
			double amount = 2;
			if(_daysRented > 2)
				amount += (_daysRented - 2)*1.5;
			return amount;
		}
	}

	public class NewReleaseMovie extends Movie
	{

		public NewReleaseMovie(String title, MovieType priceCode) {
			super(title, priceCode);
		}
		
		public double determineAmount(int _daysRented) {
			return _daysRented *3;
		}
	}
	
	
	
	
}