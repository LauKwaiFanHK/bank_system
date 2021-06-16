package myproject;

public class BankAccount extends BaseAccount {

	@Override
	protected double getCredit() {
		System.out.println("This bank account type does not support this function. Please upgrade to professional bank account.");
		return 0;
	}

	@Override
	protected void setCredit(double d) {
		System.out.println("This bank account type does not support this function. Please upgrade to professional bank account.");
	}

}
