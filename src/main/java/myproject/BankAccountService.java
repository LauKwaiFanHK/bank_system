package myproject;

import java.util.List;
/**
 * BankAccountService contains methods that execute bank services including take input command, get balance of an account, 
 * deposit in an account and withdraw from an account etc.
 * 
 * @author Konstantsin Liahk, Lau Kwai Fan
 * @since Java8
 * @version 1
 *
 */

public class BankAccountService {

    private static final String GETBALANCE_COMMAND = "getBalance";
    private static final String DEPOSIT_COMMAND = "deposit";
    private static final String WITHDRAW_COMMAND = "withdraw";
    private static final String TRANSFER_COMMAND = "transfer";

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

    private boolean isValidCommand(String input, int numberOfArg, String expectedCommand, int expectedArgs) {
        return expectedCommand.equals(input) && expectedArgs == numberOfArg;
    }
}
