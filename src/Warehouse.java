import java.util.Map;

/**
 * Created by clouway on 15-9-11.
 */
public class Warehouse {
    private final Display dispay;
    Map<String, Product> products;

    public Warehouse(Display dispay, Map<String, Product> products) {
        this.dispay = dispay;
        this.products = products;
    }

    public void checkProductPrice(String productName) {
        if (productName == null || productName.equals("")) {
            dispay.setDisplayMessage("Product not avaible!");
        } else if (products.containsKey(productName)) {
            String price = products.get(productName).getPrice();
            dispay.setDisplayMessage(price);
        }
    }

    public void deliverProducts(String productToDeliver, int quantityToDeliver) {
        Product product = products.get(productToDeliver);
        if(product==null){
            dispay.setDisplayMessage("The warehouse cannot accept orders for "+productToDeliver);
            return;
        }
        int quantity=products.get(productToDeliver).getQuantity();
        int maxQuantity=products.get(productToDeliver).getMaxQuantity();
        int currentQuantity = quantity + quantityToDeliver;

        if (currentQuantity <= maxQuantity) {
            product.setQuantity(quantityToDeliver);
            dispay.setDisplayMessage(quantityToDeliver + " bottles of " + productToDeliver + " were delivered in the warehouse");
        }else{
            dispay.setDisplayMessage("The quantity to deliver is more than the Warehouse can accept");
        }
    }

    public void sellProducts(String productForSale, int quantityForSale) {
        Product product=products.get(productForSale);
        int currentQuantity=product.getQuantity();

        if(currentQuantity-quantityForSale>=0){
            dispay.setDisplayMessage(quantityForSale+" bottles of "+productForSale+" were sold from the warehouse");
        }
    }
}

