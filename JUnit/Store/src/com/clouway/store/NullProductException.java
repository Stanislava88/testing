package com.clouway.store;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 10/8/15.
 */
public class NullProductException extends RuntimeException {
    public NullProductException(String message) {
        super(message);
    }
}
