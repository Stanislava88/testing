package com.clouway.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com))
 */
public class Bank {
    private HashMap<Integer, Account> volt;

    public Bank(HashMap<Integer, Account> volt) {

        this.volt = volt;
    }

    public void add(int id, Account account) {
        volt.put(id, account);
    }

    public Account findById(int id) {
        if (volt.containsKey(id)) {
            return volt.get(id);
        } else throw new AccountNotFoundException("This user is not available");
    }

    public void withDraw(int id, double cash) {
        Account account = volt.get(id);
        if (account.getCash() > cash) {
            account.withDraw(cash);
        } else throw new InsufficientCashException("You can't draw money. The cash is insufficient!");
    }

    public void deposit(int id, double cash) {
        Account account = volt.get(id);
        if (account.getCash() + cash < account.limit) {
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
}