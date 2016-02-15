package com.clouway.bank;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com))
 */
public class InsufficientCashException extends RuntimeException {
    public InsufficientCashException(String msg) {
        super(msg);
    }
}
