import java.math.BigDecimal;
import java.util.LinkedList;

public class CheckOut {

    Employee emp;
    LinkedList<Customer> customersQueue = new LinkedList<>();

    public CheckOut(Employee emp) {
        this.emp = emp;
    }

    public void stockControl(){

    }
    public static BigDecimal totalCalculate(){
        BigDecimal total = BigDecimal.valueOf(0.0);
        return total;
    }

    public void createBill(){

    }


}
