/**
 * @title 19.02 Challenge Program - candyMachine method that tests dispenser / register.
 * @author 
 * @date 5/26/15
 */
public class CandyMachine {
    public static void main(String[] args)
    {
        sellProduct(new Dispenser(50,100),new CashRegister(75), 10);
    }
    public static void sellProduct(Dispenser d, CashRegister c, int amount) {
    {
        int works = 0;
        // accept amount
        try {
            
        c.CashRegister(amount);
        c.acceptAmount(2);
        
        // dispense
        d.getCount();
        d.getProductCost();
        d.makeSale();
        }
        catch (IllegalArgumentException il) {
           System.out.println("No purchase has been made");
           works = -1;
        }
        if (works == 0) {
        System.out.println("Collect your items at the bottom and enjoy!");
    }
    }
}
}