/**
 * 15.01 - Uses abstract classes and extensions to print the amount of homework you have today.
 * @author 
 * 5/10/15
 */
import java.util.ArrayList;

public class testHomework
{
    public static void main(String[]args)
{
        MyMath math = new MyMath() {};
 
        math.createAssignment(4);
        
        MyScience science = new MyScience() {};
        science.createAssignment(6);
        
        MyEnglish english = new MyEnglish() {};
        english.createAssignment(10);
        
        MyJava java = new MyJava() {};
        java.createAssignment(5);
        
        ArrayList<Homework> homework = new ArrayList<Homework>();
        
        homework.add(math);
        homework.add(science);
        homework.add(english);
        homework.add(java);
        
        System.out.println(math.toString());
        System.out.println(english.toString());
        System.out.println(science.toString());
        System.out.println(java.toString());
 
    }
}