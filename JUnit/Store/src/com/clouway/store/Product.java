package com.clouway.store;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class Product {

    public String name;
    public Double price;

    /**
     *
     * @param name - name of product
     * @param price - price of product
     */
    public Product(String name,Double price) {
        this.name = name;
        this.price = price;
    }
}

