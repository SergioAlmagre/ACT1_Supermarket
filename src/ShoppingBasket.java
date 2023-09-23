import java.util.ArrayList;

public class ShoppingBasket {
    ArrayList<Item> shoppinBasket = new ArrayList<>();

    @Override
    public String toString() {
        String details = "--------------SHOPPING BASKET---------------" + '\n';
        for (int i = 0; i< shoppinBasket.size(); i++){
            details = details + shoppinBasket.get(i);
        }
        return details;
    }


}
