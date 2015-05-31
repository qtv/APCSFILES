/**
 * 8.08 Annual Fuel Use - Finds annual fuel usage using arrays and objects.
 * @author 
 * @date 12/23/14
 */
public class AnnualFuelUseTester {
    public static void main(String[] args) {
    int[] fills = {1,2,3};
    
    // I just made everything a double as it was confusing converting from ints to doubles constantly
    
    double[]day = {1, 8, 10},
            endMiles = { 17350, 17623, 17953},
            startMiles = {17065, 17350, 17623},
            gallonsUsed = { 15.5, 15.2, 15},
            pricePerGallon = {2.39, 2.08, 2.06},
            // have to calculate these later
            totalCost = new double[3],
            mpg = new double[3],
            gallonsPerMile = new double[3],
            distance = new double[3];
    
     AnnualFuelUse[] car = {new AnnualFuelUse(fills[0], startMiles[0], endMiles[0], gallonsUsed[0], pricePerGallon[0]),
                            new AnnualFuelUse(fills[1], startMiles[1], endMiles[1], gallonsUsed[1], pricePerGallon[1]),
                            new AnnualFuelUse(fills[2], startMiles[2], endMiles[2], gallonsUsed[2], pricePerGallon[2])};
     
    //min and maxs 
        double minMPG, maxMPG,
                
               minPrice, maxPrice,
                
               minDistance, maxDistance,
               //totals 
                
               totalDistance,
                
               totalGallonsUsed, 
               
               totalCostSum,
                
               totalmpgAvg,
                
               totalDays,
               //annuals 
                
               annualDistance,
               annualGallonsUsed, 
               annualMPG, 
               annualCost;
                
       for(int i = 0; i < 3; i++)
        {
            distance[i] = car[i].calcDistance(endMiles[i], startMiles[i]);
            
            totalCost[i] = car[i].totalCost(pricePerGallon[i], gallonsUsed[i]);
            
            mpg[i] = car[i].calcMPG((int) distance[i], gallonsUsed[i]);
        }
        
        //min and max calc
        minDistance = AnnualFuelUse.min(distance);
        maxDistance = AnnualFuelUse.max(distance);
        minMPG = AnnualFuelUse.min(mpg);
        maxMPG = AnnualFuelUse.max(mpg);
        minPrice = AnnualFuelUse.min(pricePerGallon);
        maxPrice = AnnualFuelUse.max(pricePerGallon);
        
        //total calcs
        totalDistance = AnnualFuelUse.totals(distance);
        totalGallonsUsed = AnnualFuelUse.totals(gallonsUsed);
        totalmpgAvg = AnnualFuelUse.totals(mpg) / mpg.length;
        totalDays = AnnualFuelUse.totals(day) - 1;
        totalCostSum = AnnualFuelUse.totals(totalCost);
        
        //annual calc
        
        annualDistance = AnnualFuelUse.annualProjection(day, totalDistance);
        annualGallonsUsed = AnnualFuelUse.annualProjection(day, totalGallonsUsed);
        annualMPG = AnnualFuelUse.annualProjection(day, totalmpgAvg) / totalDays;
        annualCost = AnnualFuelUse.annualProjection(day, totalCostSum);
        
        
        System.out.printf("%1s %8s %16s %13s %12s %18s %7s %12s %10s\n", "Fill Up" , "Days" , "Start Miles" , "End Miles" , "Distance" , "Gallons Used" , "MPG" , "Price", "Cost" );
        for(int i = 0; i < 3; i++)
        {
           System.out.printf("%4d %10.0f %14.0f %14.0f %12.0f %16.1f %11.2f %12.2f %12.2f\n", fills[i], day[i], startMiles[i], endMiles[i], distance[i], gallonsUsed[i], mpg[i], pricePerGallon[i], totalCost[i]);
        }
        
        System.out.printf("\nMinimum:%50.0f%29.2f%14.2f\n", minDistance, minPrice, minMPG);
        System.out.printf("Maximum:%50.0f%29.2f%14.2f\n\n", maxDistance, maxPrice, maxMPG);
        System.out.printf("Totals:%51.0f%17.1f%38.2f%n", totalDistance, totalGallonsUsed, totalCostSum);
        System.out.printf("Annual Projection:%40.0f%17.1f%12.2f%26.2f\n", annualDistance, annualGallonsUsed, annualMPG, annualCost);
        
}
}