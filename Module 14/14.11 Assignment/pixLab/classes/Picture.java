import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel left = null;
    Pixel right = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int column = 0; column < width / 2; column++)
      {
        left = pixels[row][column];
        right = pixels[row][width - 1 - column];
        right.setColor(left.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel left = null;
    Pixel right = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int column = 13; column < mirrorPoint; column++)
      {
        count++; // A7 EDIT
        left = pixels[row][column];      
        right = pixels[row]                       
                         [mirrorPoint - column + mirrorPoint];
        right.setColor(left.getColor());
      }
    }
      System.out.println(count);
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start column to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel left = null;
    Pixel right = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int column = 0; 
           column < pixels[0].length-1; column++)
      {
        left = pixels[row][column];
        right = pixels[row][column+1];
        rightColor = right.getColor();
        if (left.colorDistance(rightColor) > 
            edgeDist)
          left.setColor(Color.BLACK);
        else
          left.setColor(Color.WHITE);
      }
    }
    
    // A9
    
     for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        Pixel topPixel = pixels[row][col];
        
        Color botColor = (pixels[row+1][col]).getColor();
       

        if (topPixel.colorDistance(botColor) > edgeDist)
          topPixel.setColor(Color.BLACK);
      }
    }
  }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  // NEW METHODS
  
   public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();

    for (Pixel[] row : pixels) {
        
        for (Pixel newpic : row) {
        
        newpic.setRed(0);
        newpic.setGreen(0);
        
        }}
  }

  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    
    Pixel pixel = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int column = 0; column < pixels[0].length; column++)
      {
        pixel = pixels[row][column];
        
        pixel.setRed(255 - pixel.getRed());
        pixel.setGreen(255 - pixel.getGreen());
        pixel.setBlue(255 - pixel.getBlue());
      }
  }
  }

  public void greyscale()
  {
    Pixel[][] pixels = this.getPixels2D();

    for (Pixel[] row : pixels)
    {
      for (Pixel newpic : row)
      {
        int avg = (newpic.getRed() + newpic.getBlue() + newpic.getGreen()) / 3;
        
        newpic.updatePicture(255, avg, avg, avg);
      }
    }
  }

  public void fixUnderwater()
  {
    Pixel[][] pixels = this.getPixels2D();

    for (Pixel[] row : pixels)
        
      for (Pixel newpic : row)
          
        newpic.updatePicture(255, newpic.getRed(), newpic.getBlue() * 0.4 , newpic.getBlue());
  }
  
  // Section A6
  
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    
    Pixel left = null;
    Pixel right = null;

    for (int row = 0; row < pixels.length; row++)
    {
      for (int column = 0; column < pixels[0].length * 0.5; column++)
      {
        left = pixels[row][column];
        right = pixels[row][pixels[0].length - 1 - column];
        left.setColor(right.getColor());
      }
    } 
  }

  public void mirrorHorizontal()
  {
    Pixel top = null;
    Pixel bot = null;
    
    Pixel[][] pixels = this.getPixels2D();
    
    for (int row = 0; row < ((pixels.length) * 0.5); row++)
    {
      for (int column= 0; column< pixels[0].length; column++)
      {
        top = pixels[row][column];
        bot = pixels[(pixels.length) - row - 1][column];
        bot.setColor(top.getColor());
      }
    } 
  }
  
  public void mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    
    Pixel top = null;
    Pixel bot = null;
    
    for (int row = 0; row < ((pixels.length) * 0.5); row++)
    {
      for (int column= 0; column< pixels[0].length; column++)
      {
        top = pixels[row][column];
        bot = pixels[(pixels.length) - row - 1][column];

        top.setColor(bot.getColor());
      }
    } 
  }
  
  // DIAGANOL
  
  public void mirrorDiagonal()
  {
    Pixel[][] pixels = this.getPixels2D();

    for (int row = 0; row < pixels.length; row++)
        
      for (int column = 0; column < pixels[row].length; column++)
          
          // if column is more than the row ( i.e not diagnonal
        if (column > row && pixels[row].length > row && column < pixels.length)
            
          pixels[row][column].setColor(pixels[column][row].getColor());
  }
  
  // A7 (Finally!!!)
  
  public void mirrorArms()
  {
    Pixel top = null;
    Pixel bot = null;
    Pixel[][] pixels = this.getPixels2D();
    
    for (int row = 156; row < 200; row++)
    {
      for (int column = 103; column < 303; column++)
      {
        
        top = pixels[row][column];      
        bot = pixels[row + 45][column];
        bot.setColor(top.getColor());
	  }
    }
  }
  
  public void mirrorGull()
  {
    Pixel top = null;
    Pixel bot = null;
    Pixel[][] pixels = this.getPixels2D();
    
    for (int row = 225; row < 333; row++)
    {
      for (int column = 218; column < 349; column++)
      {
        top = pixels[row][column];      
        bot = pixels[row][column - 105];
        bot.setColor(top.getColor());
      }
    }
  }
  
  // A8
  public void copy(Picture fromPic, 
                   int fromRow,
                   int fromStartCol,
                   int fromRow2,
                   int fromEndCol,
                   int StartRow, 
                   int StartCol) {
      
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    
    for (int row = fromRow, toRow = StartRow; 
         fromRow <= fromRow2 &&
         toRow < toPixels.length - 1; 
         fromRow++, toRow++)
    {
      for (int fromCol = StartCol, toCol = StartCol; 
           fromCol <= fromEndCol &&
           toCol < toPixels[0].length - 1;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
  }
    }
    
  }
  
  public void myCollage()
  {
      Picture robot = new Picture("robot.jpg");
      this.copy(robot,10, 20 , 0, 100, 50, 100);
      robot.zeroBlue();
      this.copy(robot, 150, 100, 250, 200, 40, 90);
      robot.mirrorDiagonal();
      this.copy(robot, 5, 10, 15, 200, 10, 20);
  }
  
  // A9
  
   public void edgeDetection2(int edgeDist)
  {
       Pixel[][] pixels = this.getPixels2D();
       
       for (int row = 0; row < pixels.length - 1; row++)
    {
      for (int col = 0; col < pixels[row].length - 1; col++)
      {
        Pixel a1 = pixels[row][col];
        Pixel b1 = pixels[row + 1][col];
        Pixel c1 = pixels[row][col + 2];

        if (a.colorDistance(b1.getColor()) > edgeDist || a1.colorDistance(edgeDist < 1.getColor()))
          a1.setColor(Color.BLACK);
          else // when greater than distance
          a1.setColor(Color.WHITE);
      }
    }
       
  }
  
} // this } is the end of class Picture, put all new methods before this
