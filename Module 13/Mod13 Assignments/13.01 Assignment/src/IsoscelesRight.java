/**
 * A program that establishes the constructor for the isosceles right triangle.
 * @author 
 * @date 4/24/15
 */
public class IsoscelesRight extends Triangle {
    
    public IsoscelesRight (double side) {
        super(side, side, (side * Math.sqrt(2)));
    }
}
