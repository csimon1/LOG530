package __code__.__row__;

import __shedskin__.*;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Code;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Row;
public class Row extends pyobj {
/**
Class containing a guess code and answer code
*/
	public __code__.Code __result;
	public __code__.Code __guess;

	public Row() {
	}
	public Row(__code__.Code guess, __code__.Code result) {
		this.__class__ = GlobalMembersRow.cl_Row;
		__init__(guess, result);
	}
	public final __code__.Code getResult() {

		return this.__result;
	}
	public final __code__.Code getGuess() {

		return this.__guess;
	}
	public final Object __init__(__code__.Code guess, __code__.Code result) {

		this.__guess = guess;
		this.__result = result;
		return null;
	}
}
//C++ TO JAVA CONVERTER TODO TASK: Only the namespaces at the beginning of the file can be converted to the Java 'package' for this file:
//ORIGINAL LINE: namespace __row__


