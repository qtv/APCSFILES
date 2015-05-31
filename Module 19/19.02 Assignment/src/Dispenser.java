/**
 * @title 19.02 Challenge Program - dispenser constructor
 * @author 
 * @date 5/26/15
 */
public class Dispenser {
    private int numberOfItem, cost;
    
    public Dispenser() {
        this.numberOfItem = 50;
        this.cost = 50;
    }
    public Dispenser (int numberOfItem, int cost) {        
        if (numberOfItem < 0 || cost < 0) {
            throw new IllegalArgumentException("The item count or cost is less than or equal to 0");
        }
        // only assign this if no error occurs
        this.numberOfItem = numberOfItem;
        this.cost = cost;
    }
    public int getCount() {
        return numberOfItem;
    }
    public int getProductCost() {
        return cost;
    }
    public void makeSale() {
        numberOfItem = numberOfItem - 1;
    }
}
