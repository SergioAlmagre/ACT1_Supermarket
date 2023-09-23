import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Supermarket {
    /**
     * Roles:
     * 1 - Customer
     * 2 - Employee
     * 3 - Team leader
     * 4 - Boss
     */

    int time;
    int itemsLimit;
    int numCheckouts;

//    number of Employeee it's not important for this case: There are building from factory

    ArrayList<CheckOut> checkouts = new ArrayList<CheckOut>();
    ArrayList<Aisle> aisles = new ArrayList<Aisle>();
    ArrayList<Customer> customers = new ArrayList<Customer>();

    public Supermarket(int time, int itemsLimit, int numCheckouts) {
        this.time = time;
        this.itemsLimit = itemsLimit;
        this.numCheckouts = numCheckouts;

        newCheckOut();

    }

    @Override
    public String toString() {
        return "Supermarket: " +
                "time =" + time +
                ", itemsLimit =" + itemsLimit +
                ", checkouts =" + checkouts +
                ", aisles =" + aisles +
                ", customers =" + customers;
    }



    public void newRandomClient(){
        int randomSeleccion = new Random().nextInt(2);
        if (randomSeleccion == 1){
            this.customers.add(Factory.newCustumer());
        }
    }

    public void addCustomersToCheckOut(Customer customer, int checkOutLessBusy){
            this.checkouts.get(checkOutLessBusy).customersQueue.add(customer);
    }

    public int checkoutLessBusy(){
        int index = 0;
        int checkoutL = 0;
        int amount = this.checkouts.get(0).customersQueue.size();

        for (CheckOut c:this.checkouts){
            if (amount > c.customersQueue.size()){
                checkoutL = index;
                amount = c.customersQueue.size();
            }
            index++;
        }
        return checkoutL;
    }

    public int checkoutMoreBussy(){
        int index = 0;
        int checkoutL = 0;
        int amount = this.checkouts.get(0).customersQueue.size();

        for (CheckOut c:this.checkouts){
            if (amount < c.customersQueue.size()){
                checkoutL = index;
                amount = c.customersQueue.size();
            }
            index++;
        }
        return checkoutL;
    }

    public void addCustomersToSupermarket(int amount){
        for (int i=0; i!= amount;i++){
            this.customers.add(Factory.newCustumer());
        }
    }

    public  void removeCustomerFromSupermarketAndQueue(Customer customer, int checkOutNumber){
        this.customers.remove(customer);
        try{
            this.checkouts.get(checkOutNumber).customersQueue.removeFirst();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public  void addTimeCustomers(){
        for (int i = 0 ; i<customers.size(); i++){
            this.customers.get(i).time++;
        }
    }

    public  Boolean fullBasketCustomer(Customer customer){
        Boolean full = Boolean.FALSE;
            if (customer.shoppingBasket.shoppinBasket.size() == this.itemsLimit){
                full = Boolean.TRUE;
            }
        return full;
    }


    public void newCheckOut(){
        for (int i = 0; i < this.numCheckouts; i++){
            this.checkouts.add(Factory.newCheckout());
        }
    }


    public int GeneralMenu(){
        int selecction = -1;
        Scanner scanner = new Scanner(System.in);
        try{
            while (selecction < 0 || selecction > 6){
                System.out.println("--------After sale menu---------");
                System.out.println("1 - Open Supermarket");
                System.out.println("2 - See current stock");
                System.out.println("3 - Replenish stock");
                System.out.println("4 - See customers");
                System.out.println("5 - See benefit");
                System.out.println("6 - Close Supermarket");
                selecction = scanner.nextInt();
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("Some data is wrong, please put the info again");
            scanner.nextLine();
        }
        return selecction;
    }







}



