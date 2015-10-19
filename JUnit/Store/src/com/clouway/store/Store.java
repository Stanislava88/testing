package com.clouway.store;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class Store {
    Map<String, Product> products = new HashMap<>();

    private double profit;
    private double losses;

    public void register(Product product) {
        if (product.name == null) {
            throw new IllegalArgumentException("Null product is added, cannot add null product");
        }
        if (product.name.equals("")) {
            throw new IllegalArgumentException("Product with empty name is added, cannot add product with empty name");
        }
        if (product.currentQuantity < 0) {
            throw new IllegalArgumentException("Negative quantity is added,cannot add product with negative quantity");
        }
        if (product.deliverPrice < 0) {
            throw new IllegalArgumentException("Negative deliver product price is added,cannot add product with negative deliver price");
        }
        if (product.sellPrice < 0) {
            throw new IllegalArgumentException("Negative sell product price is added,cannot add product with negative sell price");
        }
        products.put(product.name, product);
    }

    public int sell(String name, int sellQuantity) {
        if (!products.containsKey(name)) {
            throw new IllegalArgumentException("Product do not exist.");
        }

        Product product = products.get(name);

        if (product.currentQuantity - sellQuantity < 0) {
            throw new IllegalArgumentException("Not enough product for sell.");
        }
        profit = (product.sellPrice - product.deliverPrice) * sellQuantity;
        losses = (product.sellPrice - product.deliverPrice) * sellQuantity;

        return product.currentQuantity -= sellQuantity;
    }

    public double profit() {

        double total = 0.0;

        total += profit;

        return total;
    }

    public double losses() {
        double total = 0.0;

        total += losses;

        return total;
    }

}
