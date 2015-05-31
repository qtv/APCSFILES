/**
 * A program that displays all the dimensions of the shapes.
 * @author 
 * @date 4/24/15
 */
public class TestCube {
    public static void main(String[] args)
	{ 
            Rectangle ones = new Rectangle(2,4);
            Box two = new Box(4,10,4);
            Cube three = new Cube (4,4,4);
            System.out.println("One's dimensions are " + ones.getLength() + " X " 
                    + ones.getWidth());
            System.out.println("\nCube's dimensions are " + three.getHeight() + " X " 
                    + three.getLength() + " X " +  three.getWidth());
            
        }
}
