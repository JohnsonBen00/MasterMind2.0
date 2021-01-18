import java.util.Scanner;
import controller.MastermindController;
import model.MastermindModel;
/**
 * This class simulates a Mastermind game.
 * The user can make 10 valid guesses till they lose the game.
 * If not a valid guess, the class asks the user again for a valid guess.
 * @author Benhur J. Tadiparti
 *
 */
public class Mastermind {

	
	/**
	 * Creates appropriate objects/variable the game needs
	 * and runs game with those objects/variable
	 * @param args -- Not used
	 */
	public static void main(String[] args) {
		
		int game = 1; //Game counter
		Scanner input = new Scanner(System.in); //Gets input from console
		MastermindModel model = new MastermindModel(); //Model object
		MastermindController controller = new MastermindController(model); //Controller object
		play(input, model, controller, game); //Game
	}
	
	/**
	 * Generates the game
	 * @param input -- console input
	 * @param model -- model object
	 * @param controller -- controller object
	 * @param game -- number of rounds
	 */
	public static void play(Scanner input, MastermindModel model, MastermindController controller, int game) {
		
		System.out.println("Welcome to Mastermind!");
		System.out.print("Would you like to play? ");
		String myString = input.next(); //Gets console input
		System.out.println();
		//If 'no' is input, end game
		if (myString.toLowerCase().equals("no")) {
			return;
		}
		//If something other than 'yes', ask again
		while (!myString.toLowerCase().equals("yes")) {
			System.out.println("Welcome to Mastermind!");
			System.out.print("Would you like to play? ");
			myString = input.next();
			System.out.println();
			
		}
		
		System.out.print("Enter guess number " + game + ": ");
		myString = input.next();
		
		while ((game < 10)) {
			if (controller.check(myString.toLowerCase())) {
				if (!controller.isCorrect(myString.toLowerCase())) { //If not correct
					System.out.print("Colors in the correct place: ");
					//Right color right place
					System.out.println(controller.getRightColorRightPlace(myString.toLowerCase()));
					System.out.print("Colors correct but in wrong position: ");
					//Right color wrong place
					System.out.println(controller.getRightColorWrongPlace(myString.toLowerCase()));
					System.out.println();
				} else {
					System.out.print("You WON!");
					return;
				}
				game++;
			}
			System.out.print("Enter guess number " + game + ": ");
			myString = input.next(); //Ask for another guess
		}
		System.out.print("You LOSE!");
	}
}
