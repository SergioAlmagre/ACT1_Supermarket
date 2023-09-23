import java.util.Scanner;

public class Main {
    static Supermarket supermarketName;
    static int initialCustomers;
    static int customerGoOutTime;

    public static void main(String[] args) throws InterruptedException {
        try{
            boolean exit = false;
            CommonData.createDataStructure();
            int[] supermarketOptions = supermarketBuildingOptions();
            supermarketName = new Supermarket(supermarketOptions[0],supermarketOptions[1],supermarketOptions[2]);
            initialCustomers = supermarketOptions[3];
            customerGoOutTime = supermarketOptions[4];
            supermarketName.addCustomersToSupermarket(initialCustomers);

            do {
                switch (supermarketName.GeneralMenu()){
                    case 1:{
                        int time = 0;

                        while (time <= supermarketName.time) {
        //            System.out.println("Time: "+ time);
                            supermarketName.addTimeCustomers();

                            if (time % 2 == 0) {
                                for (int i = 0; i < supermarketName.customers.size(); i++) {
                                    if (supermarketName.customers.get(i).shoppingBasket.shoppinBasket.size() < supermarketName.itemsLimit){
                                        supermarketName.customers.get(i).takeItem();
                                    }
                                }
                            }

                            if (time % 3 == 0) {
                                for (int i = 0; i < supermarketName.customers.size(); i++) {
                                    if (supermarketName.fullBasketCustomer(supermarketName.customers.get(i))) {
                                        supermarketName.addCustomersToCheckOut(supermarketName.customers.get(i), supermarketName.checkoutLessBusy());
                                    }
                                }
                            }

                            if (time % 4 == 0) {
                                supermarketName.newRandomClient();
                                System.out.println("New client entering");
                            }

                            if (time % 5 == 0) {
                                supermarketName.addTimeCustomers();
                                for (int i = 0; i < supermarketName.customers.size(); i++) {
                                    if (supermarketName.fullBasketCustomer(supermarketName.customers.get(i))) {
                                        supermarketName.checkouts.get(supermarketName.checkoutMoreBussy()).createBill(supermarketName.customers.get(i));
                                        supermarketName.removeCustomerFromSupermarketAndQueue(supermarketName.customers.get(i), supermarketName.checkoutMoreBussy());
                                    }
                                }
                            }

                            if (time % customerGoOutTime == 0) {
                                for (int i = 0; i < supermarketName.customers.size(); i++) {
                                    if (supermarketName.customers.get(i).time >= supermarketName.time) {
                                        checkOutProcess();
                                    }
                                }
                            }

                            Thread.sleep(100);
                            time++;
                        }
                        break;
                    }
                    case 2:{

                        break;
                    }
                    case 3:{

                        break;
                    }
                    case 4:{

                        break;
                    }
                    case 5:{

                        break;
                    }
                    case 6:{
                        exit = true;
                        break;
                    }
                }
            }while (!exit);
        }catch (Exception e){
            CommonData.logBook(e,"Main");
        }
    }

    static public void checkOutProcess(){
        for (int i = 0; i< supermarketName.customers.size(); i++) {
            supermarketName.addCustomersToCheckOut(supermarketName.customers.get(i), supermarketName.checkoutLessBusy());
            supermarketName.checkouts.get(supermarketName.checkoutMoreBussy()).createBill(supermarketName.customers.get(i));
            supermarketName.removeCustomerFromSupermarketAndQueue(supermarketName.customers.get(i), supermarketName.checkoutLessBusy());
        }
    }

    /**
     *
     * @return
     * 0 - time
     * 1 - ItemsLimit
     * 2 - Numbers Checkouts open
     * 3 - Initial customers
     * 4 - Customers go outside
     */
    static public int[] supermarketBuildingOptions(){
        boolean correct = false;
        int[] options = new int[5];
        Scanner scanner = new Scanner(System.in);
        do {
            try{
                System.out.println("Put the numbers of hours the supermarket will be open");
                options[0] = scanner.nextInt();
                System.out.println("Put the numbers of items limit to buy by the customers");
                options[1] = scanner.nextInt();
                System.out.println("Put the numbers of checkouts will be open");
                options[2] = scanner.nextInt();
                System.out.println("Put the numbers of initial customers inside the Supermarkert");
                options[3] = scanner.nextInt();
                System.out.println("Put the numbers of hours limit that a customer can be inside");
                options[4] = scanner.nextInt();
                System.out.println("All data registered successfully");
                correct = true;
            }catch (Exception ex){
                CommonData.logBook(ex,"supermarketBuildingOptions");
                System.out.println("Some data is wrong, please put the info again");
                scanner.nextLine();
            }
        }while (!correct);
        return options;
    }




}
