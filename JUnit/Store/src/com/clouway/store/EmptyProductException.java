package com.clouway.store;

/**
 * @author ivaylo_penev<ipenev91@gmail.com> on 9/14/15.
 */
public class EmptyProductException extends RuntimeException {
    public EmptyProductException( String message) {
           super(message);
    }
}
