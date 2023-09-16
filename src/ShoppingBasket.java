import java.util.ArrayList;

public class ShoppingBasket {
    ArrayList<Item> shoopinBasket = new ArrayList<>();

    @Override
    public String toString() {
        return "ShoppingBasket content: " + shoopinBasket;
    }
}
