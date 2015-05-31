
/**
 * Converts Piecewise functions to recursive methods.
 * @author 
 * 3/12/15
 */
public class Recursion {
    
 public static int fOf(int x)
    {
        if(x <= 10)
        return -7; // base case
        if(x > 10)
        return fOf(x - 4) + 2;         //recursive call
        else return -1;
    }
    public static int fOf2(int x)
    {
        if(x <= 25)
        return 20; // base case
        if(x > 25)
        return fOf2((x / 12) + 5) -3;         //recursive call
        else return -1;
    }
    
    public static int fOf4(int x)
    {
        if(x > 20)
        return -100; // base case
        if(x <= 20)
        return fOf4(x * 2) - 4;         //recursive call
        else return -1;
    }
    public static void main(String[] args) {
        System.out.println("The value of f(25) for #1 is: " + fOf(25));
        System.out.println("The value of f(30) for #2 is: " + fOf2(30));
        System.out.println("The value of f(500) for #4 is: " + fOf4(500));
    }
    
}
