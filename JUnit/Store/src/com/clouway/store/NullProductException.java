package com.clouway.store;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class NullProductException extends RuntimeException {
    public NullProductException(String message) {
        super(message);
    }
}
