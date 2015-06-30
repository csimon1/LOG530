package mastermind.__code__;

import java.util.Random;

import mastermind.__colour__.Colours;
import mastermind.__peg__.Peg;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Peg;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Code;
public class Code {
/**
Class representing a collection of pegs
*/
	private int __defaultCodeSize = 0;
	private java.util.LinkedList<Peg> __pegList;

	private Code() {
	}
	
	public Code(java.util.LinkedList<Peg> __pegList) {
		__init__(__pegList);
	}
	
	public final Code compare(Code code) throws Exception {
		java.util.LinkedList<Peg> resultPegs;
		java.util.LinkedList<Boolean> guessUsed;
		java.util.LinkedList<Boolean> secretUsed;
		Boolean __12,__13,__14,__15;
		int __10, __11, __4, __5 , __6, __7, __8, __9, codeLength, count,i, j;

		resultPegs = (new java.util.LinkedList<Peg>());
		secretUsed = (new java.util.LinkedList<Boolean>());
		guessUsed = (new java.util.LinkedList<Boolean>());
		count = 0;
		codeLength = this.__pegList.size();

		if (1 == 0) {
			throw new Exception("range() step argument must not be zero");
		}
		for (__4 = 0, __5 = codeLength; ; __4 += 1) {
			if (1 >= 0) {
				if (__4 >= __5)
					break;
			}
			else {
				if (__4 <= __5)
					break;
			}
			i = __4;
			secretUsed.add(false);
			guessUsed.add(false);
		}

		/**
		Black pegs first: correct colour in correct position
		
		*/

		if (1 == 0) {
			throw new Exception("range() step argument must not be zero");
		}
		for (__6 = 0, __7 = codeLength; ; __6 += 1) {
			if (1 >= 0) {
				if (__6 >= __7)
					break;
			}
			else {
				if (__6 <= __7)
					break;
			}
			i = __6;
			if (((this.__pegList).get(i)).equals((code.getPegs()).get(i))) {
				secretUsed.add(i, true);
				guessUsed.add(i, true);
				resultPegs.add((new Peg(Colours.black)));
				count = (count + 1);
			}
		}

		/**
		White pegs: trickier
		
		White pegs are for pegs of the correct colour, but in the wrong
		place. Each peg should only be evaluated once, hence the "used"
		lists.
		
		Condition below is a shortcut- if there were 3 blacks pegs
		then the remaining peg can't be a correct colour (think about it)
		
		*/
		if ((count < (codeLength - 1))) {

			if (1 == 0) {
				throw new Exception("range() step argument must not be zero");
			}
			for (__8 = 0, __9 = codeLength; ; __8 += 1) {
				if (1 >= 0) {
					if (__8 >= __9)
						break;
				}
				else {
					if (__8 <= __9)
						break;
				}
				i = __8;
				if (guessUsed.get(i)) {
					continue;
				}

				if (1 == 0) {
					throw new Exception("range() step argument must not be zero");
				}
				for (__10 = 0, __11 = codeLength; ; __10 += 1) {
					if (1 >= 0) {
						if (__10 >= __11)
							break;
					}
					else {
						if (__10 <= __11)
							break;
					}
					j = __10;
					if (((i != j) && (!(secretUsed.get(j)))) && (!(guessUsed.get(i))) && ((this.__pegList).get(j)).equals((code.getPegs()).get(i))) {
						resultPegs.add((new Peg(Colours.white)));
						secretUsed.add(j, true);
						guessUsed.add(i, true);
					}
				}

			}

		}
		return (new Code(resultPegs));
	}
	public final java.util.LinkedList<Peg> getPegs() {

		return this.__pegList;
	}
	private final boolean equals(Code code) throws Exception {
		java.util.LinkedList<Peg > c1;
		int __2 = 0;
		int __3 = 0;
		int i = 0;

		c1 = code.getPegs();

		if (1 == 0) {
			throw new Exception("range() step argument must not be zero");
		}
		for (__2 = 0, __3 = 4; ; __2 += 1) {
			if (1 >= 0) {
				if (__2 >= __3)
					break;
			}
			else {
				if (__2 <= __3)
					break;
			}
			i = __2;
			if (!((c1.get(i)).equals((this.__pegList).get(i)))) {
				return false;
			}
		}
		return true;
	}
	public final Object setRandomCode(int codeSize) throws Exception {
		int __0 = 0;
		int __1 = 0;
		int i = 0;
		Peg x;

		if ((codeSize == (-1))) {
			codeSize = this.__defaultCodeSize;
		}
		Random rand = new Random();
		this.__pegList = (new java.util.LinkedList<Peg>());

		if (1 == 0) {
			throw new Exception("range() step argument must not be zero");
		}
		for (__0 = 0, __1 = codeSize; ; __0 += 1) {
			if (1 >= 0) {
				if (__0 >= __1)
					break;
			}
			else {
				if (__0 <= __1)
					break;
			}
			i = __0;
			
			x = (new Peg(rand.nextInt(Colours.numberOfColours - 1)));
			(this.__pegList).add(x);
		}

		return null;
	}
	private final Object __init__(java.util.LinkedList<Peg > __pegList) {

		this.__defaultCodeSize = 4;
		this.__pegList = __pegList;
		return null;
	}
}
//C++ TO JAVA CONVERTER TODO TASK: Only the namespaces at the beginning of the file can be converted to the Java 'package' for this file:
//ORIGINAL LINE: namespace __code__


