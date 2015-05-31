
import java.util.ArrayList;

/**
 * 16.01 Assignment - Uses an ArrayList to display a candidate and their votes.
 * @author 
 * @date 5/23/15
 */
public class TestCandidate2{
    public static void main(String[] args) {
        ArrayList<Candidate> candidates = new ArrayList<Candidate>();
        
        Candidate john = new Candidate("John Smith", 5000);
        
        Candidate mary = new Candidate("Mary Miller", 4000);
        Candidate michael = new Candidate("Michael Duffy", 6000);
        Candidate tim = new Candidate("Tim Robinson", 2500);
        Candidate joe = new Candidate("Joe Ashtony", 1800);
        
        candidates.add(john);
        candidates.add(mary);
        candidates.add(michael);
        candidates.add(tim);
        candidates.add(joe);
        
        // print candidates
        
        printVotes(candidates);
        // print results
        printResults(candidates);
        
    }
    
    public static void printVotes (ArrayList<Candidate> c) {
        System.out.println("Results per candidate:");
        System.out.println("----------------------\n");
        
        for (Candidate i : c) {
            System.out.println(i.toString());
        }
    }
    
    public static double getTotal (ArrayList<Candidate> c) {
        double total = 0;
        for (Candidate i : c) {
            total = total + i.getVotes();
        }
        return total;
    }
    
    public static void printResults (ArrayList<Candidate> c) {
        System.out.printf("\n%5s %31s %29s\n", "Candidate", "Votes Received", "% of Total Votes");
        
        double total = getTotal(c);
        
        for (Candidate i: c) {
            System.out.printf("%-15s                %5d                         %-5.0f\n", i.getName(), i.getVotes(), (i.getVotes()/total) * 100);
        }
        System.out.println("\nThe total number of votes in the election: " + (int)total);
    }
    }

