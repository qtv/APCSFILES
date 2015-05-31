/**
 * 17.02 - Tester for movie class that includes methods to alter arrays but also
 * establishes a new array that has been sorted.
 * @author 
 * @date 5/24/15
 */
public class TestMovie2 {

    
    public static void main(String[] args) {
        
    Movie2[] myMovies = new Movie2[10];
    myMovies[0] = new Movie2("The Muppets Take Manhattan", 2001, "Columbia Tristar");
    myMovies[1] = new Movie2("Mulan Special Edition", 2004, "Disney");
    myMovies[2] = new Movie2("Shrek 2", 2004, "Dreamworks");
    myMovies[3] = new Movie2("The Incredibles", 2004, "Pixar");
    myMovies[4] = new Movie2("Nanny McPhee", 2006, "Universal");
    myMovies[5] = new Movie2("The Curse of the Were-Rabbit", 2006, "Aardman");
    myMovies[6] = new Movie2("Ice Age", 2002, "20th Century Fox");
    myMovies[7] = new Movie2("Lilo & Stitch", 2002, "Disney");
    myMovies[8] = new Movie2("Robots", 2005, "20th Century Fox");
    myMovies[9] = new Movie2("Monsters Inc", 2001, "Pixar");
    
    // print movies
        System.out.println("Before sorting:");
        printMovies(myMovies);
        
    // sorting
        printMovies(sortTitles(myMovies, 1));
    // by year
        printMovies(sortYears(myMovies, 2));
    // by studio
        printMovies(sortStudios(myMovies, 1));
    }
    
    public static void printMovies (Movie2[] m) {
        for (Movie2 i : m) {
            System.out.println(i.toString());
        }
    }
    
    public static Movie2[] sortTitles(Movie2[] m, int ascordec) {
        Movie2[] dest = new Movie2[m.length];
        if(ascordec==1)
        {
            System.out.println("\nSorted by title - ascending:");
            for(int i=0;i< m.length;i++)
            {
                Movie2 next = m[i];
                int insertindex = 0;
                int k =i;
                
                while(k>0 && insertindex == 0)
                {
                    if(next.getTitle().compareTo( dest[k-1].getTitle() ) > 0)
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
            System.out.println("\nSorted by title - descending:");
            for(int i=0;i<m.length;i++)
            {
                Movie2 next = m[i];
                int insertindex = 0;
                int k =i
                        ;
                while(k>0 && insertindex == 0)
                {
                    if(next.getTitle().compareTo( dest[k-1].getTitle() ) < 0)
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
    public static Movie2[] sortYears(Movie2[] m, int ascordec){
        Movie2[] dest = new Movie2[m.length];
        if(ascordec==1)
        {
            System.out.println("\nSorted by year - ascending:");
            for(int i=0;i< m.length;i++)
            {
                Movie2 next = m[i];
                int insertindex = 0;
                int k =i;
                
                while(k >0 && insertindex == 0)
                {
                    if (next.getYear() < dest[k-1].getYear() )
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
            System.out.println("\nSorted by year - descending:");
            for(int i=0;i<m.length;i++)
            {
                Movie2 next = m[i];
                int insertindex = 0;
                int k =i
                        ;
                while(k>0 && insertindex == 0)
                {
                    if (next.getYear() < dest[k-1].getYear() )
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
     public static Movie2[] sortStudios(Movie2[] m, int ascordec) {
        Movie2[] dest = new Movie2[m.length];
        if(ascordec==1)
        {
            System.out.println("\nSorted by studio - ascending:");
            for(int i=0;i< m.length;i++)
            {
                Movie2 next = m[i];
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
                Movie2 next = m[i];
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
