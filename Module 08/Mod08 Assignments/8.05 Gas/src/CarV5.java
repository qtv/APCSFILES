/**
 * CarV5 - Calculates fuel economy, gallons per mile, miles per gallon, and total 
 * price for filling up. 
 *
 */

/**
 *
 * @author 
 * @date 12/21/2014
 */
public class CarV5 {
    // instance variables
    String carType1;
    int endMiles1,startMiles1;
    double gallonsUsed1, pricePerGallon1;
    
    // default constructor
    CarV5() {}
    // with parameters
    CarV5(String carType1, int endMiles1, int startMiles1, double gallonsUsed1, double pricePerGallon1) {
        this.carType1=carType1;         // using "this" so I can use the same variables, instead of renaming (threw error)
        this.endMiles1 = endMiles1;
        this.startMiles1 = startMiles1;
        this.gallonsUsed1 = gallonsUsed1;
        this.pricePerGallon1 = pricePerGallon1;
    }
    public static int calcDistance(int endMiles1, int startMiles1) {
    return endMiles1 - startMiles1;
    }
    
    public static double calcMPG (int dist, double gals) {
        return dist / gals;
    }
    
    public static double calcGPM (int dist, double gal) { 
    return  gal / dist;    
    }
    
    public static double totalCost (double pricePerGallon1, double gallonsUsed1) {
      return gallonsUsed1 * pricePerGallon1;   
    }
    
    public static void main(String[] args) {
        String carType1 = "12 Mustang V6";
        int endMiles1 =17350,startMiles1=17065;
        double gallonsUsed1=15.5, pricePerGallon1=2.39;
        
        CarV5 car1 = new CarV5(carType1, endMiles1, startMiles1, gallonsUsed1, pricePerGallon1);
        
        int dist1 = calcDistance(car1.endMiles1, car1.startMiles1);
        double mpg1 = calcMPG(dist1,car1.gallonsUsed1);
        double gpm1   = calcGPM(dist1, car1.gallonsUsed1);
        double totalCost1  = totalCost(car1.pricePerGallon1, car1.gallonsUsed1);
        
        System.out.printf("%50s\n", "Gas Mileage Calculations");
        System.out.printf("%13s%15s%15s%15s%15s%15s%15s%15s%15s\n", "Type of Car", "Start Miles", "End Miles",
                "Distance", "Gallons", "Price", "Cost", "Miles/Gal", "Gal/Mile");
        System.out.print("=====================================================================================================================================\n");
        System.out.printf("%13s%15d%15d%15d%15.1f%15.2f%15.2f%15.1f%15.3f", car1.carType1,car1.startMiles1,car1.endMiles1,dist1,car1.gallonsUsed1, car1.pricePerGallon1, totalCost1, mpg1, gpm1);
        
    }
    
}
