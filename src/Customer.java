import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Customer extends Person {
    Boolean car;
    Boolean pay;
    ShoppingBasket shoppingBasket = new ShoppingBasket();
    ArrayList<Bill> billRegister = new ArrayList<>();


    public Customer(int rol, String name, Boolean car, Boolean pay) {
        super(rol, name);
        this.car = car;
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Customer name: " + name + " Credit card: "+ pay + " Car in parking: " + car;
    }

    @Override
    public void greet() {
        System.out.println("Hello! I'm a customer and my name is " + this.name);
    }

    public void takeItem(){
        int randomTakingItem = new Random().nextInt(2);
        Item item = Factory.randomItem();
        Boolean repeat = itemRepeat(item);

        if (randomTakingItem == 1 && !repeat){
            this.shoppingBasket.shoppinBasket.add(Factory.randomItem());
        }
    }

    private Boolean itemRepeat(Item item){
        Boolean repeat = Boolean.FALSE;
        for (int i = 0; i < this.shoppingBasket.shoppinBasket.size(); i++){
            if (item == this.shoppingBasket.shoppinBasket.get(i)){
                repeat = Boolean.TRUE;
            }
        }
        return repeat;
    }

    public Boolean compleatedShopping(int maxAmount){
        Boolean completed = Boolean.FALSE;
        int inBasket = this.shoppingBasket.shoppinBasket.size();
        if (inBasket == maxAmount){
            completed = Boolean.TRUE;
        }
        return completed;
    }


}
