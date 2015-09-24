package com.clouway.store.tests;

import com.clouway.store.MaxQuantityException;
import com.clouway.store.Product;
import com.clouway.store.ProductNotFoundException;
import com.clouway.store.Store;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by clouway on 9/14/15.
 */
public class StoreTests {

    private Store store;

    @Before
    public void setUp(){
        store = new Store();
    }
    @Test
    public void sellProduct(){
        final Product apple = new Product("apple",2.1,20);
        store.addProduct(apple);
        store.addQuantity("apple", 12);

        assertThat(store.sell("apple",6),is(6));
    }

    @Test(expected = ProductNotFoundException.class)
    public void sellNotFoundProduct() throws Exception {
        final Product orange = new Product("orange",1.20,30);

        store.addProduct(orange);
        store.sell("kiwi",12);

    }

    @Test(expected = MaxQuantityException.class)
    public void addProductWithQuantityMoreThanMaxQuantity() throws Exception {
         final Product cabbage = new Product("cabbage",1.30,40);

         store.addProduct(cabbage);
         store.addQuantity("cabbage", 50);

         assertThat(store.sell("cabbage",20),is(30));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductWithnegativePrice() throws Exception {
        final Product carrot = new Product("carrot",-1.00,100);

         store.addProduct(carrot);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductWithNegativeMaxQuantity() throws Exception {
        final Product lemon = new Product("lemon",1.10,-30);

        store.addProduct(lemon);
        store.addQuantity("lemon", 12);

        assertThat(store.sell("lemon",6),is(6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductWithEmptyName() throws Exception {
        final Product carrot = new Product(" ",1.2,100);

        store.addProduct(carrot);
    }

    @Test
    public void sortProductsByPrice() throws Exception {
        final Product orange = new Product("orange",1.10,20);
        final Product carrot = new Product("carrot",1.08,25);
        final Product cabbage = new Product("cabbage",1.00,34);

        store.addProduct(orange);
        store.addProduct(carrot);
        store.addProduct(cabbage);

        List<Product> sortProductList = new ArrayList<Product>(store.sort());

        assertThat(sortProductList.get(0),is(cabbage));
        assertThat(sortProductList.get(1),is(carrot));
        assertThat(sortProductList.get(2),is(orange));
    }
}
