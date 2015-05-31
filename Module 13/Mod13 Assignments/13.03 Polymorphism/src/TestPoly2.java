
import java.util.ArrayList;

/**
 * This program utilizes polymorphism to display the center of different shapes.
 * @author 
 * @date 4/25/15
 */
public class TestPoly2 {

    public static void main(String[] args) {
        
        ArrayList<Circle2> shapes = new ArrayList<Circle2>();
        
        Circle2 cir1= new Circle2 (2,4,1);
        Cylinder2 cyl1 = new Cylinder2 (10,15,1,1);
        Oval2 ova1 = new Oval2(25,10,5,4);
        OvalCylinder2 ovac1 = new OvalCylinder2(40, 10, 3, 4, 20);
        
        shapes.add(cir1);
        shapes.add(cyl1);     
        shapes.add(ova1);
        shapes.add(ovac1);
        
        for (int i =0; i < shapes.size(); i++) {
            showCenter(shapes.get(i));
        }
    }
    
    public static void showCenter(Circle2 e) {
        System.out.println("For " + e + " " + e.center());
    }
    
}
