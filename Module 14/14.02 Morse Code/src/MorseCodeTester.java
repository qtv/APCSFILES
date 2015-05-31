
import java.io.IOException;
import java.util.Scanner;

/**
 * This program receives input and converts it into morse code using arraylists. 
 * @author 
 * @date 4/27/15
 */

public class MorseCodeTester
{
    public static void main(String[] args) throws IOException
    {
     MorseCode e = new MorseCode("morsecode.txt");
        
     System.out.println("Please enter a message without punctuation to be converted into morse code.");
     Scanner in = new Scanner(System.in);
     String input = in.nextLine();
     
     System.out.println(e.convertMessage(input.toUpperCase()));
    }
}