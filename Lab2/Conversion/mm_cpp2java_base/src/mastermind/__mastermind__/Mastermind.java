package mastermind.__mastermind__;

import java.util.Collections;

import mastermind.__board__.Board;
import mastermind.__code__.Code;
import mastermind.__colour__.Colours;
import mastermind.__game__.Game;
import mastermind.__peg__.Peg;
import mastermind.__row__.Row;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Code;
//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Board;
//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Peg;
//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Game;
//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Row;
public class Mastermind {
/**
The game of Mastermind

This class provides a function "play" for invoking a new game.

The objective of the game is to guess a code composed of 4 coloured
pegs. The code can be composed of any combination of the six colours
(red, green, purple, yellow, white, black), and can include duplicates.

For each guess a result code may be returned composed of black and/or
white pegs. A black peg indicates a peg of the right colour and in the
right position. A white peg indicates a peg of the right colour but in
the wrong position. The arrangement of the pegs does not correspond to
the pegs in the guess- black pegs will always be shown first, followed
but white pegs.

The game ends with either a correct guess or after running out of 
guesses.
*/

	public static String const_0;
	public static String const_1;
	public static String const_10;
	public static String const_11;
	public static String const_12;
	public static String const_13;
	public static String const_14;
	public static String const_15;
	public static String const_16;
	public static String const_17;
	public static String const_18;
	public static String const_19;
	public static String const_2;
	public static String const_20;
	public static String const_21;
	public static String const_22;
	public static String const_23;
	public static String const_3;
	public static String const_4;
	public static String const_5;
	public static String const_6;
	public static String const_7;
	public static String const_8;
	public static String const_9;
	
	public static void __init() {
		const_0 = new String("Guess: ");
		const_1 = "";
		const_2 = new String("--------Board--------");
		const_3 = new String("---------------------");
		const_4 = new String("Congratulations!");
		const_5 = new String("Secret Code: ");
		const_6 = new String("");
		const_7 = new String("Welcome to Mastermind");
		const_8 = new String("Each guess should be 4 colours from any of:");
		const_9 = new String("red yellow green purple black white");
		const_10 = new String("Type four (space seperated) colours from:");
		const_11 = new String("[r]ed [y]ellow [g]reen [p]urple [b]lack [w]hite");
		const_12 = new String("\\s");
		const_13 = new String("> ");
		const_14 = new String("Invalid input, use colours as stated");
		const_15 = new String("^r");
		const_16 = new String("^p");
		const_17 = new String("^g");
		const_18 = new String("^y");
		const_19 = new String("^w");
		const_20 = new String("^b");
		const_21 = new String(" | Result:\t");
		const_22 = new String("\\d");
		const_23 = new String("__main__");

	}
		
