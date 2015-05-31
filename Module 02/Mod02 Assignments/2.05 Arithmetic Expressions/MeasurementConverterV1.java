/**
 * MeasuermentConverter_v1 converts to and from Metric and English
 * units of measure by using user-assigned variables.
 *
 *      Sample Calculation:
 *        1 mile = 5280 ft,
 *        therefore    6230 ft / 5280 = 1.17992 miles
 *          and    1.179 miles * 5280 = 6225.12 ft
 *
 * @author B. Jordan
 * @version 01/19/07
 *
 * Modified by: 
 * Date: 11/03/14
 */
public class MeasurementConverterV1
{
    public static void main(String[ ] args)
    {
        //local variable declarations - assign actual values below
        double miles;                   // distance in miles
        double feet;                    // distance in feet
        double feetPerMile = 5280;      //number of feet per 1 mile
        double kilometers;              //distance in kilometers
        double mileperKilogram = 0.62137; // number of miles per 1 kilogram
        double pounds;                  // weight in pounds
        double kilograms;               // weight in kilograms
        double poundsPerKilogram = 2.20462; // number of pounds per 1 kilogram
        double gallons;                 // volume in gallons
        double liters;                  // volume in liters
        double gallonsPerLiter = 0.26417;   // number of gallons per 1 liter
        double meters;                  // distance in meters
        double centimeters;             // distance in centimeters
        double centimetersPerMeter = 100;   // number of centimeters per 1 meter

        //convert feet to miles
        feet = 6230;
        
        miles = feet / feetPerMile;
        
        System.out.println(feet + " ft. = " + miles + " mi.");

        //convert miles to feet
        miles = 230;
        
        feet = miles * feetPerMile;
        
        System.out.println(miles + " mi. = " + feet + " ft.");
        
        System.out.println();
        
        // convert miles to kilometers
        miles = 42;
        
        kilometers = miles / mileperKilogram;
        
        System.out.println(miles + " mi. = " + kilometers + " km.");
        
        // convert kilometers to miles
        kilometers = 82;
        
        miles = kilometers * mileperKilogram;
        
        System.out.println(kilometers + " km. = " + miles + " mi.");
        
        System.out.println();
        
        // convert pounds to kilograms
        pounds = 50;
        
        kilograms = pounds / poundsPerKilogram;
        
        System.out.println(pounds + " lb. = " + kilograms + " kg.");
        
        // convert kilograms to pounds
        kilograms = 150;
        
        pounds = kilograms * poundsPerKilogram;
        
        System.out.println(kilograms + " kg. = " + pounds + " lb.");
        
        System.out.println();
        
        // convert gallons to liters
        gallons = 14;
        
        liters = gallons / gallonsPerLiter;
        
        System.out.println(gallons + " gal. = " + liters + " l.");
        
        // convert liters to gallons
        liters = 2;
        
        gallons = liters * gallonsPerLiter;
        
        System.out.println(liters + " l. = " + gallons + " gal.");
        
        System.out.println();
        //convert centimeters to meters
        centimeters = 55;
        
        meters = centimeters / centimetersPerMeter;
        
        System.out.println(centimeters + " cm. = " + meters + " m.");
        // convert meters to centimeters
        meters = 8;
        
        centimeters = meters * centimetersPerMeter;
        
        System.out.println(meters + " m. = " + centimeters + " cm.");
        
    }//end of main method
}//end of class

