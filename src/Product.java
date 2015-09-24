/**
 * Created by clouway on 15-9-11.
 */
public class Product {
    private final String price;
    private int quantity;
    private final int maxQuantity;

    public String getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public Product(String price, int quantity, int maxQuantity) {
        this.price = price;
        this.quantity = quantity;
        this.maxQuantity = maxQuantity;

    }

    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }
}
