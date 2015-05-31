/**
 * 8.08 Annual Fuel Use - Finds annual fuel usage using arrays and objects.
 * @author 
 * @date 12/23/14
 */
public class AnnualFuelUse {

     // instance variables
    String carType;
    double endMiles,startMiles;
    double gallonsUsed, pricePerGallon;
    
    // default constructor
    AnnualFuelUse() {}
    // with parameters
    AnnualFuelUse( int fills, double endMiles, double startMiles, double gallonsUsed, double pricePerGallon) {
        // using "this" so I can use the same variables, instead of renaming (threw error)
        this.endMiles = endMiles;
        this.startMiles = startMiles;
        this.gallonsUsed = gallonsUsed;
        this.pricePerGallon = pricePerGallon;
    }
    public static double calcDistance(double endMiles, double startMiles) {
    return endMiles - startMiles;
    }
    
    public static double calcMPG (int dist, double gals) {
        return dist / gals;
    }
    
    public static double totalCost (double pricePerGallon, double gallonsUsed) {
      return gallonsUsed * pricePerGallon;   
    }
    
    
    // max
    
    public static double max(double mm[])
    {
        Double max = Double.MIN_VALUE;
        for(int i = 0; i < mm.length; i++)
        {
            if(mm[i] > max)
            {
                max = mm[i];
            }
        }
        return max;
    }
    
    // min 
    
    public static double min(double mm[])
    {
        Double min = Double.MAX_VALUE;
        for(int i = 0; i < mm.length; i++)
        {
            if (mm[i] < min)
            {
                min = mm[i];
            }
        }
        return min;
    }

    public static double totals(double total[])
    {
        double totalNum = 0;
        for(double newValue : total)
        {
            totalNum = totalNum + newValue;
        }
        return totalNum;
    }
        
    public static double annualProjection(double days[], double whatever) {
        double totalNum = 0;
        
        for (double newValue : days) {
            totalNum = totalNum + newValue;
        }
        
        double annualProject = 0;
        annualProject = 365 / (totalNum -1) * whatever;
        return annualProject;
    }
    
    

}

