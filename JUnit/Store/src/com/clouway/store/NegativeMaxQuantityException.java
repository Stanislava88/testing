package com.clouway.store;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 9/26/15.
 */
public class NegativeMaxQuantityException extends RuntimeException {
    public NegativeMaxQuantityException(String message) {
          super(message);
    }
}
