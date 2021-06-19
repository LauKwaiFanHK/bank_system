package myprojecttests;

import myproject.BaseAccount;
import myproject.CreateProAccount;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CreateProAccountTests {
    @Test
    public void tests() {
        CreateProAccount createProAccount = new CreateProAccount();
        List<Integer> existedBankAccountIds = new ArrayList<>();
        List<BaseAccount> accountList = new ArrayList<>();
        assertEquals(-1, createProAccount.executeCreateProAccount("create", 1, accountList));
        assertEquals(0, createProAccount.executeCreateProAccount("create", 0, accountList));
        assertEquals(-1, createProAccount.executeCreateProAccount("Create", 0, accountList));
    }
}
