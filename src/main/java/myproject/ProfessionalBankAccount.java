package myproject;

/** Represents an professional bank account.
 * @author Group2
 * @version 1.5
 * @since 1.0
*/
public class ProfessionalBankAccount extends BaseAccount {

    private double credit;
   
    /** Gets the granted credit to a professional bank account owner.
     * @return A double representing the granted credit amount.   
     */
    public double getCredit() {
        return credit;
    }

    /** Sets a granted credit for a professional bank account
     * @param credit A double containing the amount of the granted credit.
     */
    public void setCredit(double credit) {
        this.credit = credit;
    }
    
}
