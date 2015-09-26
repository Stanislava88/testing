package com.clouway.store;

/**
 * @author ivaylo_penev<ipenev91@gmail.com> on 9/26/15.
 */
public class NegativePriceException extends RuntimeException {
    public NegativePriceException(String message) {
          super(message);
    }
}
