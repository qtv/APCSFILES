/**
 * 15.04- Uses the abstract classes to print the amount of homework you have today,
 * as well as if one subject has more homework than another using the comparisons
 * of objects.
 * @author 
 * 5/10/15
 */


import java.util.ArrayList;

public class TestHomework3
{
    public static void main(String[]args)
{
        MyMath3 math = new MyMath3() {};
 
        math.createAssignment(4);
        
        MyScience3 science = new MyScience3() {};
        science.createAssignment(6);
        
        MyEnglish3 english = new MyEnglish3() {};
        english.createAssignment(4);
        
        MyJava3 java = new MyJava3() {};
        java.createAssignment(5);
        
        ArrayList<Homework3> homework = new ArrayList<Homework3>();
        
        homework.add(math);
        homework.add(science);
        homework.add(english);
        homework.add(java);
        
        for(Homework3 i : homework){
                        System.out.println(i.toString()); 
                }
        
        // comparing
        
        int compare = math.compareTo(english);
        
        if (compare == 0) {
            System.out.println(math.getType() + " and " + english.getType() + " are the same number of pages.");
        }
        else if(compare == 1) {
            System.out.println(math.getType() + " has more pages to read than " + english.getType()); }
        else {
            System.out.println(math.getType() + " has less pages to read than " + english.getType());    
        }
    }
}

