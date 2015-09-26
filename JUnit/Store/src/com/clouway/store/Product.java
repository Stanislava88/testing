package com.clouway.store;

/**
 * @author ivaylo_penev<ipenev91@gmail.com> on 9/14/15.
 */
public class Product {

    private Double price;
    private int quantity;
    public final int maxQuantity;

    /**
     *
     * @param price is a price of product.
     * @param quantity is a quantiy of product.
     * @param maxQuantity is a max quantity of product.
     */
    public Product( Double price,int quantity,int maxQuantity) {
        this.price = price;
        this.quantity = quantity;
        this.maxQuantity = maxQuantity;
    }

    /**
     *
     * @return price of product.
     */
    public Double getPrice() {
        return price;
    }

    /**
     *
     * @return max quantity of product.
     */
    public int getMaxQuantity() {
        return maxQuantity;
    }

    /**
     *
     * @return current quantity of product.
     */
    public int getQuantity() {
        return quantity;
    }
}
