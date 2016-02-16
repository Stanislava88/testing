package com.clouway.bank;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class DuplicateIdAccountException extends RuntimeException {
    public DuplicateIdAccountException(String msg) {
        super(msg);
    }
}
