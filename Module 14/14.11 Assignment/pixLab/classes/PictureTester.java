/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */

public class PictureTester
{
    
    
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  // tests keep only blue
  public static void testKeepOnlyBlue()
  {
    Picture beach2 = new Picture("beach.jpg");
    beach2.explore();
    beach2.keepOnlyBlue();
    beach2.explore();
  }
  
  public static void testNegate()
  {
    Picture kitten2 = new Picture("kitten2.jpg");
    kitten2.explore();
    kitten2.negate();
    kitten2.explore();
  }
  
  public static void testGrayscale()
  {
    Picture gorge = new Picture("gorge.jpg");
    gorge.explore();
    gorge.greyscale();
    gorge.explore();
  }
  
  public static void testFixUnderwater()
  {
    Picture water = new Picture("water.jpg");
    water.explore();
    water.fixUnderwater();
    water.explore();
  }
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  // NEW MIRRORS
  
  public static void testMirrorVerticalRightToLeft()
  {
    Picture barbara = new Picture("barbaraS.jpg");
    barbara.explore();
    barbara.mirrorVerticalRightToLeft();
    barbara.explore();
  }

  public static void testMirrorHorizontal()
  {
    Picture koala = new Picture("koala.jpg");
    koala.explore();
    koala.mirrorHorizontal();
    koala.explore();
  }
  
  /** Method to test mirrorHorizontalBotToTop */
  public static void testMirrorHorizontalBotToTop()
  {
    Picture rmotorcycle = new Picture("redMotorcycle.jpg");
    rmotorcycle.explore();
    rmotorcycle.mirrorHorizontalBotToTop();
    rmotorcycle.explore();
  }
  
  // END NEW MIRRORS
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  // TEST MIRROR DIAGANOL
  
  public static void testMirrorDiagonal()
  {
    Picture swan2 = new Picture("swan.jpg");
    swan2.explore();
    swan2.mirrorDiagonal();
    swan2.explore();
  }
  
  public static void testMirrorArms()
  {
    Picture snowman = new Picture("snowman.jpg");
	snowman.mirrorArms();
    snowman.explore();
  }

  public static void testMirrorGull()
  {
    Picture gull = new Picture("seagull.jpg");
    gull.explore();
    gull.mirrorGull();
    gull.explore();
  }
  
  // A9
  
    public static void testCopy()
  {
    Picture lenna = new Picture("lenna.jpg");
    Picture seagull = new Picture("seagull.jpg");
    
    
    seagull.explore();
    lenna.explore();
    lenna.copy(seagull, 5, 10, 25, 90, 45, 34);
    lenna.explore();
  }

  public static void testMyCollage()
  {
    Picture robot = new Picture("robot.jpg");
    robot.myCollage();
    robot.explore();
  }

  public static void testEdgeDetection2()
  {
    Picture lenna = new Picture("lenna.jpg");
    lenna.edgeDetection2(18);
    lenna.explore();
  }
  
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}