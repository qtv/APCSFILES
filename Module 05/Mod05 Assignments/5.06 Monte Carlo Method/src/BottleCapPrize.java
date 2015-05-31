import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.util.Random;

/*
 * 5.06 Bottle Cap Prize
 * Uses the Monte Carlo sampling method to estimate the average number of bottles
 * of e-Boost would have to drink to win a prize.
 */
/**
 *
 * @author 
 * 12/07/2014
 */

public class BottleCapPrize {

    public static void main(String[] args) throws IOException{
    
        Scanner in = new Scanner(System.in);
        PrintWriter outFile = new PrintWriter(new File("bcp.txt"));
        Random random = new Random();
        
        int bottleCapCount = 0;
        int bottlesDrank = 0;
        int totalPrizes = 0;
        
        System.out.print("Enter how many trials would you like (Please choose at least 1000): ");
        int trials = in.nextInt();

        for(int i = 1; i<= trials; i++)
        {
            bottleCapCount = random.nextInt(5);
            bottlesDrank++;
            
            if(bottleCapCount ==1) // if it chooses 1 (1/5 chance) prize is won
            {
                totalPrizes++;
            }
            else i--;             // if no prize is found, subtract 1 from i to restart loop 
                                  // as if nothing ever happened
        }
        
        int averageBottels = (bottlesDrank / totalPrizes);
        
        outFile.println("The number of bottles drank was: " + bottlesDrank);
        outFile.println("The average number of bottles that need to be opened to win is: " 
                + averageBottels);    
        
        outFile.close(); // close file

        Scanner inputFile = new Scanner(new File("bcp.txt")); // file to read
                
        while(inputFile.hasNextLine())
        {
            String token = inputFile.nextLine();
            System.out.println(token); // print back
        }
        
        inputFile.close();         // close file
        
    }
    
}
