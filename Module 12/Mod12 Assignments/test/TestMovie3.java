/**
 * 17.02 - Tester for movie class that includes methods to alter arrays but also
 * establishes a new array that has been sorted.
 * @author 
 * @date 5/24/15
 */
public class TestMovie3 {

    
    public static void main(String[] args) {
        
    Movie3[] myMovies = new Movie3[10];
    myMovies[0] = new Movie3("The Muppets Take Manhattan", 2001, "Columbia Tristar");
    myMovies[1] = new Movie3("Mulan Special Edition", 2004, "Disney");
    myMovies[2] = new Movie3("Shrek 2", 2004, "Dreamworks");
    myMovies[3] = new Movie3("The Incredibles", 2004, "Pixar");
    myMovies[4] = new Movie3("Nanny McPhee", 2006, "Universal");
    myMovies[5] = new Movie3("The Curse of the Were-Rabbit", 2006, "Aardman");
    myMovies[6] = new Movie3("Ice Age", 2002, "20th Century Fox");
    myMovies[7] = new Movie3("Lilo & Stitch", 2002, "Disney");
    myMovies[8] = new Movie3("Robots", 2005, "20th Century Fox");
    myMovies[9] = new Movie3("Monsters Inc", 2001, "Pixar");
    
    // print movies
        System.out.println("Before sorting:");
        printMovies(myMovies);
        
    // sorting
        sortTitles(myMovies, 1);
    // by year
        sortYears(myMovies, 2);
    // by studio
        printMovies(sortStudios(myMovies, 1));
    }
    
    public static void printMovies (Movie3[] m) {
        for (Movie3 i : m) {
            System.out.println(i.toString());
        }
    }
    
    public static void sortTitles(Movie3[] m, int ascordec) {
        int i;
        int k;
        int posmax;
        Movie3 temp;
        
        if(ascordec==1)
        {
            System.out.println("\nSorted by title - ascending:");
            for(i= m.length - 1; i > 0; i--)
            {
                posmax = 0;
                for (k = 0; k <=i; k++)
                    if (m[k].getTitle().compareTo(m[posmax].getTitle()) > 0)
                    {
                        posmax = k;
                    }
                    temp = m[i];
                    m[i] = m[posmax];
                    m[posmax] = temp;
                    System.out.println(temp);
            }
            
        }
        if(ascordec==2)
        {
            System.out.println("\nSorted by title - descending:");
            for(i= m.length - 1; i > 0; i--)
            {
                posmax = 0;
                for (k = 0; k <=i; k++)
                    if (m[k].getTitle().compareTo(m[posmax].getTitle()) < 0)
                    {
                        posmax = k;
                    }
                    temp = m[i];
                    m[i] = m[posmax];
                    m[posmax] = temp;
                    System.out.println(temp);
                    
            }
        }
    }
    public static void sortYears(Movie3[] m, int ascordec){
        int i;
        int k;
        int posmax;
        
        Movie3 temp;
        
        if(ascordec==1)
        {
            System.out.println("\nSorted by year - ascending:");
            for(i= m.length - 1; i >= 0; i--)
            {
                posmax = 0;
                for (k = 1; k <=i; k++)
                    if (m[k].getYear() > m[posmax].getYear())
                    {
                        posmax = k;
                    }
                
                    temp = m[i];
                    m[i] = m[posmax];
                    m[posmax] = temp;
                    System.out.println(temp);
                    
            }
        }
        else if (ascordec==2)
        {
            System.out.println("\nSorted by year - descending:");
            for(i= m.length - 1; i >= 0; i--)
            {
                posmax = 0;
                for (k = 1; k <=i; k++)
                    if (m[k].getYear() < m[posmax].getYear())
                    {
                        posmax = k;
                    }
                    temp = m[i];
                    m[i] = m[posmax];
                    m[posmax] = temp;
                    System.out.println(temp);
                    
            }
        }
    }
     public static Movie3[] sortStudios(Movie3[] m, int ascordec) {
        Movie3[] dest = new Movie3[m.length];
        if(ascordec==1)
        {
            System.out.println("\nSorted by studio - ascending:");
            for(int i=0;i< m.length;i++)
            {
                Movie3 next = m[i];
                int insertindex = 0;
                int k =i;
                
                while(k >0 && insertindex == 0)
                {
                    if (next.getStudio().compareTo(dest[k-1].getStudio()) > 0 )
                    {
                        insertindex = k;
                    }
                    else
                    {
                        dest[k] = dest[k-1];
                    }
                    k--;
                }
                dest[insertindex]=m[i];
            }
            return dest;
        }
        else if (ascordec==2)
        {
            System.out.println("\nSorted by studio - descending:");
            for(int i=0;i<m.length;i++)
            {
                Movie3 next = m[i];
                int insertindex = 0;
                int k =i
                        ;
                while(k>0 && insertindex == 0)
                {
                    if (next.getStudio().compareTo(dest[k-1].getStudio()) < 0 )
                    {
                        insertindex = k;
                    }
                    else
                    {
                        dest[k] = dest[k-1];
                    }
                    k--;
                }
                dest[insertindex]=m[i];
            }
            return dest;
        }
        else
        {
            return dest;
        }
     }
    }
