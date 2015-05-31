
import java.util.Scanner;

/* 4.04 Basal Metabolic Rate
 * This program calculates your basal metabolic rate by the user entering all of 
 * their information into the program, and converts inches and pounds to the 
 * metric system.
 */
/**
 *
 * @author 
 * 11/29/14
 */
public class BMR {
    public static void main(String[] args)
    {   
Scanner in = new Scanner(System.in);

// ask for variables 

System.out.println("Enter your name: ");
String name = in.next();

System.out.println("Enter your gender (M or F): ");
String gender = in.next();

System.out.println("Enter your age: ");
Integer age = in.nextInt();

System.out.println("Height in inches: ");
Integer height = in.nextInt();

System.out.println("Weight in pounds: ");
Integer weight = in.nextInt();

// assigning / converting 

double kgWeight = weight / 2.20462; // weight to kg
double cmHeight = height / 0.39370; // height to cm

double BMR; // calling of BMR

char genderChar = gender.charAt(0);

boolean isMale = genderChar == 'M';

//final display 

System.out.print("\n\nCalculate your Basal Metabolism"); // double line space

System.out.println("\n\nName: " + name);
System.out.println("Gender: " + gender);
System.out.println("Age: " + age);

System.out.println("Weight (kg): " + Math.round(kgWeight*10.0)/10.0);

System.out.println("Height (cm): " + Math.round(cmHeight*10.0)/10.0);

if (isMale) { // no need to use the boolean, but I believe the 4.04 chapter utilizies it in Lecture Notes Part 3.
    // could just use if (genderChar == 'M'), to make it similar to the elseif. But this works.
    BMR = 66 + (13.7 * kgWeight) + (5 * cmHeight) - (6.8 * age);
    System.out.println("Basal Metabolic Rate: " + Math.round(BMR*10.0)/10.0 + " calories per day");
}
else if (genderChar == 'F') {
    BMR = 655 + (9.6 * kgWeight) + (1.8 * cmHeight) - (4.7 * age);
    System.out.println("Basal Metabolic Rate: " + Math.round(BMR*10.0)/10.0 + " calories per day");
}
else {
  System.out.println("Error: Please enter a valid gender for the determination of your Basal Metabolism.");
 // if genderChar is neither M or F
}

}
}
