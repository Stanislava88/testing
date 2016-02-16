package com.clouway.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class BankTest {
    private Bank bank = new Bank(new HashMap<>());

    @Test
    public void happyPath() throws Exception {
        int id = 12345;
        Account account = new Account("Ivan", 200, 1000);
        bank.createAccount(id, account);
        Account result = bank.findById(id);

        assertThat(result, is(account));
    }

    @Test(expected = DuplicateIdAccountException.class)
    public void registerDuplicateId() throws Exception {
        int id = 12345;
        Account account1 = new Account("Ivan", 300, 1000);
        Account account2 = new Account("Maria", 200, 1000);

        bank.createAccount(id, account1);
        bank.createAccount(id, account2);
    }

    @Test(expected = AccountNotFoundException.class)
    public void findUnregisteredAccount() throws Exception {
        bank.findById(12);
    }

    @Test
    public void withDraw() throws Exception {
        int id = 101;

        bank.createAccount(id, new Account("Lilia", 500, 1000));
        bank.withDraw(id, 200);
        Account result = bank.findById(id);

        assertThat(result, is(new Account("Lilia", 300, 1000)));
    }

    @Test
    public void deposit() throws Exception {
        int id = 100;

        bank.createAccount(id, new Account("Maria", 300, 1000));
        bank.deposit(id, 200);
        Account result = bank.findById(id);

        assertThat(result, is(new Account("Maria", 500, 1000)));
    }

    @Test(expected = InsufficientCashException.class)
    public void insufficientCash() throws Exception {
        int id = 102;

        bank.createAccount(id, new Account("Ivan", 20, 1000));
        bank.withDraw(id, 100);
    }

    @Test(expected = AccountNotFoundException.class)
    public void withDrawToUndefineAccount() throws Exception {
        int id = 102;
        bank.withDraw(id, 100);
    }

    @Test(expected = ExceedLimitException.class)
    public void exceedLimit() throws Exception {
        int id = 103;
        bank.createAccount(id, new Account("Krasimir", 20, 1000));

        bank.deposit(id, 1000);
    }

    @Test(expected = AccountNotFoundException.class)
    public void depositToUndefinedAccount() throws Exception {
        int id = 103;

        bank.deposit(id, 100);
    }

    @Test
    public void sortByCash() throws Exception {
        bank.createAccount(100, new Account("Maria", 300, 1000));
        bank.createAccount(101, new Account("Lilia", 500, 1000));
        bank.createAccount(102, new Account("Petia", 50, 1000));
        bank.createAccount(103, new Account("Ivo", 100, 1000));
        ArrayList<Integer> result = bank.sortByCash();

        assertThat(result, is(Arrays.asList(102, 103, 100, 101)));
    }

    @Test
    public void expectedExceptionAfterRemove() throws Exception {
        int id = 104;
        Account account = new Account("Maria", 300, 1000);
        try {
            bank.createAccount(id, account);
            bank.remove(id);
            bank.findById(id);

            fail("Should be thrown exception");
        } catch (AccountNotFoundException ex) {
            assertThat(ex.getMessage(), is(equalTo("This account is removed")));
        }
    }

    @Test
    public void removeUnregisterAccount() throws Exception {
        int id = 104;
        try {
            bank.remove(id);
            bank.findById(id);

            fail("Should be thrown exception");
        } catch (AccountNotFoundException ex) {
            assertThat(ex.getMessage(), is(equalTo("This account is not available")));
        }
    }
}
