package __peg__;

import __shedskin__.*;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Peg;
public class Peg extends pyobj {
/**
Class representing a (coloured) peg on the mastermind board
*/
	public __ss_int __colour = new __ss_int();

	public Peg() {
	}
	public Peg(__ss_int colour) {
		this.__class__ = GlobalMembersPeg.cl_Peg;
		__init__(colour);
	}
	public final __ss_int getColour() {

		return this.__colour;
	}
	public final __ss_bool equals(Peg peg) {

		return ___bool((peg.getColour() == this.__colour));
	}
	public final Object __init__(__ss_int colour) {

		this.__colour = colour;
		return null;
	}
}
//C++ TO JAVA CONVERTER TODO TASK: Only the namespaces at the beginning of the file can be converted to the Java 'package' for this file:
//ORIGINAL LINE: namespace __peg__


