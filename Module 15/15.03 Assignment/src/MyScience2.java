/**
 * 15.03 - Science constructor for the amount of homework.
 * @author 
 * 5/10/15
 */
public class MyScience2 extends Homework2 implements Processing{
    public MyScience2() {};
    
    public void createAssignment(int p)
    {
        setRead(p);
        setType("Science");    
    }
     
    public String toString()
    {
        return getType() + " to page " + getPage() ;
    }
    
    public void doReading() {
    System.out.println("Before reading:");
    System.out.println(toString());
    System.out.println("After reading:");
    
    int num = getPage() - 3;
            System.out.println(getType() + " to page " + num);
    }
}


