
import java.util.Scanner;

/**
 * A program that uses recursive methods to calculate if a word or phrase is a palindrome.
 * @author 
 * @date 4/18/15
 * 
 */
public class RecursivePalindromeTester {
     public static Scanner in = new Scanner(System.in);
        public static void main(String[] args) {
            
        boolean loophandler = true;
        String input;
        
        Scanner in = new Scanner(System.in);
        while (loophandler){
            System.out.println("Please enter a word or phrase");
            input = in.nextLine();
            
            boolean isPalindrome = RecursivePalindrome.palindrome(input);
            
            if (isPalindrome == true) {
                System.out.println(input + " is a palindrome.");
                // user's choice to do it again or not determines if loop ends
                loophandler = goagain();
            }
            else { System.out.println(input + " is not palindrome.");
            // user's choice to do it again or not determines if loop ends
            loophandler = goagain(); }
    }
} 
        public static boolean goagain() {
            
        while (true) {

        System.out.println("Go again? Y or N");
        char input2 = in.next().charAt(0);
        
        if (input2 == 'Y') {
            return true;
        }

        if (input2 == 'N') {
            return false;
        }
        System.out.println("Please enter either Y or N");

        }
            
        
}
}
