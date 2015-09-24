package com.clouway.store;

/**
 * Created by ivaylo_penev on 9/14/15.
 */
public class Product implements Comparable<Product> {

    private String name;
    private Double price;
    private int maxQuantity;

    public Product(String name, Double price, int maxQuantity) {
        this.name = name;
        this.price = price;
        this.maxQuantity = maxQuantity;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    @Override
    public int compareTo(Product o) {
        return this.price.compareTo(o.getPrice());
    }
}
