/**
 * 15.05 Challenge Program - Vehicle constructor for vehicle objects, which things like Car/Truck are based off of.
 * @author 
 * @date 5/20/15
 */
public class Vehicle implements Product{
    private String name;
    private double cost;
    
    public Vehicle (String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
    
    public String getName() {
        return name;
    }
    
    public double getCost() {
        return cost;
    }

    // the class overrides the compareTo as the class is not abstract.
    @Override
    public int compareTo(Product o) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
