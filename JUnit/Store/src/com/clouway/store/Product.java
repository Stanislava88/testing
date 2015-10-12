package com.clouway.store;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 9/14/15.
 */
public class Product {

    public final Double price;
    public int currentQuantity;
    public final int maxQuantity;

    /**
     * @param price           is a price of product.
     * @param currentQuantity is a quantiy of product.
     * @param maxQuantity     is a max quantity of product.
     */
    public Product(Double price, int currentQuantity, int maxQuantity) {
        this.price = price;
        this.currentQuantity = currentQuantity;
        this.maxQuantity = maxQuantity;

    }
     public int getCurrentQuantity(int quantity) {
        return currentQuantity-= quantity;
    }
}

