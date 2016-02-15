package com.clouway.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com))
 */
public class BankTest {
    Bank bank = new Bank(new HashMap<Integer, Account>());

    @Test
    public void happyPath() throws Exception {
        bank.add(12345, new Account("Ivan", 200, 1000));
        Account result = bank.findById(12345);

        assertThat(result, is(new Account("Ivan", 200, 1000)));
    }

    @Test(expected = AccountNotFoundException.class)
    public void detectedIsMissingAccount() throws Exception {
        bank.findById(12);
    }

    @Test
    public void withDraw() throws Exception {
        bank.add(101, new Account("Lilia", 500, 1000));
        bank.withDraw(101, 200);
        Account result = bank.findById(101);

        assertThat(result, is(new Account("Lilia", 300, 1000)));
    }

    @Test
    public void deposit() throws Exception {
        bank.add(100, new Account("Maria", 300, 1000));
        bank.deposit(100, 200);
        Account result = bank.findById(100);

        assertThat(result, is(new Account("Maria", 500, 1000)));
    }

    @Test(expected = InsufficientCashException.class)
    public void insufficientCash() throws Exception {
        bank.add(102, new Account("Ivan", 20, 1000));
        bank.withDraw(102, 100);
    }

    @Test(expected = ExceedLimitException.class)
    public void exceedLimit() throws Exception {
        bank.add(103, new Account("Krasimir", 20, 1000));
        bank.deposit(103, 1000);
    }

    @Test
    public void sortByCash() throws Exception {
        bank.add(100, new Account("Maria", 300, 1000));
        bank.add(101, new Account("Lilia", 500, 1000));
        bank.add(102, new Account("Petia", 50, 1000));
        bank.add(103, new Account("Ivo", 100, 1000));
        ArrayList<Integer> result = bank.sortByCash();

        assertThat(result, is(Arrays.asList(102, 103, 100, 101)));
    }
}
