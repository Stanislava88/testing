package com.clouway.store.tests;

import com.clouway.store.*;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

        store.addProduct("apple", new Product(2.1, 20, 50));
        assertThat(store.sell("apple", 6), is(14));
        assertThat(store.sell("apple", 6), is(8));
        assertThat(store.sell("apple", 2), is(6));
        assertThat(store.sell("apple", 2), is(4));
        assertThat(store.sell("apple", 2), is(2));
        assertThat(store.sell("apple", 6), is(2));

    }

    @Test
    public void sellTwoProducts() throws Exception {
        store.addProduct("kiwi", new Product(0.90, 20, 40));
        store.addProduct("orange", new Product(0.80, 25, 35));

        assertThat(store.sell("kiwi", 10), is(10));
        assertThat(store.sell("kiwi", 10), is(0));

        assertThat(store.sell("orange", 15), is(10));
        assertThat(store.sell("orange", 5), is(5));
    }

    @Test(expected = ProductNotFoundException.class)
    public void sellNotFoundProduct() throws Exception {
        store.addProduct("kiwi", new Product(1.10, 20, 30));

        assertThat(store.sell("apple", 10), is(10));
        assertThat(store.sell("orange", 15), is(10));

    }

    @Test(expected = ProductNotFoundException.class)
    public void sellProductNotFound() throws Exception {
        store.addProduct("apple", new Product(1.20, 20, 40));
        assertThat(store.sell("kiwi", 10), is(10));
    }

    @Test(expected = MaxQuantityException.class)
    public void addProductWithNegativeMaxQuantity() throws Exception {
        store.addProduct("cabbage", new Product(1.00, 20, -35));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductWithNegativeCurrentQuantity() throws Exception {
        store.addProduct("cucumber", new Product(1.20, -15, 20));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductWithNegativePrice() throws Exception {
        store.addProduct("apple", new Product(-1.20, 30, 35));
    }

    @Test(expected = EmptyProductNameException.class)
    public void addProductWithEmptyFields() throws Exception {
        store.addProduct("", new Product(1.20, 30, 40));
    }

    @Test(expected = IllegalArgumentException.class)
    public void sellProductWithQuantityMoreThanQuantityInTheStore() throws Exception {
        store.addProduct("apple", new Product(1.20, 15, 30));
        assertThat(store.sell("apple", 16), is(-1));
    }

    @Test
    public void profitAfterSellProduct() throws Exception {
        store.addProduct("apple", new Product(0.80, 30, 40));

        store.sell("apple", 10);

        assertThat(store.profit("apple", 10), is(8.00));
    }

}
