
import java.util.Scanner;

public class whatever {
    
public static void main(String [ ] args) {
        
    double[ ] a1 = new double[5];
    double[ ] a2 = new double[5];
    double[ ] a3 = new double[5];
    
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter the 10 values.");
    for (int i=0; i < 5; i++) {
            a1[i] = in.nextDouble();
    }
    
    for (int i=0; i < 5; i++) {
       a2[i] = in.nextDouble(); 
        }
        
    for (int i=0; i < 5; i++) {
        a3 [i] = a2[i] + a1[i]; 
        System.out.print("\n" + a3[i]);
    }
}
}
