package myproject;

/**
 * Represents the setting up for a standard bank account.
 * 
 */
public class BankAccount extends BaseAccount {

	/**
	 * Return a message that credit service is only available for professional version.
	 */
	@Override
	public double getCredit() {
		System.out.println("This bank account type does not support this function. Please upgrade to professional bank account.");
		return 0;
	}

	/**
	 * Return a message that credit service is only available for professional version.
	 */
	@Override
	public void setCredit(double d) {
		System.out.println("This bank account type does not support this function. Please upgrade to professional bank account.");
	}

}
