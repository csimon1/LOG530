package __code__.__board__.__peg__.__game__.__row__.__mastermind__;

import __shedskin__.*;

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
public class Mastermind extends pyobj {
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

	public Mastermind() {
		this.__class__ = GlobalMembersMastermind.cl_Mastermind;
	}
	public final Object play(__ss_int guesses) {
		__game__.Game gm;

		this.greeting();
		gm = (new __game__.Game(guesses));

		while ((__mbool((gm.isOver()).not()))) {
			print2(null,0,4, GlobalMembersMastermind.const_0, ___box((gm.getTries() + 1)), GlobalMembersMastermind.const_1, ___box(gm.getMaxTries()));
			gm.makeGuess(this.__readGuess());
			print2(null,0,1, GlobalMembersMastermind.const_2);
			this.display(gm);
			print2(null,0,1, GlobalMembersMastermind.const_3);
		}
		if (gm.isWon()) {
			print2(null,0,1, GlobalMembersMastermind.const_4);
		}
		else {
			print2(null,1,1, GlobalMembersMastermind.const_5);
			this.displaySecret(gm);
		}
		return null;
	}
	public final Object greeting() {

		print2(null,0,1, GlobalMembersMastermind.const_6);
		print2(null,0,1, GlobalMembersMastermind.const_3);
		print2(null,0,1, GlobalMembersMastermind.const_7);
		print2(null,0,1, GlobalMembersMastermind.const_3);
		print2(null,0,1, GlobalMembersMastermind.const_6);
		print2(null,0,1, GlobalMembersMastermind.const_8);
		print2(null,0,1, GlobalMembersMastermind.const_9);
		print2(null,0,1, GlobalMembersMastermind.const_6);
		return null;
	}
	public final __code__.Code __readGuess() {
		java.util.LinkedList<str > __45;
		java.util.LinkedList<str > colours;
		__peg__.Peg peg;
		java.util.LinkedList<__peg__.Peg > guessPegs;
		__ss_bool inputOk = new __ss_bool();
		__iter<str > __46;
		java.util.LinkedList<str *>.for_in_loop __48 = new java.util.LinkedList<str *>.for_in_loop();
		str c;
		__ss_int __47 = new __ss_int();

		guessPegs = (new java.util.LinkedList<__peg__.Peg *>());
		print2(null,0,1, GlobalMembersMastermind.const_10);
		print2(null,0,1, GlobalMembersMastermind.const_11);
		inputOk = False;

		while ((__mbool((inputOk).not()))) {
			colours = __re__.split(GlobalMembersMastermind.const_12, raw_input(GlobalMembersMastermind.const_13), 4);

			__45 = colours;
			__47 = -1;
			__48 = __45.for_in_init();
			while (__45.for_in_has_next(__48)) {
				__47++;
				c = __45.for_in_next(__48);
				peg = this.__parseColour(c);
				if ((peg != null)) {
					guessPegs.append(peg);
				}
			}

			inputOk = ___bool((len(guessPegs) == 4));
			if ((__mbool((inputOk).not()))) {
				print2(null,0,1, GlobalMembersMastermind.const_14);
				guessPegs = (new java.util.LinkedList<__peg__.Peg *>());
			}
		}
		return (new __code__.Code(guessPegs));
	}
	public final __peg__.Peg __parseColour(str s) {

		if ((__re__.search(GlobalMembersMastermind.const_15, s, 0) != null)) {
			return (new __peg__.Peg(__colour__.Colours.red));
		}
		else if ((__re__.search(GlobalMembersMastermind.const_16, s, 0) != null)) {
			return (new __peg__.Peg(__colour__.Colours.purple));
		}
		else if ((__re__.search(GlobalMembersMastermind.const_17, s, 0) != null)) {
			return (new __peg__.Peg(__colour__.Colours.green));
		}
		else if ((__re__.search(GlobalMembersMastermind.const_18, s, 0) != null)) {
			return (new __peg__.Peg(__colour__.Colours.yellow));
		}
		else if ((__re__.search(GlobalMembersMastermind.const_19, s, 0) != null)) {
			return (new __peg__.Peg(__colour__.Colours.white));
		}
		else if ((__re__.search(GlobalMembersMastermind.const_20, s, 0) != null)) {
			return (new __peg__.Peg(__colour__.Colours.black));
		}
		else {
			return null;
		}
		return 0;
	}
	public final Object display(__game__.Game game) {
		java.util.LinkedList<__row__.Row > __21;
		java.util.LinkedList<__peg__.Peg *>.for_in_loop __30 = new java.util.LinkedList<__peg__.Peg *>.for_in_loop();
		java.util.LinkedList<__peg__.Peg *>.for_in_loop __36 = new java.util.LinkedList<__peg__.Peg *>.for_in_loop();
		__board__.Board __26;
		__code__.Code __32;
		__code__.Code __38;
		java.util.LinkedList<__row__.Row *>.for_in_loop __24 = new java.util.LinkedList<__row__.Row *>.for_in_loop();
		java.util.LinkedList<__peg__.Peg > __27;
		java.util.LinkedList<__peg__.Peg > __33;
		Object __25;
		Object __31;
		Object __37;
		__iter<__peg__.Peg > __28;
		__iter<__peg__.Peg > __34;
		__peg__.Peg p;
		__ss_int __23 = new __ss_int();
		__ss_int __29 = new __ss_int();
		__ss_int __35 = new __ss_int();
		__row__.Row r;
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
				print2(null,1,1, (__str(__colour__.getColourName(p.getColour()))).rjust(6));
			}

			print2(null,1,1, GlobalMembersMastermind.const_21);

			__33 = (r.getResult()).getPegs();
			__35 = -1;
			__36 = __33.for_in_init();
			while (__33.for_in_has_next(__36)) {
				__35++;
				p = __33.for_in_next(__36);
				print2(null,1,1, (__str(__colour__.getColourName(p.getColour()))).rjust(6));
			}

			print2(null,0,1, GlobalMembersMastermind.const_6);
		}

		return null;
	}
	public final Object displaySecret(__game__.Game game) {
		java.util.LinkedList<__peg__.Peg *>.for_in_loop __42 = new java.util.LinkedList<__peg__.Peg *>.for_in_loop();
		java.util.LinkedList<__peg__.Peg > __39;
		__code__.Code __44;
		Object __43;
		__iter<__peg__.Peg > __40;
		__peg__.Peg p;
		__ss_int __41 = new __ss_int();


		__39 = (game.getSecretCode()).getPegs();
		__41 = -1;
		__42 = __39.for_in_init();
		while (__39.for_in_has_next(__42)) {
			__41++;
			p = __39.for_in_next(__42);
			print2(null,1,1, (__str(__colour__.getColourName(p.getColour()))).rjust(6));
		}

		return null;
	}
}
//C++ TO JAVA CONVERTER TODO TASK: Only the namespaces at the beginning of the file can be converted to the Java 'package' for this file:
//ORIGINAL LINE: namespace __mastermind__
