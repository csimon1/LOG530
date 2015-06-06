
public class Movie {
	public static enum movieType {
		CHILDRENS,
		REGULAR,
		NEW_RELEASE
	};
	
	private final String _title;
	private movieType _priceCode;
	
	public Movie(String title, movieType priceCode){
		if (title == null || priceCode == null) {
		    throw new IllegalArgumentException(
		      String.format("Parameters can't be null: title=%s, priceCode=%s", title, priceCode));
		}
		_title = title;
		_priceCode = priceCode;
	}
	
	public movieType getPriceCode(){
		return _priceCode;
	}
	
	public void setPricCode(movieType priceCode){
		if (priceCode == null) {
		    throw new IllegalArgumentException(
		      String.format("Parameters can't be null: priceCode=%s", priceCode));
		}
		_priceCode = priceCode;
	}
	
	public String getTitle(){
		return _title;
	};
	
}