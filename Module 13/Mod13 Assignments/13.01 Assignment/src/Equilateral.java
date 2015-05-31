/**
 * A program that establishes the constructor for the equilateral triangle.
 * @author 
 * @date 4/24/15
 */
public class Equilateral extends Triangle {
    
    public Equilateral (double equalSide) {
        // sets all sides to the same length using the format of the triangle structure
        super(equalSide,equalSide,equalSide);
    }
}
