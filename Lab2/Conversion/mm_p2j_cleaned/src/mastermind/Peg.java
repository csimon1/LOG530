package mastermind;

import mastermind.Colour;
import mastermind.Colour.EColour;

public class Peg {
	private Colour __colour;
	
    public Peg(EColour colour) {
	   __colour = new Colour();
	   __colour.color = colour;
	}

   public void setColour(EColour colour){
        __colour.color = colour;
   }

   public Colour getColour(){
        return __colour;
   }

   	@Override
    public boolean equals(Object pego){
   		Peg peg = (Peg) pego;
        return peg.getColour().color == this.__colour.color;
    }

    public void display(){
    	String s = __colour.getColourName();
    	int space = 6-s.length(), i;
    	for(i=0; space>i; i++){ //.rjust(6)
    		s += "";
    	}
        System.out.println(); 
    }
}
