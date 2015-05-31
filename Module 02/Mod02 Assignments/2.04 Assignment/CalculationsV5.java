/**
 * The program uses integers and doubles to calculate basic arithmetic.
 * 
 * @author 
 * @version 11/04/14
 */
public class CalculationsV5
{
    public static void main(String[ ] args)
    {
        // variable assigning
         int iNum1= 25;
         int iNum2= 9;
         int iNum3= 16;
         int iNum4 = 15;
         int iNum5 = -2;
         int iNum6 = 10;
         int iNum7 = 5;
         int iNum8 = 234;
         int iNum9 = 6;
         int iNum10 = 12;
         int iNum11 = 3;
         int iNum12 = 11;
         int iNum13 = 24;
         int iNum14 =17;
         int iNum15 = 2;
         int iNum16 = 480;
         int iNum17 = 12;
         int iNum18 = 200;
         int iNum19 = 8;
         int iNum20 = 20;
         
        double dNum1 = 43.21;
        double dNum2 = 3.14;
        double dNum3 = 5.0;
        double dNum4 = 46.2;
        double dNum5 = 2.5;
        double dNum6 = 0.5; 
        
       
        // start calculations
        // Addition
        System.out.println("Addition");

        System.out.println( iNum1 +" plus " + iNum2 + " equals ");

        System.out.println(iNum1 + iNum2);

        System.out.println( dNum1 + " plus " + dNum2 + " plus " + dNum3 + " equals");

        System.out.println(dNum1 + dNum2 + dNum3);

        // Subtraction  
        System.out.println("Subtraction");

        System.out.println ( iNum3 + " minus " + iNum2 + " minus " + iNum1 + " equals ");

        System.out.println( iNum3 - iNum2 - iNum1);

        System.out.println( dNum2+  " minus " + dNum3 + " equals");

        System.out.println( dNum2 - dNum3);

        // Multiplication
        System.out.println("Multiplication");

        System.out.println( iNum1 + " times " + iNum2 + " equals "); 

        System.out.println( iNum1 * iNum2);
        
        System.out.println((dNum2 + " times " + dNum3 + " times " + dNum3 + " equals ") );

        System.out.println((dNum2 * dNum3 * dNum3));
         
        
        // Division
        System.out.println("Division");

        System.out.println( iNum2 + " divided by " + iNum1 + " equals ");

        System.out.println( iNum2 / iNum1);

        System.out.println( dNum1 + " divided by " + dNum3 + " equals " );

        System.out.println( dNum1 / dNum3);
     
         
        // Modulus operator
        System.out.println("Modulus");

        System.out.println( iNum3 + " modulus " + iNum2 +" equals ");

        System.out.println( iNum3 % iNum2);

        System.out.println(dNum3 + " modulus " + dNum2 + " equals ");

        System.out.println(dNum3 % dNum2);

        // Addtional equations
        System.out.println("2.02 Lab Equations");
        
        System.out.println(iNum4 + " divided by " + dNum5 + " times " +   iNum5 + " plus " +   iNum6 + " divided by " + iNum7);

        System.out.println(iNum4 / dNum5 *   iNum5 +   iNum6 /   iNum7);
        
        System.out.println(iNum8 + " minus (" + iNum8 + " divided by " + iNum9 + " modulus "+  iNum10+ ") plus " + iNum11 + " equals " );

        System.out.println(iNum8 - (iNum8 / iNum9 %iNum10) + iNum11);
        
        
        System.out.println("(" + dNum4 + " divided by " + iNum12 + ") minus " + iNum11 + " plus " + iNum13 + " modulus (" + iNum14 + " minus " + iNum15 + " times " + iNum11 + ") equals ");

        System.out.println((dNum4 / iNum12) - iNum11 + iNum13 % (iNum14 - iNum15 * iNum11));
       
       
        System.out.println(iNum16 + " divided by "+  iNum6 + " divided by " + iNum10 + " plus " + iNum18 + " times " + dNum6 + " minus " + iNum20 + " modulus " + iNum19 + " equals");

        System.out.println(iNum16 / iNum6 / iNum10 + iNum18 * dNum6 - iNum20 % iNum19);
        
        // 2.03 Additional Equations
        System.out.println("2.03 Additional int Equations");

        System.out.println(iNum16 + " modulus " + iNum13 + " plus " + iNum8 + " minus " + iNum18 + " equals" );

        System.out.println(iNum16 % iNum13 + iNum8 - iNum18);
        
        System.out.println(iNum19 + " divided by " + iNum9 + " times " + iNum5 + " equals ");

        System.out.println(iNum19 / iNum9 * iNum5);
        
        // 2.04 Additional Equations
        System.out.println("2.04 Additional double Equations");

        System.out.println(dNum1 + " divided by " + dNum3 + " divided by " + dNum4 + " equals ");

        System.out.println(dNum1 / dNum3 / dNum4);
        
        System.out.println(dNum1 + " modulus " + dNum6 + " plus " + dNum4 + " minus " + dNum3 + " times " + dNum2 + " equals" );

        System.out.println(dNum1 % dNum6 + dNum4 - dNum3 * dNum2);


    } // end of main method
}
 // end of class
