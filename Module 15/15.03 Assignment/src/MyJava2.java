/**
 * 15.03 - Java constructor for the amount of homework.
 * @author 
 * 5/10/15
 */
public class MyJava2 extends Homework2 implements Processing {
    public MyJava2(){};
    
    public void createAssignment(int p)
    {
        setRead(p);
        setType("Java");    
    }
    
    public String toString()
    {
        return getType() + " to page " + getPage() ;
    }

    
    public void doReading() {
    System.out.println("Before reading:");
    System.out.println(toString());
    System.out.println("After reading:");
    
    int num = getPage() - 4;
            System.out.println(getType() + " to page " + num);
    }
}
