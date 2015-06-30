package mastermind.__game__;

import mastermind.__board__.Board;
import mastermind.__code__.Code;
import mastermind.__row__.Row;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Code;
//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Board;
//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Row;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Game;

/**
 * Class Game : Offre les fonctions pour effectuer une partie
 * copyright Sean McCarthy, license GPL v2 or later 
 */
public class Game {
/**
Class Game, provides functions for playing
*/
	public int __maxguesses = 0;
	public Code __secretCode;
	public Board __board;
	public int __tries = 0;

	public Game() {
	}
	
	/**
	 * Initialisation d'un jeux
	 * @param maxguesses : nombre maximal d'essais
	 */
	public Game(int maxguesses) throws Exception {
		__init__(maxguesses);
	}
	
	/**
	 * Determine si la partie est finit ou pas selon les regles
	 * @return vrai ou faux
	 */
	public final boolean isOver() {
		boolean __16 = false;
		boolean __17 = false;

		if ((this.__tries > 0)) {
			return ((__16 = (this.__tries >= this.__maxguesses))?(__16):((this.lastGuess()).equals(this.__secretCode)));
		}
		return false;
	}
	
	/**
	 * Un joueur effectue un essais (on recupere le code proposer)
	 * @param guessCode
	 * @return 
	 */
	public final Object makeGuess(Code guessCode) throws Exception {

		this.__tries = (this.__tries + 1);
		(this.__board).addRow((new Row(guessCode, this.getResult(guessCode))));
		return null;
	}
	
	/**
	 * Recupere le code secret de la partie
	 * @return Code secret
	 */
	public final Code getSecretCode() {
		return this.__secretCode;
	}
	
	/**
	 * Recupere le nombre d'essais deja effectue
	 * @return int > 0
	 */
	public final int getTries() {
		return this.__tries;
	}
	
	/**
	 * Determine si le joueur a gagne (trouve le code secret) ou pas
	 * @return vrai ou faux
	 */
	public final boolean isWon() {
		return (this.lastGuess()).equals(this.getSecretCode());
	}
	
	/**
	 * Recupere le derniere essais d'un joueur
	 * @return Code devinez
	 */
	public final Code lastGuess() {
		return ((this.__board).getRow((this.__tries - 1))).getGuess();
	}
	
	/**
	 * Genere le code resultat en fonction ducode devinez et le code secret
	 * @param guessCode
	 * @return 
	 */
	public final Code getResult(Code guessCode) throws Exception {
		return (this.__secretCode).compare(guessCode);
	}
	
	/**
	 * Recupere la planche de jeux
	 * @return planche de jeux
	 */
	public final Board getBoard() {
		return this.__board;
	}
	
	/**
	 * Recupere le nombre maximal d'essai autoriser pour cette partie
	 * @return int > 0
	 */
	public final int getMaxTries() {
		return this.__maxguesses;
	}
	public final Object __init__(int maxguesses) throws Exception {
		Code secret;

		secret = (new Code(null));
		secret.setRandomCode((-1));
		this.__secretCode = secret;
		this.__board = (new Board(1));
		this.__maxguesses = maxguesses;
		this.__tries = 0;
		return null;
	}
}
//C++ TO JAVA CONVERTER TODO TASK: Only the namespaces at the beginning of the file can be converted to the Java 'package' for this file:
//ORIGINAL LINE: namespace __game__


