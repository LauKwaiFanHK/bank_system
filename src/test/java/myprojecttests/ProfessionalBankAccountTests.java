package myprojecttests;

import myproject.ProfessionalBankAccount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProfessionalBankAccountTests {
    @Test
    public void tests() {
        ProfessionalBankAccount bankAccount = new ProfessionalBankAccount();
        bankAccount.setCredit(1000);
        assertEquals(1000, bankAccount.getCredit(), 0.01);
    }
}
