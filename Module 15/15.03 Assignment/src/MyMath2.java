/**
 * 15.03 - Math constructor for the amount of homework.
 * @author 
 * 5/10/15
 */
public class MyMath2 extends Homework2 implements Processing{
    
    public MyMath2() {};
    
    public void createAssignment(int p)
    {
        setRead(p);
        setType("Math");    
    }
 
    public String toString()
    {
        return getType() + " to page " + getPage() ;
    } 
    
    public void doReading() {
    System.out.println("Before reading:");
    
    // ?? test. might have to include the method name somehow for toString.
    System.out.println(toString());
    System.out.println("After reading:");
    
    int num = getPage() - 2;
            System.out.println(getType() + " to page " + num);
    }
    
}

