package mastermind;

/**
 * Class Game : Offre les fonctions pour effectuer une partie
 * copyright Sean McCarthy, license GPL v2 or later 
 */

public class Game {
	private int __maxguesses;
	private int __tries;
	private Code __secretCode;
	private Board __board;

	
	/**
	 * Initialisation d'un jeux
	 * @param maxguesses : nombre maximal d'essais
	 */
	public Game(int maxguesses) {
		Code secret = new Code();
        secret.setRandomCode(-1);
        __secretCode = secret;	
        __board = new Board();
        __maxguesses = maxguesses;
        __tries = 0;
	}

	/**
	 * Recupere la planche de jeux
	 * @return planche de jeux
	 */
	public Board getBoard() {
		return __board;
	}

	/**
	 * Recupere le code secret de la partie
	 * @return Code secret
	 */
	public Code getSecretCode() {
		return __secretCode;
	}
	
	/**
	 * Un joueur effectue un essais (on recupere le code proposer)
	 * @param guessCode
	 * @return 
	 */
	public void makeGuess(Code guessCode) {
		__tries += 1;
        __board.addRow( new Row(guessCode, getResult(guessCode) ) );
	}
	
	/**
	 * Genere le code resultat en fonction ducode devinez et le code secret
	 * @param guessCode
	 * @return 
	 */
	public Code getResult(Code guessCode){
        return __secretCode.compare(guessCode);
	}
	
	/**
	 * Recupere le derniere essais d'un joueur
	 * @return Code devinez
	 */
	private Code lastGuess() {
		return __board.getRow(__tries-1).getGuess();
	}
    
	/**
	 * Determine si la partie est finit ou pas selon les regles
	 * @return vrai ou faux
	 */
	public boolean isOver() {
		 if (__tries > 0){	 
            return (__tries >= __maxguesses || lastGuess().equals(__secretCode));
		 }
		return false;
	}
	
	/**
	 * Determine si le joueur a gagne (trouve le code secret) ou pas
	 * @return vrai ou faux
	 */
	public boolean isWon() {
		return lastGuess().equals(getSecretCode());
	}
	
	/**
	 * Recupere le nombre d'essais deja effectue
	 * @return int > 0
	 */
	public int getTries(){
		return __tries;
	}
    
	/**
	 * Recupere le nombre maximal d'essai autoriser pour cette partie
	 * @return int > 0
	 */
	public int getMaxTries() {
		return __maxguesses;
	}
}
