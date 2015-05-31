/**
 * 6.03 Heat Index: Determine the heat index of Key West, Florida
 *
 * 
 * 12/11/2014
 *
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class HeatIndex
{
    public static void main(String[] args) throws IOException
    {
    	//initialize and declare vars

        String location = "Key West, Florida";
        File fileNameTemp = new File("src/KeyWestTemp.txt");
        File fileNameHumid = new File("src/KeyWestHumid.txt");

        Scanner inFileTemp = new Scanner(fileNameTemp);
        Scanner inFileHumid = new Scanner(fileNameHumid);

        String [] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "Novermber", "December"};
        int length = month.length;
        double [] temperature = new double[length];
        int [] humidity = new int[length];
        double [] hI = new double[length];


		//INPUT - read in data for temp and humidity from files

		int n = 0; //index value for arrays
        while( inFileTemp.hasNextDouble() )
        {
            temperature[n] = inFileTemp.nextDouble( );
            // System.out.println (temperature[n]); //debug statement - uncomment to see values assignned to temperature
            n++;
        }
        inFileTemp.close();


        n = 0; //reset index to 0
        while (inFileHumid.hasNextDouble())
        {
                humidity[n] = inFileHumid.nextInt( );
                // System.out.println (humidity[n]);  //debug statement - uncomment to see values assignned to humidity
                n++;
        }
        inFileHumid.close();

		//PROCESSING - calculate Heat Index if needed- see lecture notes for details, formula is incomplete

		double t = 0.0;
		int h = 0;

        for(n = 0; n < hI.length; n++)
        {
            if( temperature[n] >= 80.0  ) //determine if HI should be calculated, complete the condition based on Lecture notes
            {
            	t = temperature[n];
            	h = humidity[n];

                hI[n] = -42.379
                	    + 2.04901523 * t 
                            + 10.1433127 * h 
                            - 0.22475541 * t * h 
                            - 6.83783E-3 * (Math.pow(t,2)) 
                            - 5.481717E-2 * (Math.pow(h,2))
                            + 1.22874E-3 * (Math.pow(t,2)) * h
                            + 8.5282E-4 * (Math.pow(t*h,2))
                            - 1.99E-6 * (Math.pow(t,2)) * (Math.pow(h,2));
            }
            else  // HI is the temperature value
            {
                hI[n] = temperature[n];
            }
        }


        //calculate averages for temperature, humidity and HI

        double tempSum = 0.0;
        int humidSum = 0;
        double hISum = 0.0;

        for(n = 0; n < temperature.length; n++)
        {
        	tempSum = tempSum + temperature[n];
        }
        
        for(n = 0; n < humidity.length; n++)
        {
        	humidSum = humidSum + humidity[n];
        }
        for(n = 0; n < hI.length; n++)
        {
        	hISum = hISum + hI[n];
        }
        double tempAvg = tempSum/temperature.length;
        int humidAvg = humidSum/ humidity.length;
        double hIAvg = hISum / hI.length;


        //OUTPUT - print table. Use enhanced for loops to print the months, temp, humidity and HI

        System.out.printf("%45s %15s\n", "Heat Index: ", location);
        System.out.println();


        System.out.printf("%52s\n", "Months");
        System.out.print("            ");
        for(String m : month)
        {
            System.out.printf("   %3.3s", m);
        }


        System.out.println("  Avg");
        System.out.println("******************************************************************************************");


        System.out.print("Temp (F)    ");
         for (double tt: temperature) {
             System.out.printf("  %2.1f", tt); 
         }

		System.out.printf("  %2.1f", tempAvg);
        System.out.println();

        System.out.print("Humidity (%)");
        for (int hh: humidity) {
             System.out.printf("  %4d", hh); 
         }
        System.out.printf("  %4d", humidAvg);
        System.out.println();

        System.out.print("HI (F)      ");
        for (double hih: hI) {
            System.out.printf("  %2.1f", hih);
        }
        System.out.printf("  %2.1f", hIAvg);
        System.out.println();
        
        // outFile stuff
        
        PrintWriter outFile = new PrintWriter(new File("hI.txt"));
        
        outFile.print("            ");
        for(String m : month)
        {
            outFile.printf("   %3.3s", m);
        }


        outFile.println("  Avg");
        outFile.println("******************************************************************************************");


        outFile.print("Temp (F)    ");
         for (double tt: temperature) {
             outFile.printf("  %2.1f", tt); 
         }

		outFile.printf("  %2.1f", tempAvg);
        outFile.println();

        outFile.print("Humidity (%)");
        for (int hh: humidity) {
             outFile.printf("  %4d", hh); 
         }
        outFile.printf("  %4d", humidAvg);
        outFile.println();

        outFile.print("HI (F)      ");
        for (double hih: hI) {
            outFile.printf("  %2.1f", hih);
        }
        outFile.printf("  %2.1f", hIAvg);
        outFile.println();
        
        outFile.close();
        
    } //end main()
}//end HeatIndex
