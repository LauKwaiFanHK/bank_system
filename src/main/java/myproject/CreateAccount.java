package myproject;

import java.util.List;

public class CreateAccount {
	
	private static final String COMMAND = "create";
    private static final int NUMBER_OF_ARG = 0;

    public int executeCreateAccount(String input, int numberOfArg, List<BankAccount> list) {
        if (verifyCommand(input, numberOfArg)) {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setId(list.size());
            bankAccount.setBalance(0);

            list.add(bankAccount);
            return bankAccount.getId();
        } else {
            System.out.println("Invalid command: " + input);
            return -1;
        }
    }

    private boolean verifyCommand(String input, int numberOfArg) {
        return COMMAND.equals(input) && NUMBER_OF_ARG == numberOfArg;
    }
}
