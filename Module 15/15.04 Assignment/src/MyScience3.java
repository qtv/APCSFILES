/**
 * 15.04 - Science constructor for the amount of homework.
 * @author 
 * 5/10/15
 */
public class MyScience3 extends Homework3{
    public MyScience3() {};
    
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


