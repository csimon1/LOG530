package mastermind.__mastermind__;

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
		boolean __49;
		boolean __50;
		int guesses = 0;

		m = (new Mastermind());
		guesses = 8;
		if (((len(__sys__.argv) > 1) && (__re__.match(const_22, (__sys__.argv).__getfast__(1), 0) != null))) {
			guesses = __int((__sys__.argv).__getfast__(1));
		}
		m.play(guesses);
		return null;
	}




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


	public static String __name__;



	/**
	 copyright Sean McCarthy, license GPL v2 or later 
	*/
	public static class_ cl_Mastermind;

	public static void __init() {
		const_0 = new String("Guess: ");
		const_1 = __char_cache[47];
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

		__name__ = new String("__main__");

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

}
