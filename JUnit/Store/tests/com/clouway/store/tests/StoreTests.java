package com.clouway.store.tests;

import com.clouway.store.*;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author  ivaylo_penev <ipenev91@gmail.com> on 9/14/15.
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
    }

    @Test(expected = ProductNotFoundException.class)
    public void sellNotFoundProduct() throws Exception {

        store.addProduct("orange", new Product(1.20, 15, 30));
        store.sell("kiwi", 12);
    }

    @Test(expected = EmptyProductNameException.class)
    public void addProductWithEmptyName() throws Exception {

        store.addProduct(" ", new Product(1.00, 20, 50));
    }


    @Test(expected = NegativeMaxQuantityException.class)
    public void addProductWithNegativeMaxQuantity() throws Exception {

        store.addProduct("cabbage", new Product(1.10, 20, -30));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductWithNegativeQuantity() throws Exception {

        store.addProduct("orange", new Product(1.20, -10, 20));
    }

    @Test(expected = NegativePriceException.class)
    public void addProductWithNegativePrice() throws Exception {

        store.addProduct("cucumber", new Product(-1.00, 20, 40));
    }

    @Test(expected = StoreQuantityException.class)
    public void tryToSellProductWithQuantityMoreThanQuantiNametyInTheStore() {

        store.addProduct("lemon", new Product(0.80, 15, 30));
        assertThat(store.sell("lemon", 16), is(-1));
    }

    @Test(expected = MaxQuantityException.class)
    public void tryToAddlProductQuantityMoreThanMaxQuantity() throws Exception {
        store.addProduct("apple",new Product(1.10,40,35));
    }
}