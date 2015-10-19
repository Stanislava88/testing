package com.clouway.store;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class Product {

    public String name;
    public int currentQuantity;
    public double deliverPrice;
    public double sellPrice;

    public Product(String name, int currentQuantity, double deliverPrice, double sellPrice) {
        this.name = name;
        this.currentQuantity = currentQuantity;
        this.deliverPrice = deliverPrice;
        this.sellPrice = sellPrice;
    }
}
