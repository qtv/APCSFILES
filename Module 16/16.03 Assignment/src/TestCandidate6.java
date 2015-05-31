
import java.util.ArrayList;

/**
 * 16.03 Assignment - Uses an ArrayList to display a candidate and their votes, and
 * uses methods to edit the array.
 * @author 
 * @date 5/23/15
 */
public class TestCandidate6 {
    
            
    public static void main(String[] args) {
        ArrayList<Candidate5> candidates = new ArrayList<Candidate5>();
        
        Candidate5 john = new Candidate5("John Smith", 5000);
        Candidate5 mary = new Candidate5("Mary Miller", 4000);
        Candidate5 michael = new Candidate5("Michael Duffy", 6000);
        Candidate5 tim = new Candidate5("Tim Robinson", 2500);
        Candidate5 joe = new Candidate5("Joe Ashtony", 1800);
        Candidate5 mickey = new Candidate5("Mickey Jones", 3000);
        Candidate5 rebecca = new Candidate5("Rebecca Morgan", 2000);
        Candidate5 kathleen = new Candidate5("Kathleen Turner", 8000);
        Candidate5 tory = new Candidate5("Tory Parker", 500);
        Candidate5 ashton = new Candidate5("Ashton Davis", 10000);
        
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
        // candidate arraylist 

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
        
        // insert position
        insertPosition(candidates, 5, "Mickey Duck", 14000);
        printResults(candidates);
        
        // add candidate
        insertCandidate(candidates, "Kathleen Turner", "Donald Mouse", 100);
        printResults(candidates);
    }
    
    public static void printVotes (ArrayList<Candidate5> c ) {
        System.out.println("Results per candidate:");
        System.out.println("----------------------\n");
        
        for (Candidate5 i : c) {
            System.out.println(i.toString());
        }
    }
    
    public static double getTotal (ArrayList<Candidate5> c ){
        double total = 0;
        for(int i = 0; i < c.size(); i++)
		{
			total += c.get(i).getVotes();
		}
        return total;
    }
    
    public static void printResults (ArrayList<Candidate5> c ) {
        System.out.printf("\n%5s %31s %29s\n", "Candidate", "Votes Received", "% of Total Votes");
        
        double total = getTotal(c);
        
        for (Candidate5 i: c) {
            System.out.printf("%-15s                %-5d                         %-5.0f\n", i.getName(), i.getVotes(), (i.getVotes()/total) * 100);
        }
        System.out.println("\nThe total number of votes in the election: " + (int)total + "\n");
    }
    
    public static void replaceName (ArrayList<Candidate5> c , String name, String newName) {
        
        System.out.println("Changing " + name + " to " + newName);
        
        for (int i = 0; c.size() > i; i++) {
            
            if (name.equalsIgnoreCase(c.get(i).getName())) {
                int votes = c.get(i).getVotes();
                c.set(i, new Candidate5(newName,votes)); 
            }
       }
        }

    public static void replaceVotes (ArrayList<Candidate5> c , String name, int newVotes) {
        System.out.println("Changing the votes for " + name + " to " + newVotes);
        for (int i = 0; c.size() > i; i++) {
            if (name.equalsIgnoreCase(c.get(i).getName())) {
                String name1 = c.get(i).getName();
                c.set(i, new Candidate5(name1, newVotes));
            }
        }
    }
    public static void replaceCandidate (ArrayList<Candidate5> c , String name, String newName, int newVotes) {
        System.out.println("Replacing the candidate " + name + " with the candidate " + newName);
        for (int i = 0; c.size() > i; i++) {
            if (name.equalsIgnoreCase(c.get(i).getName())) {
                c.set(i, new Candidate5(newName, newVotes));
            } 
}
    }
    public static void insertPosition (ArrayList<Candidate5> c , int position, String newName, int newVotes) {
             System.out.println("Adding Mickey Duck, 14000 votes:");
             
             for (int i = c.size()-1; i > position; i--) {
                 c.set(i, c.get(i-1));
             }
             c.set(position, new Candidate5(newName, newVotes));
    }
    public static void insertCandidate (ArrayList<Candidate5> c , String name, String newName, int newVotes) {
            System.out.println("Adding Donald Mouse, 100 votes, and replacing Kathleen Turner.");
            int location = 0;

		for(int i = 0; i < c.size(); i++)
		{       
                        String name1 = c.get(i).getName();
			if(name1.equals(name))
			{
				location = i;
			}
		}

		for(int i = c.size() - 1; i > location; i--)
		{
                        c.set(i, c.get(i-1));
			//c[i] = c[i-1];
		}

		c.set(location, new Candidate5(newName, newVotes));
    }
}
