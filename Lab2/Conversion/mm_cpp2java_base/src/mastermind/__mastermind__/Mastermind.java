package mastermind.__mastermind__;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

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
	
	public static void main(String[] args) throws Exception {
		Main(args);
	}
	public static int Main( String[] __ss_argv) throws Exception {

		Colours.__init();
		
		Mastermind m;
		boolean __49;
		boolean __50;
		int guesses = 0;
		Mastermind.__init();

		 
		m = (new Mastermind());
		guesses = 8;
		if ((__ss_argv.length > 1) && (const_22.equals(__ss_argv[1]))) {
			guesses = Integer.parseInt(__ss_argv[1]);
		}
		m.play(guesses);
		
		return 0;
	}
	
	/**
	 * default constructor
	 */
	public Mastermind() {
	}
	
	/**
	 * Demarrage d'une partie
	 * @param guesses : nombre d'essais max
	 * @return 
	 */
	public final Object play(int guesses) throws Exception {
		Game gm;

		this.greeting();
		gm = (new Game(guesses));

		while (!gm.isOver()) {
			System.out.println(const_0 +"   " + (gm.getTries() + 1) +"   " + const_1 + "    " + gm.getMaxTries());
			gm.makeGuess(this.__readGuess());
			System.out.println(const_2);
			this.display(gm);
			System.out.println(const_3);
		}
		if (gm.isWon()) {
			System.out.println(const_4);
		}
		else {
			System.out.println(const_5);
			this.displaySecret(gm);
		}
		return null;
	}
	
	/**
	 * Affichage du msg de bienvenue
	 * @return 
	 */
	public final Object greeting() {

		System.out.println(const_6);
		System.out.println(const_3);
		System.out.println(const_7);
		System.out.println(const_3);
		System.out.println(const_6);
		System.out.println(const_8);
		System.out.println(const_9);
		System.out.println(const_6);
		return null;
	}
	
	/**
	 * Lecture de l'entree clavier pour avoir un 'code devinez'
	 * @return Code
	 */
	public final Code __readGuess() throws IOException {
		String[] __45;
		String[] colours;
		Peg peg;
		java.util.LinkedList<Peg> guessPegs;
		boolean inputOk = false;
		Iterator<String> __46;
		Iterator<String> __48;
		String c;
		int __47 = 0;

		guessPegs = (new java.util.LinkedList<Peg>());
		System.out.println(const_10);
		System.out.println(const_11);
		inputOk = false;

		while (!inputOk) {
			System.out.print(const_13);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			colours = br.readLine().split(const_12);
			
			__45 = colours;
			__47 = -1;
			//__48 = __45;
			for (int i = 0; i < colours.length; i++) {
				__47++;
				c = colours[i];
				System.out.println(c);
				peg = this.__parseColour(c);
				if ((peg != null)) {
					guessPegs.add(peg);
				}
			}

			inputOk = guessPegs.size() == 4;
			if (!inputOk) {
				System.out.println(const_14);
				guessPegs = (new java.util.LinkedList<Peg>());
			}
		}
		return (new Code(guessPegs));
	}
	
	/**
	 * Parcour de l'entree clavier (string) obtenue pour extraire les couleurs
	 * @param s : string du clavier
	 * @return Pion identifie
	 */
	public final Peg __parseColour(String s) {

		if (s.matches(const_15)) {
			return (new Peg(Colours.red));
		}
		else if (s.matches(const_16)) {
			return (new Peg(Colours.purple));
		}
		else if (s.matches(const_17)) {
			return (new Peg(Colours.green));
		}
		else if (s.matches(const_18)) {
			return (new Peg(Colours.yellow));
		}
		else if (s.matches(const_19)) {
			return (new Peg(Colours.white));
		}
		else if (s.matches(const_20)) {
			return (new Peg(Colours.black));
		}
		else {
			return null;
		}
	}
	
	/**
	 * Affiche de l'evolution du jeux
	 * @param game
	 * @return 
	 */

	public final Object display(Game game) {
		java.util.LinkedList<Row > __21;
		Iterator<Peg> __30;
		Iterator<Peg> __36;
		Board __26;
		Code __32;
		Code __38;
		Iterator<Row> __24;
		java.util.LinkedList<Peg > __27;
		java.util.LinkedList<Peg > __33;
		Object __25;
		Object __31;
		Object __37;
		Iterator<Peg > __28;
		Iterator<Peg > __34;
		Peg p;
		int __23 = 0;
		int __29 = 0;
		int __35 = 0;
		Row r;
		Iterator<Row > __22;


		__21 = (game.getBoard()).getRows();
		__23 = -1;
		__24 = __21.iterator();
		while (__24.hasNext()) {
			__23++;
			r = __24.next();

			__27 = (r.getGuess()).getPegs();
			__29 = -1;
			__30 = __27.iterator();
			while (__30.hasNext()) {
				__29++;
				p = __30.next();
				System.out.print(rjust(Colours.getColourName(p.getColour()),6));
			}

			System.out.print(const_21);

			__33 = (r.getResult()).getPegs();
			__35 = -1;
			__36 = __33.iterator();
			while (__36.hasNext()) {
				__35++;
				p = __36.next();
				System.out.print(rjust(Colours.getColourName(p.getColour()),6));
			}

			System.out.println(const_6);
		}

		return null;
	}
	
	/**
   	 * Affichage d'un pion en remplissant d'espace 
   	 * pour uniformiser la taille
   	 */
	public static String rjust(String s, int len){
		int space = len+1-s.length(), i;
    	for(i=0; space>i; i++){ //.rjust(6)
    		s = " " + s;
    	}
    	return s;
	}
	
	/**
	 * Affichage du code secret
	 * @param game
	 * @return 
	 */
	public final Object displaySecret(Game game) {
		Iterator<Peg> __42;
		java.util.LinkedList<Peg > __39;
		Code __44;
		Object __43;
		Iterator<Peg > __40;
		Peg p;
		int __41 = 0;


		__39 = (game.getSecretCode()).getPegs();
		__41 = -1;
		__42 = __39.iterator();
		while (__42.hasNext()) {
			__41++;
			p = __42.next();
			System.out.print(rjust(Colours.getColourName(p.getColour()),6));
		}

		return null;
	}
}
//C++ TO JAVA CONVERTER TODO TASK: Only the namespaces at the beginning of the file can be converted to the Java 'package' for this file:
//ORIGINAL LINE: namespace __mastermind__
