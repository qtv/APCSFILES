/**
 * Program that uses object-oriented programming to determine the prime numbers in a certain range.
 * @author 
 * @date 4/28/15
 */

import java.util.Scanner;


public class PrimeNumbersOOPTester {
     public static void main(String[] args) {
        
      Scanner in = new Scanner(System.in);
      
      System.out.println("Please enter an upper limit for the value of n: ");
      
      // inputs upper limit to "upperlimit" variable
      int upperlimit = in.nextInt();
      
      primenumbersOOP primes = new primenumbersOOP(upperlimit);
      
      
      System.out.println("\nThe Prime Numbers from 0 to the upper limit are: ");
      primes.primes(); // prints all prime numbers
      
      System.out.println("\nTotal amount of prime numbers found: " + primenumbersOOP.primeCounter);
}
}