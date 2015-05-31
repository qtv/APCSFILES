/**
 * 15.03 - Main abstract class that all other classes extend. 
 * @author 
 * 5/10/15
 */
public abstract class Homework2 implements Processing{
    
    private int pagesRead; 
    private String typeHomework;
    
    public Homework2()
    {
        pagesRead = 0 ;
        typeHomework = "";
    }
    public void setRead(int page)
    {
       pagesRead = page;
    }
 
    public abstract void createAssignment(int p);
    
    public int getPage()
    {
        return pagesRead;
    }
 
 
    public void setType(String typeHomework)
    {
        this.typeHomework = typeHomework;
    }
 
    public String getType()
    {
        return typeHomework;
    }
}
