package com.clouway.store;

/**
 * Created by ivaylo_penev on 9/14/15.
 */
public class MaxQuantityException extends RuntimeException {
    public MaxQuantityException(String message) {
         super(message);
    }
}
