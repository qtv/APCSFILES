/**
 * 15.05 Challenge Program - Product interface that other classes are based off of.
 * @author 
 * @date 5/20/15
 */

public interface Product extends Comparable<Product> {
    public abstract String getName();
    public abstract double getCost();

       
}
