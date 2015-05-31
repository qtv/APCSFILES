/**
 * 15.01 - Math constructor for the amount of homework.
 * @author 
 * 5/10/15
 */
public class MyMath extends Homework{
    
    public MyMath() {};
    
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
