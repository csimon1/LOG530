package mastermind;

import java.util.ArrayList;
import java.util.Random;

import mastermind.Colour.EColour;

public class Code {
	private int __defaultCodeSize = 4;
	private ArrayList<Peg> __pegList;
	
	public Code(ArrayList<Peg> guessPegs) {
        __pegList = guessPegs;
	}

	public Code() {
        __pegList = new ArrayList<Peg>();
	}
	
    public void setPegs(ArrayList<Peg> __pegList){
    	this.__pegList = __pegList;
    }
        
	public void setRandomCode(int codeSize) {
		if (codeSize == -1){
            codeSize = __defaultCodeSize;
		}
		
		Random rand = new Random();
        __pegList.clear();
        
        for(int i=0; i<codeSize; i++){ 
        	int r = rand.nextInt(Colour.numberOfColours-1);
        	EColour e[] =  Colour.EColour.values();
        	Peg x =  new Peg(e[r]);
            __pegList.add(x);
        }
        
	}
	

	public ArrayList<Peg> getPegs(){
        return __pegList;
	}    		
        		
	public boolean equals(Code code){
		ArrayList<Peg> c1 = code.getPegs();
		return c1.equals(__pegList);
	}
	
	public Code compare(Code code){
		ArrayList<Peg> resultPegs = new ArrayList<Peg>();
		ArrayList<Boolean> secretUsed = new ArrayList<Boolean>();
		ArrayList<Boolean> guessUsed = new ArrayList<Boolean>();
        int count = 0;
        int codeLength = __pegList.size();
        
        for(int i=0; i<codeLength; i++){
            secretUsed.add(false);
            guessUsed.add(false);
        }


        for(int i=0; i<codeLength; i++){
            if (__pegList.get(i).equals(code.getPegs().get(i))){
                secretUsed.set(i, true);
                guessUsed.set(i, true);
                resultPegs.add(new Peg(Colour.EColour.black) ) ;
                count += 1;
            }
        }

        if (count < codeLength-1){
        	for(int i=0; i<codeLength; i++){
                if (guessUsed.get(i)) continue;
                for(int j=0; j<codeLength; j++){
                    if ( (i != j) && (! secretUsed.get(j) )
                    		&& (! guessUsed.get(i)) 
                    		&& ( __pegList.get(j).equals(code.getPegs().get(i)) )
                    ){
                        resultPegs.add( new Peg(Colour.EColour.white));
                        secretUsed.set(j, true);
                        guessUsed.set(i, true);
                    }
                }
        	}
        }

        return new Code(resultPegs);
	}


}
