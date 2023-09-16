import java.math.BigDecimal;

public class Item {

    String ItemID;
    String nameItem;
    BigDecimal price;

    public Item(String itemID, String nameItem, BigDecimal price) {
        ItemID = itemID;
        this.nameItem = nameItem;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ItemID='" + ItemID + '\'' +
                ", nameItem='" + nameItem + '\'' +
                ", price=" + price +
                '}';
    }
}

