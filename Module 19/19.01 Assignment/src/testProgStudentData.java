/**
 * @title 19.01 - assertions and exceptions, tests the student data file.
 * @author 
 * @date 5/26/15
 */
public class testProgStudentData {
    public static void main(String[] args) {
        double[] list = {89.00, 78.00, 95.00, 63.00, 94.00};
        StudentData john = new StudentData("John","Doe",list);
        System.out.println(john.toString(list));
        
        double[] list1 = {88.00,  90.00, 100.00, 88.00, 90.00, 100.00};
        StudentData lindsay = new StudentData("Lindsay","Green",list1);
        System.out.println(lindsay.toString(list1));
    }
}
