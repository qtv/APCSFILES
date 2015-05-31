
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program receives input and converts it into morse code using arraylists. 
 * @author 
 * @date 4/27/15
 */
public class MorseCode {
 public static ArrayList<Character> letters;
 public static ArrayList<String> morsecode;
 
// reads morescode from file and uses arraylist to store it 
 public MorseCode(String fileName) throws IOException
 {
    letters = new ArrayList<Character>();
    
    morsecode = new ArrayList<String>();
    
    char char1;
    String code;
    
    Scanner inFile = new Scanner(new File(fileName));
    
     while(inFile.hasNextLine()){
         
         String line = inFile.nextLine();
         if (line.contains(", ")) {

            } else {
             System.out.println("NO");
            }
         // split each line in two parts - part 1 = letters (A,B,C)
         // part 2 = morsecode
         String []parts = line.split(", ");
         String part1 = parts[0];
         String part2 = parts[1];
        
         letters.add(part1.charAt(0));
         morsecode.add(part2);
        }
 }
 
 public static String getMorseCode(char e){
     
    int index = letters.indexOf(e);
    //System.out.println(index);
    return morsecode.get(index);
 }
 
 public static String convertMessage(String input) throws IOException{
     
     String convertedMessage = "";
     // remove spaces
     if (input.contains(" ")) {
         input.replaceAll(" ", "");
     }
     
     // for every char in input, get morsecode and add it to convertedMessage
     for (int i = 0; i < input.length(); i++) {
        char a = input.charAt(i);
        
        //System.out.println(a);
        
        convertedMessage += getMorseCode(a);
       // System.out.println(convertedMessage);
     }
     return convertedMessage;
 }
}
