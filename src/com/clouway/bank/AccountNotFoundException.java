package com.clouway.bank;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
