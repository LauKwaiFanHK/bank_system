package myproject;

import java.io.PrintStream;

/**
 * Represents the setting up for a standard bank account.
 * @author Group2
 * @since 1.0
 * @version 1
 */
public class BankAccount extends BaseAccount {
	
	private PrintStream standardOut;

	/**
	 * Return a message that credit service is only available for professional version.
	 */
	@Override
	public double getCredit() {
		standardOut.println("This bank account type does not support this function. Please upgrade to professional bank account.");
		return 0;
	}

	/**
	 * Return a message that credit service is only available for professional version.
	 */
	@Override
	public void setCredit(double d) {
		standardOut.println("This bank account type does not support this function. Please upgrade to professional bank account.");
	}

}
