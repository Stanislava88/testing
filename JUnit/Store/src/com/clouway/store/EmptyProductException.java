package com.clouway.store;

/**
 * Created by clouway on 9/14/15.
 */
public class EmptyProductException extends RuntimeException {
    public EmptyProductException( String message) {
           super(message);
    }
}
