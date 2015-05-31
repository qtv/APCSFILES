
import java.util.Scanner;
/**
 * A program that uses recursive methods to calculate if a number has a Fibonacci number.
 * @author 
 * @date 4/20 /15
 * 
 */
public class FibonacciNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int fibNum =0;
        String input;
        String input2;
        int intinput;
        boolean loophandler = true;
        
        while (loophandler){
            System.out.println("Please enter an integer value greater than 0 and less than 49");
            input = in.next();
            intinput = Integer.parseInt(input);
            if ( intinput <=0 | intinput >=49 ) {
                System.out.println("Greater than 0 and less than 49 please!");
            }
            else {
                fibNum = fibcode(intinput);
                System.out.println("For the number " + intinput + " the Fibonacci Sequence equivalent is " + fibNum);
                System.out.println("Find another number? Please type Y or N");
                input2 = in.next();
                if (input2.equalsIgnoreCase("N")) {
                    loophandler = false;
                }   
        }
    }
    }

    private static int fibcode(int intinput) {
       //base case
        
        if (intinput == 0) {
            return 0;
        }
        if (intinput == 1) {
            return 1;
        }
        //recursive m
        else {
            return fibcode(intinput-1) + fibcode(intinput - 2);
        }
    }
    
}
