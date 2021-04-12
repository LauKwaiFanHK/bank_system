package myproject;

public class BankAccount {
	protected long balance;

	public long getBalance() {
		return balance;
	}	
	
	public void deposit(long value){
		balance += value;
	}

	public void withdraw(long value) {
		balance -= value;
	}

	public void withdraw(long foreignValue, double conversionfactor) {
		long convertedValue = (long) Math.round(foreignValue*conversionfactor);
		balance -= convertedValue; 
	}
}
