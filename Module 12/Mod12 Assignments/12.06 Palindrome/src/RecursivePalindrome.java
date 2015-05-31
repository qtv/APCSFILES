/**
 * A program that uses recursive methods to calculate if a word or phrase is a palindrome.
 * @author 
 * @date 4/18/15
 * 
 */
public class RecursivePalindrome {

public static boolean palindrome(String input) {
        String word = (palindrome_helper(input));
        //checks to see if a palindrome can be made immediately
        //base case
        if(word.length() == 1){
            boolean isPalindrome = true;
            return isPalindrome;
        }
        //base case
        if(word.length() == 0){
            boolean isPalindrome = true;
            return isPalindrome;
        }
        
        //recursive method in loop form
        
        boolean loophandler = true;
        
        while(loophandler) {
             int length = word.length() -1;
             int beginning = 0;
            
             while (word.charAt(beginning) == word.charAt(length) && length > beginning)
             {
            beginning++;
            length--;
             }
             // declares boolean and assigs a value
            boolean isPalindrome = true;
             
             if (length > beginning) {
                 loophandler = false;
             }
             else
                 // it's a palindrome!
             return isPalindrome;
             }
        
             return false;
         }
       

 public static String palindrome_helper(String input)
    {
        // replace all punctuation / spaces with nothing
     String newString = (input.replaceAll("\\W","")).toLowerCase();
     return newString;
}
}