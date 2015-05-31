
import java.util.ArrayList;

/*
 * 8.12 - Write a program that models 5 individual homes CO2 production and reduction.
 */

/**
 *
 * @author 
 * @version 1/2/15
 */
public class CO2FootPrintTester {
  
   public static void main(String[] args)
   {
       //CO2FootPrint(double gallons, double kwh, double mBill,
       // int bulbs, int myNumPeople, boolean paper, boolean plastic, boolean glass, boolean cans)
       ArrayList<CO2FootPrint> co2 = new ArrayList<>();
       co2.add(new CO2FootPrint(48000.00, 0.22400, 200.00, 8, 2,  true, false, true, false));
       co2.add(new CO2FootPrint(38400.00, 0.13418, 300.00, 6, 4, false, false, false, true));
       co2.add(new CO2FootPrint(40221.60, 0.20000, 252.16, 18, 6,  true, true, true, false));
       co2.add(new CO2FootPrint(27000.32, 0.11259, 159.20, 9, 4, false, false, false, false));
       co2.add(new CO2FootPrint(25000.17, 0.19259, 145.23, 11, 4, true, true, true, true));
       
       
       System.out.println("|               Pounds of CO2               |       Pounds of CO2       |                    |");
       System.out.println("|               Emitted From                |       Reduced from        |                    |");
       System.out.println("|     Gas    |   Electricity   |    Waste   | Recycling  |   New Bulbs  |    CO2 Footprint   |");
       System.out.println("|============|=================|============|============|==============|====================|");
       CO2FootPrint dataRecord;
       for(int i = 0; i < co2.size(); i++)
       {
           dataRecord = co2.get(i);
           dataRecord.calcGrossWasteEmission();
           dataRecord.calcWasteReduction();
           dataRecord.calcNetWasteReduction();
        }
           
           
       for(int i = 0; i < co2.size(); i++)
       {
           dataRecord = co2.get(i);
           System.out.printf("| %10.2f | %13.2f   | %10.2f | %10.2f | %11.2f  |     %12.2f   |\n", dataRecord.calcPoundsCO2Gas(),
               dataRecord.calcElecEmission(), dataRecord.calcGrossWasteEmission(), 
               dataRecord.calcWasteReduction(), dataRecord.calcBulbReduction(), 
               dataRecord.calcNetWasteReduction());
       }
       
    }
   
}
