import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
/*
 * 7.03 GravityV1: Determines surface gravity of multiple planets.
 */

/**
 *
 * @author 
 * 12/13/14 
 */

public class GravityV1
{
    public static double[] calculateGravity( double []kg, double[]km)
    {   double gravitationNumber = 6.67E-11;
    
        double []totalG= new double[8]; //initialize array
        for(int i = 0; i < totalG.length;i++)
        {
            totalG[i] = ((gravitationNumber * kg[i]) / (Math.pow(km[i]/2,2)));  // I had to use a different formula, 
                                                                                // as listing the radius in a array called "m" always said the integer was too large.
                                                                                // now it just divides by half
        }
        return totalG; 
    }
    public static void output(String [] planet, double [] diameter, double [] kg, double[]surfaceGravity)
    {   
        System.out.printf("%32s\n","Planetary Data");
        
        System.out.printf("%-11s %-17s %5s %11s\n","Planet","Diameter(Km)","Mass(Kg)","g(m/s^2)");
        System.out.println("--------------------------------------------------");        
        for(int i = 0; i < 8; i++)
        {
            System.out.printf("%-15s %-15.0f %5.2E %9.2f\n" // uses "-" to align everything, despite varying lengths of numbers / planet names.
                    ,planet[i],diameter[i],kg[i],surfaceGravity[i]);
        }
    }
    public static void write(double[] surfaceGravity) throws IOException // had to include IOException, wouldn't let me without
    {
       double []gravity = surfaceGravity; 
       PrintWriter outFile = new PrintWriter(new File("gravity.txt"));
       
       for(int i = 0; i < gravity.length ;i++)
       {
           outFile.println(gravity[i]);
       }
       
       outFile.close(); //close file
    }
    public static void main(String[]args) throws IOException // had to include IOException here too
    {
        String [] planet = {"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
 
        double [] kg = {3.30E23,4.869E24,5.972E24,6.4219E23,1.900E27,5.68E26,8.683E25,1.0247E26};
        double [] diameter = {4880,12103.6,12756.3,6794,142984,120536,51118,49532};
        double [] km = {4880000,12103600,12756300,6794000,142984000,120536000,51118000,49532000};
        
        double [] surfaceGravity = calculateGravity(kg, km); // just to make it easy to refer to, calculates surface gravity
        
        output(planet, diameter, kg, surfaceGravity); // shows to screen
        write(surfaceGravity); // writes to file
    }
}