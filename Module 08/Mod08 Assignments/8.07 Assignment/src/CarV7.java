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
public class CarV7 {
    // instance variables
    String carType;
    int endMiles,startMiles;
    double gallonsUsed, pricePerGallon;
    
    // default constructor
    CarV7() {}
    // with parameters
    CarV7(String carType, int endMiles, int startMiles, double gallonsUsed, double pricePerGallon) {
        this.carType=carType;         // using "this" so I can use the same variables, instead of renaming (threw error)
        this.endMiles = endMiles;
        this.startMiles = startMiles;
        this.gallonsUsed = gallonsUsed;
        this.pricePerGallon = pricePerGallon;
    }
    public static int calcDistance(int endMiles, int startMiles) {
    return endMiles - startMiles;
    }
    
    public static double calcMPG (int dist, double gals) {
        return dist / gals;
    }
    
    public static double calcGPM (int dist, double gal) { 
    return  gal / dist;    
    }
    
    public static double totalCost (double pricePerGallon, double gallonsUsed) {
      return gallonsUsed * pricePerGallon;   
    }
    
    public static void main(String[] args) {
        String carType;
        int endMiles,startMiles;
        double gallonsUsed, pricePerGallon;
        
        CarV7 car1 = new CarV7("12 Mustang V6", 17350, 17065, 15.5, 2.39);
        CarV7 car2 = new CarV7("08 Hummer H3", 17650, 17350, 22.0, 2.39);
        CarV7 car3 = new CarV7("13 Acura ILX", 17894, 17450, 12.0, 2.39);
        
        int dist1 = calcDistance(car1.endMiles, car1.startMiles), dist2 = calcDistance(car2.endMiles ,car2.startMiles), dist3 = calcDistance(car3.endMiles, car3.startMiles);
        double mpg1 = calcMPG(dist1,car1.gallonsUsed), mpg2 = calcMPG(dist2,car2.gallonsUsed), mpg3 = calcMPG(dist3,car3.gallonsUsed);
        double gpm1 = calcGPM(dist1, car1.gallonsUsed), gpm2 = calcGPM(dist2, car2.gallonsUsed), gpm3 = calcGPM(dist3, car3.gallonsUsed);
        double totalCost1 = totalCost(car1.pricePerGallon, car1.gallonsUsed), totalCost2 = totalCost(car2.pricePerGallon, car2.gallonsUsed), totalCost3 = totalCost(car3.pricePerGallon, car3.gallonsUsed);
        
        System.out.printf("%50s\n", "Gas Mileage Calculations");
        System.out.printf("%13s%15s%15s%15s%15s%15s%15s%15s%15s\n", "Type of Car", "Start Miles", "End Miles",
                "Distance", "Gallons", "Price", "Cost", "Miles/Gal", "Gal/Mile");
        System.out.print("=====================================================================================================================================\n");
        System.out.printf("%-13s%15d%15d%15d%15.1f%15.2f%15.2f%15.1f%15.3f\n", car1.carType,car1.startMiles,car1.endMiles,dist1,car1.gallonsUsed, car1.pricePerGallon, totalCost1, mpg1, gpm1);
        System.out.printf("%-13s%15d%15d%15d%15.1f%15.2f%15.2f%15.1f%15.3f\n" , car2.carType,car2.startMiles,car2.endMiles,dist2,car2.gallonsUsed,car2.pricePerGallon, totalCost2, mpg2, gpm2);
        System.out.printf("%-13s%15d%15d%15d%15.1f%15.2f%15.2f%15.1f%15.3f" , car3.carType,car3.startMiles,car3.endMiles,dist3,car3.gallonsUsed,car3.pricePerGallon, totalCost3, mpg3, gpm3);
    }
    
}
