import java.math.BigDecimal;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

public class Factory {

    static int id = 1;

    public static Customer newCustumer(){
        String randomNames[] = {"Antonio","Laura","Paco","Rodrigo","Ana","Robert","Albert","Steave"};
        int index = new Random().nextInt(randomNames.length);
        String randomName = randomNames[index];

        int randomCar = new Random().nextInt(2);
        Boolean car = Boolean.FALSE;
        if (randomCar == 1){
            car = Boolean.TRUE;
        }

        int randomPay = new Random().nextInt(2);
        Boolean creditCard = Boolean.FALSE;
        if (randomPay == 1){
            creditCard = Boolean.TRUE;
        }

        Customer cus = new Customer(1,randomName,car,creditCard);
        return cus;
    }

    public static Item randomItem(){
        Item[] allItems = {
                new Item("br1","Bread",(BigDecimal.valueOf(2.60))),
                new Item("wa1","Natural Water",(BigDecimal.valueOf(1.60))),
                new Item("on1","Sweet Onion",BigDecimal.valueOf(4.50))};
        int index = new Random().nextInt(allItems.length);
        Item selectedItem = allItems[index];
        return selectedItem;
    }

    public static Employee newEmployee(){
        String randomNames[] = {"Employee1","Employee2","Employee3","Employee4","Employee5","Employee6","Employee7","Employee8"};
        int index = new Random().nextInt(randomNames.length);
        String randomName = randomNames[index];
        int randomshift = new Random().nextInt(2);
        Employee emp = new Employee(2,randomName,randomshift);
        return emp;
    }

    public static CheckOut newCheckout(){
        // De esta forma el id aunque es un campo numérico se transforma en string
        String name = "CheckOut" + id + " ";
        id++;
        CheckOut chkOut = new CheckOut(name,newEmployee());
        return chkOut;
    }
}
