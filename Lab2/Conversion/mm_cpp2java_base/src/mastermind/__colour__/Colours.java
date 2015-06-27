package mastermind.__colour__;

public class Colours {
	public static int purple = 0;
	public static int yellow = 0;
	public static int green = 0;
	public static int numberOfColours = 0;
	public static int white = 0;
	public static int red = 0;
	public static int black = 0;

	public Colours() {
		
	}
	private static void __static__() {
		numberOfColours = 6;
		red = 0;
		green = 1;
		purple = 2;
		yellow = 3;
		white = 4;
		black = 5;
	}
	
	public static void __init() {
		const_0 = new String("red");
		const_1 = new String("green");
		const_2 = new String("purple");
		const_3 = new String("yellow");
		const_4 = new String("white");
		const_5 = new String("black");

		Colours.__static__();
	}
	public static String getColourName(int i) {

		if ((i == 0)) {
			return const_0;
		}
		else if ((i == 1)) {
			return const_1;
		}
		else if ((i == 2)) {
			return const_2;
		}
		else if ((i == 3)) {
			return const_3;
		}
		else if ((i == 4)) {
			return const_4;
		}
		else if ((i == 5)) {
			return const_5;
		}
		return "0";
	}



	/**
	 copyright Sean McCarthy, license GPL v2 or later 
	*/


	public static String const_0;
	public static String const_1;
	public static String const_2;
	public static String const_3;
	public static String const_4;
	public static String const_5;

}
//C++ TO JAVA CONVERTER TODO TASK: Only the namespaces at the beginning of the file can be converted to the Java 'package' for this file:
//ORIGINAL LINE: namespace __colour__


