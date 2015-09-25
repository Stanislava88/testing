package warehouse;

import org.junit.Test;
import warehouse.Display;
import warehouse.Product;
import warehouse.Warehouse;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by clouway on 15-9-11.
 */
public class WarehouseTest {
    Map<String, Product> products = new HashMap<String,Product>(){{
        put("Cola",new Product("$1.50",0,50));
        put("Fanta",new Product("$1.39",0,60));

    }};
    final Display display = new Display();
    final Warehouse warehouse = new Warehouse(display,products);
    @Test
    public void checkProductPrice(){
        warehouse.checkProductPrice("Cola");
        assertEquals("$1.50",display.displayMessage());
    }

    @Test
    public void checkAnotherProductPrice(){
        warehouse.checkProductPrice("Fanta");
        assertEquals("$1.39",display.displayMessage());
    }

    @Test
    public void checkIfProductNameIsEmpty(){
        warehouse.checkProductPrice("");
        assertEquals("warehouse.Product not avaible!",display.displayMessage());
    }

    @Test
    public void checkIfProductIsNull(){
        warehouse.checkProductPrice(null);
        assertEquals("warehouse.Product not avaible!",display.displayMessage());

    }

    @Test
    public void deliverProductsInTheWarehouse(){
        warehouse.deliverProducts("Cola", 30);
        assertEquals("30 bottles of Cola were delivered in the warehouse",display.displayMessage());
    }

    @Test
    public void deliverMoredProductsThanTheWarehouseCanAccept(){
        warehouse.deliverProducts("Cola",70);
        assertEquals("The quantity to deliver is more than the warehouse.Warehouse can accept",display.displayMessage());
    }

    @Test
    public void tryToDeliverProductWhichIsNotOfferedInTheWarehouse(){
        warehouse.deliverProducts("Devin",60);
        assertEquals("The warehouse cannot accept orders for Devin",display.displayMessage());
    }

    @Test
    public void sellProductsFromTheWarehouse(){
        warehouse.deliverProducts("Fanta",20);
        warehouse.sellProducts("Fanta", 15);
        assertEquals("15 bottles of Fanta were sold from the warehouse",display.displayMessage());
    }

    @Test
    public void tryToSellMoreProductsThanInStock(){
        warehouse.deliverProducts("Cola",40);
        warehouse.sellProducts("Cola", 41);
        assertEquals("There is not enough quantity of Cola in the warehouse!",display.displayMessage());
    }

    @Test
    public void tryToSellProductWhichTheWarehouseDoesNotOffer(){
        warehouse.sellProducts("Zayo Bayo",20);
        assertEquals("warehouse.Product not avaible!",display.displayMessage());
    }

}
