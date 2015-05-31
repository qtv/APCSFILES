/*
 * 5.07 Password Generator 
 * Generates random, secure passwords with a set length.
 */
/**
 *
 * @author 
 * 12/07/2014
 */
import java.util.Scanner;
import java.util.Random;

public class Password {
    public static void main(String[] args) {
        // variables
        Scanner in = new Scanner(System.in);
        
        Random random = new Random();
        
        String password = "";
        int immaChar = 0;
        String selection = "0";
        int length = 0;
       
    
         while(!selection.equals("5")){   // giant while statement, so if 5 is chosen, it quits
            //Menu
            System.out.println("\t\tPassword Generation Menu");
            System.out.println("**********************************************************");
            System.out.println("*   [1] Lowercase Letters                                *");
            System.out.println("*   [2] Lowercase & Uppercase Letters                    *");
            System.out.println("*   [3] Lowercase, Uppercase, and Numbers                *");
            System.out.println("*   [4] Lowercase, Uppercase, Numbers, and Punctuation   *");
            System.out.println("*   [5] Quit                                             *");
            System.out.println("**********************************************************");
            System.out.print("Enter Selection (1-5): ");
            selection = in.next();
            
            if(!selection.equals("5") && (selection.equals("1") || selection.equals("2") || selection.equals("3") || selection.equals("4"))){
                System.out.println();
                
                //Input
                while(length > 14 || length < 1){
                    System.out.print("Password Length (1-14): ");
                    
                    length = Integer.parseInt(in.next());
                    
                    if(length < 1 || length > 14)
                        System.out.println("Please select something between 1 and 14."); //error handling 
                }
                
                //password 
                
                for(int i = 0;i<length;i++){
                    
                    if(selection.equals("1")){
                        immaChar = random.nextInt(26) + 97;
                    }
                    
                    else if(selection.equals("2")){
                        immaChar = random.nextInt(26) + (32 * random.nextInt(2)) + 65;
                    }
                    
                    else if(selection.equals("3")){
                        
                        immaChar = random.nextInt(36);
                        
                            // if statement inside if statement
                            if(immaChar >= 10)
                            immaChar += 32 * random.nextInt(2) + 55;
                            
                            else
                            immaChar += 48;
                    }
                    else if(selection.equals("4")){
                        immaChar = random.nextInt(78) + 48;
                        
                       // wouldn't work if anything was under 47, even if its not between 33-47?
                        
                       // immaChar = random.nextInt(78) + 1; 
                       // while (immaChar >=33 && immaChar <=47)
                       // {
                       //     immaChar = random.nextInt(78) + 1;
                       //  }
                    }
                    password += (char)immaChar;
                } // end of for statement 
                
                System.out.println("\nPassword equals: " + password);
            }
            else if(!selection.equals("5"))
                System.out.println("Choose something between 1-5. Try Again.");
        
    }
        System.out.println("\nBye bye!");
}
}
