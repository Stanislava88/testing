package com.clouway.store;

/**
 * @author ivaylo_penev<ipenev91@gmail.com> on 9/26/15.
 */
public class NegativeMaxQuantityException extends RuntimeException {
    public NegativeMaxQuantityException(String message) {
          super(message);
    }
}
