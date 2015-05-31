/*
 * 8.12 - Write a program that models 5 individual homes CO2 production and reduction.
 */

/**
 *
 * @author 
 * @version 1/2/15
 */
public class CO2FootPrint {
   private int myNumPeople2, myNumBulbs;
   private boolean myPaper, myPlastic, myGlass, myCans; // reduction booleans
   private double myEmissions, myReduction, myNetEmissions;
   private double bulbReductions, elecPricePerKWH, avgElecBill, elecEmission;
   private double myGallons, myPoundsCO2Gas; // gas
   
   CO2FootPrint(double gallons, double kwh, double mBill, int bulbs, int myNumPeople, boolean paper, boolean plastic, boolean glass, boolean cans)
   {
       myGallons = gallons;
       elecPricePerKWH = kwh;
       avgElecBill = mBill;
       myNumPeople2 = myNumPeople;
       
       myNumBulbs = bulbs;
       myPaper = paper;
       myPlastic = plastic;
       myGlass = glass;
       myCans = cans;
       myEmissions = 0.0;
       myReduction = 0.0;
       myNetEmissions = 0.0;
       
   }
   /**
    * Mutator method to calculate the total emissions, without any recycling (no parameters)
    */
   public double calcGrossWasteEmission()
   {
       myEmissions = (myNumPeople2 * 1018);
       return myEmissions;
    }
   

   /**
    * Mutator method to calculate the emission reduction from recycling (no parameters)
    */
   public double calcWasteReduction()
   {
       myReduction = 0;

       if(myPaper)
       {
           myReduction += (184.0 * myNumPeople2);
       }
        if(myPlastic){
         myReduction = myReduction + (myNumPeople2 * 25.6);
        }
        if(myGlass){
         myReduction = myReduction + (myNumPeople2 * 46.6);
        }
        if(myCans){
         myReduction = myReduction + (myNumPeople2 * 165.8);
        }
        return myReduction;
   }

   /**
    * Mutator method to calculate the net emissions (no paramters)
    */
   public double calcNetWasteReduction()
   {
        calcGrossWasteEmission();
        calcWasteReduction();
        myNetEmissions = myEmissions - myReduction;
        return myNetEmissions;
   }
   
   /**
    * Mutator method to calculate the net emissions and return them (not void) & (no paramters)
    */
   public double calcBulbReduction()
   {
        bulbReductions = (double)(myNumBulbs) * 1.37 * 73;
        return bulbReductions;
   }
   
    /**
    * Mutator method to calculate the emissions of electricity and return them (not void) & (no paramters)
    */
   double calcElecEmission(){
        elecEmission = (avgElecBill / elecPricePerKWH) * 1.37 * 12;
        return elecEmission;
    }
   
   /**
    * Mutator method to calculate the pounds of CO2 generated from burning the provided gas amount and return them (not void) & (no paramters)
    */
   public double calcPoundsCO2Gas(){
        myPoundsCO2Gas = (myGallons * (8.78E-3) * 2000);
        return myPoundsCO2Gas;
    }
   
   // GETS
   /**
    * Getter method to return the number of people (no paramters)
    */
   public int getNumPeople()
   {
       return myNumPeople2;
   }

   /**
    * Getter method to return paper's recycled status (true or false) (no paramters)
    */
   public boolean getPaper()
   {
       return myPaper;
   }

   /**
    * Getter method to return glass's recycled status (true or false) (no paramters)
    */
   public boolean getGlass()
   {
       return myGlass;
   }

   /**
    * Getter method to return plastic's recycled status (true or false) (no paramters)
    */
   public boolean getPlastic()
   {
       return myPlastic;
   }

   /**
    * Getter method to return cans' recycled status (true or false) (no paramters)
    */
   public boolean getCans()
   {
       return myCans;
   }

   /**
    * Getter method to return the total emissions (no paramters)
    */
   public double getEmissions()
   {
       return myEmissions;
   }

   /**
    * Getter method to return the reduction amount (no paramters)
    */
   public double getReduction()
   {
       return myReduction;
   }

   /**
    * Getter method to return the net emissions (no paramters)
    */
   public double getNetEmissions()
   {
       return myNetEmissions;
   }
   
   /**
    * Getter method to return the gallons used (no paramters)
    */
   public double getGallons()
   {
       return myGallons;
   }
}
