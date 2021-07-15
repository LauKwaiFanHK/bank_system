package myproject;

import java.io.PrintStream;
import java.util.List;

/**
 * Represents credit services of the professional version
 * 
 * @author Group2
 * @version 1.5
 * @since 1.0
 */
public class CreditService {
	private static final String grantCredit_COMMAND = "grantcredit";
	private static final String repayCredit_COMMAND = "repaycredit";
	private static final String payInterest_COMMAND = "payinterest";
	private static final String getCreditInterest_COMMAND = "getCreditInterest";

	/**
	 * Execute the command to grant credit to a professional bank account. Interest
	 * to pay for the bank will be deducted from the professional bank account once
	 * credit is granted. Assumed the fixed global interest rate to be 3.5%.
	 * 
	 * @param input                 A string representing the input command
	 * @param numberOfArg           An integer representing the number of arguments
	 *                              taken for command validation
	 * @param bankAccountId         An integer representing the identifier of a
	 *                              professional bank account
	 * @param credit                A double representing the amount of credit in a
	 *                              professional bank account
	 * @param existedBankAccountIds An array list that store all existing bank IDs
	 *                              of the professional version bank system
	 * @param list                  an array list which store a list of all accounts
	 *                              in the professional version bank system
	 * @param standardOut           A PrintStream object that print representations of string data.                             
	 * @return a double containing the granted credit amount.
	 * 
	 */
	public double executeGrantCredit(String input, int numberOfArg, Integer bankAccountId, double credit,
			List<Integer> existedBankAccountIds, List<BaseAccount> list, PrintStream standardOut) {
		if (!isValidCommand(input, numberOfArg, grantCredit_COMMAND, 2)) {
			standardOut.println("Invalid command: " + input + ".");
			standardOut.println("Please enter 'grantcredit ', <accountId> and <amount>");
			return -1;
		}

		if (!existedBankAccountIds.contains(bankAccountId)) {
			standardOut.println("Invalid account id: " + bankAccountId);
			return -1;
		}

		BaseAccount bankAccount = list.get(bankAccountId);
		bankAccount.setCredit(bankAccount.getCredit() + credit);
		double balance = bankAccount.getBalance();
		balance = balance - bankAccount.getCredit() * 3.5 / 100;
		balance = balance + credit;
		bankAccount.setBalance(balance);

		return bankAccount.getCredit();
	}

	/**
	 * Executes the command to repay credit by a professional bank account owner.
	 * 
	 * @param input                 A string representing the input command
	 * @param numberOfArg           An integer representing the number of arguments
	 *                              taken for command validation
	 * @param bankAccountId         An integer representing the identifier of a
	 *                              professional bank account
	 * @param credit                A double representing the amount of credit in a
	 *                              professional bank account
	 * @param existedBankAccountIds An array list that store all existing bank IDs
	 *                              of the professional version bank system
	 * @param list                  an array list which store a list of all accounts
	 *                              in the professional version bank system
	 * @param standardOut           A PrintStream object that print representations of string data.                            
	 * @return a double containing the credit still need to be repaid.
	 */
	public double executeRepayCredit(String input, int numberOfArg, Integer bankAccountId, double credit,
			List<Integer> existedBankAccountIds, List<BaseAccount> list, PrintStream standardOut) {
		if (!isValidCommand(input, numberOfArg, repayCredit_COMMAND, 2)) {
			standardOut.println("Invalid command: " + input);
			standardOut.println("Please enter 'repaycredit ', <accountId> and <amount>");
			return -1;
		}

		if (!existedBankAccountIds.contains(bankAccountId)) {
			standardOut.println("Invalid account id: " + bankAccountId);
			return -1;
		}

		BaseAccount bankAccount = list.get(bankAccountId);
		bankAccount.setCredit(bankAccount.getCredit() - credit);

		return bankAccount.getCredit();
	}

	/**
	 * Calculate the interest amount of all professional accounts and deducts the
	 * interest to be paid. This function is only available for system admin of the
	 * professional version of bank system.
	 * 
	 * @param input       A string representing the input command
	 * @param numberOfArg An integer representing the number of arguments taken for
	 *                    command validation
	 * @param list        an array list which store a list of all accounts in the
	 *                    professional version bank system                  
	 */

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

	/**
	 * Gets the credit interest that will be deducted from the professional bank
	 * account when the user repay the credit.
	 * 
	 * @param input                 A string representing the input command
	 * @param numberOfArg           An integer representing the number of arguments
	 *                              taken for command validation
	 * @param bankAccountId         An integer representing the identifier of a
	 *                              professional bank account
	 * @param existedBankAccountIds An array list that store all existing bank IDs
	 *                              of the professional version bank system
	 * @param list                  an array list which store a list of all accounts
	 *                              in the professional version bank system
	 * @param standardOut           A PrintStream object that print representations of string data.                             
	 * @return a double containing the amount of interest
	 */
	public double getCreditInterest(String input, int numberOfArg, Integer bankAccountId,
			List<Integer> existedBankAccountIds, List<BaseAccount> list, PrintStream standardOut) {
		if (!isValidCommand(input, numberOfArg, getCreditInterest_COMMAND, 1)) {
			standardOut.println("Invalid command: " + input);
			standardOut.println("Please enter 'deposit ', <accountId> and <amount>");
			return -1;
		}

		if (!existedBankAccountIds.contains(bankAccountId)) {
			standardOut.println("Invalid account id: " + bankAccountId);
			return -1;
		}

		BaseAccount account = list.get(bankAccountId);
		double creditToRepay = account.getCredit();
		if (creditToRepay > 0) {
			double interestAmount = creditToRepay * 3.5 / 100; // assumed global interest rate to be 3.5%
			if (interestAmount > 0) {
				return interestAmount;
			}
		}
		return -1;
	}

	/**
	 * Validate the input command.
	 * 
	 * @param input           A string representing the input command
	 * @param numberOfArg     An integer representing the number of arguments taken
	 *                        for command validation
	 * @param expectedCommand a string representing the correct command used to
	 *                        compare with the input command
	 * @param expectedArgs    an integer representing the number of expected
	 *                        arguments in a command
	 * @param standardOut           A PrintStream object that print representations of string data.                       
	 * @return a boolean containing the state of validation.
	 */
	private boolean isValidCommand(String input, int numberOfArg, String expectedCommand, int expectedArgs) {
		return expectedCommand.equals(input) && expectedArgs == numberOfArg;
	}
}
