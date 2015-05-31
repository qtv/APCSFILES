/**
 * 15.01 - Java constructor for the amount of homework.
 * @author 
 * 5/10/15
 */
public class MyJava extends Homework {
    public MyJava(){};
    
    public void createAssignment(int p)
    {
        setRead(p);
        setType("Java");    
    }
    
    public String toString()
    {
        return getType() + " to page " + getPage() ;
    }
}
