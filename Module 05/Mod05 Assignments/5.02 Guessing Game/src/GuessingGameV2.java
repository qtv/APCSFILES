
import java.util.Random;
import java.util.Scanner;

/*
 * 5.02 Guessing Game
 * A program where you guess a random computer generated number in a specified range.
 */
/**
 *
 * @author 
 * 12/01/14
 */
public class GuessingGameV2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        Random random = new Random(); // create random object
        
        System.out.println("Attempt to guess the computer's chosen number between 1 and 100!");
        
        System.out.println("Choose a range of numbers to guess from (### - ###): ");
        String sRange = in.nextLine();
        
        int location = 0;
        int lowBound = 0;
        int highBound = 0;
        
        // if statements to prevent errors
        
        if (sRange.contains(" ")) { // in case they did a number format with a space
            sRange = sRange.replaceAll(" - ", "-"); 
            location = sRange.indexOf("-");
            lowBound = Integer.parseInt(sRange.substring(0,location));
            highBound = Integer.parseInt(sRange.substring(location+1,sRange.length()));
           
        }
            else {
            location = sRange.indexOf("-"); // in case they did a number format without a space
            lowBound = Integer.parseInt(sRange.substring(0,location));
            highBound = Integer.parseInt(sRange.substring(location+1,sRange.length()));
                    }
        
        if (highBound >= lowBound) {         // makes sure highBound is greater than (or equal) to lowBound
        int randomNumber = random.nextInt((highBound - lowBound) + 1) + lowBound;  // (maxValue - minvalue + 1) + min
        
        System.out.println("\nEnter your guess: ");
        int guess = in.nextInt();
        int guessNumber = 0;
        
        while (guess != randomNumber)
        {
         guessNumber++;
         
            if (guess > randomNumber) {
                System.out.println("Too high");
            }
            else if (guess < randomNumber) {
                System.out.println("Too low");
            }
            
        System.out.println("Enter your guess: ");
        guess = in.nextInt();
        } // exit loop when correct
        
        // display congrats
        System.out.println("Congratulations!\n\rThe random number was: "
                    + randomNumber + "\n\rNumber of guesses: " 
                    + (guessNumber + 1));  // plus one as the guessnumber++ is in the loop
    }
        else {    // error handling for when lowBound is greater than HighBound
            System.out.println("Error! Please enter a smaller number followed by a larger number as your range. ");
        }
    
}
    
    
}

