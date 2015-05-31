/**
 * A program to calculate the average of test scores by assigning values to user-defined variables.
 * * Created by: 
 * Date: 11/06/14
 */
public class GradesV2
{
    public static void main(String[ ] args)
    {
     //local variables
     	int numTests = 0;	// counts number of tests
     	int testGrade = 0;	//individual test grade
     	int totalPoints = 0;	//total points for all tests
     	double average = 0.0;	//average grade
     
        
     //Calculations
        
     //Test 1
        numTests++;
        
        testGrade = 97;
        
        totalPoints += testGrade;
        
        average = (double)totalPoints / (double)numTests;
        
        System.out.println("n = " + numTests + "  New Test Grade: "+testGrade + "  Total Points: "+ totalPoints+ "  Average Score: "+ average);
     //Test 2
        numTests++;
        
        testGrade = 79;
        
        totalPoints += testGrade;
        
        average = (double)totalPoints / (double)numTests;
        
        System.out.println("n = " + numTests + "  New Test Grade: "+testGrade + "  Total Points: "+ totalPoints+ "  Average Score: "+ average);
     
    //Test 3
        numTests++;
        
        testGrade = 83;
        
        totalPoints += testGrade;
        
        average = (double)totalPoints / (double)numTests;
        
        System.out.println("n = " + numTests + "  New Test Grade: "+testGrade + "  Total Points: "+ totalPoints+ "  Average Score: "+ average);
    
     //Test 4
        numTests++;
        
        testGrade = 88;
        
        totalPoints += testGrade;
        
        average = (double)totalPoints / (double)numTests;
        
        System.out.println("n = " + numTests + "  New Test Grade: "+testGrade + "  Total Points: "+ totalPoints+ "  Average Score: "+ average);
    }//end of main method
}//end of class

