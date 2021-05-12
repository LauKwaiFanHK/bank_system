package myproject;

import java.util.List;

public class withdraw {
	
	protected String command = "withdraw";
	protected int numberOfArg = 2;
	
	private boolean verifyCommand(String input, int numberOfArg) {
		if(input == command & numberOfArg == 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public void executeWithdraw(String input, int numberOfArg, long amount, String acc, List<BankAccount> accList) {
		if(verifyCommand(input, numberOfArg)) {
			int accIdentifier = Integer.parseInt(acc);
			if(amount > 0 && accIdentifier > 0) {
				BankAccount targetAcc = accList.get(accIdentifier);
				targetAcc.withdraw(amount);
				System.out.println(amount + " Euro is deducted from account: " + acc);
			} else {
				System.out.println("Invalid command. To withdraw money, type: withdraw <amount> <account> and press enter.");
			}
		} else {
			System.out.println("Invalid command. To withdraw money, type: withdraw <amount> <account> and press enter.");
		}
	}

}
