package com.clouway.store;

/**
 * Created by clouway on 9/14/15.
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
           super(message);
    }
}
