/**
 * Program that contains the Constructor for Box3 and redefines ToString
 * @author 
 * @date 4/26/15
 */

public class Box3 extends Rectangle3 {
    
// instance variables 
	private int height;

	/**
	 * Constructor for objects of class box
	 */
	public Box3 (int l, int w, int h)
	{
		// call superclass
		super(l, w);
	    // initialise instance variables
		height = h;
	}

	// return the height
	public int getHeight()
	{
		return height;
	}
        
        public String toString() {
            return "Box - " + getLength() + " X " + getWidth() + " X " + getHeight();
        }
        public boolean equals (Box3 e) {
            if (getLength() == e.getLength() & getWidth() == e.getWidth() &
                    height == e.getHeight()) {
                return true;
        }
        return false;
        }
}

