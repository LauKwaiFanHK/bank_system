package myproject;

import java.util.List;
/**
 * represents bank services for a bank account.
 * @author Group2
 * @since 1.0
 * @version 1
 *
 */

public class BankAccountService {

	/** Represents the string of command to get balance of a bank account.
	*/
    private static final String GETBALANCE_COMMAND = "getBalance";
    /** Represents the string of command to deposit money to a bank account.
	*/
    private static final String DEPOSIT_COMMAND = "deposit";
    /** Represents the string of command to withdraw money from a bank account.
	*/
    private static final String WITHDRAW_COMMAND = "withdraw";
    /** Represents the string of command to transfer money from a bank account
     * to another bank account.
	*/
    private static final String TRANSFER_COMMAND = "transfer";

    /** Executes the command to get balance of a bank account.
    *@return a double representing the balance of a bank account.
    */
    public double executeGetBalance(String input, int numberOfArg, Integer bankAccountId, List<Integer> existedBankAccountIds, List<BaseAccount> list) {
        if (!isValidCommand(input, numberOfArg, GETBALANCE_COMMAND, 1)) {
            System.out.println("Invalid command: " + input);
            System.out.println("Please enter 'deposit ', <accountId> and <amount>");
            return -1;
        }

        if (!existedBankAccountIds.contains(bankAccountId)) {
            System.out.println("Invalid account id: " + bankAccountId);
            return -1;
        }
        
        BaseAccount account = list.get(bankAccountId);

        return account.getBalance();
    }

    /** Executes the command to deposit money to a bank account.
    *@return a double representing the balance of account after deposit.
    */
    public double executeDeposit(String input, int numberOfArg, Integer bankAccountId, double amount, List<Integer> existedBankAccountIds, List<BaseAccount> list) {
        if (!isValidCommand(input, numberOfArg, DEPOSIT_COMMAND, 2)) {
            System.out.println("Invalid command: " + input);
            return -1;
        }

        if (!existedBankAccountIds.contains(bankAccountId)) {
            System.out.println("Invalid account id: " + bankAccountId);
            return -1;
        }

        if (amount <= 0.0) {
            System.out.println("Invalid amount: " + amount);
            return -1;
        }

        BaseAccount bankAccount = list.get(bankAccountId);
        bankAccount.setBalance(bankAccount.getBalance() + amount);
        return bankAccount.getBalance();
    }

    /** Executes the command to withdraw money from a bank account.
    *@return a double representing the balance of the account after withdrawal. 
    */
    public double executeWithdraw(String input, int numberOfArg,Integer bankAccountId, double amount, List<Integer> existedBankAccountIds, List<BaseAccount> list) {
        if (!isValidCommand(input, numberOfArg, WITHDRAW_COMMAND, 2)) {
            System.out.println("Invalid command: " + input);
            return -1;
        }

        if (!existedBankAccountIds.contains(bankAccountId)) {
            System.out.println("Invalid account id: " + bankAccountId);
            return -1;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount: " + amount);
            return -1;
        }

        BaseAccount bankAccount = list.get(bankAccountId);

        if (bankAccount.getBalance() < amount) {
            System.out.println("insufficient balance: " + bankAccount.getBalance());
            return -1;
        }

        bankAccount.setBalance(bankAccount.getBalance() - amount);

        return bankAccount.getBalance();
    }
    
    /** Executes the command to transfer money from a bank account to another bank account.
     *@return a double representing the balance of the sender's account. 
     */
    public double executeTransfer(String input, int numberOfArg, Integer senderAccountId, Integer receiverAccountId, double amount, List<Integer> existedSenderAccountIds, List<Integer> existedReceiverAccountIds, List<BaseAccount> list) {
        if (!isValidCommand(input, numberOfArg, TRANSFER_COMMAND, 5)) {
            System.out.println("Invalid command: " + input);
            return -1;
        }

        if (!existedSenderAccountIds.contains(senderAccountId) || !existedReceiverAccountIds.contains(receiverAccountId)) {
        	if(!existedSenderAccountIds.contains(senderAccountId)) {
        		System.out.println("Invalid sender account id: " + senderAccountId);
        		return -1;
        	} else {
        		System.out.println("Invalid receiver account id: " + receiverAccountId);
        		return -1;
        	}
        }

        if (amount <= 0) {
            System.out.println("Invalid amount: " + amount);
            return -1;
        }

        BaseAccount senderAccount = list.get(senderAccountId);

        if (senderAccount.getBalance() < amount) {
            System.out.println("insufficient balance: " + senderAccount.getBalance());
            return -1;
        }

        senderAccount.setBalance(senderAccount.getBalance() - amount);
        
        BaseAccount receiverAccount = list.get(receiverAccountId);

        receiverAccount.setBalance(receiverAccount.getBalance() + amount);
        
        return senderAccount.getBalance();
    }

    /** Validate the input command.
     *@return a boolean representing the state after validation. 
     */
    private boolean isValidCommand(String input, int numberOfArg, String expectedCommand, int expectedArgs) {
        return expectedCommand.equals(input) && expectedArgs == numberOfArg;
    }
}
