/**
 * @purpose: Calculate yearly CO2 emissions from electricity (8.10)
 *
 * @author: 
 * @version: 12/26/14
 */
import java.util.ArrayList;
public class CO2FromElectricity

{
   CO2FromElectricity()
   {
   	//default constructor to be used
   }

   /**
     * Method that calculates the average electricity bill..
     * @param ArrayList<Double>
     * @returns double Average Monthly Bill
     */
   
   public double calcAverageBill(ArrayList<Double> monthlyBill)
   {
       double total = 0;
       
       for (double bill : monthlyBill) {
           total = total + bill;
       }
       return total / monthlyBill.size(); // kinda like array.length()
   }

   /**
     * Method that calculates the average price for a kilowatt her hour.
     * @param ArrayList<Double>
     * @returns double Average KWH Price
     */
   
   public double calcAveragePrice (ArrayList<Double> monthlyPrice)
   {
       double total = 0;
       
       for (double price : monthlyPrice) {
           total = price + total;
       }
       return total / monthlyPrice.size();
   }

    /**
     * Method that calculates the CO2 used per year.
     * @param double avgBill, avgPrice
     * @returns double CO2 Burned
     */
   
   public double calcElectricityCO2 (double avgBill, double avgPrice)
   {
        double emissionFactor = 1.37;
        int months = 12;
        
        return (avgBill / avgPrice) * emissionFactor * months;
   }
}

