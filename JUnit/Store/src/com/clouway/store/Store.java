package com.clouway.store;

import java.util.*;

/**
 * @author ivaylo_penev<ipenev91@gmail.com> on 9/14/15.
 */
public class Store {

    private Product product;
    private HashMap<String, Product> productList = new HashMap<>();

    /**
     * @param name    is a name of Product in the Store added.
     * @param product contains product characteristics.
     */
    public void addProduct(String name, Product product) {

        productList.put(name, product);

        if (name.equals("")) {
            throw new EmptyProductNameException("Empty product name added");
        }
        if (product.maxQuantity < 0) {
            throw new MaxQuantityException("Add negative max quantity, cannot add negative max quantity");
        }
        if (product.currentQuantity < 0) {
            throw new IllegalArgumentException("Negative quantity of product added,cannot add negative quantity ");
        }
        if (product.price < 0) {
            throw new IllegalArgumentException("Negative price of product added,cannot add negative price");
        }
    }
    /**
     * @param name     is a name of product in the Store.
     * @param quantity is a quantity of product in the Store.
     * @return quantity of product after sell.
     */
    public int sell(String name, int quantity) {
        product = productList.get(name);

        if (!productList.containsKey(name)) {
            throw new ProductNotFoundException("Product not found");
        }
        if (product.currentQuantity - quantity < 0) {
            throw new IllegalArgumentException("Not enough product for sale.");
        }
        return product.currentQuantity -= quantity;
    }

    public double profit(String name, int quantity) {

        return product.price * (product.currentQuantity - quantity);

    }

}

