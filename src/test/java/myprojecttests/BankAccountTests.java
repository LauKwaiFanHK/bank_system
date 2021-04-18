package myprojecttests;

import static org.junit.Assert.*;
import org.junit.Test;
import myproject.BankAccount;

public class BankAccountTests {
	@Test
	public void deposit() {
		BankAccount bankaccount = new BankAccount();
		bankaccount.deposit(5000);
		assertEquals(5000, bankaccount.getBalance());
	}

	@Test
	public void withdraw() {
		BankAccount bankaccount = new BankAccount();
		bankaccount.withdraw(5000);
		assertEquals(-5000, bankaccount.getBalance());
	}

	@Test
	public void withdrawForeign() {
		BankAccount bankaccount = new BankAccount();
		bankaccount.deposit(100);
		assertEquals(100, bankaccount.getBalance());
		bankaccount.withdrawForeign(5, 9.22);
		assertEquals(54, bankaccount.getBalance());
	}
}
