/**
 * Hurricane description: Calculates the average category, pressure, and wind speed
 * of all Atlantic Hurricanes between 1980-2006. 
 *
 * @author: 
 * @version: 12/11/2014
 *
 */


import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Hurricanes2
{
    public static void main(String[] args)throws IOException
    {
    	//declare and initialize variables

	int arrayLength = 59;
        int [] year = new int[arrayLength];
        String [] month = new String[arrayLength];
        int [] pressure = new int[arrayLength];
        int [] windSpeed = new int[arrayLength];
        String [] name = new String[arrayLength];

        File fileName = new File("hurcdata2.txt");
        Scanner inFile = new Scanner(fileName);

        //INPUT  - read data in from the file
        int index = 0;
        while (inFile.hasNext())
        {
            year[index] = inFile.nextInt();
            month[index] = inFile.next();
            pressure[index] = inFile.nextInt();
            windSpeed[index] = inFile.nextInt();
            name[index] = inFile.next();
            index++;
        }
        inFile.close();


		//PROCESSING - calculate and convert values
        
		// convert windspeed from knots to MPH
                double [] windMPH = new double[arrayLength];
                int [] category = new int[arrayLength];
                
                int numCategory1 =0; // numCategorys
                int numCategory2 = 0;
                int numCategory3 = 0;
                int numCategory4=0;
                int numCategory5 = 0;
                
                for (index = 0; index < arrayLength; index++) {
                    windMPH [index] = windSpeed[index] * 1.1507;  // to MPH
                    
                    // determine category
                if (windMPH[index] >=74 && windMPH[index] <=95)
                    {
                category[index] = 1;
                numCategory1++;
                    }
                else if(windMPH[index] >= 96 && windMPH[index] <= 110)
                    {
                category[index] = 2;
                numCategory2++;
                    }
                else if(windMPH[index] >= 111 && windMPH[index] <= 130)
                    {
                category[index] = 3;
                numCategory3++;
                    }
                else if(windMPH[index] >= 131 && windMPH[index] <= 155)
                    {
                category[index] = 4;
                numCategory4++;
                    }
                else if (windMPH[index] > 155)
                    {
                category[index] = 5;
                numCategory5++;
                    }
                else 
                    System.out.println("Error!!!!");
                    
                    } // end for
		

        //Find min, max and average for category, windspeed and pressure
        
        int windMPHSum = 0;
        int pressureSum = 0;
        int cSum = 0;
        
        double cAvg = 0;
        double windMPHAvg = 0;
        double pressureAvg = 0;
        
         for(index = 0; index < arrayLength; index++)
        {
            // sums
            cSum = cSum + category[index];
            windMPHSum = (int) (windMPHSum + windMPH[index]);
            pressureSum = pressureSum + pressure[index];
        }
         
         
        // MAX AND MINS
        
        int cMin = Integer.MAX_VALUE;
        for(int i = 0; i < arrayLength; i++)
        {
            if (category[i] < cMin)
                cMin = category[i];
        }
        
        int cMax = Integer.MIN_VALUE;
        for(int i = 0; i < arrayLength; i++)
        {
            if (category[i] > cMax)
                cMax = category[i];
        }
        
        int minPressure = Integer.MAX_VALUE;
        for(int i = 0; i < arrayLength; i++)
        {
            if (pressure[i] < minPressure)
                minPressure = pressure[i];
        }
        
        int maxPressure = Integer.MIN_VALUE;
        for(int i = 0; i < arrayLength; i++)
        {
            if (pressure[i] > maxPressure)
                maxPressure = pressure[i];
        }
        
        int minSpeed = Integer.MAX_VALUE;
        for(int i = 0; i < arrayLength; i ++)
        {
            if (windSpeed[i] < minSpeed)
                minSpeed = windSpeed[i];
        }
        
        int maxSpeed = Integer.MIN_VALUE;
        for(int i = 0; i< arrayLength; i++)
        {
            if (windSpeed[i] > maxSpeed)
                maxSpeed = windSpeed[i];
        }
         // END MAX AND MINS
        
        
         // averages
         cAvg = cSum / arrayLength;
         pressureAvg = pressureSum / arrayLength;
         windMPHAvg = windMPHSum / arrayLength;


        //Output - print table using printf to format the columns


        System.out.println("                      Hurricanes 1980 - 2006");
        System.out.println();
        System.out.println("Year     Hurricane    Category     Pressure (mb)     Wind Speed (mph)");
        System.out.println("=====================================================================");
         for(index = 0; index < arrayLength; index++)
        {
            System.out.printf("%d%10s%10d %15d %25.0f", year[index], name[index], category[index], pressure[index], windMPH[index]);
            System.out.println();
        }


        System.out.println("=====================================================================");
        
    System.out.printf("%s%17.0f%16.0f%26.0f", "Average", cAvg, pressureAvg, windMPHAvg);
    System.out.println();
    System.out.printf("%s%17d%16d%26d", "Maximum", cMax, maxPressure, maxSpeed);
    System.out.println();
    System.out.printf("%s%17d%16d%26d", "Minimum", cMin, minPressure, minSpeed);
    System.out.println();

    System.out.println("Number of Category 1 Hurricanes: " + numCategory1);
    System.out.println("Number of Category 2 Hurricanes: " + numCategory2);
    System.out.println("Number of Category 3 Hurricanes: " + numCategory3);
    System.out.println("Number of Category 4 Hurricanes: " + numCategory4);
    System.out.println("Number of Category 5 Hurricanes: " + numCategory5);

    PrintWriter outFile = new PrintWriter(new File("Summary.txt"));
    
    outFile.printf("%s%17.0f%16.0f%26.0f", "Average", cAvg, pressureAvg, windMPHAvg);
    outFile.println();
    outFile.printf("%s%17d%16d%26d", "Maximum", cMax, maxPressure, maxSpeed);
    outFile.println();
    outFile.printf("%s%17d%16d%26d", "Minimum", cMin, minPressure, minSpeed);
    outFile.println();

    outFile.println("Number of Category 1 Hurricanes: " + numCategory1);
    outFile.println("Number of Category 2 Hurricanes: " + numCategory2);
    outFile.println("Number of Category 3 Hurricanes: " + numCategory3);
    outFile.println("Number of Category 4 Hurricanes: " + numCategory4);
    outFile.println("Number of Category 5 Hurricanes: " + numCategory5);
    }//end main()
}
//end Hurricanes2
