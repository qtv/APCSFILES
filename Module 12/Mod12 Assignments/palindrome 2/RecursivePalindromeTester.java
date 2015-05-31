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
public class RecursivePalindromeTester {
        public static void main(String[] args) {
            
        boolean loophandler = true;
        String input;
        
        
        while (loophandler){
            System.out.println("Please enter a word or phrase");
            input = new Scanner(System.in).nextLine();
            
            boolean isPalindrome = RecursivePalindrome.palindrome(input);
            
            if (isPalindrome == true) {
                System.out.println(input + " is a palindrome.");
                loophandler = goagain();
            }
            else System.out.println(input + " is not palindrome.");
            loophandler = goagain();
    }
} 
        public static boolean goagain() {
            boolean goagain1 = true;
            
                
            System.out.println("Go again? Y or N");
            Scanner in = new Scanner(System.in);
            String input2 = in.nextLine();
            
            
            while (goagain1) {
            if ( (input2.equalsIgnoreCase("Y")) | !(input2.equalsIgnoreCase("N"))) {
                    System.out.println("Please enter either Y or N");
                    goagain1=false;
            }
            
            else goagain1 = false;
            }      
                
            if (input2.equalsIgnoreCase("Y")) {
                return true;
                  }
            else return false;
        
}
}
