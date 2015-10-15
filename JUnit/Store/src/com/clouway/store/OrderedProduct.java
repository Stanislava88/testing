package com.clouway.store;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com
 */
public class OrderedProduct {

    public String name;
    public int quantity;
    public final double deliverPrice;
    public final double sellPrice;

    /**
     * @param name         - name of product
     * @param quantity     - deliver quantity in the store.
     * @param deliverPrice - deliver price of product;
     * @param sellPrice    - sell price of product.
     */
    public OrderedProduct(String name, int quantity, double deliverPrice, double sellPrice) {
        this.name = name;
        this.quantity = quantity;
        this.deliverPrice = deliverPrice;
        this.sellPrice = sellPrice;
    }
}
