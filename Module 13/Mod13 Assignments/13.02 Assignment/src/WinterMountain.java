/**
 * A program that establishes the constructor for the Winter Mountain.
 * @author 
 * @date 4/25/15
 */

public class WinterMountain extends Mountain
{
    private double temp;
    
    public WinterMountain(int l, int w, int m, double temp)
    {
        super(l, w, m);
        this.temp= temp;
    }
    
    
    public double getTemp()
    {
        return temp;
    }
}