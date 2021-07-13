package myproject;

import java.io.PrintStream;
import java.util.List;

/**
 * represents bank services for a bank account.
 * 
 * @author Group2
 * @since 1.0
 * @version 1
 *
 */

public class BankAccountService {

	/**
	 * Represents the string of command to get balance of a bank account.
	 */
	private static final String GETBALANCE_COMMAND = "getBalance";
	/**
	 * Represents the string of command to deposit money to a bank account.
	 */
	private static final String DEPOSIT_COMMAND = "deposit";
	/**
	 * Represents the string of command to withdraw money from a bank account.
	 */
	private static final String WITHDRAW_COMMAND = "withdraw";
	/**
	 * Represents the string of command to transfer money from a bank account to
	 * another bank account.
	 */
	private static final String TRANSFER_COMMAND = "transfer";	

	/**
	 * Executes the command to get balance of a bank account.
	 * 
	 * @return a double representing the balance of a bank account.
	 * @param input                 A string representing the input command
	 * @param numberOfArg           An integer representing the number of arguments
	 *                              taken for command validation
	 * @param bankAccountId         An integer representing the identifier of a bank
	 *                              account
	 * @param existedBankAccountIds An array list that store all existing bank IDs
	 *                              in the bank system
	 * @param list                  An array list that store the existing bank
	 *                              accounts in the bank system
	 */
	public double executeGetBalance(String input, int numberOfArg, Integer bankAccountId,
			List<Integer> existedBankAccountIds, List<BaseAccount> list, PrintStream standardOut) {
		if (!isValidCommand(input, numberOfArg, GETBALANCE_COMMAND, 1)) {
			standardOut.println("Invalid command: " + input);
			standardOut.println("Please enter 'deposit ', <accountId> and <amount>");
			return -1;
		}

		if (!existedBankAccountIds.contains(bankAccountId)) {
			standardOut.println("Invalid account id: " + bankAccountId);
			return -1;
		}

		BaseAccount account = list.get(bankAccountId);

		return account.getBalance();
	}

	/**
	 * Executes the command to deposit money to a bank account.
	 * 
	 * @return a double representing the balance of account after deposit.
	 * @param input                 A string representing the input command
	 * @param numberOfArg           An integer representing the number of arguments
	 *                              taken for command validation
	 * @param bankAccountId         An integer representing the identifier of a bank
	 *                              account
	 * @param amount                A double representing the amount of money to
	 *                              deposit to a bank account
	 * @param existedBankAccountIds An array list that store all existing bank IDs
	 *                              in the bank system
	 * @param list                  An array list that store the existing bank
	 *                              accounts in the bank system
	 */
	public double executeDeposit(String input, int numberOfArg, Integer bankAccountId, double amount,
			List<Integer> existedBankAccountIds, List<BaseAccount> list, PrintStream standardOut) {
		if (!isValidCommand(input, numberOfArg, DEPOSIT_COMMAND, 2)) {
			standardOut.println("Invalid command: " + input);
			return -1;
		}

		if (!existedBankAccountIds.contains(bankAccountId)) {
			standardOut.println("Invalid account id: " + bankAccountId);
			return -1;
		}

		if (amount <= 0.0) {
			standardOut.println("Invalid amount: " + amount);
			return -1;
		}

		BaseAccount bankAccount = list.get(bankAccountId);
		bankAccount.setBalance(bankAccount.getBalance() + amount);
		return bankAccount.getBalance();
	}

