/**
 * @title 17.05 Challenge Program - modifies an array and sorts it based on
 * things like price, store ID, etc.
 * @author 
 * @date 5/25/15
 */
public class TestItem{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Item[] hardware = new Item[6];
        hardware[0] = new Item("1011","Air Filters",200,10.5);
        hardware[1] = new Item("1034","Door Knobs",60,21.5);
        hardware[2] = new Item("1101","Hammers",90,9.99);
        hardware[3] = new Item("1600","Levels",80,19.99);
        hardware[4] = new Item("1500","Ceiling Fans",100,59);       
        hardware[5] = new Item("1201","Wrench Sets",55,80);
        
        // original
        System.out.println("Original Array");
        printInventory(hardware);
        // by ID
        printInventory(sortID(hardware));
        // by name
        printInventory(sortName(hardware));
        // by inStore
        printInventory(sortInStore(hardware));
        // by price
        printInventory(sortPrices(hardware));
    }
    public static void printInventory (Item[] m) {
        System.out.println("");
        for (Item i : m)  {
            System.out.println(i.toString());
        }
    }
    public static Item[] sortID (Item[] m) {
        int i;
        int k;
        int posmax;
        Item temp;
            System.out.println("\nSorted by ID:");
            for(i= m.length - 1; i > 0; i--)
            {
                posmax = 0;
                for (k = 0; k <=i; k++)
                    if (m[k].getID().compareTo(m[posmax].getID()) > 0)
                    {
                        posmax = k;
                    }
                    temp = m[i];
                    m[i] = m[posmax];
                    m[posmax] = temp;
            }
        return m;
    }
    
    public static Item[] sortName(Item[] m) {
        int i;
        int k;
        int posmax;
        Item temp;
        
            System.out.println("\nSorted by Name:");
            for(i= m.length - 1; i >= 0; i--)
            {
                posmax = 0;
                for (k = 0; k <=i; k++)
                    if (m[k].getStore() > m[posmax].getStore())
                    {
                        posmax = k;
                    }
                
                    temp = m[i];
                    m[i] = m[posmax];
                    m[posmax] = temp;
            }
            return m;
    }
    public static Item[] sortInStore(Item[] m) {
        int i;
        int k;
        int posmax;
        Item temp;
            System.out.println("\nSorted by inStore:");
            for(i= m.length - 1; i >= 0; i--)
            {
                posmax = 0;
                for (k = 0; k <=i; k++)
                    if (m[k].getStore()> m[posmax].getStore())
                    {
                        posmax = k;
                    }
                    temp = m[i];
                    m[i] = m[posmax];
                    m[posmax] = temp;
            }
        return m;
    }
    
     public static Item[] sortPrices (Item[] m) {
         int i;
        int k;
        int posmax;
        Item temp;
            System.out.println("\nSorted by price:");
            for(i= m.length - 1; i >= 0; i--)
            {
                posmax = 0;
                for (k = 0; k <=i; k++)
                    if (m[k].getPrice()< m[posmax].getPrice())
                    {
                        posmax = k;
                    }
                    temp = m[i];
                    m[i] = m[posmax];
                    m[posmax] = temp;
            }
        return m;
     } 
    
}
