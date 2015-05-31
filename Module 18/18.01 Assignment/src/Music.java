/**
 * @title 18.01 - constructor for the Music object.
 * @author 
 * @date 5/26/15
 */
public class Music {
    private String title, singer;
    private int year;
    
    public Music (String title, int year, String singer) {
        this.title = title;
        this.year = year;
        this.singer = singer;
    }
    
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    public String getSinger() {
        return singer;
    }
    public String toString() {
          return title + ", " + year + ", " + singer;
    }
 }
