public class Main {
    static Supermarket coviran = new Supermarket(24, 3);
    static int initialCustomers = 10;

    public static void main(String[] args) throws InterruptedException {
        addCustomersToSupermarket(initialCustomers);

        int time = 0;
        int totalTime = coviran.time; // Assuming Supermarket has a getTime() method

        while (time <= totalTime) {

            if (time % 2 == 0){
                System.out.println("Test 2 seconds");
                System.out.println(coviran);
                for (int i = 0; i<amountClientsInside(); i++){
                    coviran.customers.get(i).takeItem();
                }
            }

            if (time % 3 == 0){
                Boolean full = Boolean.FALSE;
                System.out.println("Test 3 seconds");
                full = fullBasketCustomers();
            }

            if (time % 4 == 0){
                coviran.newRandomClient();
                System.out.println("New client entering");
            }

            if (time % 5  == 0){
                addTimeClient();
            }

            Thread.sleep(1000);
            time++;
        }
    }

    public static void addCustomersToSupermarket(int amount){
        for (int i=0; i!= amount;i++){
            coviran.customers.add(Factory.newCustumer());
        }
    }

    public static int checkoutLessBusy(){
        int customersAmount = coviran.checkouts.get(0).customersQueue.size();
        int lessbusy = 0;
        for (int i = 1; i< coviran.checkouts.size();i++){
            if (coviran.checkouts.get(i).customersQueue.size() < customersAmount){
                lessbusy = i;
            }
        }
        return lessbusy;
    }

    public static void addCustomersToCheckOut(Customer customer, int checkOutLessBusy){
        coviran.checkouts.get(checkOutLessBusy).customersQueue.add(customer);
    }

    public static void removeCustomerFromSupermarketAndQueue(Customer customer, int checkOutNumber){
        coviran.customers.remove(customer);
        coviran.checkouts.get(checkOutNumber).customersQueue.removeFirst();
    }

    public static void addTimeClient(){
        for (int i = 0 ; i<amountClientsInside(); i++){
            coviran.customers.get(i).time++;
        }
    }

    public static int amountClientsInside(){
        int allCustomers = coviran.customers.size();
        return allCustomers;
    }

    public static Boolean fullBasketCustomers(){
        Boolean full = Boolean.FALSE;
        for (int i = 0; i<amountClientsInside();i++){
            full = coviran.customers.get(i).compleatedShopping(coviran.itemsLimit);
        }
        return full;
    }
}
