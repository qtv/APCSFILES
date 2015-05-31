/**
 * @title 17.05 Challenge Program - constructor for Item object.
 * @author 
 * @date 5/25/15
 */
public class Item {
    private String itemID, itemName;
    private int inStore;
    private double price;

    public Item(String itemID, String itemName, int inStore, double price)
    {
        this.itemID = itemID;
        this.itemName = itemName;
        this.inStore = inStore;
        this.price = price;
    }
    
    public String getID()
    {
        return itemID;
    }
    public int getStore()
    {
        return inStore;
    }
    public String getName()
    {
        return itemName;
    }
    public double getPrice()
    {
        return price;
    }
    
    public String toString()
    {
        String s = itemID + "   " + itemName + "   " + inStore + "   $ " + price;
        return s;
    }
}
