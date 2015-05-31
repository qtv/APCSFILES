/*
 * 9.04 Catapult - A program that calculates the distance a catapult would throw 
 * when given a certain angle and speed.
 */

/**
 *
 * @author 
 * @version 1/04/15
 */
public class CatapultTester {

    public static void main(String[] args) {
        Catapult[][] catapult1 = new Catapult[7][6];
        int v;
        
        // generates velocities for row 
        for(int row = 0; row < catapult1.length; row++)
        {
            v = 20 + (5 * row); 
            for(int column = 0; column <catapult1.length - 1; column++) // minus one as it uses row length of 7 when column length is 6
            {    
                catapult1[row][column] = new Catapult(v, 25 + (5 * column));
            }
        }
        System.out.printf("%42s%n"," Projectile Distance (feet)");
        System.out.println(" MPH   25 deg   30 deg   35 deg   40 deg   45 deg   50 deg  ");
        System.out.println("============================================================");

        for(int row = 0; row < catapult1.length; row++)
        {
           
            System.out.printf(" %3.0f", catapult1[row][0].getVelocity());
            
            for(int column = 0; column < catapult1.length - 1; column++) // same as above
            {
               
                catapult1[row][column].calcDistance(); 
                
                System.out.printf( "%9.1f", catapult1[row][column].getDistance());
            }
            
            System.out.println("");
        }
    }
    
    
}
