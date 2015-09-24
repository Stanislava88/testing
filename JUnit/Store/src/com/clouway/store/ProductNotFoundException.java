package com.clouway.store;

/**
 * Created by ivaylo_penev on 9/14/15.
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
           super(message);
    }
}
