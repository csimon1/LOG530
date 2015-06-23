package mastermind;

public class Game {

	private int __maxguesses;
	private int __tries;
	private Code __secretCode;
	private Board __board;

	public Game(int maxguesses) {
		Code secret = new Code();
        secret.setRandomCode(-1);
        __secretCode = secret;	
        __board = new Board();
        __maxguesses = maxguesses;
        __tries = 0;
	}

	public Board getBoard() {
		return __board;
	}

	public Code getSecretCode() {
		return __secretCode;
	}
	
	public void makeGuess(Code guessCode) {
		__tries += 1;
        __board.addRow( new Row(guessCode, getResult(guessCode) ) );
	}
	
	public Code getResult(Code guessCode){
        return __secretCode.compare(guessCode);
	}
	
	private Code lastGuess() {
		return __board.getRow(__tries-1).getGuess();
	}
        		
	public boolean isOver() {
		 if (__tries > 0){	 
            return (__tries >= __maxguesses || lastGuess().equals(__secretCode));
		 }
		return false;
	}
	
	public boolean isWon() {
		return lastGuess().equals(getSecretCode());
	}
	
	public int getTries(){
		return __tries;
	}
        		
	public int getMaxTries() {
		return __maxguesses;
	}
}
