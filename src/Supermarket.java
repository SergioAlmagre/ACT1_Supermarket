import java.util.ArrayList;
import java.util.Random;

public class Supermarket {

    int time;
    int itemsLimit;
    ArrayList<CheckOut> checkouts = new ArrayList<CheckOut>();
    ArrayList<Aisle> aisles = new ArrayList<Aisle>();
    ArrayList<Customer> customers = new ArrayList<Customer>();

    @Override
    public String toString() {
        return "Supermarket: " +
                "time =" + time +
                ", itemsLimit =" + itemsLimit +
                ", checkouts =" + checkouts +
                ", aisles =" + aisles +
                ", customers =" + customers;
    }

    public Supermarket(int time, int itemsLimit) {
        this.time = time;
        this.itemsLimit = itemsLimit;
    }

    public void newRandomClient(){
        int randomSeleccion = new Random().nextInt(2);
        if (randomSeleccion == 1){
            this.customers.add(Factory.newCustumer());
        }
    }





}



