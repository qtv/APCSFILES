/**
 * 15.04 - Main abstract class that all other classes extend. 
 * @author 
 * 5/10/15
 */
public abstract class Homework3 implements Comparable<Homework3>{
    
    private int pagesRead; 
    private String typeHomework;
    
    public Homework3()
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
    
    public int compareTo(Homework3 homework) {
        if(pagesRead < homework.pagesRead)
            return -1;
        else if(pagesRead == homework.pagesRead)
            return 0;
        else
            return 1;
    }
    }

