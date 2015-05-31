/**
 * 15.03 - English constructor for the amount of homework.
 * @author 
 * 5/10/15
 */

public class MyEnglish2 extends Homework2 implements Processing {
    
    public MyEnglish2(){};
    
     public String toString()
    {
        return getType() + " to page " + getPage() ;
    }
      
    public void createAssignment(int p)
    {
        setRead(p);
        setType("English");    
    }
    
    public void doReading() {
    System.out.println("Before reading:");
    System.out.println(toString());
    System.out.println("After reading:");
    
    int num = getPage() - 1;
            System.out.println(getType() + " to page " + num);
    }
    
}
