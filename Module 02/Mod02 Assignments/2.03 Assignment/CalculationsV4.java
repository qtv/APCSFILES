/**
 * The Calculations class performs addition, subtraction,
 * multiplication, division, and modulus operations on integers and
 * decimals.
 * 
 * �FLVS 2007
 * @author Bill Jordan; A.Ross+
 * @version 01/19/07; 06/24/12
 */
public class CalculationsV4
{
    public static void main(String[ ] args)
    {
        // Addition
        int iNum1= 25;
        int iNum2= 9;
        double dNum1 = 43.21 
        double dNum2 = 3.14
        double dNum3 = 5.0 
        
        System.out.println("Addition");
        System.out.print( iNum1 +" plus " + iNum2 + " equals ");
        System.out.println(iNum1 + iNum2);
        System.out.print( dNum1 + dNum2 + dNum3);
        System.out.println(dNum1 + dNum2);
        System.out.println();
        // Subtraction
        int iNum3= 16;
        
        System.out.println("Subtraction");
        System.out.print( iNum3 + " minus " + iNum2 + " minus " + iNum1 + " equals ");
        System.out.println( iNum3 - iNum2 - iNum1);
        System.out.println( 3.14 - 5.0 );
        
        // Multiplication
        System.out.println("Multiplication");
        System.out.print( iNum1 + " times " + iNum2 + " equals "); 
        System.out.println( iNum1 * iNum2);
        
        System.out.println((3.14 * 5.0 * 5.0) );
         
        
        // Division
        System.out.println("Division");
        System.out.print( iNum2 + " divided by " + iNum1 + " equals ");
        System.out.println( iNum2 / iNum1);
        System.out.println( (43.21 / 5.0) );
         
         
        // Modulus operator
        System.out.println("Modulus");
        System.out.print( iNum3 + " modulus " + iNum2 +" equals ");
        System.out.println( iNum3 % iNum2);
        System.out.println((5.0 % 3.14) );
        System.out.println("2.02 Lab Equations");
        
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
        
        System.out.println(   iNum4 + " divided by 2.5 times " +   iNum5 + " plus " +   iNum6 + " divided by " + iNum7);
        System.out.println( iNum4 / 2.5 *   iNum5 +   iNum6 /   iNum7);
        
        System.out.println(iNum8 + " minus (" + iNum8 + " divided by " + iNum9 + " modulus "+  iNum10+ ") plus " + iNum11 + " equals " );
        System.out.println(iNum8 - (iNum8 / iNum9 %iNum10) + iNum11);
        
        
        System.out.println("(" + 46.2 + " divided by " + iNum12 + ") minus " + iNum11 + " plus " + iNum13 + " modulus (" + iNum14 + " minus " + iNum15 + " times " + iNum11 + ") equals ");
        System.out.println( (46.2 / iNum12) - iNum11 + iNum13 % (iNum14 - iNum15 * iNum11));
        
       
        System.out.println(iNum16 + " divided by "+  iNum6 + " divided by " + iNum10 + " plus " + iNum18 + " times 0.5 minus " + iNum20 + " modulus " + iNum19 + " equals");
        System.out.println(iNum16 / iNum6 / iNum10 + iNum18 * 0.5 - iNum20 % iNum19);
        
        System.out.println(iNum16 + " modulus " + iNum13 + " plus " + iNum8 + " minus " + iNum18 + " equals" );
        System.out.println(iNum16 % iNum13 + iNum8 - iNum18);
        
        System.out.println(iNum19 + " divided by " + iNum9 + " times " + iNum5 + " equals ");
        System.out.println(iNum19 / iNum9 * iNum5);
        // 2.02 Lab Equations
        // 15 divided by 2.5 times -2 plus 10 / 5
        // 234 minus (234 divided by 6 modulus 12) + 3
        // (46.2 divided by 11) minus 3 plus 24 modulus (17 minus 2 times 3)
        // 480 divided by 10 divided by 12 plus 200 *.5 minus 20 modulus 8
        
        // 2.03 Additional int Equations
        
        
        //2.04 Additional double Equations
        
               
    } // end of main method
} // end of class
