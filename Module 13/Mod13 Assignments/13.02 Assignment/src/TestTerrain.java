/**
 * A program that assigns values to the land constructors and displays them.
 * @author 
 * @date 4/25/15
 */

public class TestTerrain
{
    public static void main(String[] args)
    {
        Forest for1 = new Forest(100, 200, 100);
        Mountain mou1 = new Mountain(300, 400, 25);
        WinterMountain wm1 = new WinterMountain(500, 600, 15, 10.0);
        
        System.out.println("Forest " + for1.terrainSize() + " and has " + for1.getTrees() + " trees.");
        System.out.println("Mountain " + mou1.terrainSize() + " and has " + mou1.getMountains() + " mountains.");
        System.out.println("Winter Mountain " + wm1.terrainSize() + " and has temperature " + wm1.getTemp()+ " and " + wm1.getMountains() + " mountains.");
    }
}