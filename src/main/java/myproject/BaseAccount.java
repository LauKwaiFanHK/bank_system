package myproject;

/** Represents a Base Account which are a double Int.
 * @author Group2
 * @version 1.5
 * @since 1.0
*/
public abstract class BaseAccount {
	private int id;
    private double balance;

    /** Gets the id of a bank account.
     * @return A integer representing the id of a bank account.
    */
    public int getId() {
        return id;
    }

    /** Sets the id of a bank account
     * @param id An integer containing a bank account number.
    */
    public void setId(int id) {
        this.id = id;
    }

    /** Gets the balance of the basic bank account.
     * @return A double representing the money in the bank account.
    */
    public double getBalance() {
        return balance;
    }

    /** Sets the balance of the basic bank account.
     * @param balance a double containing the balance of the bank account
    */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /** An abstract method to gets the credit amount of a credit account.
     * @return A double representing the credit balance of a professional account
    */
	protected abstract double getCredit();

	/** An abstract method to set the credit amount of a credit account.
	 * @param d A double containing the amount of granted credit
	    */
	protected abstract void setCredit(double d);
}
