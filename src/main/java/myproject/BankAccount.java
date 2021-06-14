package myproject;

public class BankAccount {
    private int id;
    private double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

@test
package myproject;

import static org.junit.Assert.assertEquals;

Class BankAccountTest extends BankAccount {
    @Test
    void shouldFailIfCommandIsInvalid() {
		//Given
        int invalidNumberOfArg = 1000;
        int expected = id;
        //When
        int actual = executeReturnId(invalidCommand, invalidNumberOfArg, emptyAccountList);
       //Then
		assertEquals(expected,actual);
		
	}
    @Test
	void shouldSuccessIfCommandIsValid() {
		//Given
		
}

