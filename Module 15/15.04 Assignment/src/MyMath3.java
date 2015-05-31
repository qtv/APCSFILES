/**
 * 15.04 - Math constructor for the amount of homework.
 * @author 
 * 5/10/15
 */
public class MyMath3 extends Homework3{
    
    public MyMath3() {};
    
    public void createAssignment(int p)
    {
        setRead(p);
        setType("Math");    
    }
 
    public String toString()
    {
        return getType() + " to page " + getPage() ;
    } 
    
    
}

