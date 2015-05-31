/**
 * 8.09 - Use OOP/javadoc concepts to calculate the amount of carbon dioxide emitted for a 
 * gallon of gas consumed.
 * @author  
 * 
 */
public class CO2FootprintV1 {
    // declare private instance variables
    double myGallonsUsed, myTonsCO2, myPoundsCO2;
    /**
    * constructor for objects of CO2FootPrintV1
    * @param gals - gallons used
    */
    
    CO2FootprintV1(double gals) {
		myGallonsUsed = gals;
	}
     /**
     * method to calculate tons of CO2 created
     * Initializes and calculates tons of CO2
     */
	void calcTonsCO2() {
		myTonsCO2 = myGallonsUsed * 8.78E-3;
	}
     /**
     * method to convert tons of CO2 to pounds
     * initializes and calculates myPoundsCO2
     */
	void convertTonsToPoundsCO2() {
            System.out.println(myTonsCO2);
		myPoundsCO2 = myTonsCO2 * 2000;
	}
     /**
     * method to return the value of tons of CO2
     * @return tons of CO2
     */
	double getTonsCO2(){
		return myTonsCO2;
	}
     /**
     * method to return the value of pounds of CO2
     * @return double pounds of CO2
     */
	double getPoundsCO2(){
		return myPoundsCO2;
	}
}
