/**
 * 16.03 Assignment - Uses an Array to display a candidate and their votes, and
 * uses methods to edit the array.
 * @author 
 * @date 5/23/15
 */
public class TestCandidate5 {
        public static Candidate5[] candidates = {
        new Candidate5("John Smith", 5000),
        new Candidate5("Mary Miller", 4000),
        new Candidate5("Michael Duffy", 6000),
        new Candidate5("Tim Robinson", 2500),
        new Candidate5("Joe Ashtony", 1800) ,
        new Candidate5("Mickey Jones", 3000),
        new Candidate5("Rebecca Morgan", 2000),
        new Candidate5("Kathleen Turner", 8000),
        new Candidate5("Tory Parker", 500),
        new Candidate5("Ashton Davis", 10000)};
            
    public static void main(String[] args) {
    
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
    
    public static void printVotes (Candidate5[] c) {
        System.out.println("Results per candidate:");
        System.out.println("----------------------\n");
        
        for (Candidate5 i : c) {
            System.out.println(i.toString());
        }
    }
    
    public static double getTotal (Candidate5[] c){
        double total = 0;
        for(int i = 0; i < c.length; i++)
		{
			total += c[i].getVotes();
		}
        return total;
    }
    
    public static void printResults (Candidate5[] c ) {
        System.out.printf("\n%5s %31s %29s\n", "Candidate", "Votes Received", "% of Total Votes");
        
        double total = getTotal(c);
        
        for (Candidate5 i: c) {
            System.out.printf("%-15s                %-5d                         %-5.0f\n", i.getName(), i.getVotes(), (i.getVotes()/total) * 100);
        }
        System.out.println("\nThe total number of votes in the election: " + (int)total + "\n");
    }
    
    public static void replaceName (Candidate5[] c, String name, String newName) {
        
        System.out.println("Changing " + name + " to " + newName);
        
        for (int i = 0; c.length > i; i++) {
            
            if (name.equalsIgnoreCase(c[i].getName())) {
                int votes = c[i].getVotes();
                c[i] = new Candidate5(newName,votes); 
            }
       }
        }

    public static void replaceVotes (Candidate5[] c, String name, int newVotes) {
        System.out.println("Changing the votes for " + name + " to " + newVotes);
        for (int i = 0; c.length > i; i++) {
            if (name.equalsIgnoreCase(c[i].getName())) {
                String name1 = c[i].getName();
                c[i] = new Candidate5(name1, newVotes);
            }
        }
    }
    public static void replaceCandidate (Candidate5[] c, String name, String newName, int newVotes) {
        System.out.println("Replacing the candidate " + name + " with the candidate " + newName);
        for (int i = 0; c.length > i; i++) {
            if (name.equalsIgnoreCase(c[i].getName())) {
                c[i] = new Candidate5(newName, newVotes);
            } 
}
    }
    public static void insertPosition (Candidate5[] c, int position, String newName, int newVotes) {
        //System.out.println("Inserting " + newName + " in the " + position + " position");
        // since you can't edit an arrays length, making new array.
        // array v is the new array - defined as a public static method
        //for (int i = 0; v.length > i; i++) {
            // if position is found, add new Candidate, then end loop and go to next
            // iteration
           // if (i == position)  
              //  v[i] = new Candidate5(newName, newVotes);
              //  i++;
            //}
            // if i is greater than c.length (because the loop is based off of v.length),
            // don't do anything with c and move on to next iteration.
            //if (i > c.length -1) {i++;}
            //else {
            // if not, add the previous Candidate to v   
            //String canName = c[i].getName();
            //int canVotes = c[i].getVotes();
            //v[i] = new Candidate5 (canName, canVotes);
             //}
             System.out.println("Adding Mickey Duck, 14000 votes:");
             
             for (int i = c.length-1; i > position; i--) {
                 c[i] = c[i-1];
             }
             c[position] = new Candidate5(newName, newVotes);
    }
    public static void insertCandidate (Candidate5[] c, String name, String newName, int newVotes) {
            System.out.println("Adding Donald Mouse, 100 votes, and replacing Kathleen Turner.");
            int location = 0;

		for(int i = 0; i < c.length; i++)
		{       
                        String name1 = c[i].getName();
			if(name1.equals(name))
			{
				location = i;
			}
		}

		for(int i = c.length - 1; i > location; i--)
		{
			c[i] = c[i-1];
		}

		c[location] = new Candidate5(newName, newVotes);
    }
}
