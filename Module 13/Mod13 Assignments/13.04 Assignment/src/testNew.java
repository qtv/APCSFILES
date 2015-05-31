/**
 * Program that tests the Rectangle3, Box3, Cube3 classes.
 * @author 
 * @date 4/26/15
 */
public class testNew {
    public static void main(String[] args) {
        // create objects
        Rectangle3 r1 = new Rectangle3(5, 20);
        Box3 b1 = new Box3(4, 4, 4);
        Box3 b2 = new Box3(4, 10, 5);
        Cube3 c1 = new Cube3(4, 4, 4);
        
        showEffectBoth(r1);
        showEffectBoth(b1);
        showEffectBoth(b2);
        showEffectBoth(c1);
        
        // 1st box same size as cube?
        // could also use ShowEffectBoth here (same thing minus the " is " )
        System.out.print(b1.toString() + " is ");
        
        if (b1.equals(c1)) {
            System.out.print("same size as " + c1.toString());
        }
        else System.out.print("not the same size as " + c1.toString());
        
        System.out.println("");
        
        // second box same size as cube?
        System.out.print(b2.toString() + " is ");
        if (b2.equals(c1)) {
            System.out.print("same size as " + c1.toString());
        }
        else System.out.println("not the same size as " + c1.toString());
    }
    
    private static void showEffectBoth (Rectangle3 e) {
        System.out.println(e);
    }
}
