package com.clouway.store;

import java.util.*;

/**
 * @author ivaylo_penev<ipenev91@gmail.com> on 9/14/15.
 */
public class Store {

    private HashMap<String,Product> products = new HashMap<>();


    public void addProduct(String name,Product product) {

        products.put(name, product);

        if(product.price < 0 ){
            throw new IllegalArgumentException("negative price added, cannot add negative price of product");
        }
        if(product.maxQuantity < 0 ){
            throw new IllegalArgumentException("negative max quantity is added,cannot add negative max quantity");
        }
        if (product.currentQuantity < 0){
            throw new IllegalArgumentException("negative quantity of product added cannot add negative quantity.");
        }
        if(product.currentQuantity > product.maxQuantity){
            throw new IllegalArgumentException("try to add quantity more than max quantity");
        }
        if(name == null){
            throw new IllegalArgumentException("Null product try to add.");
        }
    }

    public int sell(String name,int quantity) {

        Product product = products.get(name);


        if(!products.containsKey(name)){
            throw new ProductNotFoundException("Product do not exist in the store");
        }
        if(product.currentQuantity - quantity < 0){
            throw new IllegalArgumentException("Not enough product for sale");
        }
        return product.currentQuantity -= quantity;
    }

    public double  profit(String name, int quantiy) {

        Product product = products.get(name);

        double profitAfter = product.price*(product.currentQuantity - quantiy);

        return profitAfter;
    }

}

