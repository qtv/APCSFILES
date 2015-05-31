

/**
 * Program that uses object-oriented programming to determine the prime numbers in a certain range.
 * @author 
 * @date 4/28/15
 */
public class primenumbersOOP {
    
    private int upperLimit;
    public static int primeCounter;
        
    public primenumbersOOP(int upperLimit){
        
        this.upperLimit = upperLimit;
        
    }            
       
            
    public String primes(){
     String primeNumbers = "";
     for (int i = 1; i <= upperLimit; i++)  	   
      { 		 
         // establishes varibale counter and gives it a value of 0 
         int counter=0; 
         // loops through all the numbers between upper limit and 0 
         // and searches for remainders
         for(int i2 = i; i2 >= 1; i2--) {
      
	    if(i % i2 ==0) {                // if remainder is not found...
		counter += 1;               // add one to the counter
	    }
	 }
         
	 if (counter ==2)
	 {
	    primeNumbers += i + "\n";      // adds i (the number) as a prime number
            primeCounter += 1;
	 }	
      }	
            return primeNumbers;
    }
}
