import java.io.*;
public class Bill {

    static int billID = 0;
    Customer customer;
    String details;

    public Bill( Customer customer, String details) {
        billID++;
        this.customer = customer;
        this.details = details;
    }



}
