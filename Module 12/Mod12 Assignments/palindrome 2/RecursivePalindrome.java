
/**
 *
 * @author 
 */
public class RecursivePalindrome {

public static boolean palindrome(String input) {
        String word = palindrome_helper(input);
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
            boolean isPalindrome = true;
             
             if (length > beginning) {
                 loophandler = false;
             }
             else 
             return isPalindrome;
             }
        
             return false;
         }
       
        
      /*  if(word.charAt(0) == word.charAt(word.length() - 1)){
            //if the current first and last is correct, check the smaller word
            return palindrome(word.substring(1, word.length() - 1));
        }
        return palindrome_helper(word);
    }

*/

 public static String palindrome_helper(String input)
    {
     String newString = input.replaceAll("\\W","");
     return newString;
}
}