/**
 * Program to calculate the Total Daily Energy Expenditure
 *
 * 
 * 4.07 TDEE
 * 11/30/14
 */
import java.util.Scanner;
public class TDEE
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);

        // Input: Gather information from user
        System.out.print("Please enter your name: ");
        String name = in.nextLine();
        System.out.print("Please enter your BMR: ");
        double basalMR = in.nextDouble();
        System.out.print("Please enter your gender (M/F): ");
        String gender = in.next();
        System.out.println();

        // Activity Level Menu
        System.out.println("Select Your Activity Level");
        System.out.println("[A] Resting (Sleeping, Reclining)");
        System.out.println("[B] Sedentary (Minimal Movement)");
        System.out.println("[C] Light (Sitting, Standing)");
        System.out.println("[D] Moderate (Light Manual Labor, Dancing, Riding Bike)");
        System.out.println("[E] Very Active (Team Sports, Hard Manual Labor)");
        System.out.println("[F] Extremely Active (Full-time Athelete, Heavy Manual Labor)");
        System.out.println();
        System.out.print("Enter the letter corresponding to your activity level: ");
        String choice = in.next();
        System.out.println();

        
        // Activity Factor
        double activityFactor = 0;

        if (choice.equalsIgnoreCase("A")) 
        {
            activityFactor = 1.0;
            
        }
        else if (choice.equalsIgnoreCase("B")) 
        {
            
            activityFactor = 1.3;
        }
        else if (choice.equalsIgnoreCase("C") && gender.equalsIgnoreCase("F")) 
        {
            
            activityFactor = 1.5;
        }
         else if (choice.equalsIgnoreCase("C") && gender.equalsIgnoreCase("M")) 
        {
            
            activityFactor = 1.6;
        }
        else if (choice.equalsIgnoreCase("D") && gender.equalsIgnoreCase("F") ) 
        {
            
            activityFactor = 1.6;
        }
        else if (choice.equalsIgnoreCase("D") && gender.equalsIgnoreCase("M") ) 
        {
            
            activityFactor = 1.7;
        }
        else if (choice.equalsIgnoreCase("E") && gender.equalsIgnoreCase("F") ) 
        {
            
            activityFactor = 1.9;
        }
        else if (choice.equalsIgnoreCase("E") && gender.equalsIgnoreCase("M") ) 
        {
            
            activityFactor = 2.1;
        }
            else if (choice.equalsIgnoreCase("F") && gender.equalsIgnoreCase("F") ) 
        {
            
            activityFactor = 2.2;
        }
            else if (choice.equalsIgnoreCase("F") && gender.equalsIgnoreCase("M") ) 
        {
            
            activityFactor = 2.4;
        }
        else //default choice for an invalid entry
        {
            // provide print statement to indicate invalid entry
            System.out.println("Please enter a valid choice.");
        }
            

        // Calculate TDEE
        double tDEE = basalMR * activityFactor;

        // print results
        System.out.println("Name: " + name + "\t\tGender: " + gender);
        System.out.println("BMR: " + basalMR + " calories "+ "\t\tActivity Factor: " + activityFactor);
        System.out.println("TDEE: " + tDEE + " calories ");

    }
}

