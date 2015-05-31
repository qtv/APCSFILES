/**
 * A program that establishes the constructor for the Forest
 * @author 
 * @date 4/25/15
 */

public class Forest extends Terrain
{
    
    private int trees;
    
    public Forest(int l, int w, int t)
    {
        super(l, w);
        trees = t;
    }
    
    
    public int getTrees()
    {
        return trees;
    }
}