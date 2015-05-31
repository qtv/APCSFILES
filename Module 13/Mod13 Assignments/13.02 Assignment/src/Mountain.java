/**
 * A program that establishes the constructor for the mountain.
 * @author 
 * @date 4/25/15
 */

public class Mountain extends Terrain
{
    private int NumMountains;
    
    public Mountain(int l, int w, int m)
    {
        super(l, w);
        NumMountains = m;
    }
    
    
    public int getMountains()
    {
        return NumMountains;
    }
}