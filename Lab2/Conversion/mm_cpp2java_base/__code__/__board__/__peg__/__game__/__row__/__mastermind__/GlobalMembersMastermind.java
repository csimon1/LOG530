package __code__.__board__.__peg__.__game__.__row__.__mastermind__;

import __shedskin__.*;

public class GlobalMembersMastermind {

//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	//extern str *const_0, *const_1, *const_10, *const_11, *const_12, *const_13, *const_14, *const_15, *const_16, *const_17, *const_18, *const_19, *const_2, *const_20, *const_21, *const_22, *const_23, *const_3, *const_4, *const_5, *const_6, *const_7, *const_8, *const_9;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
	//class Mastermind;


//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	//extern str *__name__;


//C++ TO JAVA CONVERTER NOTE: 'extern' variable declarations are not required in Java:
	//extern class_ *cl_Mastermind;

/**
Instantiate mastermind and invoke play method to play game

*/

	public static Object __ss_main() {
		Mastermind m;
		__ss_bool __49 = new __ss_bool();
		__ss_bool __50 = new __ss_bool();
		__ss_int guesses = new __ss_int();

		m = (new Mastermind());
		guesses = 8;
		if (((len(__sys__.argv) > 1) && (__re__.match(const_22, (__sys__.argv).__getfast__(1), 0) != null))) {
			guesses = __int((__sys__.argv).__getfast__(1));
		}
		m.play(guesses);
		return null;
	}




	public static str const_0;
	public static str const_1;
	public static str const_10;
	public static str const_11;
	public static str const_12;
	public static str const_13;
	public static str const_14;
	public static str const_15;
	public static str const_16;
	public static str const_17;
	public static str const_18;
	public static str const_19;
	public static str const_2;
	public static str const_20;
	public static str const_21;
	public static str const_22;
	public static str const_23;
	public static str const_3;
	public static str const_4;
	public static str const_5;
	public static str const_6;
	public static str const_7;
	public static str const_8;
	public static str const_9;


	public static str __name__;



	/**
	 copyright Sean McCarthy, license GPL v2 or later 
	*/
	public static class_ cl_Mastermind;

	public static void __init() {
		const_0 = new str("Guess: ");
		const_1 = __char_cache[47];
		const_2 = new str("--------Board--------");
		const_3 = new str("---------------------");
		const_4 = new str("Congratulations!");
		const_5 = new str("Secret Code: ");
		const_6 = new str("");
		const_7 = new str("Welcome to Mastermind");
		const_8 = new str("Each guess should be 4 colours from any of:");
		const_9 = new str("red yellow green purple black white");
		const_10 = new str("Type four (space seperated) colours from:");
		const_11 = new str("[r]ed [y]ellow [g]reen [p]urple [b]lack [w]hite");
		const_12 = new str("\\s");
		const_13 = new str("> ");
		const_14 = new str("Invalid input, use colours as stated");
		const_15 = new str("^r");
		const_16 = new str("^p");
		const_17 = new str("^g");
		const_18 = new str("^y");
		const_19 = new str("^w");
		const_20 = new str("^b");
		const_21 = new str(" | Result:\t");
		const_22 = new str("\\d");
		const_23 = new str("__main__");

		__name__ = new str("__main__");

		/**
		 copyright Sean McCarthy, license GPL v2 or later 
		*/
		cl_Mastermind = new class_("Mastermind");
		/**
		Instantiate mastermind and invoke play method to play game
		
		*/
		if (__eq(__name__, const_23)) {
			GlobalMembersMastermind.__ss_main();
		}
	}


	public static int Main(int __ss_argc, String[] __ss_argv) {
		__shedskin__.__init();
		__math__.__init();
		__time__.__init();
		__random__.__init();
		__colour__.__init();
		__peg__.__init();
		__code__.__init();
		__row__.__init();
		__board__.__init();
		__game__.__init();
		__re__.__init();
		__sys__.__init(__ss_argc, __ss_argv);
		__shedskin__.__start(__init);
	}
}