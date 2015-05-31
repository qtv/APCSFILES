        
/**
 * The Calculations class performs addition, subtraction,
 * multiplication, division, and modulus operations on integers and
 * decimals.
 * 
 * �FLVS 2007
 * @author Bill Jordan; A.Ross
 * @version 01/19/07; 06/24/12
 */
public class Calculations_v3
{
    public static void main(String[ ] args)
    {
        // Addition
        int iNum1= 25;
        int iNum2= 9;
        
        System.out.println("Addition");
        System.out.print( iNum1 +" plus " + iNum2 + "=");
        System.out.println(iNum1 + iNum2);
        System.out.println( 43.21 + 3.14 );
        System.out.println();
        
        // Subtraction
        System.out.println("Subtraction");
        System.out.println( "16 minus 9 minus 25 equals " + (16 - 9 - 25) );
        System.out.println( "3.14 minus 5 equals " + (3.14 - 5.0) );
        System.out.println();
        
        // Multiplication
        System.out.println("Multiplication");
        System.out.println( "25 multiplied by 9 equals " + (25 * 9) ); 
        System.out.println("3.14 multiplied by 5 multipled by 5 equals " + (3.14 * 5.0 * 5.0) );
        System.out.println();
        
        // Division
        System.out.println("Division");
        System.out.println( "9 divided by 25 equals " + (9 / 25) );
        System.out.println( "43.21 divided by 5 equals " + (43.21 / 5.0) );
        System.out.println();
         
        // Modulus operator
        System.out.println("Modulus");
        System.out.println( "16 modulus 9 equals " + (16 % 9));
        System.out.println( "5 modulus 5 equals " + (5.0 % 3.14) );
        System.out.println();
        
        System.out.println( "15 divided by 2.5 multiplied by -2 plus 10 divided by 5 equals " + (15/2.5 * -2 + 10/5));
        System.out.println();
        
        System.out.println("234 minus (234 divided by 6 modulus 12) plus 3 equals " + (234- (234/6 % 12) + 3));
        System.out.println();
        
        System.out.println("(46.2 divided by 11) minus 3 plus 24 modulus (17 minus 2 multipled by 3) equals " + ((46.2 / 11) - 3 + 24 % (17 - 2 *3)));
        System.out.println();
        
        
        System.out.println("480 divided by 10 divided by 12 plus 200 multipled by 0.5 minus 20 modulus 8 equals " + (480/10/12 + 200 *.5 - 20 % 8));
        System.out.println();
        // 2.02 Lab Equations
        // 15 divided by 2.5 times -2 plus 10 / 5
        // 234 minus (234 divided by 6 modulus 12) + 3
        // (46.2 divided by 11) minus 3 plus 24 modulus (17 minus 2 times 3)
        // 480 divided by 10 divided by 12 plus 200 *.5 minus 20 modulus 8
        
        // 2.03 Additional int Equations
        
        
        //2.04 Additional double Equations
        
               
    } // end of main method
} // end of class
