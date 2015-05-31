/**
 * 5.04 Lottery project - Determine if a user correctly chose a randomly selected
 * three digit number.
 * 
 * @
 * @12/02/2014
 */
 
import java.util.Random;
import java.util.Scanner;

public class Lottery
{
    public static void main(String[] args)
    {
        //declare and initialized variables and objects
        Scanner input = new Scanner(System.in);
        
        //Generate a 3-digit "lottery" number composed of random numbers
        Random random = new Random();
        String digit = "";

        //Simulate a lottery by drawing one number at a time
        
        for (int counter=0; counter<3; counter++) {
            
        int digitPart = random.nextInt((9 - 0) + 1) + 0;    // determines random
        digit += digitPart;
        }
        
        // Input: Ask user to guess 3 digit number
        System.out.println("Guess a 3 digit lottery number: ");
        String answer = input.next();
        
        String part11 = answer.substring(0, 2);
        String part12 = answer.substring(1, 3);
        String part21 = digit.substring(0, 2);
        String part22 = digit.substring(1, 3);                                                  
      
        //Compare the user's guess to the lottery number and report results
        
        if (part11.equals(part21) && part12.equals(part22)) {
            System.out.println("Winner: " + digit);
            System.out.println("Congratulations! You got everything correct.");
        }
            else if (part11.equals(part21)) {
            System.out.println("Winner: " + digit);    
            System.out.println("You got the first half correct.");    
        }    
        else if (part12.equals(part22)) {
            System.out.println("Winner: " + digit);
            System.out.println("You got the second half correct.");
        }
            else {System.out.println("Winner: " + digit);
            System.out.println("You got nothing correct.");
        }
        
       

        
    } //end main
}//end class Lottery