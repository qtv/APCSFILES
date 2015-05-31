/**
 * 8.09 - Use OOP/javadoc concepts to calculate the amount of carbon dioxide emitted for a 
 * gallon of gas consumed.
 * @author  
 * 
 */
public class CO2FootPrintV1Tester {
     public static void main(String[] args) {
        // declare instance variables
        double gals, tonsCO2, poundsCO2;
        
        // declare gal variable
        gals = 926;
        CO2FootprintV1 obj = new CO2FootprintV1(gals);

        obj.calcTonsCO2();
        obj.convertTonsToPoundsCO2();
        tonsCO2 = obj.getTonsCO2();
        poundsCO2 = obj.getPoundsCO2();
        
        System.out.printf("%20s\n","CO2 Emissions");
        System.out.printf("%2s%10s%10s\n","Gallons","Pounds", "Tons");
        System.out.printf("%2s%12s%11s\n","of Gas","from Gas","from Gas");
        System.out.println("******************************   ");
        System.out.printf("%2.1f%13.2f%9.3f",gals, poundsCO2, tonsCO2);
    }
}
