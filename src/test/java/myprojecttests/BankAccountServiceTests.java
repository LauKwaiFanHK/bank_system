package myprojecttests;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import myproject.BankAccount;
import myproject.BankAccountService;
import myproject.BaseAccount;

public class BankAccountServiceTests extends TestCase {

	public void testExecuteGetBalance() {
		PrintStream out = null;
		BankAccountService bankAccountService = new BankAccountService();
		BaseAccount bankAccount = new BankAccount();
		bankAccount.setId(0);
		bankAccount.setBalance(100);
		List<Integer> idLists = new ArrayList();
		idLists.add(bankAccount.getId());
		List<BaseAccount> baseAccounts = new ArrayList();
		baseAccounts.add(bankAccount);
		double result = bankAccountService.executeGetBalance("getBalance", 1, 0, idLists, baseAccounts, out);
		assertEquals(100D, result);
	}

	public void testExecuteDeposit() {
		PrintStream out = null;
		BankAccountService bankAccountService = new BankAccountService();
		BaseAccount bankAccount = new BankAccount();
		bankAccount.setId(0);
		bankAccount.setBalance(100);
		List<Integer> idLists = new ArrayList();
		idLists.add(bankAccount.getId());
		List<BaseAccount> baseAccounts = new ArrayList();
		baseAccounts.add(bankAccount);
		double result = bankAccountService.executeDeposit("deposit", 2, 0, 200, idLists, baseAccounts, out);
		assertEquals(300D, result);
		
	}

	public void testExecuteWithdraw() {
		PrintStream out = null;
		BankAccountService bankAccountService = new BankAccountService();
		BaseAccount bankAccount = new BankAccount();
		bankAccount.setId(0);
		bankAccount.setBalance(200);
		List<Integer> idLists = new ArrayList();
		idLists.add(bankAccount.getId());
		List<BaseAccount> baseAccounts = new ArrayList();
		baseAccounts.add(bankAccount);
		double result = bankAccountService.executeWithdraw("withdraw", 2, 0, 200, idLists, baseAccounts, out);
		assertEquals(0D, result);
		
	}

	public void testExecuteTransfer() {
	PrintStream out = null;
	BankAccountService bankAccountService = new BankAccountService();
	BaseAccount bankAccount1 = new BankAccount();
	BaseAccount bankAccount2 = new BankAccount();
	bankAccount1.setId(0);
	bankAccount2.setId(1);
	bankAccount1.setBalance(1000);
	bankAccount2.setBalance(200);
	List<Integer> idSendList = new ArrayList();
	List<Integer> idReceiverList = new ArrayList(); 
	idSendList.add(bankAccount1.getId());
	idReceiverList.add(bankAccount2.getId());
	List<BaseAccount> baseAccounts = new ArrayList();
	baseAccounts.add(bankAccount1);
	baseAccounts.add(bankAccount2);
	double result = bankAccountService.executeTransfer("transfer", 5, 0, 1, 300, 
					idSendList, idReceiverList , baseAccounts, out);
	assertEquals(700D, result);
	}

}

