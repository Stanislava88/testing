package com.clouway.bank;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com))
 */
public class ExceedLimitException extends RuntimeException {
    public ExceedLimitException(String msg) {
        super(msg);
    }
}
