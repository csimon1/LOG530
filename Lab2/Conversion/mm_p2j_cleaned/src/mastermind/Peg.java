package mastermind;

import mastermind.Colour;
import mastermind.Colour.EColour;

/** 
 * classe Peg : Representation d'un pion. 
 * copyright Sean McCarthy, license GPL v2 or later 
 */
public class Peg {
	private Colour __colour;
	
	/**
	 * Initialisation d'un pion
	 * @param colour :couleur du pion
	 * @return 
	 */
    public Peg(EColour colour) {
	   __colour = new Colour();
	   __colour.color = colour;
	}

   /**
    * Recupere la couleur d'un pion
    * @return 
    */
   public Colour getColour(){
        return __colour;
   }

   /**
    * Verifie qu'un pion en equivaut un autre (meme couleur)
    * @param peg
    * @return vrai ou faux
    */
   	@Override
    public boolean equals(Object pego){
   		Peg peg = (Peg) pego;
        return peg.getColour().color == this.__colour.color;
    }
}
