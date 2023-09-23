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
        return "ItemID: " + ItemID + " NameItem: " + nameItem +  " Price: " + price + '\n';
    }
}

