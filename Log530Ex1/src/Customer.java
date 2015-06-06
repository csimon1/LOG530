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
			thisAmount = determineAmount(each);
			
			// add frequent renter points
			frequentRenterPoints ++;
			// add bonus for two day new release rental
			if(hasBonus(each)) frequentRenterPoints ++;
			
			//show figures for this rental
			
			result += showFigure(each,thisAmount);
			
			totalAmount += thisAmount;
			
		}
		
		//add footer lines
		result += addFooter(totalAmount,frequentRenterPoints);
		

		return result;
	}

	
	
	private double determineAmount(Rental r) {
		double amount = 0;
		
		switch (r.getMovie().getPriceCode()){
		case Movie.REGULAR:
			amount += 2;
			if(r.getDaysRented() > 2)
				amount += (r.getDaysRented() - 2)*1.5;
			break;
		case Movie.NEW_RELEASE:
			amount += r.getDaysRented() *3;
			break;
		case Movie.CHILDRENS:
			amount += 1.5;
			if(r.getDaysRented() > 3)
				amount += (r.getDaysRented() - 3) *1.5;
			break;
		}
		
		return amount;
	}

	private String showFigure(Rental r, double rAmount) {
		return "\t" +r.getMovie().getTitle()+ "\t" + String.valueOf(rAmount) + "\n";
	}

	private boolean hasBonus(Rental r) {
		return (r.getMovie().getPriceCode() == Movie.NEW_RELEASE) && r.getDaysRented() > 1;
		 
	}

	private String addFooter(double totalAmount, int frequentRenterPoints) {
		return "Amount owed is " + String.valueOf(totalAmount) + "\n"
		+ "You earned " + String.valueOf(frequentRenterPoints) + "frequent renter points";
	}
	
	
}
