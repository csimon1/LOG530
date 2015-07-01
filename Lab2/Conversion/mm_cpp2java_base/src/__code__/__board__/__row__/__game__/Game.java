package __code__.__board__.__row__.__game__;

import __shedskin__.*;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Code;
//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Board;
//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Row;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Game;
public class Game extends pyobj {
/**
Class Game, provides functions for playing
*/
	public __ss_int __maxguesses = new __ss_int();
	public __code__.Code __secretCode;
	public __board__.Board __board;
	public __ss_int __tries = new __ss_int();

	public Game() {
	}
	public Game(__ss_int maxguesses) {
		this.__class__ = GlobalMembersGame.cl_Game;
		__init__(maxguesses);
	}
	public final __ss_bool isOver() {
		__ss_bool __16 = new __ss_bool();
		__ss_bool __17 = new __ss_bool();

		if ((this.__tries > 0)) {
			return ((___bool(__16 = ___bool((this.__tries >= this.__maxguesses))))?(__16):((this.lastGuess()).equals(this.__secretCode)));
		}
		return False;
	}
	public final Object makeGuess(__code__.Code guessCode) {

		this.__tries = (this.__tries + 1);
		(this.__board).addRow((new __row__.Row(guessCode, this.getResult(guessCode))));
		return null;
	}
	public final __code__.Code getSecretCode() {

		return this.__secretCode;
	}
	public final __ss_int getTries() {

		return this.__tries;
	}
	public final __ss_bool isWon() {

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
	public final __ss_int getMaxTries() {

		return this.__maxguesses;
	}
	public final Object __init__(__ss_int maxguesses) {
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


