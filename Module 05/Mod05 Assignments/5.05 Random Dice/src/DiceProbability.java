/**
 * Description for 5.05 Dice Probability project
 *
 * @
 * @12/7/2014
 *
 *
 */

import java.util.Random;
import java.util.Scanner;

public class DiceProbability
{
    public static void main(String[] args)
    {
    	//Declare and initialize variables and objects
        Scanner in = new Scanner(System.in);
        
        int sum = 0;
        int numSides = 0;
        int numRolls = 0;
        int match = 0; //Number of times sum of dice matches the current sum
        int die2 = 0;
        int die1 = 0;
        double probability = 0.0;
        
        //Input: ask user for number of rolls and number of sides on a die
        System.out.print("Please enter the number of sides on a die: ");
        numSides = in.nextInt();
        System.out.print("Please enter the number of rolls: ");
        numRolls = in.nextInt();
        //Print heading for output table
        System.out.print("\n Sum of dice \t Probability \n");
        
        Random randNum = new Random();
        
        // nested for statement

        for( sum = 2; sum <= (numSides * 2); sum++ )
        {
            for( int roll  = 0; roll < numRolls; roll++ )
            {
                
            die2 = randNum.nextInt( numSides ) +1;
            die1 = randNum.nextInt( numSides ) +1;
        
                if ( die1 + die2 == sum )  
                {
                match++;
                } // end if
        
            } //end for
            
        probability = (double)match / numRolls * 100;

        System.out.println("    " + sum + "\t\t" + probability );
        match=0;
        
        } //end for
    } //end main
}//end class DiceProbability

