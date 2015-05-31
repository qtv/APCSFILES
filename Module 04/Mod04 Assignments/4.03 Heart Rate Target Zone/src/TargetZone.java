/*
 */
/** This program calculates the target heart range of an individual using the Karvonen Formula.
 *
 * @author 
 */
import java.util.Scanner;
public class TargetZone {
    public static void main(String[] args)
    {   
Scanner in = new Scanner(System.in);

System.out.println("Determine Your Target Heart Rate Zone for Cardiovascular Execerise (50% - 85%)");

// start program

System.out.print("\nEnter your age: ");
Integer age = in.nextInt();

System.out.println("Enter your resting heart rate: ");
Integer restRate = in.nextInt();

System.out.println("Enter your heart rate after exercising: ");
Integer exerRate = in.nextInt();

// calculations of target heart rate

Integer maxRate = 220 - age;

Integer heartReserve = maxRate - restRate;

double upperRate = (heartReserve * 0.85) + restRate;

double lowerRate = (heartReserve * 0.50) + restRate;
        
boolean isWithin = exerRate > (int)lowerRate  && (int)upperRate > exerRate;

// convert and display

System.out.println("Your heart rate target zone is between " + (int)lowerRate + " and " + (int)upperRate);

if(isWithin) {
        System.out.println("After just exercising, your heart rate is within your target zone.");
     }
else {
        System.out.println("After just exercising, your heart rate is not within your target zone."); 
     }

        }
}
