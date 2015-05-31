/**
 * 15.04 - Java constructor for the amount of homework.
 * @author 
 * 5/10/15
 */
public class MyJava3 extends Homework3 {
    public MyJava3(){};
    
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
