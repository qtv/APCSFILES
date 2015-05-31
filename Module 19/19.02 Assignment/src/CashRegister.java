/**
 * @title 19.02 Challenge Program - cashRegister constructor.
 * @author 
 * @date 5/26/15
 */
public class CashRegister {
    private int cashOnHand;
    
    public CashRegister () {
        this.cashOnHand = 500;
    }
    public CashRegister(int cashOnHand) {
        if (cashOnHand < 0) {
                throw new IllegalArgumentException("You have no cash.");
        }
        this.cashOnHand = cashOnHand;
    }
   // public void cashAmount (int cash) {
    //    this.cashOnHand = cash;
    //}
    
    public void CashRegister (int v) {
        if (cashOnHand > 0) {
            cashOnHand = v;
        }
    }
    public void acceptAmount (int v) {
        if (cashOnHand > 0) {
            cashOnHand = v;
        }
    }
 }
