package mastermind.__row__;

import mastermind.__code__.Code;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Code;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Row;
public class Row {
/**
Class containing a guess code and answer code
*/
	public Code __result;
	public Code __guess;

	/**
	 * Initialisation d'un ligne
	 * Une ligne est constitue d'un code devinez + code resulat
	 * @param guess
	 * @param result
	 * @return 
	 */
	public Row(Code guess, Code result) {
		__init__(guess, result);
	}
	
	/**
	 * Recupere le code resultat de la ligne
	 * @return 
	 */
	public final Code getResult() {

		return this.__result;
	}
	
	/**
	 * Recupere le code devinez de la ligne
	 * @return 
	 */
	public final Code getGuess() {

		return this.__guess;
	}
	
	private final Object __init__(Code guess, Code result) {

		this.__guess = guess;
		this.__result = result;
		return null;
	}
	
}
//C++ TO JAVA CONVERTER TODO TASK: Only the namespaces at the beginning of the file can be converted to the Java 'package' for this file:
//ORIGINAL LINE: namespace __row__


