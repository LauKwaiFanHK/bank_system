package myproject;

import java.util.List;

public class CreditService {
	private static final String grantCredit_COMMAND = "grantcredit";
	private static final String repayCredit_COMMAND = "repaycredit";
	private static final String getCreditInterest_COMMAND = "getCreditInterest";
	
	public double executeGrantCredit(String input, int numberOfArg, Integer bankAccountId, double credit, List<Integer> existedBankAccountIds, List<ProfessionalBankAccount> list) {
        if (!isValidCommand(input, numberOfArg, grantCredit_COMMAND, 2)) {
            System.out.println("Invalid command: " + input);
            System.out.println("Please enter 'grantcredit ', <accountId> and <amount>");
            return -1;
        }

        if (!existedBankAccountIds.contains(bankAccountId)) {
            System.out.println("Invalid account id: " + bankAccountId);
            return -1;
        }
        
        ProfessionalBankAccount bankAccount = list.get(bankAccountId);
        bankAccount.setCredit(bankAccount.getCredit() + credit);

        return bankAccount.getCredit();
    }
	
	public double executeRepayCredit(String input, int numberOfArg, Integer bankAccountId, double credit, List<Integer> existedBankAccountIds, List<ProfessionalBankAccount> list) {
        if (!isValidCommand(input, numberOfArg, repayCredit_COMMAND, 2)) {
            System.out.println("Invalid command: " + input);
            System.out.println("Please enter 'repaycredit ', <accountId> and <amount>");
            return -1;
        }

        if (!existedBankAccountIds.contains(bankAccountId)) {
            System.out.println("Invalid account id: " + bankAccountId);
            return -1;
        }
        
        ProfessionalBankAccount bankAccount = list.get(bankAccountId);
        bankAccount.setCredit(bankAccount.getCredit() - credit);

        return bankAccount.getCredit();
    }
	
	public void executePayInterest(String input, int numberOfArg, List<ProfessionalBankAccount> list) {
        if (!isValidCommand(input, numberOfArg, repayCredit_COMMAND, 0)) {
            System.out.println("Invalid command: " + input);
            System.out.println("Please enter 'payinterest '.");
        }
        
        for(int i = 0; i < list.size(); i++) {
        	ProfessionalBankAccount proBankAccount = list.get(i);
            double creditToRepay = proBankAccount.getCredit();
            double interestAmount = creditToRepay * ( 3 / 100);
            proBankAccount.setBalance(proBankAccount.getBalance() - interestAmount);
        }
       
    }
	
	public double getCreditInterset(String input, int numberOfArg, Integer bankAccountId, List<Integer> existedBankAccountIds, List<ProfessionalBankAccount> list) {
        if (!isValidCommand(input, numberOfArg, getCreditInterest_COMMAND, 1)) {
            System.out.println("Invalid command: " + input);
            System.out.println("Please enter 'deposit ', <accountId> and <amount>");
            return -1;
        }

        if (!existedBankAccountIds.contains(bankAccountId)) {
            System.out.println("Invalid account id: " + bankAccountId);
            return -1;
        }
        
        ProfessionalBankAccount account = list.get(bankAccountId);
        double creditToRepay = account.getCredit();
        double interestAmount = creditToRepay * ( 3 / 100); // assume global interest rate to be 3%
        
        return interestAmount;
    }
		
	private boolean isValidCommand(String input, int numberOfArg, String expectedCommand, int expectedArgs) {
        return expectedCommand.equals(input) && expectedArgs == numberOfArg;
    }
}
