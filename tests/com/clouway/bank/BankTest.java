package com.clouway.bank;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class BankTest {
    private Bank bank = new Bank(new HashMap<Integer, Account>());

    @Test
    public void happyPath() throws Exception {
        Account account = new Account("Ivan", 200, 1000);
        bank.createAccount(12345, account);
        Account result = bank.findById(12345);

        assertThat(result, is(account));
    }

    @Test(expected = DoubleIdException.class)
    public void checkAccountId() throws Exception {
        Account account1 = new Account("Ivan", 300, 1000);
        Account account2 = new Account("Maria", 200, 1000);
        bank.createAccount(12345, account1);
        bank.createAccount(12345, account2);

    }

    @Test(expected = AccountNotFoundException.class)
    public void detectedIsMissingAccount() throws Exception {
        bank.findById(12);
    }

    @Test
    public void withDraw() throws Exception {
        Account account = new Account("Lilia", 500, 1000);
        int id = 101;
        bank.createAccount(id, account);
        bank.withDraw(101, 200);
        Account result = bank.findById(101);

        assertThat(result, is(account));
    }

    @Test
    public void deposit() throws Exception {
        Account account = new Account("Maria", 300, 1000);
        int id = 100;
        bank.createAccount(id, account);
        bank.deposit(id, 200);
        Account result = bank.findById(100);

        assertThat(result, is(account));
    }

    @Test(expected = InsufficientCashException.class)
    public void insufficientCash() throws Exception {
        int id = 102;
        bank.createAccount(id, new Account("Ivan", 20, 1000));
        bank.withDraw(102, 100);
    }

    @Test(expected = AccountNotFoundException.class)
    public void expectedExceptionInWithDraw() throws Exception {
        int id = 102;
        bank.withDraw(id, 100);
    }

    @Test(expected = ExceedLimitException.class)
    public void exceedLimit() throws Exception {
        bank.createAccount(103, new Account("Krasimir", 20, 1000));
        bank.deposit(103, 1000);
    }

    @Test(expected = AccountNotFoundException.class)
    public void expectedExceptionInDeposit() throws Exception {
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

    @Test(expected = AccountNotFoundException.class)
    public void remove() throws Exception {
        Account account = new Account("Maria", 300, 1000);
        int id = 104;
        bank.createAccount(id, account);
        bank.remove(id);
    }
}
