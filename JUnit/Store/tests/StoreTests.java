import com.clouway.store.Product;
import com.clouway.store.Store;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class StoreTests {

    Store store = new Store();

    @Test
    public void sellProduct() throws Exception {
        Product apple = new Product("apple", 30, 1.40, 1.45);

        store.register(apple);

        assertThat(store.sell("apple", 10), is(20));
    }

    @Test
    public void sellTwoProducts() throws Exception {

        Product apple = new Product("apple", 30, 1.40, 1.45);
        Product kiwi = new Product("kiwi", 20, 0.90, 1.10);

        store.register(apple);
        store.register(kiwi);

        assertThat(store.sell("apple", 10), is(20));
        assertThat(store.sell("kiwi", 10), is(10));
    }

    @Test
    public void profit() throws Exception {

        Product apple = new Product("apple", 30, 1.40, 1.45);

        store.register(apple);

        store.sell("apple", 5);

        assertThat(store.profit(), is(closeTo(0, 25)));
    }

    @Test
    public void lossesAfterSellProduct() throws Exception {

        Product apple = new Product("apple", 30, 1.40, 1.35);

        store.register(apple);

        store.sell("apple", 5);

        assertThat(store.losses(), is(closeTo(-0, 25)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductWithEmptyName() throws Exception {

        Product apple = new Product("", 30, 1.40, 1.35);

        store.register(apple);

    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullProduct() throws Exception {

        Product apple = new Product(null, 30, 1.40, 1.35);

        store.register(apple);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductWithNegativeQuantity() throws Exception {

        Product apple = new Product("apple", -30, 1.40, 1.45);

        store.register(apple);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductWithNegativeSellPrice() throws Exception {

        Product apple = new Product("apple", 30, 1.40, -1.45);

        store.register(apple);

    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductWithNegativeDeliverPrice() throws Exception {
        Product apple = new Product("apple", 30, -1.40, 1.45);

        store.register(apple);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sellNotExisitingProduct() throws Exception {

        Product apple = new Product("apple", 30, 1.40, 1.45);

        store.register(apple);

        assertThat(store.sell("kiwi", 10), is(20));
    }

    @Test(expected = IllegalArgumentException.class)
    public void sellProductMoreThanCurrentQuantity() throws Exception {

        Product apple = new Product("apple", 30, 1.40, 1.45);

        store.register(apple);

        assertThat(store.sell("apple", 35), is(-5));
    }
}
