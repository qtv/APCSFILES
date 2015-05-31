/**
 * Program that contains the Constructor for Rectangle3 and redefines ToString
 * @author 
 * @date 4/26/15
 */

public class Rectangle3
{
    // instance variables 
	private int length;
	private int width;

	/**
	 * Constructor for objects of class rectangle
	 */
	public Rectangle3(int l, int w)
	{
		// initialise instance variables
		length = l;
		width = w;
	}

	// return the height
	public int getLength()
	{
		return length;
	}
	public int getWidth()
	{
	    return width;
	}
    
        public String toString(){
        return "Rectangle - " + length + " X " + width;
        }
    
         public boolean equals(Rectangle3 e)
        {
        if (length == e.getLength() & width == e.getWidth()){
                return true;
        }
        return false;
        }
    
        }