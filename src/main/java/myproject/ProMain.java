package myproject;

import java.io.IOException;

/** Executes the bank system in console
 * @author Group2
 * @version 1.5
 * @since 1.0
*/

public class ProMain {

	/** Interacts with bank account owner and executes a command based on user input. 
	 * @param args an array of strings passed as parameters when running the bank system application.
	*/
	public static void main(String[] args) {
		BankSystemServer server = new BankSystemServer();
		try {
			server.start(4444, true);
			server.stop();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
