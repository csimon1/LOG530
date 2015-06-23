
public abstract class Movie {
	
	public static enum movieType 
	{
		CHILDRENS,
		REGULAR,
		NEW_RELEASE
	}
	
	private String _title;
	private movieType _priceCode;

	public Movie(String title, movieType priceCode){
		_title = title;
		_priceCode = priceCode;
	}
	
	public movieType getPriceCode(){
		return _priceCode;
	}
	public void setPricCode(movieType priceCode){
		_priceCode = priceCode;
	}
	public String getTitle(){
		return _title;
	};
	
	public abstract double determineAmount(int _daysRented);
	
}