package com.clouway.store;

import java.util.*;

/**
 * @author ivaylo_penev<ipenev91@gmail.com> on 9/14/15.
 */
public class Store {

    private Map<String, Product> productList = new HashMap<>();

    /**
     *
     * @param name is a name of Product in the Store added.
     * @param product contains product characteristics.
     */
    public void addProduct(String name, Product product) {

        productList.put(name, product);

        if (name == null || name.equals(" ")) {
            throw new EmptyProductNameException("Empty product name added");
        }
        if (product.getPrice() < 0) {
            throw new NegativePriceException("Negative price added");
        }
        if (product.getMaxQuantity() < 0) {
            throw new NegativeMaxQuantityException("Negative max quantity");
        }
        if(product.getQuantity() < 0){
            throw new IllegalArgumentException("Negative quantity added.");
        }
    }

    /**
     *
     * @param name is a name of product in the Store.
     * @param quantity is a quantity of product in the Store.
     * @return quantity of product after sell.
     */
    public int sell(String name, int quantity) {
        Product product = productList.get(name);

        if (!productList.containsKey(name)) {
            throw new ProductNotFoundException("Product not found");
        }
        if (quantity > productList.get(name).getMaxQuantity()) {
            throw new MaxQuantityException("quantity is more than max quantity");
        }

        return product.getQuantity() - quantity;
    }

}
