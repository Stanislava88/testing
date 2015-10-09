package com.clouway.store;

import java.util.*;

/**
 * @author ivaylo_penev<ipenev91@gmail.com> on 9/14/15.
 */
public class Store {

    private Product product;
    private HashMap<String, Product> products = new HashMap<>();


    public void addProduct(String name, Product product) {

        if (name != null && !name.equals("")) {
            products.put(name, product);
        }
        if (product.price < 0) {
            throw new IllegalArgumentException("negative price added, cannot add negative price of product");
        }
        if (product.maxQuantity < 0) {
            throw new MaxQuantityException("negative max quantity is added,cannot add negative max quantity");
        }
        if (product.currentQuantity < 0) {
            throw new IllegalArgumentException("negative quantity of product added cannot add negative quantity.");
        }
        if (product.currentQuantity > product.maxQuantity) {
            throw new IllegalArgumentException("try to add quantity more than max quantity");
        }
        if (name == null) {
            throw new NullProductException("Null product try to add.");
        }
        if (name.equals("")) {
            throw new EmptyProductNameException("Empty product is added.");
        }
    }

    public int sell(String name, int quantity) {

        product = products.get(name);


        if (!products.containsKey(name)) {
            throw new ProductNotFoundException("Product do not exist in the store");
        }
        if (product.currentQuantity - quantity < 0) {
            throw new IllegalArgumentException("Not enough product for sale");
        }
        return product.currentQuantity -= quantity;
    }

    public double profit(String name, int quantity) {

        return product.price * (quantity);
    }

    public double totalProfit(String product1, String product2, int quantityProduct1, int quantityProduct2) {

        Product item1 = products.get(product1);
        Product item2 = products.get(product2);

        double profitFromItem1 = item1.price * (quantityProduct1);
        double profitFromItem2 = item2.price * (quantityProduct2);


        return profitFromItem1 + profitFromItem2;
    }
}

