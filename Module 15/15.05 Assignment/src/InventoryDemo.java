
import java.util.ArrayList;

/**
 * 15.05 Challenge Program - Utilizes lists to compare objects.
 * @author 
 * @date 5/20/15
 */
public class InventoryDemo {
    public static ArrayList<Product> product = new ArrayList<Product>();
    public static void main(String [] args) {
        
        // add cars
        product.add(new Car("Jaguar", 1000000.00) {});
        product.add(new Car("Neon", 17000) {});
        product.add(new Tool("JigSaw", 149.18) {});
        product.add(new Car("Jaguar", 110000.00) {});
        product.add(new Car("Neon", 17500) {});
        product.add(new Car("Neon", 17875.32) {});
        product.add(new Truck("RAM", 35700) {});
        product.add(new Tool("CircularSaw", 200) {});
        product.add(new Tool("CircularSaw", 150) {});
        
        // test objects
        product.add(new Tool("saw1", 50) {});
        product.add(new Tool("saw2", 55) {});
        
        Product s1 = product.get(9);
        Product s2 = product.get(10);
        
        // print
        System.out.println(takeInventory("Jigsaw"));
        System.out.println(takeInventory("Neon"));
        System.out.println(takeInventory("Jaguar"));
        System.out.println(takeInventory("RAM"));
        System.out.println(takeInventory("CircularSaw"));
       
        // compare
         if (s1.compareTo(s2) == 1){
         System.out.println("The first Saw is more expensive");}
         
         else if (s1.compareTo(s2) == 0){
         System.out.println("The saws are the same price.");
         }
         else{
             System.out.println("The second Saw is more expensive");
    }
    }
    
    public static String takeInventory (String name) {
        int i = 0;
        double cost = 0;
        
        for (Product p : product) {
            if (p.getName().equalsIgnoreCase(name)) {
                i= i + 1;
                cost += p.getCost();
            }
        }
        return name + ": Quantity = " + i + ", Total cost = " + cost;
    }
}
