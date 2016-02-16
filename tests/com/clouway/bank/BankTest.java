package com.clouway.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class BankTest {
    private HashMap<Integer, Account> accounts = new HashMap<>();
    private Bank bank = new Bank(accounts);

    @Test
    public void happyPath() throws Exception {
        int accountId = 12345;

        Account account = new Account("Ivan", 200, 1000);
        bank.save(accountId, account);
        Account result = bank.find(accountId);

        assertThat(result, is(account));
    }

    @Test(expected = DuplicateIdAccountException.class)
    public void registerDuplicateId() throws Exception {
        int accountId = 12345;
        Account account1 = new Account("Ivan", 300, 1000);
        Account account2 = new Account("Maria", 200, 1000);

        bank.save(accountId, account1);
        bank.save(accountId, account2);
    }

    @Test(expected = AccountNotFoundException.class)
    public void findUnregisteredAccount() throws Exception {
        int accountId = 12;
        bank.find(accountId);
    }

    @Test
    public void withDraw() throws Exception {
        int accountId = 101;

        bank.save(accountId, new Account("Lilia", 500, 1000));
        bank.withDraw(accountId, 200);
        Account result = bank.find(accountId);

        assertThat(result, is(new Account("Lilia", 300, 1000)));
    }

    @Test
    public void deposit() throws Exception {
        int accountId = 100;

        bank.save(accountId, new Account("Maria", 300, 1000));
        bank.deposit(accountId, 200);
        Account result = bank.find(accountId);

        assertThat(result, is(new Account("Maria", 500, 1000)));
    }

    @Test(expected = InsufficientCashException.class)
    public void insufficientCash() throws Exception {
        int accountId = 102;

        bank.save(accountId, new Account("Ivan", 20, 1000));
        bank.withDraw(accountId, 100);
    }

    @Test(expected = AccountNotFoundException.class)
    public void withDrawToUndefineAccount() throws Exception {
        int accountId = 102;
        bank.withDraw(accountId, 100);
    }

    @Test(expected = ExceedLimitException.class)
    public void exceedLimit() throws Exception {
        int accountId = 103;
        bank.save(accountId, new Account("Krasimir", 900, 1000));
        bank.deposit(accountId, 300);
    }

    @Test(expected = AccountNotFoundException.class)
    public void depositToUndefinedAccount() throws Exception {
        int accountId = 103;

        bank.deposit(accountId, 100);
    }

    @Test
    public void sortByCash() throws Exception {
        bank.save(100, new Account("Maria", 300, 1000));
        bank.save(101, new Account("Lilia", 500, 1000));
        bank.save(102, new Account("Petia", 50, 1000));
        bank.save(103, new Account("Ivo", 100, 1000));
        ArrayList<Integer> result = bank.sortByCash();

        assertThat(result, is(Arrays.asList(102, 103, 100, 101)));
    }

    @Test(expected = AccountNotFoundException.class)
    public void remove() throws Exception {
        int accountId = 104;

        Account account = new Account("Maria", 300, 1000);
        bank.save(accountId, account);
        bank.remove(accountId);
        bank.find(accountId);
    }

    @Test(expected = AccountNotFoundException.class)
    public void removeUndefineAccount() throws Exception {
        bank.remove(104);
    }
}
