package recursion_and_iteration_comparison;

import java.lang.Math;

public class Game1Iter2 {
	public String game; // either "racquetball" or "volleyball"
	public boolean winByTwo;
	public int numberOfGames;
	// use the following field to enable tracing of results of each game
	public static boolean printGame = true;

	/**
	 * Constructor specifies whether racquetball or volleyball will be simulated
	 * (default racquetball) and the number of games to be simulated Constructor
	 * also uses the racquetball/volleyball information to determine if players
	 * of the game must win by 2 or 1, respectively.
	 */
	public Game1Iter2(String simGame, int simNumGames) {
		game = simGame;
		numberOfGames = simNumGames;
		winByTwo = simGame.equals("volleyball");
	}

	/**
	 * Format a probability (a number between 0.0 and 1.0) as a 2-character
	 * integer percentage, followed by a "%" character.
	 */
	public static String formatPercent(double value) {
		String str = "" + Math.round(value * 100.0);
		while (str.length() < 3)
			str = " " + str;
		return str + "%";
	}

	/**
	 * Play one game of racquetball or volleyball to conclusion
	 * 
	 * @parms probWinVolley specifies the likelihood the server wins a volley
	 * @returns winner of game: either "A" or "B"
	 */
	public String playUntilWin(double probWinVolley) { // start at 0-0
		int AScore = 0;
		int BScore = 0;

		// continue indefinitely
		// (until A wins after A's serve or B wins after B's serve)
		while (true) { // A serves
			while (Math.random() < probWinVolley) {
				AScore++;
				if ((AScore >= 15) && ((!winByTwo) || (AScore >= BScore + 2))) 
					
					{ if (printGame)
					    System.out.println ("A wins the game" + " - Score(A/B) :  " 
								+ AScore 
								+ " / " + BScore);
				      return "A";
				    }
					
				
			}

			// B serves
			while (Math.random() < 1.0 - probWinVolley) {
				BScore++;
				if ((BScore >= 15) && ((!winByTwo) || (BScore >= AScore + 2))) 
				{ if (printGame)
				    System.out.println ("B wins the game" + " - Score(B/A):  " 
							+ BScore 
							+ " / " + AScore);
			      return "B";
			    }
			}
		}
	}

	/**
	 * Run simulation of 1000 games for probability of "A" winning a volley
	 * covering the range 0.40, 0.41, ..., 0.59, 0.60. For each probability of
	 * "A" winning, simulate games with Player/Team A always serving first print
	 * one line with the percentage of volleys won by A and B and percentage of
	 * games won by A and B
	 */
	public void simulateGames() { // print headings
		System.out.println("\nSimulation of " + game + " based on "
				+ numberOfGames + " games");
		System.out.println("Must win by 2:  " + winByTwo);
		System.out.println();
		System.out.println("    Probabilities         Percentage");
		System.out.println(" for winning volley        of Wins");
		System.out.println("     A       B            A        B");
		System.out.println();

		// Simulate games for 40% to 60% probabilities for A
		for (int prob40To60 = 40; prob40To60 <= 60; prob40To60++) {
			double probWinVolley = prob40To60 / 100.0;

			// Simulate games for a given probability
			int AWins = 0; // at first neither A nor B has won any games
			int BWins = 0;
			for (int i = 0; i < numberOfGames; i++) { // tally winner of game
														// System.out.print
														// ("game " + i
														// +" \t prob "+
														// probWinVolley);
				if (playUntilWin(probWinVolley).equals("A"))
					AWins++;
				else
					BWins++;
			}
			System.out.println("   " + formatPercent(probWinVolley) + "    "
					+ formatPercent(1 - probWinVolley) + "         "
					+ formatPercent(((double) AWins) / numberOfGames) + "     "
					+ formatPercent(((double) BWins) / numberOfGames));
		}
	}

	/**
	 * @parm args is a command-line argument specifies the type of game
	 *       "racquetball" indicates server need not win by 2 points
	 *       "volleyball" indicates server must win by 2 points no parameter or
	 *       other parameter defaults to "racquetball"
	 */
	public static void main(String[] args) {
		Game1Iter2 rac1 = new Game1Iter2("racquetball", 1000);
		rac1.simulateGames();

		Game1Iter2 rac2 = new Game1Iter2("volleyball", 500);
		rac2.simulateGames();
	}
}