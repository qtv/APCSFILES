/**
 * @purpose: Calculate yearly CO2 emissions from electricity (8.10)
 *
 * @author: 
 * @version: 12/26/14
 */
import java.util.ArrayList;
public class CO2FromElectricityTester
{
   public static void main(String[] args)
   {
       	CO2FromElectricity CO2 = new CO2FromElectricity();

       	ArrayList<Double> monthlyBill = new ArrayList<Double>(3);
       	ArrayList<Double> monthlyPrice = new ArrayList<Double>(3);
        
        monthlyBill.add(116.67); // september
        monthlyBill.add(96.42);  // october
        monthlyBill.add(111.52); // november
        
        monthlyPrice.add(116.67 / 1200);
        monthlyPrice.add(96.42 / 990);
        monthlyPrice.add(111.52 / 1140);
        

       double avgBill = CO2.calcAverageBill(monthlyBill);
       double avgPrice = CO2.calcAveragePrice(monthlyPrice);

       double emissions = CO2.calcElectricityCO2(avgBill, avgPrice);

       System.out.printf("Average Monthly Electricity Bill: %6.2f%n", avgBill);
       System.out.printf("Average Monthly Electricity Price: %4.2f%n", avgPrice);
       System.out.printf("Annual CO2 Emissions from Electricity Usage:   %7.1f pounds", emissions);
   }
}

