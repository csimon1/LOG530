import java.util.Vector;


public class Customer {
	private final String _name;	
	private Vector<Rental> _rentals;
	
	public Customer (String name){
		if ( name == null) {
		    throw new IllegalArgumentException(
		      String.format("Parameters can't be null:  name=%s",  name));
		}
		_name = name;
		_rentals = new Vector<Rental>();
	}
	
	public void addRental(Rental rental){
		if ( rental == null) {
		    throw new IllegalArgumentException(
		      String.format("Parameters can't be null:  rental=%s",  rental));
		}
		if(_rentals.contains(rental)==false) 
			_rentals.addElement(rental);
	}
	public String getName() {
		return _name;
	}
	
	public String displayInfos(){
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() +"\n";
		
		for(Rental each : _rentals ){	
			//determine amounts for each rental
			double thisAmount = each.calcPoints();
			
			// add frequent renter points
			frequentRenterPoints += each.frequentRenterPoint();
						
			//show figures for this rental
			totalAmount += thisAmount;	
			
			result += "\t" +each.getMovie().getTitle()+ "\t" + String.valueOf(thisAmount) + "\n";
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + "frequent renter points";
			
		return result;
	}
	
}
