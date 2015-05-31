/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		// three deck objects
            String[] ranks = {"queen", "jack", "king"};
            String[] suits = {"hearts", "clubs"};
            int[] pointValues = {12, 11, 13};
            Deck d1 = new Deck(ranks, suits, pointValues);
            
            //String[] ranks1 = {"queen", "king", "ace"};
            //String[] suits1 = {"spades", "clubs"};
            //int[] pointValues1 = {12, 11, 14};
            //Deck d2 = new Deck(ranks, suits, pointValues);
            
           // String[] ranks2 = {"monkey", "gorilla", "orangutan"};
            //String[] suits2 = {"red", "brown"};
           // int[] pointValues2 = {5, 10, 11};
           // Deck d3 = new Deck(ranks, suits, pointValues);
            
            System.out.println(d1);
            System.out.println("Dealing one crad");
            System.out.println(d1.deal());
            System.out.println(d1.isEmpty());
            System.out.println(d1.size());
            
            System.out.println("\n" + d1);
            
            // dealing others
            for (int i = 0; i < 5; i++) {
			System.out.println("Dealing : " + d1.deal());
		}
            
            //System.out.println(d2);
            //System.out.println(d2.deal());
            //System.out.println(d2.isEmpty());
            //System.out.println(d2.size());
            
            //System.out.println("\n" + d2 + "\n");
            
            //System.out.println(d3);
            //System.out.println(d3.deal());
            //System.out.println(d3.isEmpty());
            //System.out.println(d3.size());
            
            //System.out.println("\n" + d3+ "\n");
	}
}
