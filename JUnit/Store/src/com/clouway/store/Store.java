package com.clouway.store;

import java.util.*;

/**
 * Created by ivaylo_penev on 9/14/15.
 */
public class Store {

    private Map<String,Integer> productQuantity = new HashMap<>();
    private Map<String,Product> productList = new HashMap<>();
    private List<Product> price = new ArrayList<>();


    public void addProduct(Product product) {
          price.add(product);
          productList.put(product.getName(),product);

          if(product.getName().equals("")){
              throw new EmptyProductException("Empty product name.");
          }
          if(product.getPrice() < 0 ){
              throw new IllegalArgumentException("Negative price added");
          }
          if(product.getMaxQuantity()<0){
              throw new IllegalArgumentException("Negative max quantity");
          }
    }

    public void addQuantity(String name, int quantity) {
          if(!productList.containsKey(name)){
              throw new ProductNotFoundException("Product not found");
          }
          if(quantity > productList.get(name).getMaxQuantity()){
              throw new MaxQuantityException("quantity us more than max quantity");
          }
          productQuantity.put(name,quantity);
    }

    public int sell(String name, int quantity) {
          if(!productList.containsKey(name)){
              throw new  ProductNotFoundException("Product not found");
          }
          if(quantity > productQuantity.get(name)){
              throw new MaxQuantityException("quantity is more than max quantity");
          }
          return productQuantity.get(name) - quantity;
    }

    public List<Product> sort() {
         List<Product> sortProductByPrice = new ArrayList<>(price);
         Collections.sort(sortProductByPrice);
         return sortProductByPrice;
    }
}
