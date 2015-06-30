package mastermind.__peg__;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Peg;
public class Peg  {
/**
Class representing a (coloured) peg on the mastermind board
*/
	public int __colour = 0;

	public Peg() {
	}
	
	/**
	 * Initialisation d'un pion
	 * @param colour :couleur du pion
	 * @return 
	 */
	public Peg(int colour) {
		__init__(colour);
	}
	
	/**
	    * Recupere la couleur d'un pion
	    * @return 
	    */
	public final int getColour() {
		return this.__colour;
	}
	
	/**
	    * Verifie qu'un pion en equivaut un autre (meme couleur)
	    * @param peg
	    * @return vrai ou faux
	    */
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(obj instanceof Peg){
			Peg peg = (Peg) obj;
			
			return ((peg.getColour() == this.__colour));
		}
		
		return false;
	}

	public final void __init__(int colour) {
		this.__colour = colour;
	}
	
}
//C++ TO JAVA CONVERTER TODO TASK: Only the namespaces at the beginning of the file can be converted to the Java 'package' for this file:
//ORIGINAL LINE: namespace __peg__


