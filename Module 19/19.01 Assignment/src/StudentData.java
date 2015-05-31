/**
 * @title 19.01 - Prints a persons grade and finds the average.
 * @author 
 * @date 5/26/15
 */
public class StudentData {
private String firstName, lastName;
private double testScores[];
private char grade;

public StudentData (String firstName, String lastName, double testScores[]) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.testScores = testScores;
    this.grade = courseGrade(testScores);
    }
public String getLastName(){
    return lastName;
}
public String getFirstName(){
    return firstName;
}
	
public double[] getTestScores(){
    return testScores;
}
public char getGrade() {
   return grade;
}
public String toString(double[] list)
    {
        
        String s = firstName + "     " + lastName + "     ";
        return s + gradeList(list) + "  " + getGrade();
    }
// prints array properly
public String gradeList (double[] list ) {
    String e ="";
    for (int i = 0; i < list.length; i++) {
        e += list[i] + "  ";
    }
    return e;
}
public char courseGrade(double[] list)
    {
        // find average
        
        double average = 0;
        for (int i = 0; i < list.length; i++) {
            average = average + list[i];
        }
        
        average = average / (list.length);
        if (average >= 90) {
            return 'A';
        }
        else if (average <= 90 && average >= 80) {
            return 'B';
        }
        else if (average <= 80 && average >=70) {
        return 'C';
        }
        else if (average <=70 && average >= 60) {
            return 'D';
        }
        else return 'F';
    }
}
