package com.clouway.store;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 9/14/15.
 */
public class Product {

    private final Double price;
    private  int currentQuantity;
    public final int maxQuantity;

    /**
     *
     * @param price is a price of product.
     * @param currentQuantity is a quantiy of product.
     * @param maxQuantity is a max quantity of product.
     */
    public Product( Double price,int currentQuantity,int maxQuantity) {
        this.price = price;
        this.currentQuantity = currentQuantity;
        this.maxQuantity = maxQuantity;
    }
    /**
     *
     * @return price of product.
     */
    public Double getPrice() {

        return price;
    }
    /**
     *
     * @return max quantity of product.
     */
    public int getMaxQuantity() {
          return maxQuantity;
    }
    /**
     *
     * @return current quantity of product.
     */
    public int getCurrentQuantity(int   quantity) {
        return currentQuantity-=quantity;

    }


}
