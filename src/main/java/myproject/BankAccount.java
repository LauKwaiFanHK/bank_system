package myproject;

public class BankAccount extends BaseAccount {

	@Override
	public double getCredit() {
		System.out.println("This bank account type does not support this function. Please upgrade to professional bank account.");
		return 0;
	}

	@Override
	public void setCredit(double d) {
		System.out.println("This bank account type does not support this function. Please upgrade to professional bank account.");
	}

}
