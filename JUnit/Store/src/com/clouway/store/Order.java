package com.clouway.store;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 10/12/15.
 */
public class Order {

    public String name;
    public final int quantity;
    public final double price;

    public Order(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
