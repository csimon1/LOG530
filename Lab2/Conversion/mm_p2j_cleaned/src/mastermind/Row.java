package mastermind;

/** 
 * classe Row : Representation d'une ligne (un ensemble de pion). 
 * copyright Sean McCarthy, license GPL v2 or later 
 */
public class Row {
	private Code __guess;
	private Code __result;
	
	/**
	 * Initialisation d'un ligne
	 * Une ligne est constitue d'un code devinez + code resulat
	 * @param guess
	 * @param result
	 * @return 
	 */
	public Row (Code guess,Code result){
		__guess = guess;
		__result = result;
	}

	/**
	 * Recupere le code devinez de la ligne
	 * @return 
	 */
	public Code getGuess(){
		return __guess;
	}

	/**
	 * Recupere le code resultat de la ligne
	 * @return 
	 */
	public Code getResult(){
		return __result;
	}
}
