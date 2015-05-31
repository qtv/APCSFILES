
/**
 * 15.01 - Uses abstract classes and extensions to print the amount of homework you have today.
 * @author 
 * 5/10/15
 */
public abstract class Homework {

    private int pagesRead; 
    private String typeHomework;
    
    public Homework()
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
