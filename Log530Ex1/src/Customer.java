import java.util.Enumeration;
import java.util.Vector;



public class Customer {
	private String _name;
	
	private Vector _rentals = new Vector();
	
	public Customer (String name){
		_name = name;
	}
	
	public void add(Rental rental){
		_rentals.addElement(rental);
	}
	public String getName() {
		return _name;
	}
	
	public String toString(){
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() +"\n";
		while(rentals.hasMoreElements()){
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();
			
			//determine amounts for each Rental
			thisAmount = each.determineAmount();
			
			// add frequent renter points
			frequentRenterPoints ++;
			// add bonus for two day new release rental
			if(each.hasBonus()) frequentRenterPoints ++;
			
			//show figures for this rental
			
			result += each.toString()
			
			totalAmount += thisAmount;
			
		}
		
		//add footer lines
		result += addFooter(totalAmount,frequentRenterPoints);
		

		return result;
	}

	private String addFooter(double totalAmount, int frequentRenterPoints) {
		return "Amount owed is " + String.valueOf(totalAmount) + "\n"
		+ "You earned " + String.valueOf(frequentRenterPoints) + "frequent renter points";
	}
	
	
}
