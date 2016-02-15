package com.clouway.bank;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class Account {
    public final double limit;
    private final String userName;
    private double cash;

    public Account(String userName, double cash, double limit) {

        this.userName = userName;
        this.cash = cash;
        this.limit = limit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.cash, cash) != 0) return false;
        if (Double.compare(account.limit, limit) != 0) return false;
        return userName != null ? userName.equals(account.userName) : account.userName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userName != null ? userName.hashCode() : 0;
        temp = Double.doubleToLongBits(cash);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(limit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public void withDraw(double cash) {
        this.cash -= cash;
    }

    public void deposit(double cash) {
        this.cash += cash;
    }

    public double getCash() {
        return cash;
    }
}
