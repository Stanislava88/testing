package com.clouway.store;

/**
 * @author  Ivaylo Penev(ipenev91@gmail.com) on 9/14/15.
 */
public class MaxQuantityException extends RuntimeException {
    public MaxQuantityException(String message) {
         super(message);
    }
}
