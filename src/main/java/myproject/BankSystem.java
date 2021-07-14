package myproject;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Represents the bank system
 * 
 * @author Group2
 * @version 1.5
 * @since 1.0
 */
public class BankSystem {

	private InputStream standardIn;
	private PrintStream standardOut;

	public BankSystem(InputStream standardIn, PrintStream standardOut) {
		this.standardIn = standardIn;
		this.standardOut = standardOut;
	}

	/**
	 * Interacts with bank account owner and executes a command based on user input.
	 */
	public void mainLoop() {

		boolean isProVersion = executeProBankAcc();

		getStartDialog();
		showChoices(false);

		Scanner scanner = new Scanner(standardIn);
		String choice = scanner.nextLine();

		CreditService creditService = new CreditService();
		BankAccountService service = new BankAccountService();
		List<BaseAccount> accounts = new ArrayList<>();
		Map<String, List<Integer>> accountMap = new HashMap<>();
		String accountName = null;

		while (choice != null) {
			switch (choice) {
			case "login": {
				if (accountName == null) {
					standardOut.println("Please enter your name");
					accountName = scanner.nextLine();
					standardOut.println("Hi, " + accountName + "!");
				} else {
					standardOut.println("you are logged in already");
				}
				break;
			}
			case "logout": {
				standardOut.println("Bye, " + accountName + "!");
				accountName = null;
				break;
			}
			case "bye": {
				return;
			}
			default: {
				if (accountName != null) {
					String[] inputArgs = choice.split(" ");
					int numberOfArgs = inputArgs.length;
					String command = inputArgs[0];

					if (numberOfArgs == 1 && command.equals("create")) {
						if (isProVersion) {
							CreateProAccount createProAccount = new CreateProAccount();
							int accountId = createProAccount.executeCreateProAccount(inputArgs[0], 0, accounts);
							if (accountId != -1) {
								accountMap.putIfAbsent(accountName, new ArrayList<>());
								accountMap.get(accountName).add(accountId);

								standardOut
										.println("New account is created. The account number is " + accountId + " .");
							}
						} else {
							CreateAccount createAccount = new CreateAccount();
							int accountId = createAccount.executeCreateAccount(inputArgs[0], 0, accounts);
							if (accountId != -1) {
								accountMap.putIfAbsent(accountName, new ArrayList<>());
								accountMap.get(accountName).add(accountId);

								standardOut
										.println("New account is created. The account number is " + accountId + " .");
							}
						}
					} else if (numberOfArgs == 2) {
						if (inputArgs[0].equals("getCreditInterest")) {

							Integer bankAccountId = Integer.valueOf(inputArgs[1]);
							List<Integer> existedBankAccountIds = accountMap.getOrDefault(accountName,
									new ArrayList<>());

							double interest = creditService.getCreditInterest(inputArgs[0], numberOfArgs - 1,
									bankAccountId, existedBankAccountIds, accounts, standardOut);
							if (interest != -1) {
								standardOut.println(interest + " euro as credit interest was deducted from account: "
										+ bankAccountId);
							} else {
								standardOut.println("You have not yet applied for any credit.");
							}
						}

						if (inputArgs[0].equals("getBalance")) {
							Integer bankAccountId = Integer.valueOf(inputArgs[1]);
							List<Integer> existedBankAccountIds = accountMap.getOrDefault(accountName,
									new ArrayList<>());

							double balance = service.executeGetBalance(inputArgs[0], numberOfArgs - 1, bankAccountId,
									existedBankAccountIds, accounts, standardOut);

							if (balance != -1) {
								standardOut.println("Your account balance is " + balance + " euro.");
							}
						}
					} else if (numberOfArgs == 3) {
						if (inputArgs[0].equals("grantcredit")) {

							Integer bankAccountId = Integer.valueOf(inputArgs[1]);
							Integer amount = Integer.valueOf(inputArgs[2]);
							List<Integer> existedBankAccountIds = accountMap.getOrDefault(accountName,
									new ArrayList<>());

							double credit = creditService.executeGrantCredit(inputArgs[0], numberOfArgs - 1,
									bankAccountId, amount, existedBankAccountIds, accounts, standardOut);
							if (credit != -1) {
								standardOut.println("Your credit balance is " + credit + " euro.");
							}
						}

						if (inputArgs[0].equals("repaycredit")) {

							Integer bankAccountId = Integer.valueOf(inputArgs[1]);
							Integer amount = Integer.valueOf(inputArgs[2]);
							List<Integer> existedBankAccountIds = accountMap.getOrDefault(accountName,
									new ArrayList<>());

							double credit = creditService.executeRepayCredit(inputArgs[0], numberOfArgs - 1,
									bankAccountId, amount, existedBankAccountIds, accounts, standardOut);
							if (credit != -1) {
								standardOut.println("You repaid credit amount: " + amount
										+ " euro. Your credit balance is " + credit + " euro.");
							}
						}

						if (inputArgs[0].equals("deposit")) {
							Integer bankAccountId = Integer.valueOf(inputArgs[1]);
							Integer amount = Integer.valueOf(inputArgs[2]);
							List<Integer> existedBankAccountIds = accountMap.getOrDefault(accountName,
									new ArrayList<>());

							double balance = service.executeDeposit(inputArgs[0], numberOfArgs - 1, bankAccountId,
									amount, existedBankAccountIds, accounts, standardOut);
							if (balance != -1) {
								standardOut.println("Your account balance is " + balance + " euro.");
							}
						}
					} else if (numberOfArgs == 4) {
						Integer bankAccountId = Integer.valueOf(inputArgs[2]);
						Integer amount = Integer.valueOf(inputArgs[3]);
						List<Integer> existedBankAccountIds = accountMap.getOrDefault(accountName, new ArrayList<>());

						double balance = service.executeWithdraw(inputArgs[0], numberOfArgs - 2, bankAccountId, amount,
								existedBankAccountIds, accounts, standardOut);
						if (balance != -1) {
							standardOut.println("Your account balance is " + balance + " euro.");
						}
					} else if (numberOfArgs == 6) {
						Integer senderAccountId = Integer.valueOf(inputArgs[2]);
						Integer receiverAccountId = Integer.valueOf(inputArgs[4]);
						Integer amount = Integer.valueOf(inputArgs[5]);
						List<Integer> existedSenderAccountIds = accountMap.getOrDefault(accountName, new ArrayList<>());
						String receiverAccName = inputArgs[3];
						List<Integer> existedReceiverAccountIds = accountMap.getOrDefault(receiverAccName,
								new ArrayList<>());

						double balance = service.executeTransfer(inputArgs[0], numberOfArgs - 1, senderAccountId,
								receiverAccountId, amount, existedSenderAccountIds, existedReceiverAccountIds, accounts,
								standardOut);
						if (balance != -1) {
							standardOut.println(amount + " euro is transferred from account number: " + senderAccountId
									+ " to account number: " + receiverAccountId);
						}
					} else {
						standardOut.println("incorrect input!");
					}

				} else {
					standardOut.println("Please log in");
				}
			}
			}

			showChoices(accountName != null);
			choice = scanner.nextLine();
		}
		scanner.close();
	}

