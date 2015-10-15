package com.clouway.store.tests;

import com.clouway.store.*;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 9/14/15.
 */
public class StoreTests {

    private Store store;

    @Before
    public void setUp() {
        store = new Store();
    }

    @Test
    public void sellProduct() {

        store.addProduct(new Product("apple", 2.1), 20, 50);
        assertThat(store.sell("apple", 6), is(14));
        assertThat(store.sell("apple", 6), is(8));
        assertThat(store.sell("apple", 2), is(6));
        assertThat(store.sell("apple", 2), is(4));
        assertThat(store.sell("apple", 2), is(2));
    }

    @Test
    public void sellTwoProducts() throws Exception {
        store.addProduct(new Product("kiwi", 0.90), 20, 40);
        store.addProduct(new Product("orange", 1.90), 25, 40);

        assertThat(store.sell("kiwi", 10), is(10));
        assertThat(store.sell("kiwi", 10), is(0));

        assertThat(store.sell("orange", 15), is(10));
        assertThat(store.sell("orange", 5), is(5));
    }

    @Test(expected = ProductNotFoundException.class)
    public void sellNotExistingProduct() throws Exception {

        store.addProduct(new Product("apple", 1.20), 20, 45);

        assertThat(store.sell("kiwi", 10), is(10));
    }

    @Test(expected = NegativeMaxQuantityException.class)
    public void addProductWithNegativeMaxQuantity() throws Exception {
        store.addProduct(new Product("cabbage", 1.00), 20, -35);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductWithNegativeCurrentQuantity() throws Exception {
        store.addProduct(new Product("cucumber", 1.20), -15, 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductWithNegativePrice() throws Exception {
        store.addProduct(new Product("apple", -1.20), 30, 35);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductWithEmptyName() throws Exception {
        store.addProduct(new Product("", 1.20), 30, 40);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sellProductWithQuantityMoreThanQuantityInTheStore() throws Exception {
        store.addProduct(new Product("apple", 1.20), 15, 30);
        assertThat(store.sell("apple", 16), is(-1));
    }

    @Test(expected = NullProductException.class)
    public void addNullProduct() throws Exception {
        store.addProduct(new Product(null, 1.20), 30, 45);
    }

    @Test
    public void profitAfterSellOneProduct() throws Exception {
        OrderedProduct apple = new OrderedProduct("apple", 50, 1.40, 1.45);

        store.register(apple);

        store.sellOrderedProduct(apple, 5);

        assertThat(store.profit(), is(0.25));
    }

    @Test
    public void profitAfterSellMoreProducts() throws Exception {

        OrderedProduct apple = new OrderedProduct("apple", 50, 1.40, 1.45);
        OrderedProduct orange = new OrderedProduct("orange", 50, 1.40, 1.55);
        OrderedProduct kiwi = new OrderedProduct("kiwi", 50, 1.40, 1.45);

        store.register(apple);
        store.register(orange);
        store.register(kiwi);

        store.sellOrderedProduct(apple, 10);
        store.sellOrderedProduct(orange, 10);
        store.sellOrderedProduct(kiwi, 5);

        assertThat(store.profit(), is(1.25));
    }

    @Test
    public void loosesAfterSellProduct() throws Exception {

        OrderedProduct apple = new OrderedProduct("apple", 50, 1.40, 1.35);

        store.register(apple);

        store.sellOrderedProduct(apple, 5);

        assertThat(store.losses(), is(-0.25));
    }

    @Test
    public void lossesAfterSellMoreProducts() throws Exception {

        OrderedProduct apple = new OrderedProduct("apple", 50, 1.40, 1.35);
        OrderedProduct orange = new OrderedProduct("orange", 30, 1.40, 1.25);

        store.register(apple);
        store.register(orange);

        store.sellOrderedProduct(apple, 10);
        store.sellOrderedProduct(orange, 10);

        assertThat(store.losses(), is(-2.00));
    }

    @Test
    public void amountProfit() throws Exception {
        OrderedProduct apple = new OrderedProduct("apple", 50, 1.40, 1.35);

        store.register(apple);

        store.sellOrderedProduct(apple, 5);

        assertThat(store.amountMoney(), is(6.75));

    }
}
