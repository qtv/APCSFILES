
import java.util.Scanner;

/*
 * This program calculates a users BMI, and advises them on what their weight
 * status is.
 */
/**
 * 4.05 BMI 
 * @author 
 * 11/29/14
 */

public class BMI {
    public static void main(String[] args)
    {   
Scanner in = new Scanner(System.in);

System.out.println("Enter your name (first last): ");
String name = in.nextLine();

System.out.println("Height in feet and inches (ex: 5 11): ");
String feetHeightString = in.next();
String inchHeightString = in.next();

System.out.println("Weight in pounds: ");
Integer weight = in.nextInt();

// conversions

double kgWeight = weight * 0.45359237; // weight to kg

int feetHeight= Integer.parseInt(feetHeightString);
int inchHeight = Integer.parseInt(inchHeightString);

double totalHeight = ((feetHeight * 12) + inchHeight) / 39.370;  // in meters

// BMI Formula : weight (kg) / [height (m)]^2

double BMI = kgWeight / Math.pow(totalHeight,2);   // can also just mutliply number by itself

// final display

System.out.println("\nBody Mass Index Calculator");
System.out.println("==========================");
System.out.println("Name: " + name);
System.out.println("Height (m): " + Math.round(totalHeight * 10.0) / 10.0);
System.out.println("Weight (kg): " + Math.round(kgWeight * 10.0) / 10.0);
System.out.println("BMI: " + Math.round(BMI * 10.0) / 10.0);

if (BMI < 18.5) {
        System.out.println("Category : Underweight");
    } else if (BMI >= 18.5 && BMI <= 24.9) {
        System.out.println("Category : Normal");
    } else if (BMI >= 25.0 && BMI <= 29.9) {
        System.out.println("Category : Overweight");
    } else if (BMI >= 30.0) {
        System.out.println("Category : Obese");
    }
    
}
}
