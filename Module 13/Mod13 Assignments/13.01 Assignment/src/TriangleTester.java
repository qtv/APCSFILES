/**
 * A program that calculates and displays all the sides of the triangles.
 * @author 
 * @date 4/24/15
 */
public class TriangleTester {
    

      public static void main(String[] args)
    {
        Triangle triangle = new Triangle(4.0,5.0,6.0);
        Equilateral equilateral = new Equilateral(5.0);
        IsoscelesRight isosright = new IsoscelesRight(1.5);
        
        System.out.println("Triangle has sides A = " + triangle.getSideA() + " B = "
                + triangle.getSideB()
                + " C = " + triangle.getSideC());
                
        System.out.println("Equilateral Triangle has sides A = " + equilateral.getSideA() + " B = " 
                + equilateral.getSideB()
                + " C = " + equilateral.getSideC());
        
        System.out.println("Isosceles Right Triangle has sides A = " + isosright.getSideA() + " B = " 
                + isosright.getSideB()
                + " C = " + isosright.getSideC());
}
}
