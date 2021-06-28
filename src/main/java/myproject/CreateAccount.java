package myproject;

import java.util.List;

/** Represents the creation of an standard bank account.
 * @author Group2
 * @version 1.0
 * @since 1.0
*/
public class CreateAccount {
	
	private static final String COMMAND = "create";
    private static final int NUMBER_OF_ARG = 0;

    /** Executes the command to create a standard bank account.
     *@return an integer representing the id of the created account. 
     */
    public int executeCreateAccount(String input, int numberOfArg, List<BaseAccount> list) {
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

    /** Verifies the input command.
     *@return an boolean representing the state of verification. 
     */
    private boolean verifyCommand(String input, int numberOfArg) {
        return COMMAND.equals(input) && NUMBER_OF_ARG == numberOfArg;
    }
}
