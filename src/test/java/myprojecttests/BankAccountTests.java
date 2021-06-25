package myprojecttests;

import myproject.BankAccount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankAccountTests {
    @Test
    public void tests() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(8);
        bankAccount.setBalance(50);
		assertEquals(50, bankAccount.getBalance(), 0.01);
		assertEquals(8, bankAccount.getId(), 0.01);
    }
}
