
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
public class primenumbers {

    public static void main(String[] args) {
        
      Scanner in = new Scanner(System.in);
      
      String primeNumbers = ""; 
      
      System.out.println("Please enter an upper limit for the value of n: ");
      
      // inputs upper limit to "upperlimit" variable
      int upperlimit = in.nextInt();
      
      int primeCounter = 0;                 // varibale that totals the amount of prime numbers found
      for (int i = 1; i <= upperlimit; i++)  	   
      { 		 
         // establishes varibale counter and gives it a value of 0 
         int counter=0; 
         // loops through all the numbers between upper limit and 0 
         // and searches for remainders
         for(int i2 = i; i2 >= 1; i2--) {
      
	    if(i % i2 ==0) {                // if remainder is found...
		counter += 1;               // add one to the counter
	    }
	 }
         
	 if (counter ==2)
	 {
	    primeNumbers += i + "\n";      // adds i (the number) as a prime number
            primeCounter += 1;
	 }	
      }	
      System.out.println("The Prime Numbers from 0 to the upper limit are:");
      
      System.out.println(primeNumbers);     // prints all prime numbers
      System.out.println("Total amount of prime numbers found: " + primeCounter);
   }
}
