package com.clouway.store;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class ProductPlot {
    public Product product;
    public int currentQuantity;
    public int maxQuantity;

    public ProductPlot(Product product, int currentQuantity, int maxQuantity) {
        this.product = product;
        this.currentQuantity = currentQuantity;
        this.maxQuantity = maxQuantity;
    }
}
