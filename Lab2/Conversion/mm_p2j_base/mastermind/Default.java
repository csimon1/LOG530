/*
    Instantiate mastermind and invoke play method to play game
*/

public static void main() { // Line 110
	m = Mastermind(); // Line 111
	guesses = 8; // Line 112
	if ((re.match("\d", sys.argv.get(1))len(sys.argv)>1null)) { // Line 113
		guesses = int(sys.argv.get(1)); // Line 114
	}
	m.play(guesses);
}

if (__name__.equals("__main__")) { // Line 117
	main();
}
