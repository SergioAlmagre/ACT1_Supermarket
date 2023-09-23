import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;

public class CheckOut {

    String nameCheckOut;
    Employee emp;
    LinkedList<Customer> customersQueue = new LinkedList<>();

    public CheckOut(String nameCheckOut, Employee emp) {
        this.nameCheckOut = nameCheckOut;
        this.emp = emp;
    }

    public void stockControl(){

    }

    @Override
    public String toString() {
        return "hola test string checkout";
    }

    public static  BigDecimal totalCalculate(Customer customer){
        BigDecimal total = BigDecimal.valueOf(0.0);
        for (int i = 0; i<customer.shoppingBasket.shoppinBasket.size(); i++){
            total = total.add(customer.shoppingBasket.shoppinBasket.get(i).price);
        }
        return total;
    }

    public void createBill(Customer customer){
        String details = "********************BILL***********************" + '\n'+
                nameCheckOut + emp + '\n' +  customer + '\n' + customer.shoppingBasket.toString()
                + "TOTAL:_____________________________________ "+totalCalculate(customer) + " €"
                + '\n';

        System.out.println(details);
        Bill newBill = new Bill(customer,details);
        printBill(newBill);
        customer.billRegister.add(newBill);
    }

    public static void printBill(Bill bill){
        try {
            File customerDir = new File(CommonData.mainPath + "/Customers" + "/" +bill.customer.name);
            customerDir.mkdir();
            String pathBills = CommonData.mainPath + "/Customers" + "/" +bill.customer.name + "/" + "Bills";
            File billsDirectory = new File(pathBills);
            billsDirectory.mkdir();
            String nameFile = pathBills + "/" +   bill.billID + "_Bill.txt";
            FileWriter writer = new FileWriter(nameFile);
            writer.write(bill.details);
            writer.close();
        }catch (IOException io){
            System.out.println(io.getMessage());
        }
    }





}
