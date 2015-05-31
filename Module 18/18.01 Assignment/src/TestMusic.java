/**
 * @title 18.01 - searches an array for artists, song titles, etc.
 * @author 
 * @date 5/26/15
 */
public class TestMusic
{
public static Music[] myMusic = new Music[10];
    

    public static void main(String[] args)
    {
        myMusic[0] = (new Music("Pieces of You",1994, "Jewel"));
        myMusic[1] = (new Music("Jagged Little Pill",1995, "Alanis Morissette"));
        myMusic[2] = (new Music("What If It's You",1995, "Reba McEntire"));
        myMusic[3] = (new Music("Misunderstood",2001, "Pink"));
        myMusic[4] = (new Music("Laundry Service",2001, "Shakira"));
        myMusic[5] = (new Music("Taking the Long Way",2006, "Dixie Chicks"));
        myMusic[6] = (new Music("Under My Skin",2004, "Avril Lavigne"));
        myMusic[7] = (new Music("Let Go",2002, "Avril Lavigne"));
        myMusic[8] = (new Music("Let It Go",2007, "Tim McGraw"));
        myMusic[9] = (new Music("White Flag",2004, "Dido"));
        
         System.out.println("Music library:");
         System.out.println("--------------");
         printMusic(myMusic);
         
         System.out.println();
         System.out.println("Search - Title - Let Go");
         searchTitle(myMusic, "Let Go");
         
         System.out.println();
         System.out.println("Search - Title - Some Day");
         searchTitle(myMusic, "Some Day");
         
         System.out.println();
         System.out.println("Search - Year - 2001");        
         searchYear(myMusic, 2001);
         
         System.out.println();
         System.out.println("Search - Year - 2003");
         searchYear(myMusic, 2003);
         
         System.out.println();
         System.out.println("Search - Singer - Avril Lavigne");
         searchSinger(myMusic, "Avril Lavigne");
         
         System.out.println();
         System.out.println("Search - Singer - Tony Curtis");
         searchSinger(myMusic, "Tony Curtis");     
    }
    
    public static void printMusic(Music [] m)
    {
        for (Music i: m) {
            System.out.println(i.toString());
        }
    }
    public static void searchTitle(Music[] m, String title)

    {

        int found = 0;

        for(Music i : m)

            {
                if(title.equalsIgnoreCase(i.getTitle())){
                    System.out.println("We found " + title + " in the library:");
                    System.out.println(i);
                    found++;}}
        
        if(found == 0)
            System.out.println(title + " is not in the library.");
    }
    public static void searchYear(Music[] m, int year)
    {
        int found = 0;
        System.out.println("Find results:");
        
        for(Music i : m)
        {if(i.getYear() == year){
            
            System.out.println(i);
            found++;
        }}
        if(found == 0)
        {
            System.out.println("There are no listings for " + year);
        }
        
        else
        {
            System.out.println("There were " + found + " listings for " + year);
        }
    }



    public static void searchSinger(Music[] m, String singer)
    {
    int found = 0;

    System.out.println("Find results:");
    for(Music i : m)
    {
        if(i.getSinger().equals(singer))
        {
            System.out.println(i);
            found++;
        }
    }
    if(found == 0)
    {
        System.out.println("There are no listings for " + singer);
    }
    else
    {
        System.out.println("There were " + found + " listings for " + singer);
    }
    }

    }

