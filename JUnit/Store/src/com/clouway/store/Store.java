package com.clouway.store;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class Store {

    private ProductSlot product;
    private HashMap<String, ProductSlot> products = new HashMap<>();
    private List<OrderedProduct> orderedList = new ArrayList<>();
    private List<Integer> sellQuantites = new ArrayList<>();

    /**
     * @param product         - delivered product in the store
     * @param currentQuantity - deliver quantity
     * @param maxQuantity     - max quantiy which store can received.
     *
     */
    public void addProduct(Product product, int currentQuantity, int maxQuantity) {

        if (product.price < 0) {
            throw new IllegalArgumentException("negative price added, cannot add negative price of product");
        }
        if (maxQuantity < 0) {
            throw new NegativeMaxQuantityException("negative max quantity is added,cannot add negative max quantity");
        }
        if (currentQuantity < 0) {
            throw new IllegalArgumentException("negative quantity of product added cannot add negative quantity.");
        }
        if (currentQuantity > maxQuantity) {
            throw new IllegalArgumentException("try to add quantity more than max quantity");
        }
        if (product.name == null) {
            throw new NullProductException("Null product try to add.");
        }
        if (product.name.equals("")) {
            throw new IllegalArgumentException("Empty product is added.");
        }
        products.put(product.name, new ProductSlot(product, currentQuantity, maxQuantity));
    }

    /**
     * @param order - ordered product which register in the store;
     *
     */

    public void register(OrderedProduct order) {
        orderedList.add(order);
    }

    /**
     * @param product      - ordered product which store received.
     * @param sellQuantity - quantity which we sold from store.
     * @return sell quantity of ordered product;
     */


    public int sellOrderedProduct(OrderedProduct product, int sellQuantity) {

        sellQuantites.add(sellQuantity);

        return product.quantity -= sellQuantity;
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

    /**
     * @return profit of store when sell products;
     *
     */

    public double profit() {

        double profit = 0.0;
        double total = 0.0;

        DecimalFormat df = new DecimalFormat("0.00");
        String totalFormat = df.format(total);
        Double totalValue = Double.parseDouble(totalFormat);

        for (int i = 0; i < orderedList.size(); i++) {

            OrderedProduct orderedProduct = orderedList.get(i);

            for (int j = 0; j < sellQuantites.size(); j++) {

                int sellQuantity = sellQuantites.get(j);

                profit = (orderedProduct.sellPrice - orderedProduct.deliverPrice) * sellQuantity;

            }
            DecimalFormat pf = new DecimalFormat("0.00");
            String profitFormat = pf.format(profit);
            Double profitValue = Double.parseDouble(profitFormat);

            totalValue += profitValue;
        }
        return totalValue;
    }

    /**
     * @return losses after sell product with price less than delivered price.
     *
     */

    public double losses() {

        double losses = 0.0;
        double total = 0.0;

        DecimalFormat df = new DecimalFormat("0.00");
        String totalFormat = df.format(total);
        Double totalValue = Double.parseDouble(totalFormat);

        for (int i = 0; i < orderedList.size(); i++) {

            OrderedProduct orderedProduct = orderedList.get(i);

            for (int j = 0; j < sellQuantites.size(); j++) {

                int sellQuantity = sellQuantites.get(j);

                losses = (orderedProduct.sellPrice - orderedProduct.deliverPrice) * sellQuantity;

            }
            DecimalFormat pf = new DecimalFormat("0.00");
            String lossesFormat = pf.format(losses);
            Double lossesValue = Double.parseDouble(lossesFormat);

            totalValue += lossesValue;
        }
        return totalValue;
    }

    /**
     * @return amount profit when sell product;
     */
    public double amountMoney() {

        double amount = 0.0;
        double total = 0.0;

        for (int i = 0; i < orderedList.size(); i++) {

            OrderedProduct orderedProduct = orderedList.get(i);

            for (int j = 0; j < sellQuantites.size(); j++) {

                int sellQuantity = sellQuantites.get(j);

                amount = sellQuantity * orderedProduct.sellPrice;
            }
            total += amount;
        }
        return total;
    }
}

