
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 
 */
public class GuessingGameV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        Random random = new Random(); // create random object
        int randomNumber = random.nextInt(100 - 2) + 1;  // (maxValue - minvalue + 1) + min
        
        System.out.println("Attempt to guess the computer's chosen number between 1 and 100!");
        
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
    
}
