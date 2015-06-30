package mastermind;

import java.util.ArrayList;
import java.util.Random;

import mastermind.Colour.EColour;

/**
 * Class Code : Un code est un ensemble de 4 (par defaut) pions qui forme une combinaison
 * copyright Sean McCarthy, license GPL v2 or later 
 */

public class Code {
	private int __defaultCodeSize = 4;
	private ArrayList<Peg> __pegList;
	
	/**
	 * Constructeur d'un code en donnant une liste de pions
	 * @param guessPegs
	 * @return 
	 */
	public Code(ArrayList<Peg> guessPegs) {
        __pegList = guessPegs;
	}

	/**
	 * Constructeur d'un code par defaut
	 * @return 
	 */
	public Code() {
        __pegList = new ArrayList<Peg>();
	}

	/**
	 * Assignation des pions pour un code
	 * @param __pegList
	 */
    public void setPegs(ArrayList<Peg> __pegList){
    	this.__pegList = __pegList;
    }
    
    /**
     * Genere un code aleatoire de taille codeSize
     * @param codeSize : Taille du code a genere
     * @return Code aleatoire
     */
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

	/**
	 * Retourne la liste de pions constituant le code
	 * @return list<__peg__::Peg *>
	 */
	public ArrayList<Peg> getPegs(){
        return __pegList;
	}    		
    
	/**
	 * Fonction pour verifier qu'un Code est equivalent a un autre.
	 * On verifie simplement que la couleur d'un pions est egale a un autre pour l'emplacement donne.
	 * @param code
	 * @return 
	 */
	public boolean equals(Code code){
		ArrayList<Peg> c1 = code.getPegs();
		return c1.equals(__pegList);
	}
	
	/**
	 * On compare le code donne par rapport au code secret et genere un "Code" resultant.
	 * Le code resultant est contitue de :
	 *  -1 pions blanc par pion correct mais mal place.
	 *  -1 pions noir par pion correct et bien place.
	 * Le code resultant ne doit pas respecte les indexs 
	 * @param code : code devinez
	 * @return code resultat
	 */
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
