public class product {
    public static void main(String[] args)
    {
     int [] primes;
     
     primes = new int[] {2,3,5,7,11};
     
     int product = 1;
     for (int i= 0; i < primes.length; i++) {
         
     product = product * primes[i];    
     }
     
    System.out.println("Product of 2, 3, 4, 7, and 11: " + product);
    }
    
    }
