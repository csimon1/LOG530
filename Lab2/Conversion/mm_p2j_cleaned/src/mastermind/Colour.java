package mastermind;

/**
 * Class Colours : Association d'une couleur a un chiffre pour facilite les comparaison
 * copyright Sean McCarthy, license GPL v2 or later 
 */

public class Colour {
	public static final int numberOfColours = 6;
	public static enum EColour {
		red,
		green,
	    purple,
	    yellow,
	    white,
	    black
	};
	
	public EColour color;
	
	/**
	 * Retourne le nom d'une couleur pour un index donnee
	 * @param i
	 * @return 
	 */
	public String getColourName() {
		switch(color){
			case red : return "red";
			case green : return "green";
			case purple : return "purple";
			case yellow : return "yellow";
			case white : return "white";
			case black : return "black";
		}
		return null;
	}
    
}
