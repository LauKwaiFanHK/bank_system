package myproject;

import java.util.List;

public class deposit {
	protected String command = "depost";
	protected int numberOfArg = 2;
	
	private boolean verifyCommand(String input, int numberOfArg) {
		if(input == command & numberOfArg == 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public void executeDeposit(String input, int numberOfArg, long amount, String acc, List<BankAccount> accList) {
		if(verifyCommand(input, numberOfArg)) {
			int accIdentifier = Integer.parseInt(acc);
			if(amount > 0 && accIdentifier > 0) {
				BankAccount targetAcc = accList.get(accIdentifier);
				targetAcc.deposit(amount);
				System.out.println(amount + " Euro is deposited in the account: " + acc);
			} else {
				System.out.println("Invalid command. To deposit money, type: deposit <amount> <account> and press enter.");
			}
		} else {
			System.out.println("Invalid command. To deposit money, type: deposit <amount> <account> and press enter.");
		}
	}

}
