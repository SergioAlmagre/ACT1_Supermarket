import java.util.ArrayList;
import java.util.Random;

public class Customer extends Person {
    Boolean car;
    Boolean pay;
    ShoppingBasket shoppingBasket = new ShoppingBasket();

    public Customer(int rol, String name, Boolean car, Boolean pay) {
        super(rol, name);
        this.car = car;
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Customer:" +
                "car=" + car +
                ", pay=" + pay +
                ", shoppingBasket=" + shoppingBasket +
                ", rol=" + rol +
                ", name='" + name + '\'' +
                ", time inside=" + time;
    }

    public void takeItem(){
        int randomTakingItem = new Random().nextInt(2);
        Item item = Factory.randomItem();
        Boolean repeat = itemRepeat(item);

        if (randomTakingItem == 1 && !repeat){
            this.shoppingBasket.shoopinBasket.add(Factory.randomItem());
        }
    }

    private Boolean itemRepeat(Item item){
        Boolean repeat = Boolean.FALSE;
        for (int i = 0; i < this.shoppingBasket.shoopinBasket.size(); i++){
            if (item == this.shoppingBasket.shoopinBasket.get(i)){
                repeat = Boolean.TRUE;
            }
        }
        return repeat;
    }

    public Boolean compleatedShopping(int maxAmount){
        Boolean completed = Boolean.FALSE;
        int inBasket = this.shoppingBasket.shoopinBasket.size();
        if (inBasket == maxAmount){
            completed = Boolean.TRUE;
        }
        return completed;
    }


}
