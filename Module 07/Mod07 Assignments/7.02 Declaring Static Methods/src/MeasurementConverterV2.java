
/**
 * Converts a set of measurements to and from the metric system using methods.
 * 
 * 
 * 12/11/2014
 */
public class MeasurementConverterV2
{
//Purpose of program
    public static void printPurpose( )  //notice that this method is void, nothing is returned
    {
        System.out.println("This program converts to and from");
        System.out.println("English and metric units of measure.");
        System.out.println("=====================================");
    }
        
    //convert feet to miles
    //the ft parameter receives the value of the feet argument passed from main method. 
    public static double convertFeetToMiles(double ft)
    {
        return ft / 5280;      
    } 
    
    //convert miles to feet
    public static double convertMilesToFeet(double mi)
    {
        return mi * 5280;      
    } 
    
    //convert miles to kilometers
    public static double convertMilesToKilometers(double mi)
    {
        return mi / 0.62137;     
    } 
    
    //convert kilometers to miles
    public static double convertKilometersToMiles(double km)
    {
        return km * 0.62137;   
    } 
    public static double convertPoundsToKilograms(double lbs) {
        return lbs / 2.2046;
    }
    public static double convertKilogramsToPounds (double kg)
    {
        return kg * 2.2046;
    } 
    
    //convert Gallons to Liters
	public static double convertGallonsToLiters(double gal)
	{
		return gal/0.26417;
	}
	
	//convert Liters to Gallons
	public static double convertLitersToGallons(double liter)
	{
		return liter * 0.26417;
	}
    
    public static void main(String[ ] args) // MAIN CLASS
    {
        double liters;
        double kilograms;
        double inches;
        double gallons;
    
        printPurpose();                                    //invoke the printPurpose() method
        double feet = 6230.0;
        double miles = convertFeetToMiles(feet);            //invoke the convertFeetToMiles() static method and pass the feet variable as an argument
        System.out.printf("%8.1f ft. = %7.1f mi. %n", feet, miles);
        
        miles = 1.9;
        feet = convertMilesToFeet(miles);
        System.out.printf("%8.1f mi. = %7.1f ft. %n", miles, feet);
        
        miles = 22.3;
        double kilometers = convertMilesToKilometers(miles);
        System.out.printf("%8.1f mi. = %7.1f km. %n", miles, kilometers);
        
        kilometers = 1000.0;
        miles = convertKilometersToMiles(kilometers);
        System.out.printf("%8.1f km. = %7.1f mi. %n", kilometers, miles);
        
        double pounds = 204.0;
        kilograms = convertPoundsToKilograms(pounds);
        System.out.printf("%8.1f lb. = %7.1f kg. %n", pounds, kilograms);
         
        kilograms = 98.0;
        pounds = convertKilogramsToPounds(kilograms);
        System.out.printf("%8.1f kg. = %7.1f lbs. %n", kilograms, pounds);
		
        gallons = 55.0;
        liters = convertGallonsToLiters(gallons);
        System.out.printf("%8.1f gl. = %7.1f li. %n", gallons, liters);
    	
        liters = 2.0;
        gallons = convertLitersToGallons(liters);
        System.out.printf("%8.1f li. = %7.1f gl. %n", liters, gallons);
           
    }//end of main method
	
}//end of class


