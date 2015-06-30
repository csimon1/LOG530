package mastermind;

public class start {

	/**
	* Instantiate mastermind and invoke play method to play game
	* @param args : Argument passera l'invocation du prog
	*/
	public static void main(String[] args) {
		Mastermind m = new Mastermind(); // Line 111
		int guesses = 8; // Line 112
		
		if ( args.length == 1) { // Line 113
			try {
				guesses= Integer.parseInt(args[0]); // Line 114
			} catch (NumberFormatException e) {}
		}	
		m.play(guesses);
	}
}
