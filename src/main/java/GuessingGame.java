import java.util.Random;
import java.util.Scanner;

/*This code is build from an example code from
https://gist.github.com/jjfiv/767a8041868caae861278659abc063ac*/
public class GuessingGame {
	// I mean for you to delete this code or start typing over it.
	public static void main(String[] args) {
		final int HIGH = 100;
		final int LOW = 0;

		// Create a random number generator:
		Random rand = new Random();

		// Select a secret number.
		final int secretNumber = rand.nextInt(HIGH - LOW) + LOW;
		System.out.println("Welcome to the Guessing Game.");
		System.out.println("I have selected a number from [" + LOW + "," + HIGH + ").");

		// Set the current guess to something that can't be correct.
		int guess = LOW - 1;

		// We use a Scanner to turn characters from SYstem.in into numbers.
		Scanner scanner = new Scanner(System.in);

		while (guess != secretNumber) {
			System.out.println("What is your guess?");
			try {
				guess = scanner.nextInt();
			} catch (Exception err) {
				String whatYouSaid = scanner.nextLine().trim();
				System.out.println("Please enter a valid number! You said '" + whatYouSaid + "' but I don't understand.");
				// Continue to take us around the loop again.
				continue;
			}
			//Test if guess is out of range
			if (guess >= HIGH || guess < LOW) {
				System.out.println("That guess is out of range.");
				continue;
			}
			
			//Test if guess if within 10
			if (Math.abs(guess - secretNumber) < 10 && guess != secretNumber) {
				System.out.println("That was a very good guess!");
			}
			
			// Give the player a hint!
			if (guess > secretNumber) {
				System.out.println("Your guess of " + guess + " is too high.");
			} else if (guess < secretNumber) {
				System.out.println("Your guess of " + guess + " is too low.");
			}
		}

		// The only way we exit the loop is if we have won.
		System.out.println("Congratulations, you've won!");
		System.out.println("Thanks for playing!");

		// Always close resources that you open (We'll talk more about this later).
		scanner.close();

		// System.out.println("Just Hello, World! for now.");
	}
}
