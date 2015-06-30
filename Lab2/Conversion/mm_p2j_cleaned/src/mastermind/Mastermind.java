package mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// copyright Sean McCarthy, license GPL v2 or later 

/**
The game of Mastermind

This class provides a function "play" for invoking a new game.

The objective of the game is to guess a code composed of 4 coloured
pegs. The code can be composed of any combination of the six colours
(red, green, purple, yellow, white, black), and can include duplicates.

For each guess a result code may be returned composed of black and/or
white pegs. A black peg indicates a peg of the right colour and in the
right position. A white peg indicates a peg of the right colour but in
the wrong position. The arrangement of the pegs does not correspond to
the pegs in the guess- black pegs will always be shown first, followed
but white pegs.

The game ends with either a correct guess or after running out of 
guesses.
*/

public class Mastermind { // Line 10
	/**
	 * Parcour de l'entree clavier (string) obtenue pour extraire les couleurs
	 * @param s : string du clavier
	 * @return Pion identifie
	 */
	public Peg __parseColour(String s) { // Line 89
		if (s.matches("^b")) { // Line 100
			return new Peg(Colour.EColour.black);
		} 
		if (s.matches("^w")) { // Line 98
			return new Peg(Colour.EColour.white);
		}
		if (s.matches("^y")) { // Line 96
			return new Peg(Colour.EColour.yellow);
		}
		if (s.matches("^g")) { // Line 94
			return new Peg(Colour.EColour.green);
		}
		if (s.matches("^p")) { // Line 92
			return new Peg(Colour.EColour.purple);
		}
		if (s.matches("^r")) { // Line 90
			return new Peg(Colour.EColour.red);
		}
		return null;
	}
	
	/**
	 * Affichage du msg de bienvenue
	 * @return 
	 */
	public void greeting() { // Line 48
		System.out.println("");
		System.out.println("---------------------");
		System.out.println("Welcome to Mastermind");
		System.out.println("---------------------");
		System.out.println("");
		System.out.println("Each guess should be 4 colours from any of:");
		System.out.println("red yellow green purple black white");
		System.out.println("");
	}
	
	/**
	 * Affiche de l'evolution du jeux
	 * @param game
	 * @return 
	 */
	public void display(Game game) { // Line 58
		for (Row r:game.getBoard().getRows()) { // Line 59
			for (Peg p:r.getGuess().getPegs()) { // Line 60
				String str = p.getColour().getColourName() ;
				System.out.print( utils.rjust(str,6));
			};
			System.out.print(" | Result:	");
			for (Peg p:r.getResult().getPegs()) { // Line 63
				String str = p.getColour().getColourName() ;
				System.out.print( utils.rjust(str,6));
			};
			System.out.println("");
		};	
		//displaySecret(game);
	}
	
	/**
	 * Affichage du code secret
	 * @param game
	 * @return 
	 */
	public void displaySecret(Game game) { // Line 67
		for (Peg p:game.getSecretCode().getPegs()) { // Line 68
			String str = p.getColour().getColourName() ;
			System.out.print( utils.rjust(str,6));
		};
	}
	
	/**
	 * Lecture de l'entree clavier pour avoir un 'code devinez'
	 * @return Code
	 */
	public Code __readGuess() { // Line 71
		ArrayList<Peg> guessPegs = new ArrayList<Peg>(); // Line 72
		System.out.println("Type four (space seperated) colours from:");
		System.out.println("[r]ed [y]ellow [g]reen [p]urple [b]lack [w]hite");
		boolean inputOk = false; // Line 76
		
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String strin;
		try {

			while (!inputOk) { // Line 77
				strin = sc.readLine();
				String colours[] = strin.split(" ", 4); // Line 78
				for (String c:colours) { // Line 79
					Peg pegpeg = __parseColour(c);
					if (pegpeg != null) { // Line 81 !!INVERSION DE LA conversion loll
						guessPegs.add(pegpeg);
					}
				};
				inputOk = (guessPegs.size() == 4); // Line 83
				if (!inputOk) { // Line 84
					System.out.println("Invalid input, use colours as stated\n");
					guessPegs.clear(); // Line 86
				}
			};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new Code(guessPegs);
	}

	/**
	 * Demarrage d'une partie
	 * @param guesses : nombre d'essais max
	 * @return 
	 */
	public void play(int guesses) { // Line 32
		this.greeting();
		Game gm = new Game(guesses); // Line 34
		while (!gm.isOver()) { // Line 35
			//Guess: 
			System.out.println("Guess : "+(gm.getTries()+1)+"/"+gm.getMaxTries()); // missing dans conversion
			gm.makeGuess(this.__readGuess());
			System.out.println("--------Board--------");
			this.display(gm);
			System.out.println("---------------------");
		};
		if (gm.isWon()) { // Line 42
			System.out.println("Congratulations!");
		} else {
			System.out.println("Secret Code: ");
			this.displaySecret(gm);
		}
	}

}
