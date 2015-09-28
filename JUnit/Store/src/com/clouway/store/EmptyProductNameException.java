package com.clouway.store;

/**
 * @author  Ivaylo Penev(ipenev91@gmail.com) on 9/26/15.
 */
public class EmptyProductNameException extends RuntimeException {
    public EmptyProductNameException(String message) {
         super(message);
    }
}
