package com.clouway.store;

/**
 * Created by ivaylo_penev on 9/14/15.
 */
public class EmptyProductException extends RuntimeException {
    public EmptyProductException( String message) {
           super(message);
    }
}
