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

	public void withdrawForeign(long foreignValue, double conversionfactor) {
		long convertedValue = Math.round(conversionfactor*foreignValue);
		balance -= convertedValue; 
	}
}
