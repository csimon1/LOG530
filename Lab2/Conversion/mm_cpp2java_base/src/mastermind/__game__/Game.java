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
	public Game(int maxguesses) throws Exception {
		__init__(maxguesses);
	}
	public final boolean isOver() {
		boolean __16 = false;
		boolean __17 = false;

		if ((this.__tries > 0)) {
			return ((__16 = (this.__tries >= this.__maxguesses))?(__16):((this.lastGuess()).equals(this.__secretCode)));
		}
		return false;
	}
	public final Object makeGuess(Code guessCode) throws Exception {

		this.__tries = (this.__tries + 1);
		(this.__board).addRow((new Row(guessCode, this.getResult(guessCode))));
		return null;
	}
	
	public final Code getSecretCode() {
		return this.__secretCode;
	}
	
	public final int getTries() {
		return this.__tries;
	}
	
	public final boolean isWon() {
		return (this.lastGuess()).equals(this.getSecretCode());
	}
	
	public final Code lastGuess() {
		return ((this.__board).getRow((this.__tries - 1))).getGuess();
	}
	
	public final Code getResult(Code guessCode) throws Exception {
		return (this.__secretCode).compare(guessCode);
	}
	
	public final Board getBoard() {
		return this.__board;
	}
	
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


