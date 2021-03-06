import java.util.Scanner;
import java.util.Random;

public class headsOrTails {

	public static void main(String[] args) {
		boolean userInputHeads = false;
		boolean valid = false;
		Scanner scan = new Scanner(System.in);
		String headsOrTailsGuess;
		 System.out.println("Welcome to the Heads or Tails program by Bolanle Aduroja." +"\n");
	
		do {
			// ask user for heads or tails, lowercase and trim to use more easily
			System.out.print("Guess which will have more: heads or tails? ");
			headsOrTailsGuess = scan.next().toLowerCase().trim();

			// check that user input valid heads or tails

			if (headsOrTailsGuess.equals("heads") || headsOrTailsGuess.equals("head")) {
				userInputHeads = true;
				valid = true;
			} else if (headsOrTailsGuess.equals("tails") || headsOrTailsGuess.equals("tail")) {
				userInputHeads = false;
				valid = true;

			} else {
				System.out.println("");
				System.out.print("ERROR. Only 'heads' or 'tails' should be entered. Please try again. ");
				valid = false;
			}
			// INSTEAD OF RETURN I WANT TO LOOP TO KEEP ASKING UNTIL IT'S HEADS OR TAILS
		} while (valid == false);
		// ask for number of flips
		System.out.print("How many times shall we flip a coin? ");
		int numberOfFlips = scan.nextInt();
		System.out.println("");

		// generate heads and tails randomly based on user input and store the amount of
		// each flip
		int correctCount = 0;

		if (numberOfFlips <= 0) {
			System.out.println("ERROR");
			scan.close();
			return;
		}
		for (int i = 1; i <= numberOfFlips; i++) {
			int randomFlip = ((int) (Math.random() * 2));

			if (randomFlip == 0) {
				System.out.println("Heads");
			} else {
				System.out.println("Tails");
			}
			if (userInputHeads && randomFlip == 0) {
				correctCount = correctCount + 1;
			} else if (userInputHeads == false && randomFlip == 1) {
				correctCount = correctCount + 1;
			}
		}
		// calculate percentage and print final statement

		int percentage = (int) ((double) correctCount / numberOfFlips * 100);

		System.out.println(" ");
		System.out.println("Your guess, " + headsOrTailsGuess + ", came up " + correctCount + " time(s).");
		System.out.println("That's " + percentage + "%.");

		scan.close();
	}

}