	/**
	 * Executes the command to withdraw money from a bank account.
	 * 
	 * @return a double representing the balance of the account after withdrawal.
	 * @param input                 A string representing the input command
	 * @param numberOfArg           An integer representing the number of arguments
	 *                              taken for command validation
	 * @param bankAccountId         An integer representing the identifier of a bank
	 *                              account
	 * @param amount                A double representing the amount of money to
	 *                              withdraw from a bank account
	 * @param existedBankAccountIds An array list that store all existing bank IDs
	 *                              in the bank system
	 * @param list                  An array list that store the existing bank
	 *                              accounts in the bank system
	 */
	public double executeWithdraw(String input, int numberOfArg, Integer bankAccountId, double amount,
			List<Integer> existedBankAccountIds, List<BaseAccount> list, PrintStream standardOut) {
		if (!isValidCommand(input, numberOfArg, WITHDRAW_COMMAND, 2)) {
			standardOut.println("Invalid command: " + input);
			return -1;
		}

		if (!existedBankAccountIds.contains(bankAccountId)) {
			standardOut.println("Invalid account id: " + bankAccountId);
			return -1;
		}

		if (amount <= 0) {
			standardOut.println("Invalid amount: " + amount);
			return -1;
		}

		BaseAccount bankAccount = list.get(bankAccountId);

		if (bankAccount.getBalance() < amount) {
			standardOut.println("insufficient balance: " + bankAccount.getBalance());
			return -1;
		}

		bankAccount.setBalance(bankAccount.getBalance() - amount);

		return bankAccount.getBalance();
	}

	/**
	 * Executes the command to transfer money from a bank account to another bank
	 * account.
	 * 
	 * @return a double representing the balance of the sender's account.
	 * @param input                     A string representing the input command
	 * @param numberOfArg               An integer representing the number of
	 *                                  arguments taken for command validation
	 * @param senderAccountId           An integer representing the identifier of
	 *                                  the sender's bank account
	 * @param receiverAccountId         An integer representing the identifier of
	 *                                  the receiver's bank account
	 * @param amount                    A double representing the amount of money to
	 *                                  withdraw from a bank account
	 * @param existedSenderAccountIds   An array list that store all existing bank
	 *                                  IDs of the sender
	 * @param existedReceiverAccountIds An array list that store all existing bank
	 *                                  IDs of the receiver
	 * @param list                      An array list that store the existing bank
	 *                                  accounts in the bank system
	 */
	public double executeTransfer(String input, int numberOfArg, Integer senderAccountId, Integer receiverAccountId,
			double amount, List<Integer> existedSenderAccountIds, List<Integer> existedReceiverAccountIds,
			List<BaseAccount> list, PrintStream standardOut) {
		if (!isValidCommand(input, numberOfArg, TRANSFER_COMMAND, 5)) {
			standardOut.println("Invalid command: " + input);
			return -1;
		}

		if (!existedSenderAccountIds.contains(senderAccountId)
				|| !existedReceiverAccountIds.contains(receiverAccountId)) {
			if (!existedSenderAccountIds.contains(senderAccountId)) {
				standardOut.println("Invalid sender account id: " + senderAccountId);
				return -1;
			} else {
				standardOut.println("Invalid receiver account id: " + receiverAccountId);
				return -1;
			}
		}

		if (amount <= 0) {
			standardOut.println("Invalid amount: " + amount);
			return -1;
		}

		BaseAccount senderAccount = list.get(senderAccountId);

		if (senderAccount.getBalance() < amount) {
			standardOut.println("insufficient balance: " + senderAccount.getBalance());
			return -1;
		}

		senderAccount.setBalance(senderAccount.getBalance() - amount);

		BaseAccount receiverAccount = list.get(receiverAccountId);

		receiverAccount.setBalance(receiverAccount.getBalance() + amount);

		return senderAccount.getBalance();
	}

	/**
	 * Validate the input command.
	 * 
	 * @return a boolean representing the state after validation.
	 * @param input           A string representing the input command
	 * @param numberOfArg     an integer representing the number of arguments taken
	 *                        for command validation
	 * @param expectedCommand a string representing the correct command which is
	 *                        used to compare with the input command
	 * @param expectedArgs    an integer representing the number of expected
	 *                        arguments
	 */
	private boolean isValidCommand(String input, int numberOfArg, String expectedCommand, int expectedArgs) {
		return expectedCommand.equals(input) && expectedArgs == numberOfArg;
	}
}
