public class Main {
    static Supermarket coviran = new Supermarket(24, 3,2);
    static int initialCustomers = 10;
    static int customerGoOutTime = 12;

    public static void main(String[] args) throws InterruptedException {
        coviran.addCustomersToSupermarket(initialCustomers);

        int time = 0;
        int totalTime = coviran.time; // Assuming Supermarket has a getTime() method

        while (time <= totalTime) {
            System.out.println("Time: "+ time);
            coviran.addTimeCustomers();


            if (time % 2 == 0){
                for (int i = 0; i< coviran.customers.size(); i++){
                    coviran.customers.get(i).takeItem();
                }
            }

            if (time % 3 == 0){
                Boolean full = Boolean.FALSE;
                for(int i = 0; i<coviran.customers.size();i++){
                    if (coviran.fullBasketCustomer(coviran.customers.get(i))){
                        coviran.addCustomersToCheckOut(coviran.customers.get(i),coviran.checkoutLessBusy());

                    }
                }

            }

            if (time % 4 == 0){
                coviran.newRandomClient();
                System.out.println("New client entering");
            }

            if (time % 5  == 0){
                coviran.addTimeCustomers();
                for(int i = 0; i<coviran.customers.size();i++){
                    if (coviran.fullBasketCustomer(coviran.customers.get(i))){
                        coviran.createBill(coviran.customers.get(i));
                        coviran.removeCustomerFromSupermarketAndQueue(coviran.customers.get(i),coviran.checkoutMoreBussy());
                    }
                }
            }

            if (time % customerGoOutTime == 0){
                for (int i = 0; i<coviran.customers.size();i++){
                    if (coviran.customers.get(i).time >= coviran.time ){
                      checkOutProcess();
                    }
                }
            }

            Thread.sleep(100);
            time++;
        }
    }


    static public void checkOutProcess(){
        for (int i = 0; i<coviran.customers.size();i++) {
            coviran.addCustomersToCheckOut(coviran.customers.get(i), coviran.checkoutLessBusy());
            coviran.createBill(coviran.customers.get(i));
            coviran.removeCustomerFromSupermarketAndQueue(coviran.customers.get(i), coviran.checkoutLessBusy());
        }
    }


}
