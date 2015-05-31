/**
 * 15.01 - Science constructor for the amount of homework.
 * @author 
 * 5/10/15
 */
public class MyScience extends Homework{
    public MyScience() {};
    
    public void createAssignment(int p)
    {
        setRead(p);
        setType("Science");    
    }
     
    public String toString()
    {
        return getType() + " to page " + getPage() ;
    }
}
