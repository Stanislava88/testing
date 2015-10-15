package com.clouway.store;

/**
 * @author  Ivaylo Penev(ipenev91@gmail.com)
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
           super(message);
    }
}
