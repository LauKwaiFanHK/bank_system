package myprojecttests;

import myproject.BaseAccount;
import myproject.CreditService;
import myproject.ProfessionalBankAccount;
import org.junit.Test;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CreditServiceTests {

    @Test
    public void professionalAccountTest() {
    	PrintStream out = null;
        CreditService creditService = new CreditService();
        List<Integer> existedBankAccountIds = new ArrayList<>();
        List<BaseAccount> accountList = new ArrayList<>();
        ProfessionalBankAccount bankAccount = new ProfessionalBankAccount();
        bankAccount.setId(0);
        bankAccount.setBalance(0);
        accountList.add(bankAccount);
        existedBankAccountIds.add(bankAccount.getId());
        // executeGrantCredits
        assertEquals(-1, creditService.executeGrantCredit("grantCredit", 2, 0,
                1000, existedBankAccountIds, accountList, out), 0.1);
        assertEquals(-1, creditService.executeGrantCredit("grantcredit", 1, 0,
                1000, existedBankAccountIds, accountList, out), 0.1);
        assertEquals(-1, creditService.executeGrantCredit("grantcredit", 2, 2,
                1000, existedBankAccountIds, accountList, out), 0.1);
        assertEquals(1000, creditService.executeGrantCredit("grantcredit", 2, 0,
                1000, existedBankAccountIds, accountList, out), 0.1);
        assertEquals(-35, bankAccount.getBalance(), 0.01);

        // getCreditInterest
        assertEquals(35, creditService.getCreditInterest("getCreditInterest", 1, 0,
                existedBankAccountIds, accountList, out), 0.1);
        assertEquals(-1, creditService.getCreditInterest("getCreditInterest", 0, 0,
                existedBankAccountIds, accountList, out), 0.1);
        assertEquals(-1, creditService.getCreditInterest("getinterest", 1, 0,
                existedBankAccountIds, accountList, out), 0.1);
        assertEquals(-1, creditService.getCreditInterest("getCreditInterest", 1, 4,
                existedBankAccountIds, accountList, out), 0.1);

        // executeRepayCredit
        assertEquals(0, creditService.executeRepayCredit("repaycredit", 2, 0, 1000,
                existedBankAccountIds, accountList, out), 0.1);
        assertEquals(-1, creditService.executeRepayCredit("repayCredit", 2, 0, 1000,
                existedBankAccountIds, accountList, out), 0.1);
        assertEquals(-1, creditService.executeRepayCredit("repaycredit", 1, 0, 1000,
                existedBankAccountIds, accountList, out), 0.1);
        assertEquals(-1, creditService.executeRepayCredit("repaycredit", 1,10, 1000,
                existedBankAccountIds, accountList, out), 0.1);
    }
}
