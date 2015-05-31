/**
 * 15.04 - English constructor for the amount of homework.
 * @author 
 * 5/10/15
 */

public class MyEnglish3 extends Homework3 {
    
    public MyEnglish3(){};
    
     public String toString()
    {
        return getType() + " to page " + getPage() ;
    }
      
    public void createAssignment(int p)
    {
        setRead(p);
        setType("English");    
    }
    
}
