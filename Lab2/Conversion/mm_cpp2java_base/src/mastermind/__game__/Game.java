package mastermind.__game__;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Code;
//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Board;
//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Row;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Game;
public class Game {
/**
Class Game, provides functions for playing
*/
	public int __maxguesses = 0;
	public __code__.Code __secretCode;
	public __board__.Board __board;
	public int __tries = 0;

	public Game() {
	}
	public Game(int maxguesses) {
		this.__class__ = GlobalMembersGame.cl_Game;
		__init__(maxguesses);
	}
	public final boolean isOver() {
		boolean __16 = new boolean();
		boolean __17 = new boolean();

		if ((this.__tries > 0)) {
			return ((___bool(__16 = ___bool((this.__tries >= this.__maxguesses))))?(__16):((this.lastGuess()).equals(this.__secretCode)));
		}
		return false;
	}
	public final Object makeGuess(__code__.Code guessCode) {

		this.__tries = (this.__tries + 1);
		(this.__board).addRow((new __row__.Row(guessCode, this.getResult(guessCode))));
		return null;
	}
	
	public final __code__.Code getSecretCode() {
		return this.__secretCode;
	}
	
	public final int getTries() {
		return this.__tries;
	}
	
	public final boolean isWon() {
		return (this.lastGuess()).equals(this.getSecretCode());
	}
	
	public final __code__.Code lastGuess() {
		return ((this.__board).getRow((this.__tries - 1))).getGuess();
	}
	
	public final __code__.Code getResult(__code__.Code guessCode) {
		return (this.__secretCode).compare(guessCode);
	}
	
	public final __board__.Board getBoard() {
		return this.__board;
	}
	
	public final int getMaxTries() {
		return this.__maxguesses;
	}
	
	public final Object __init__(int maxguesses) {
		__code__.Code secret;

		secret = (new __code__.Code(null));
		secret.setRandomCode((-1));
		this.__secretCode = secret;
		this.__board = (new __board__.Board(1));
		this.__maxguesses = maxguesses;
		this.__tries = 0;
		return null;
	}
}
//C++ TO JAVA CONVERTER TODO TASK: Only the namespaces at the beginning of the file can be converted to the Java 'package' for this file:
//ORIGINAL LINE: namespace __game__


