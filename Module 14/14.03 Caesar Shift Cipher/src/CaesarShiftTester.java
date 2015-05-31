
import java.util.Scanner;

/**
 * Uses Caesar's Shift method to encrypt a message.
 * @author 
 * @date 4/27/15
 */
public class CaesarShiftTester {

    public static final String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Would you like to Encrypt or Decrypt?");
        System.out.println("A. Encrypt");
        System.out.println("B. Decrypt");
        System.out.println("C. Quit");
        
        String choice = in.nextLine();
        
        Scanner in1 = new Scanner(System.in);
        System.out.println("\nPlease enter the shift key (0-25)");
       
        int shiftkey;
        shiftkey = in.nextInt();
       
        String encryptedmessage = "";
        if (choice.equalsIgnoreCase("A")) {
            System.out.println(CaesarShiftEncryption.beginencrypt(encryptedmessage, shiftkey));
        }
        else if (choice.equalsIgnoreCase("C")) {
            System.out.println("Bye bye!");
        }
    }
    
    
       
    
}

