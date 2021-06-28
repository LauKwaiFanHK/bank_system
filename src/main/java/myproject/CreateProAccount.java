package myproject;

import java.util.List;

/** Represents the creation of an professional account.
 * @author LauKwaiFanHK
 * @version 1.5
 * @since 1.0
*/
public class CreateProAccount {
	private static final String COMMAND = "create";
    private static final int NUMBER_OF_ARG = 0;

    /** Executes the command to create a professional bank account.
     *@return an integer representing the id of the created professional bank account. 
     */
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

    /** Verifies the input command.
     *@return an boolean representing the state of verification. 
     */
    private boolean verifyCommand(String input, int numberOfArg) {
        return COMMAND.equals(input) && NUMBER_OF_ARG == numberOfArg;
    }
}
