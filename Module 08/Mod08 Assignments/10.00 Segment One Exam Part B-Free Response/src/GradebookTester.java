import java.util.ArrayList;

class RectangleStats
{ 

   
// Private instance variables

// length is an ArrayList which will contain integer values, width is an array which will contain integer

    ArrayList<Integer> length = new ArrayList<Integer>();
    private int[] width;
    private double [] area;
    
// code for constructor goes here
 RectangleStats(ArrayList<Integer> intLength, int[] intWidth) {
     this.width = intWidth;  
     this.length = intLength;
     this.area = new double [this.width.length]; // defines size of array
    }


// The calcRectangleArea() method calculates the area of rectangles using the length and

// the width assigned to the private instance variables and assigns the results to the area array of type

// double. This method does not return anything.

    void calcRectangleArea(){
        for(int i=0; i<width.length; i++){
            area[i] = length.get(i) * width[i];
        }
    }


// The printArea() method prints the values assigned to the area array using the most appropriate

// type of loop. This method does not return anything.


// code for the printArea() method goes here

     public void printArea(){
        calcRectangleArea(); // void type requires this to be called
        
        for(int i=0; i<area.length; i++){
            System.out.println("Area " + i + " : " + area[i]);
        }
    }

}


// The RectangleStatsTesterClass assigns the length of two rectangles to an ArrayList and assigns the
// width of two rectangles to an array. The calcRectangleArea() and printArea() methods are invoked to
// calculate and print the area of the two rectangles.
public class RectangleStatsTesterClass2 
{ 
public static void main(String[] args)

{

ArrayList<Integer> intLength = new ArrayList<Integer>();

intLength.add(7);

intLength.add(5);

int [ ] intWidth = {3, 4};



RectangleStats rectStats = new RectangleStats(intLength, intWidth);

rectStats.calcRectangleArea();

rectStats.printArea();

}

}
