
import java.util.ArrayList;

/**
 * 16.02 Assignment - Uses an ArrayList to display a candidate and their votes.
 * @author 
 * @date 5/23/15
 */
public class TestCandidate4 {

    public static void main(String[] args) {
    
        ArrayList<Candidate3> candidates = new ArrayList<Candidate3>();
        
        Candidate3 john = new Candidate3("John Smith", 5000);
        Candidate3 mary = new Candidate3("Mary Miller", 4000);
        Candidate3 michael = new Candidate3("Michael Duffy", 6000);
        Candidate3 tim = new Candidate3("Tim Robinson", 2500);
        Candidate3 joe = new Candidate3("Joe Ashtony", 1800);
        Candidate3 mickey = new Candidate3("Mickey Jones", 3000);
        Candidate3 rebecca = new Candidate3("Rebecca Morgan", 2000);
        Candidate3 kathleen = new Candidate3("Kathleen Turner", 8000);
        Candidate3 tory = new Candidate3("Tory Parker", 500);
        Candidate3 ashton = new Candidate3("Ashton Davis", 10000);
        
        candidates.add(john);
        candidates.add(mary);
        candidates.add(michael);
        candidates.add(tim);
        candidates.add(joe);
        candidates.add(mickey);
        candidates.add(rebecca);
        candidates.add(kathleen);
        candidates.add(tory);
        candidates.add(ashton);
        
        
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
    
    public static void printVotes (ArrayList<Candidate3> c) {
        System.out.println("Results per candidate:");
        System.out.println("----------------------\n");
        
        for (Candidate3 i : c) {
            System.out.println(i.toString());
        }
    }
    
    public static double getTotal (ArrayList<Candidate3> c) {
        double total = 0;
        for (Candidate3 i : c) {
            total = total + i.getVotes();
        }
        return total;
    }
    
    public static void printResults (ArrayList<Candidate3> c ) {
        System.out.printf("\n%5s %31s %29s\n", "Candidate", "Votes Received", "% of Total Votes");
        
        double total = getTotal(c);
        
        for (Candidate3 i: c) {
            System.out.printf("%-15s                %-5d                         %-5.0f\n", i.getName(), i.getVotes(), (i.getVotes()/total) * 100);
        }
        System.out.println("\nThe total number of votes in the election: " + (int)total + "\n");
    }
    
    public static void replaceName (ArrayList<Candidate3> c, String name, String newName) {
        
        // get name 
       // String name1 = ((c.get(1)).toString());
        //int index = name1.indexOf(' ');
        //index = name1.indexOf(' ', index + 1);
        //String result = name1.substring(0, index);
        
        System.out.println("Changing " + name + " to " + newName);
        for (int i = 0; c.size() > i; i++) {
            
            if (name.equalsIgnoreCase((c.get(i)).getName())){
                int votes = (c.get(i).getVotes());
                c.set(i, new Candidate3(newName,votes)); 
            }
       }
        }

    public static void replaceVotes (ArrayList<Candidate3> c, String name, int newVotes) {
        System.out.println("Changing the votes for " + name + " to " + newVotes);
        for (int i = 0; c.size() > i; i++) {
            if (name.equalsIgnoreCase((c.get(i)).getName())){
                String name1 = (c.get(i).getName());
                c.set(i, new Candidate3(name1, newVotes));
            }
        }
    }
    public static void replaceCandidate (ArrayList<Candidate3> c, String name, String newName, int newVotes) {
        System.out.println("Replacing the candidate " + name + " with the candidate " + newName);
        for (int i = 0; c.size() > i; i++) {
            if (name.equalsIgnoreCase((c.get(i)).getName())){
                 c.set(i, new Candidate3(newName, newVotes));
            }
}
    }
}
