
import java.util.Scanner;


/**
 * Uses Caesar's Shift method to encrypt a message.
 * @author 
 * @date 4/27/15
 */

public class CaesarShiftEncryption {
    
    // starts encrypting message
    // shift key declared as final
   public static String beginencrypt(String encryptedmessage, final int shiftkey) {
        
       Scanner in1 = new Scanner(System.in);
       System.out.println("\nPlease enter the plaintext message to encrypt.");
       String plaintext = in1.nextLine();
       
       encryptedmessage = encrypt(plaintext, shiftkey);
       return encryptedmessage;
   }
   
   // first generates a new alphabet based on the shift key
   // then converts text with the new alphabet.
   // returns converted text to beginencrypt
   private static String encrypt (String text, final int shiftkey) {
       String newalphabet = generate(shiftkey);
       
       String convertedMessage = "";
       
       // a = reference to constant normal alphabet
       String a = CaesarShiftTester.Alphabet;
       
       for (int i = 0; i < text.length(); i++) {
         // finds first letter of text
         char char1 = text.charAt(i);
         
         // finds location of first letter in normal alphabet (Z is 26, etc)
         int indexchar1 = text.indexOf(char1);
         
         // then finds the char at the same location in the new alphabet,
         // which should be shifted already.
         convertedMessage += newalphabet.charAt(indexchar1);
           
       }
       return convertedMessage;
   }
   
   private static String generate (final int shiftkey) {
       
       String newalphabet = "";
       String a = CaesarShiftTester.Alphabet;
       for (int i = 0; i < a.length() - shiftkey; i++) {
       
        // if index would be past last letter (i.e. z) (aka an index greater than 26),
        //subtract 26 to start again at A.
           
       char char1 = a.charAt(i);
       int indexchar1 = a.indexOf(char1 + shiftkey);    
       
       if (26 < indexchar1) {
              System.out.println(a.charAt(i + shiftkey)); // test
             
              newalphabet = (Character.toString(a.charAt(i + shiftkey - 26))).concat(newalphabet); 
          } 
         else
           // else, convert the alphabets char at an index that the shift key determined
           // to a whole new alphabet
           // output - shift key 1, ABCDEF becomes ZABCDEF. 
           
           newalphabet = newalphabet + Character.toString(a.charAt(i + shiftkey)); 
       }
       return newalphabet;
   }
}
