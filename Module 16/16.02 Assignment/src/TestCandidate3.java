/**
 * 16.01 Assignment - Uses an Array to display a candidate and their votes.
 * @author 
 * @date 5/23/15
 */
public class TestCandidate3 {

    public static void main(String[] args) {
    
        // candidate arraylist 
        Candidate3[] candidates = {
        new Candidate3("John Smith", 5000),
        new Candidate3("Mary Miller", 4000),
        new Candidate3("Michael Duffy", 6000),
        new Candidate3("Tim Robinson", 2500),
        new Candidate3("Joe Ashtony", 1800) ,
        new Candidate3("Mickey Jones", 3000),
        new Candidate3("Rebecca Morgan", 2000),
        new Candidate3("Kathleen Turner", 8000),
        new Candidate3("Tory Parker", 500),
        new Candidate3("Ashton Davis", 10000)};
        // print candidates
        
        //   printVotes(candidates);
        System.out.println("Original results:");
        printResults(candidates);
        
        // replace name
        replaceName(candidates, "Michael Duffy", "John Elmos");
        printResults(candidates);
        
        //replace votes
        replaceVotes(candidates, "Mickey Jones", 2500);
        printResults(candidates);
        
        //replace candidate
        replaceCandidate(candidates, "Kathleen Turner", "John Kennedy", 8500);
        printResults(candidates);
        
    }
    
    public static void printVotes (Candidate3[] c) {
        System.out.println("Results per candidate:");
        System.out.println("----------------------\n");
        
        for (Candidate3 i : c) {
            System.out.println(i.toString());
        }
    }
    
    public static double getTotal (Candidate3[] c) {
        double total = 0;
        for (Candidate3 i : c) {
            total = total + i.getVotes();
        }
        return total;
    }
    
    public static void printResults (Candidate3[] c ) {
        System.out.printf("\n%5s %31s %29s\n", "Candidate", "Votes Received", "% of Total Votes");
        
        double total = getTotal(c);
        
        for (Candidate3 i: c) {
            System.out.printf("%-15s                %-5d                         %-5.0f\n", i.getName(), i.getVotes(), (i.getVotes()/total) * 100);
        }
        System.out.println("\nThe total number of votes in the election: " + (int)total + "\n");
    }
    
    public static void replaceName (Candidate3[] c, String name, String newName) {
        
        System.out.println("Changing " + name + " to " + newName);
        
        for (int i = 0; c.length > i; i++) {
            
            if (name.equalsIgnoreCase(c[i].getName())) {
                int votes = c[i].getVotes();
                c[i] = new Candidate3(newName,votes); 
            }
       }
        }

    public static void replaceVotes (Candidate3[] c, String name, int newVotes) {
        System.out.println("Changing the votes for " + name + " to " + newVotes);
        for (int i = 0; c.length > i; i++) {
            if (name.equalsIgnoreCase(c[i].getName())) {
                String name1 = c[i].getName();
                c[i] = new Candidate3(name1, newVotes);
            }
        }
    }
    public static void replaceCandidate (Candidate3[] c, String name, String newName, int newVotes) {
        System.out.println("Replacing the candidate " + name + " with the candidate " + newName);
        for (int i = 0; c.length > i; i++) {
            if (name.equalsIgnoreCase(c[i].getName())) {
                c[i] = new Candidate3(newName, newVotes);
            }
}
    }
}
