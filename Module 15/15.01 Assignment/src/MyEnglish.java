/**
 * 15.01 - English constructor for the amount of homework.
 * @author 
 * 5/10/15
 */
public class MyEnglish extends Homework{
    
    public MyEnglish(){};
    
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