	public static int Main( String[] __ss_argv) {

		Colours.__init();
		
		Mastermind m;
		boolean __49;
		boolean __50;
		int guesses = 0;

		 
		m = (new Mastermind());
		guesses = 8;
		if ((__ss_argv.length > 1) && (__re__.match(const_22, (__ss_argv[1]), 0) != null)) {
			guesses = Integer.parseInt(__ss_argv[1]);
		}
		m.play(guesses);
	}
	
	
	public Mastermind() {
	}
	public final Object play(int guesses) {
		Game gm;

		this.greeting();
		gm = (new Game(guesses));

		while (!gm.isOver()) {
			print2(null,0,4, const_0, ___box((gm.getTries() + 1)), const_1, ___box(gm.getMaxTries()));
			gm.makeGuess(this.__readGuess());
			print2(null,0,1, const_2);
			this.display(gm);
			print2(null,0,1, const_3);
		}
		if (gm.isWon()) {
			print2(null,0,1, const_4);
		}
		else {
			print2(null,1,1, const_5);
			this.displaySecret(gm);
		}
		return null;
	}
	public final Object greeting() {

		print2(null,0,1, const_6);
		print2(null,0,1, const_3);
		print2(null,0,1, const_7);
		print2(null,0,1, const_3);
		print2(null,0,1, const_6);
		print2(null,0,1, const_8);
		print2(null,0,1, const_9);
		print2(null,0,1, const_6);
		return null;
	}
	public final Code __readGuess() {
		java.util.LinkedList<String> __45;
		java.util.LinkedList<String> colours;
		Peg peg;
		java.util.LinkedList<Peg> guessPegs;
		boolean inputOk = false;
		__iter<String> __46;
		java.util.LinkedList<String>.for_in_loop __48 = new java.util.LinkedList<String>.for_in_loop();
		String c;
		int __47 = 0;

		guessPegs = (new java.util.LinkedList<Peg>());
		print2(null,0,1, const_10);
		print2(null,0,1, const_11);
		inputOk = false;

		while (!inputOk) {
			colours = __re__.split(const_12, raw_input(const_13), 4);

			__45 = colours;
			__47 = -1;
			__48 = __45.for_in_init();
			while (__45.for_in_has_next(__48)) {
				__47++;
				c = __45.for_in_next(__48);
				peg = this.__parseColour(c);
				if ((peg != null)) {
					guessPegs.add(peg);
				}
			}

			inputOk = guessPegs.size() == 4;
			if (!inputOk) {
				print2(null,0,1, const_14);
				guessPegs = (new java.util.LinkedList<Peg>());
			}
		}
		return (new Code(guessPegs));
	}
	public final Peg __parseColour(String s) {

		if ((__re__.search(const_15, s, 0) != null)) {
			return (new Peg(Colours.red));
		}
		else if ((__re__.search(const_16, s, 0) != null)) {
			return (new Peg(Colours.purple));
		}
		else if ((__re__.search(const_17, s, 0) != null)) {
			return (new Peg(Colours.green));
		}
		else if ((__re__.search(const_18, s, 0) != null)) {
			return (new Peg(Colours.yellow));
		}
		else if ((__re__.search(const_19, s, 0) != null)) {
			return (new Peg(Colours.white));
		}
		else if ((__re__.search(const_20, s, 0) != null)) {
			return (new Peg(Colours.black));
		}
		else {
			return null;
		}
		return null;
	}
	public final Object display(Game game) {
		java.util.LinkedList<Row > __21;
		java.util.LinkedList<Peg>.for_in_loop __30 = new java.util.LinkedList<Peg>.for_in_loop();
		java.util.LinkedList<Peg>.for_in_loop __36 = new java.util.LinkedList<Peg>.for_in_loop();
		__board__.Board __26;
		Code __32;
		Code __38;
		java.util.LinkedList<Row>.for_in_loop __24 = new java.util.LinkedList<Row >.for_in_loop();
		java.util.LinkedList<Peg > __27;
		java.util.LinkedList<Peg > __33;
		Object __25;
		Object __31;
		Object __37;
		__iter<Peg > __28;
		__iter<Peg > __34;
		Peg p;
		int __23 = 0;
		int __29 = 0;
		int __35 = 0;
		Row r;
		__iter<__row__.Row > __22;


		__21 = (game.getBoard()).getRows();
		__23 = -1;
		__24 = __21.for_in_init();
		while (__21.for_in_has_next(__24)) {
			__23++;
			r = __21.for_in_next(__24);

			__27 = (r.getGuess()).getPegs();
			__29 = -1;
			__30 = __27.for_in_init();
			while (__27.for_in_has_next(__30)) {
				__29++;
				p = __27.for_in_next(__30);
				print2(null,1,1, (__str(getColourName(p.getColour()))).rjust(6));
			}

			print2(null,1,1, const_21);

			__33 = (r.getResult()).getPegs();
			__35 = -1;
			__36 = __33.for_in_init();
			while (__33.for_in_has_next(__36)) {
				__35++;
				p = __33.for_in_next(__36);
				print2(null,1,1, (__str(getColourName(p.getColour()))).rjust(6));
			}

			print2(null,0,1, const_6);
		}

		return null;
	}
	public final Object displaySecret(Game game) {
		java.util.LinkedList<Peg>.for_in_loop __42 = new java.util.LinkedList<Peg *>.for_in_loop();
		java.util.LinkedList<Peg > __39;
		Code __44;
		Object __43;
		__iter<Peg > __40;
		Peg p;
		int __41 = 0;


		__39 = (game.getSecretCode()).getPegs();
		__41 = -1;
		__42 = __39.for_in_init();
		while (__39.for_in_has_next(__42)) {
			__41++;
			p = __39.for_in_next(__42);
			print2(null,1,1, (Colours.getColourName(p.getColour()))).rjust(6);
		}

		return null;
	}
}
//C++ TO JAVA CONVERTER TODO TASK: Only the namespaces at the beginning of the file can be converted to the Java 'package' for this file:
//ORIGINAL LINE: namespace __mastermind__