	/**
	 * Prints greeting dialog after the bank system is executed.
	 */
	private void getStartDialog() {
		standardOut.println("Hey,it is your bank assistant,we are happy to see you!");
		standardOut.println("To use the bank services, please login.");
	}

	/**
	 * Prints instructions and related commands of all basic services for the bank
	 * account. If the loaded system is a professional version, prints instructions
	 * for additional credit services.
	 * 
	 * @param isLoggedIn
	 */
	private void showChoices(boolean isLoggedIn) {
		standardOut.println("\n");

		if (isLoggedIn) {
			standardOut.println("0. Please type 'logout' to logout");
		} else {
			standardOut.println("0. Please type 'login' to login");
		}
		standardOut.println("1. To create a new account, type 'create ' and press enter.");
		standardOut.println(
				"2. To transfer money from account A to account B, type 'transfer ', 'loginName ', <accountAId>, 'receiverName', <accountBId>, <amount> and press enter.");
		standardOut.println("3. To get balance from your account, type 'getBalance ', <accountId> and press enter.");
		standardOut.println(
				"4. To deposit money into your account, type 'deposit ', <accountId> and <amount> and press enter.");
		standardOut.println(
				"5. To withdraw money from your account, type 'withdraw  ','loginName ', <accountId> and <amount> and press enter.");
		standardOut.println("6. If you dont want to proceed, type 'bye' and press enter.");

		if (executeProBankAcc()) {
			standardOut.println(
					"7. To apply for credit, type in 'grantcredit ', <accountId> and <amount> and press enter.");
			standardOut
					.println("8. To repay credit, type in 'repaycredit ', <accountId> and <amount> and press enter.");
			standardOut.println(
					"9. To check the amount of credit interest being deducted from your account, type in 'getCreditInterest ', <accountId> and press enter.");
		}
	}

	/**
	 * Check if the loaded bank system is standard or professional version.
	 * 
	 * @return a boolean showing if the loaded system is a professional version.
	 */
	private static boolean executeProBankAcc() {
		ClassLoader classLoader = BankSystem.class.getClassLoader();

		boolean isProBankAcc = false;

		try {
			Class aClass = classLoader.loadClass("myproject.ProfessionalBankAccount");
			isProBankAcc = true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return isProBankAcc;
	}

}
