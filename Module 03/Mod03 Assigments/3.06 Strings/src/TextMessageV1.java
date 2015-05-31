/**
 * 3.06 Strings
 * This program uses Strings and String methods to encode a text message.
 *
 * @author 
 * @version 11/15/2014
 */
public class TextMessageV1
{
    public static void main(String [ ] args)
    {
        //local variables
        String oldString = "today i will be dancing with my friends being cool and getting all the ladies.";
        
        int oldStringLength = oldString.length();
  
        String replaceCharacters = oldString.replace("will be","WLB");
        replaceCharacters = replaceCharacters.replace("cool","kwl");
        replaceCharacters = replaceCharacters.replace("ladies","LD3Z");
        replaceCharacters = replaceCharacters.replace("friends","H0MZ");
        replaceCharacters = replaceCharacters.replace("and","&");
        
        // better variable name for new string
        String newString = replaceCharacters;
                
        int newStringLength = newString.length();
        
        //additional variables
        int positionOfExample = newString.indexOf("k");
        
        int halfwayPoint = newStringLength / 2;
        
        String secondHalf = newString.substring(halfwayPoint);
        
        String firstHalf = newString.substring(0,halfwayPoint);
        
        String newString1 = newString.replaceAll("[lamsope]","");
        
        //PRINT STATEMENTS
        
        //old string
        System.out.println("Original Message:");
        
        System.out.println(oldString);
        
        System.out.println("message length: " + oldStringLength + " characters");
        
        // blank space
        System.out.println("");
        
        //new string
        System.out.println("New Message:");
        
        System.out.println(newString);
        
        System.out.println("message length: " + newStringLength + " characters");
        
        // blank space
        System.out.println("");
        
        //string method samples
        System.out.println("Sting method samples:");
        
        System.out.println("indexOf \"k\":                          " + positionOfExample);
        
        System.out.println("substring(one parameter) second half: " + secondHalf);
        
        System.out.println("substring(two parameters) first half: " + firstHalf);
        
        System.out.println("replaceAll LAMOSPE's:                 " + newString1);
} 
}