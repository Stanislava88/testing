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
<<<<<<< HEAD
        if (product.maxQuantity < 0) {
            throw new MaxQuantityException("Add negative max quantity, cannot add negative max quantity");
        }
        if (product.currentQuantity < 0) {
            throw new IllegalArgumentException("Negative quantity of product added,cannot add negative quantity ");
        }
        if (product.price < 0) {
            throw new IllegalArgumentException("Negative price of product added,cannot add negative price");
=======
        if (product.price < 0) {
            throw new NegativePriceException("Negative price added");
        }
        if (product.maxQuantity < 0) {
            throw new NegativeMaxQuantityException("Negative max quantity");
>>>>>>> 23a337f5d14222abef2282ddcde6a8f4acc0c682
        }
        if (productList.get(name) == null) {
            throw new NullPointerException("Null product added, cannot add null product.");
        }
        if(product.currentQuantity < 0){
            throw  new IllegalArgumentException("Negative price of product added, can't add negative price.");
        }
        if(product.currentQuantity > product.maxQuantity){
            throw new MaxQuantityException("Quanity is more than maxQuantity");
        }
    }
    /**
     * @param name     is a name of product in the Store.
<<<<<<< HEAD
     * @param quantity is a quantity of product in the Store.
     * @return quantity of product after sell.
     */
    public int sell(String name, int quantity) {
        product = productList.get(name);
=======
     * @param quantityToSell is a quantity of product in the Store.
     * @return quantity of product after sell.
     */
    public int sell(String name, int quantityToSell) {
        Product product = productList.get(name);
>>>>>>> 23a337f5d14222abef2282ddcde6a8f4acc0c682

        if(!productList.containsKey(name)){
              throw new ProductNotFoundException("Product not found in the store.");
        }
<<<<<<< HEAD
        if (product.currentQuantity - quantity < 0) {
            throw new IllegalArgumentException("Not enough product for sale.");
        }
        return product.currentQuantity -= quantity;
    }

    public double profit(String name, int quantity) {

        return product.price * (product.currentQuantity - quantity);
=======
        if(product.currentQuantity - quantityToSell < 0){
            throw new IllegalArgumentException("Not enough product to sell");
        }
        return product.currentQuantity-= quantityToSell;
>>>>>>> 23a337f5d14222abef2282ddcde6a8f4acc0c682

    }

}

