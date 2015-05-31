/*
 * 5.03 File Input
 * Program that parses through a text file to determine family composition.
 */
/**
 *
 * @author 
 * 12/2/14
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException; //error handling class
import java.io.IOException;

public class Family {

    public static void main(String[] args) throws FileNotFoundException {
       String token="";
       
       int twoBoys = 0; // counters
       int boyGirl = 0;
       int twoGirls = 0;
              
       Scanner inFile = new Scanner (new File("MaleFemaleInFamily.txt"));
               
       while (inFile.hasNext()) {
       
        token = inFile.next();
        
        if (token.equals("BB")) {
            twoBoys++;
        }
        
        else if (token.equals("GB") || (token.equals("BG"))) {  // either or
            boyGirl++;   
        }
        
        else {
            twoGirls++;
       }
       
       inFile.close();
       
        System.out.println("Sample size: " + (twoBoys + boyGirl + twoGirls));
        System.out.println("Two Boys: " + twoBoys);
        System.out.println("One Boy One Girl: " + boyGirl);
        System.out.println("Two Girls: " + twoGirls);
    }
    
}

