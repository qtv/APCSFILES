/**
 * Program that contains the Constructor for Cube3 and redefines ToString
 * @author 
 * @date 4/26/15
 */

public class Cube3 extends Box3{
    public Cube3(int length, int width, int height)
    {
        super(width, width, width);
    }
    
    public String toString() {
        return "Cube - " + getWidth() + " X " + getWidth() +
                " X " + getWidth();
    }
    public boolean equals (Cube3 e) {
        if (getWidth() == e.getWidth()) {
            return true;
        }
        return false;
    }
}
