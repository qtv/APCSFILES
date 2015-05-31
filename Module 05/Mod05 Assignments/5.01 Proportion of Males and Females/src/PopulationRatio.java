/*
 * Program calculates the amount of females and males that would be randomly 
 * selected with a given male to female ration and a user-inputed pop. size.
 * 
 */
/**
 *
 * @author 
 * 12/1/2014
 */
import java.util.Scanner;
public class PopulationRatio {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
      // country of Angola
        
      // ask for population sizes
        System.out.println("What's the population size of the country?: ");
        int populationSize = in.nextInt();
        
        int populationCounter = 0;
        double populationValue = 0; // becomes random value
        
        int males = 0;   //declare males and female counters
        int females = 0;
        
        while(populationSize > populationCounter)
        {
            populationCounter ++;
            populationValue = Math.random();
            
            if (populationValue >= 0.493)
            {
                System.out.println("Person #[" + populationCounter + "]: Male");
                males++;
            }
            else if (populationValue <= 0.493)
            {
                System.out.println("Person #[" + populationCounter + "]: Female");
                females++;
            }
        }
        // display final result
        System.out.println("\nAmount of females: " + females);
        System.out.println("Amount of males: " + males);
    }
    
}
