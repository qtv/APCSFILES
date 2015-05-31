/**
 * A program that allows you to enter a menu item for more information (doesn't
 * give any information though). 
 * 
 * @
 * 4.06 Wellness Menu
 * 11/30/14
 */
import java.util.Scanner;
public class WellnessMenu
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Please select one of the following options from the menu for more information.");
        System.out.println("\nSelect a letter corresponding to a menu option.");
        System.out.println("[A] BMI");
        System.out.println("[B] BMR");
        System.out.println("[C] Healthy Eating");
        System.out.println("[D] Food Pyramid");
        System.out.println("[E] Fitness Training");
    
        System.out.println("\nPlease enter either A, B, C, D, or E: ");
        // accept user choice with a Scanner class method
        String option = in.next();
        System.out.println();
        
        if(option.equalsIgnoreCase("A") ) //condition for choice A goes in the parentheses
        {
            
            System.out.println("Testing: You chose A for BMI");
        }
        else if( option.equalsIgnoreCase("B")) //condition for choice B goes in the parentheses
        {
            
            System.out.println("Testing: You chose B for BMR");
        }
        else if (option.equalsIgnoreCase( "C") ) //condition for choice C goes in the parentheses
        {
            
            System.out.println("Testing: You chose C for Healthy Eating");
        }
        else if (option.equalsIgnoreCase("D") ) //condition for choice D goes in the parentheses
        {
            
            System.out.println("Testing: You chose D for Food Pyramid");
        }
        else if (option.equalsIgnoreCase("E") ) //condition for choice E goes in the parentheses
        {
            
            System.out.println("Testing: You chose E for Fitness Training");
        }
        else //default choice for an invalid entry
        {
            // provide print statement to indicate invalid entry
            System.out.println("Please enter a valid option.");
        }
    }
}
