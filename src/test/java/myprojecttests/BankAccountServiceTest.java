package myprojecttests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import myproject.BankAccount;
import myproject.BankAccountService;
import myproject.BaseAccount;

public class BankAccountServiceTest extends TestCase {

	public void testExecuteGetBalance() {
		BankAccountService bankAccountService = new BankAccountService();
		BaseAccount bankAccount = new BankAccount();
		bankAccount.setId(0);
		bankAccount.setBalance(100);
		List<Integer> idLists = new ArrayList();
		idLists.add(bankAccount.getId());
		List<BaseAccount> baseAccounts = new ArrayList();
		baseAccounts.add(bankAccount);
		double result = bankAccountService.executeGetBalance("getBalance", 1, 0, idLists, baseAccounts);
		assertEquals(100D, result);
		//fail("Not yet implemented");
	}

	public void testExecuteDeposit() {
		BankAccountService bankAccountService = new BankAccountService();
		BaseAccount bankAccount = new BankAccount();
		bankAccount.setId(0);
		bankAccount.setBalance(100);
		List<Integer> idLists = new ArrayList();
		idLists.add(bankAccount.getId());
		List<BaseAccount> baseAccounts = new ArrayList();
		baseAccounts.add(bankAccount);
		double result = bankAccountService.executeDeposit("deposit", 2, 0, 200, idLists, baseAccounts);
		assertEquals(300D, result);
		
		//fail("Not yet implemented");
	}

	public void testExecuteWithdraw() {
		BankAccountService bankAccountService = new BankAccountService();
		BaseAccount bankAccount = new BankAccount();
		bankAccount.setId(0);
		bankAccount.setBalance(200);
		List<Integer> idLists = new ArrayList();
		idLists.add(bankAccount.getId());
		List<BaseAccount> baseAccounts = new ArrayList();
		baseAccounts.add(bankAccount);
		double result = bankAccountService.executeWithdraw("withdraw", 2, 0, 200, idLists, baseAccounts);
		assertEquals(0D, result);
		
		//fail("Not yet implemented");
	}

	public void testExecuteTransfer() {
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
	double result = bankAccountService
			.executeTransfer("transfer", 5, 0, 1, 300, 
					idSendList, idReceiverList , baseAccounts);
	assertEquals(700D, result);
		//fail("Not yet implemented");
	}

}
