package myprojecttests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import myproject.BaseAccount;
import myproject.CreateAccount;

public class CreateAccountTests {

	@Test
	public void testExecuteCreateAccount() {
		CreateAccount createAccount = new CreateAccount();
		List<BaseAccount> baseAccounts = new ArrayList<>();
		int result = createAccount.executeCreateAccount("create", 0, baseAccounts); // 0
		assertEquals(0, result);
	}

}
