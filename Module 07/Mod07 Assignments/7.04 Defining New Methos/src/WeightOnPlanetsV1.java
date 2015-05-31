/**
 * Converts earth weight to weight on different planets.
 *
 * @author 
 * @version 11/13/15
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WeightOnPlanetsV1
{
    // write static methods here
    // Note: formula for finding weight on a planet:  Earth weight divided by Gravity constant times surface gravity

    public static double[] getGravity() throws IOException {
        
        double [] sGravity = new double[8];
        File fileName = new File("gravity1.txt");
        Scanner inFile = new Scanner(fileName);
        
        int i = 0;
                
        while (inFile.hasNext()){
                sGravity[i] = inFile.nextDouble();
                i++;
                // System.out.println(sGravity[i]);
        }
        inFile.close(); //close file 
        return sGravity; 
        
    }
    
    public static double[] calcWeight(double earthWeight, double []gravity) throws IOException {
        // double [] mass = new double[8];
        double [] weight = new double[8];
       
        for (int i=0; i < 8; i++) {
            // mass[i] = (earthWeight * 433.59237) / gravity[i];
            gravity[i] = gravity[i] * 0.1;
            
            weight [i] = earthWeight  * gravity[i];
            
            weight[i] = weight[i]; // convert to pounds
        }
            
        return weight;
        
    }
    
    private static void printResults(String[] names, double[] gravity, double[] weight) {
      System.out.printf("%25s\n","My Weight on the Planets");
	    System.out.println("Planet      Gravity	 Weight(lbs)");
            
	    for (int i = 0; i< 8; i ++){
	        System.out.printf(names[i] + "	 %8.2f	%8.2f",gravity[i],weight[i]);
	        System.out.println();
	    } 
    }

    public static void main(String[] args)throws IOException
	{

		// Extension idea... instead of hard codeing the weight, you may propt the user for input.
                
		double earthWeight = 100.0; // initalize Earth weight to 100 lbs.

		String[] names = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", 
                    "Saturn", "Uranus", "Neptune"};
                
                
		double[] gravity = getGravity(); 	
                // static method you write
                
		double[] weight = calcWeight(earthWeight, gravity);  // static method you write
		printResults(names, gravity, weight); 					// static method you write

    } //end main
}//end class