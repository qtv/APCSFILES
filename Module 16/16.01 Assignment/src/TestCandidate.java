/**
 * 16.01 Assignment - Uses an Array to display a candidate and their votes.
 * @author 
 * @date 5/23/15
 */
public class TestCandidate {

    public static void main(String[] args) {
    
        // candidate arraylist 
        Candidate[] candidates = {
        new Candidate("John Smith", 5000),
        new Candidate("Mary Miller", 4000),
        new Candidate("Michael Duffy", 6000),
        new Candidate("Tim Robinson", 2500),
        new Candidate("Joe Ashtony", 1800) };
    
        // print candidates
        
        printVotes(candidates);
        // print results
        printResults(candidates);
        
    }
    
    public static void printVotes (Candidate[] c) {
        System.out.println("Results per candidate:");
        System.out.println("----------------------\n");
        
        for (Candidate i : c) {
            System.out.println(i.toString());
        }
    }
    
    public static double getTotal (Candidate[] c) {
        double total = 0;
        for (Candidate i : c) {
            total = total + i.getVotes();
        }
        return total;
    }
    
    public static void printResults (Candidate[] c ) {
        System.out.printf("\n%5s %31s %29s\n", "Candidate", "Votes Received", "% of Total Votes");
        
        double total = getTotal(c);
        
        for (Candidate i: c) {
            System.out.printf("%-15s                %5d                         %-5.0f\n", i.getName(), i.getVotes(), (i.getVotes()/total) * 100);
        }
        System.out.println("\nThe total number of votes in the election: " + (int)total);
    }
}
