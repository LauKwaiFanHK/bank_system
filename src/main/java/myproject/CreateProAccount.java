package myproject;

import java.util.List;

public class CreateProAccount {
	private static final String COMMAND = "create";
    private static final int NUMBER_OF_ARG = 0;

    public int executeCreateProAccount(String input, int numberOfArg, List<BaseAccount> list) {
        if (verifyCommand(input, numberOfArg)) {
            ProfessionalBankAccount proBankAccount = new ProfessionalBankAccount();
            proBankAccount.setId(list.size());
            proBankAccount.setBalance(0);
            proBankAccount.setCredit(0);

            list.add(proBankAccount);
            return proBankAccount.getId();
        } else {
            System.out.println("Invalid command: " + input);
            return -1;
        }
    }

    private boolean verifyCommand(String input, int numberOfArg) {
        return COMMAND.equals(input) && NUMBER_OF_ARG == numberOfArg;
    }
}
