package myproject;

import java.util.List;

public class createAccount {
	
	protected String command = "createAccount";
	protected int numberOfArg = 0;

	private boolean verifyCommand(String input, int numberOfArg) {
		if(input == command & numberOfArg == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void executeOrder(String input, int numberOfArg, List<BankAccount> accList) {
		if (verifyCommand(input, numberOfArg)) {
			BankAccount acc = new BankAccount();
			int accIdentifier = -1;
			accList.add(acc);
			accIdentifier = accList.indexOf(acc);
			System.out.println("A new account is created. The account number is: " + accIdentifier);
		} else {
			System.out.println("Invalid command. To create a new account, type 'createAccount' and press enter.");
		}
	}
}
