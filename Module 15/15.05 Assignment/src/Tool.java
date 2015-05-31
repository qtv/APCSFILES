/**
 * 15.05 Challenge Program - Tool constructor for tool objects. Also includes
 * the compareTo method to compare the two saw tools.
 * @author 
 * @date 5/20/15
 */
public class Tool implements Product, Comparable<Product> {
    
    private String name;
    private double cost;
    
    public Tool(String name, double cost){
		this.name = name;
		this.cost = cost;
    }
    
    public String getName() {
        return name;
    }
    
    public double getCost() {
        return cost;
    }
    
    public int compareTo (Product obj) {
      if (getCost() < obj.getCost()) {
            return -1 ;
        } else if (getCost() == obj.getCost()) {
            return 0;
        } else {
            return 1;
        }  
    }
}
