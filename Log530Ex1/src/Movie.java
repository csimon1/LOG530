
public abstract class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	private String _title;
	private int _priceCode;
	
	public Movie(String title, int priceCode){
		_title = title;
		_priceCode = priceCode;
	}
	
	public int getPriceCode(){
		return _priceCode;
	}
	public void setPricCode(int priceCode){
		_priceCode = priceCode;
	}
	public String getTitle(){
		return _title;
	};
	
	public abstract double determineAmount(int _daysRented);
	
	
	public class ChildrensMovie extends Movie
	{

		public ChildrensMovie(String title, int priceCode) {
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

		public RegularMovie(String title, int priceCode) {
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

		public NewReleaseMovie(String title, int priceCode) {
			super(title, priceCode);
		}
		
		public double determineAmount(int _daysRented) {
			return _daysRented *3;
		}
	}
	
	
	
	
}