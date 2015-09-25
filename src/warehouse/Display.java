package warehouse;

/**
 * Created by clouway on 15-9-11.
 */
public class Display {
    private String price;

    public String displayMessage() {
        return price;
    }

    public void displayMessage(String price) {
        this.price = price;
    }
}
