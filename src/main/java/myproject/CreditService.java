package myproject;

import java.util.List;

public class CreditService {
	private static final String grantCredit_COMMAND = "grantcredit";
	private static final String repayCredit_COMMAND = "repaycredit";
	private static final String payInterest_COMMAND = "payinterest";
	private static final String getCreditInterest_COMMAND = "getCreditInterest";

	public double executeGrantCredit(String input, int numberOfArg, Integer bankAccountId, double credit,
			List<Integer> existedBankAccountIds, List<BaseAccount> list) {
		if (!isValidCommand(input, numberOfArg, grantCredit_COMMAND, 2)) {
			System.out.println("Invalid command: " + input + ".");
			System.out.println("Please enter 'grantcredit ', <accountId> and <amount>");
			return -1;
		}

		if (!existedBankAccountIds.contains(bankAccountId)) {
			System.out.println("Invalid account id: " + bankAccountId);
			return -1;
		}

		BaseAccount bankAccount = list.get(bankAccountId);
		bankAccount.setCredit(bankAccount.getCredit() + credit);
		double balance = bankAccount.getBalance();
		balance = balance - bankAccount.getCredit() * 3.5/100;
		bankAccount.setBalance(balance);

		return bankAccount.getCredit();
	}

	public double executeRepayCredit(String input, int numberOfArg, Integer bankAccountId, double credit,
			List<Integer> existedBankAccountIds, List<BaseAccount> list) {
		if (!isValidCommand(input, numberOfArg, repayCredit_COMMAND, 2)) {
			System.out.println("Invalid command: " + input);
			System.out.println("Please enter 'repaycredit ', <accountId> and <amount>");
			return -1;
		}

		if (!existedBankAccountIds.contains(bankAccountId)) {
			System.out.println("Invalid account id: " + bankAccountId);
			return -1;
		}

		BaseAccount bankAccount = list.get(bankAccountId);
		bankAccount.setCredit(bankAccount.getCredit() - credit);

		return bankAccount.getCredit();
	}

	public void executePayInterest(String input, int numberOfArg, List<BaseAccount> list) {
		if (!isValidCommand(input, numberOfArg, payInterest_COMMAND, 0)) {
			System.out.println("Invalid command: " + input);
			System.out.println("Please enter 'payinterest '.");
		}

		for (int i = 0; i < list.size(); i++) {
			BaseAccount proBankAccount = list.get(i);
			double creditToRepay = proBankAccount.getCredit();
			double interestAmount = creditToRepay * (3 / 100);
			proBankAccount.setBalance(proBankAccount.getBalance() - interestAmount);
		}

	}

	public double getCreditInterset(String input, int numberOfArg, Integer bankAccountId,
			List<Integer> existedBankAccountIds, List<BaseAccount> list) {
		if (!isValidCommand(input, numberOfArg, getCreditInterest_COMMAND, 1)) {
			System.out.println("Invalid command: " + input);
			System.out.println("Please enter 'deposit ', <accountId> and <amount>");
			return -1;
		}

		if (!existedBankAccountIds.contains(bankAccountId)) {
			System.out.println("Invalid account id: " + bankAccountId);
			return -1;
		}

		BaseAccount account = list.get(bankAccountId);
		double creditToRepay = account.getCredit();
		if (creditToRepay > 0) {
			double interestAmount = creditToRepay * 3.5 / 100; // assumed global interest rate to be 3%
			if (interestAmount > 0) {
				return interestAmount;
			}
		}
		return -1;
	}

	private boolean isValidCommand(String input, int numberOfArg, String expectedCommand, int expectedArgs) {
		return expectedCommand.equals(input) && expectedArgs == numberOfArg;
	}
}
