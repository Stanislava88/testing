package com.clouway.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class Bank {
    private HashMap<Integer, Account> volt;

    public Bank(HashMap<Integer, Account> volt) {
        this.volt = volt;
    }

    public void save(int id, Account account) {
        if (!volt.containsKey(id)) {
            volt.put(id, account);
        } else throw new DuplicateIdAccountException("This id is not available");
    }

    public Account find(int id) {
        return getAccount(id);
    }

    public void withDraw(int id, double cash) {
        Account account = getAccount(id);
        if (account.getCash() > cash) {
            account.withDraw(cash);
        } else throw new InsufficientCashException("You can't draw money. The cash is insufficient!");
    }

    public void deposit(int id, double cash) {
        Account account = getAccount(id);
        double totalAmount = account.getCash() + cash;
        if (totalAmount < account.limit) {
            account.deposit(cash);
        } else
            throw new ExceedLimitException("You can't deposit. Exceed limit!");
    }

    public ArrayList<Integer> sortByCash() {
        ArrayList<Integer> accountsId = new ArrayList<>(volt.keySet());
        Collections.sort(accountsId, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (volt.get(o1).getCash() > volt.get(o2).getCash()) {
                    return 1;
                }
                return -1;
            }
        });
        return accountsId;
    }

    public void remove(int id) {
        getAccount(id);
        volt.remove(id);
    }

    private Account getAccount(int accountId) {
        if (volt.containsKey(accountId)) {
            return volt.get(accountId);
        } else throw new AccountNotFoundException("This accountId is not available");
    }
}