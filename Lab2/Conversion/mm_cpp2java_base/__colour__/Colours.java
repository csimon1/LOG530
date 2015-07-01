package __colour__;

import __shedskin__.*;

public class Colours extends pyobj {
	public static __ss_int purple = new __ss_int();
	public static __ss_int yellow = new __ss_int();
	public static __ss_int green = new __ss_int();
	public static __ss_int numberOfColours = new __ss_int();
	public static __ss_int white = new __ss_int();
	public static __ss_int red = new __ss_int();
	public static __ss_int black = new __ss_int();

	public Colours() {
		this.__class__ = GlobalMembersColour.cl_Colours;
	}
	public static void __static__() {
		numberOfColours = 6;
		red = 0;
		green = 1;
		purple = 2;
		yellow = 3;
		white = 4;
		black = 5;
	}
}
//C++ TO JAVA CONVERTER TODO TASK: Only the namespaces at the beginning of the file can be converted to the Java 'package' for this file:
//ORIGINAL LINE: namespace __colour__


