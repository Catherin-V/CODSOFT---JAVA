import java.util.Scanner;
import java.util.Random;

public class NumberGuessing
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 5;
        int score = 0;
        String playAgain;

        do
        {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean Guess = false;

            System.out.println("\n********** NUMBER GAME **********");
            System.out.println("\nGuess the Number 1 to 100!");
            while (attempts < maxAttempts && !Guess)
            {
                System.out.print("\nEnter your Guess (Attempt " + (attempts + 1) + " of " + maxAttempts + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if(userGuess == randomNumber)
                {
                    System.out.println("\n\nCongratulations! You Guessed the Correct Number!");
                    Guess = true;
                    score += maxAttempts - attempts + 10;
                }
                else if(userGuess < randomNumber)
                {
                    if((randomNumber - userGuess) <= 20)
                        System.out.println("Your guess is nearly low!");
                    else
                        System.out.println("No, Your guess is too low!");
                }
                else if(userGuess > randomNumber)
                {
                    if((userGuess - randomNumber) <= 20)
                        System.out.println("Your guess is nearly high!");
                    else
                        System.out.println("No, Your guess is too high!");
                }
                else
                    System.out.println("Invalid Input!");
            }
            if(!Guess)
            {
                System.out.println("\n\nSorry, you have used all attempts. The correct answer was: " + randomNumber);
            }
            System.out.print("\nDo you want to Play Again? (Yes/No): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\nThank you for Playing! Your final score is: " + score + "\n");
        scanner.close();
    }
}