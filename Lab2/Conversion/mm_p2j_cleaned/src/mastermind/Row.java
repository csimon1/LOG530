package mastermind;

public class Row {
	private Code __guess;
	private Code __result;
	
	public Row (Code guess,Code result){
		__guess = guess;
		__result = result;
	}

	public void setGuess(Code guess){
		__guess = guess;
	}

	public void setResult(Code result){
		__result = result;
	}

	public Code getGuess(){
		return __guess;
	}

	public Code getResult(){
		return __result;
	}
}
