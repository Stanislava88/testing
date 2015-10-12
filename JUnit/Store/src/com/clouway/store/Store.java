package com.clouway.store;

import java.util.*;

/**
 * @author ivaylo_penev<ipenev91@gmail.com> on 9/14/15.
 */
public class Store {

    private Product product;
    private HashMap<String, Product> products = new HashMap<>();
    private List<Product> cart = new ArrayList();

    public void addProduct(String name, Product product) {

        if( name != null && !name.equals("") ) {
            cart.add(product);
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

    public double profit(int sellQuantity) {

        return product.price * (sellQuantity);
    }
    public double totalProfit(int sellQuantityOfProducts) {
       
        double totalProfit = 0.0;
        double sum = 0.0;

        for (int i = 0; i < cart.size(); i++) {

            product = cart.get(i);

            totalProfit = product.getCurrentQuantity(sellQuantityOfProducts) * product.price;
            sum += totalProfit;
        }
        return sum;
    }
}

