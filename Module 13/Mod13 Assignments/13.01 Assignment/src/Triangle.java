/**
 * A program that establishes the constructor for the triangle.
 * @author 
 * @date 4/24/15
 */
public class Triangle {
    
    //instance variables
    
    private double sideA, sideB, sideC;
    
    public Triangle(double sideA, double sideB, double sideC) {
        // so I can name them the same (sideA, sideB, etc. I used "this"
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    
    // get methods (public)
    public double getSideA() {
        return sideA;
    }
     public double getSideB()
    {
        return sideB;
    }
    
    public double getSideC()
    {
        return sideC;
    }
}
