package com.clouway.warehouse;

import java.util.Map;

/**
 * Created by clouway on 15-9-11.
 */
public class Warehouse {
    private final Display dispay;
    private final Map<String, Product> products;

    public Warehouse(Display dispay, Map<String, Product> products) {
        this.dispay = dispay;
        this.products = products;
    }

    public void checkProductPrice(String productName) {
        if (productName == null || productName.equals("")) {
            dispay.displayMessage("Product not avaible!");
        } else if (products.containsKey(productName)) {
            String price = products.get(productName).getPrice();
            dispay.displayMessage(price);
        }
    }

    public void deliverProducts(String productToDeliver, int quantityToDeliver) {
        Product product = products.get(productToDeliver);
        if (product == null) {
            dispay.displayMessage("The warehouse.warehouse cannot accept orders for " + productToDeliver);
            return;
        }
        int quantity = products.get(productToDeliver).getQuantity();
        int maxQuantity = products.get(productToDeliver).getMaxQuantity();
        int currentQuantity = quantity + quantityToDeliver;

        if (currentQuantity <= maxQuantity) {
            product.setQuantity(quantityToDeliver);
            dispay.displayMessage(quantityToDeliver + " bottles of " + productToDeliver + " were delivered in the warehouse.warehouse");
        } else {
            dispay.displayMessage("The quantity to deliver is more than the Warehouse can accept");
        }
    }

    public void sellProducts(String productForSale, int quantityForSale) {
        Product product = products.get(productForSale);
        if (product == null) {
            dispay.displayMessage("Product not avaible!");
            return;
        }
        int currentQuantity = product.getQuantity();
        if (currentQuantity - quantityForSale >= 0) {
            dispay.displayMessage(quantityForSale + " bottles of " + productForSale + " were sold from the warehouse.warehouse");
        } else {
            dispay.displayMessage("There is not enough quantity of " + productForSale + " in the warehouse.warehouse!");
        }
    }
}

