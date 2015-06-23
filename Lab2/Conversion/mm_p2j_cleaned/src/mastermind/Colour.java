package mastermind;

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
