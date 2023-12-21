import java.util.Scanner;
import java.util.Random;

public class NumberGuessGame {
    private int targetNumber;
    public int attempts = 0;
    private Scanner inputScanner;
    private Random random;

    public NumberGuessGame() {
        random = new Random();
        targetNumber = random.nextInt(100) + 1;
        inputScanner = new Scanner(System.in);
    }

    public void startGame() {
        while (true) {
            displayGameInstructions();
            int guess = getGuessInput();
            int result = compareGuess(guess);

            if (result == 0) {
                System.out.println("That's the right answer!!: " + targetNumber);
                break;
            } else {
                displayResult(result);
            }
        }
    }

    private void displayGameInstructions() {
        System.out.println("Think of number between 1 to 100 and enter it: ");
    }

    private int getGuessInput() {
        System.out.print("Enter your guess: ");
        return inputScanner.nextInt();
    }

    private int compareGuess(int guess) {
        attempts++;
        if (guess == targetNumber) {
            return 0;
        } else if (guess < targetNumber) {
            return -1;
        } else {
            return 1;
        }
    }

    private void displayResult(int result) {
        if (result < 0) {
            System.out.println("Too low! Try again.");
        } else {
            System.out.println("Too high! Try again.");
        }
    }

    public static void main(String[] args) {
        NumberGuessGame game = new NumberGuessGame();
        game.startGame();
    }
}