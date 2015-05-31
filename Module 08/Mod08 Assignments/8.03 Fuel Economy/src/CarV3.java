/*
 * 8.03 - Calculate the fuel economy of your family or personal car for one fill up.
 */

/**
 *
 * @author 
 * @date 12/20/14
 */
public class CarV3 {
    CarV3() 
    {    
    }
    public int calcDistance (int sMiles, int eMiles) {
       int dist = eMiles - sMiles;
       return dist;
    }
    
    public double calcMPG (int dist, double gals) {
        return dist / gals;
    }
    public static void main(String[] args) {
      String carType = "12 Mustang V6";
      int sMiles1 = 17065;
      int eMiles1 = 17350;
      double gals = 15.5;
      
      CarV3 car1 = new CarV3();
      int dist = car1.calcDistance(sMiles1, eMiles1);
      double mpg = car1.calcMPG(dist, gals);
      
        System.out.printf("%50s\n", "Gas Mileage Calculations");
        System.out.printf("%13s%15s%15s%15s%15s%15s\n", "Type of Car", "Start Miles", "End Miles",
                "Distance", "Gallons", "Miles/Gal");
        System.out.print("=========================================================================================\n");
        System.out.printf("%13s%15d%15d%15d%15.1f%15.1f\n", carType, sMiles1, eMiles1, dist, gals, mpg);
    }
    
}
