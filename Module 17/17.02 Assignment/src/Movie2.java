/**
 * 17.02 - Constructor for movie class.
 * @author 
 * @date 5/24/15
 */
public class Movie2 {
    private String title, studio;
    private int year;
    
    public Movie2 (String title, int year, String studio) {
        this.title = title;
        this.year = year;
        this.studio = studio;
    }
    
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    public String getStudio() {
        return studio;
    }
    
    public String toString() {
        return title + ", " + year + ", " + studio;
    }
}
