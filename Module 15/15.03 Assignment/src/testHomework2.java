/**
 * 15.03 - Uses the abstract classes to print the amount of homework you have today,
 * as well as the amount of homework you will have after it's done.
 * @author 
 * 5/10/15
 */


import java.util.ArrayList;

public class testHomework2
{
    public static void main(String[]args)
{
        MyMath2 math = new MyMath2() {};
 
        math.createAssignment(4);
        
        MyScience2 science = new MyScience2() {};
        science.createAssignment(6);
        
        MyEnglish2 english = new MyEnglish2() {};
        english.createAssignment(10);
        
        MyJava2 java = new MyJava2() {};
        java.createAssignment(5);
        
        ArrayList<Homework2> homework = new ArrayList<Homework2>();
        
        homework.add(math);
        homework.add(science);
        homework.add(english);
        homework.add(java);
        
        for(Homework2 i : homework){
                        i.doReading();   
                }
    }
}

