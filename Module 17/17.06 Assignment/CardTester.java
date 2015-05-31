/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card jackClubs = new Card("jack", "clubs", 1);
		Card aceHearts = new Card("ace", "hearts", 1);
		Card nineHearts = new Card("9", "hearts", 9);
                
                System.out.println("Rank: " + jackClubs.rank());
		System.out.println("Suit: " + jackClubs.suit());
		System.out.println("Points: " + jackClubs.pointValue());
		System.out.println("ToString: " + jackClubs.toString());
                
                System.out.println("Rank: " + aceHearts.rank());
		System.out.println("Suit: " + aceHearts.suit());
		System.out.println("Points: " + aceHearts.pointValue());
		System.out.println("ToString: " + aceHearts.toString());
                
                System.out.println("Rank: " + nineHearts.rank());
		System.out.println("Suit: " + nineHearts.suit());
		System.out.println("Points: " + nineHearts.pointValue());
		System.out.println("ToString: " + nineHearts.toString());
                
                // matching
                
                // not matching 
                System.out.println("Not matching: " + jackClubs.matches(nineHearts));
                // 
	}
}
