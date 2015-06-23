package mastermind;

public class start {

	/**
	 * @param args
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
