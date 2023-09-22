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

    @Override
    public String toString() {
        return "CheckOut{" +
                "nameCheckOut='" + nameCheckOut + '\'' +
                ", emp=" + emp +
                ", customersQueue=" + customersQueue +
                '}';
    }

    public void stockControl(){

    }
    public static BigDecimal totalCalculate(){
        BigDecimal total = BigDecimal.valueOf(0.0);
        return total;
    }




}
