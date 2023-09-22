import java.util.ArrayList;
public class Employee extends Person {

    /**
     * shift:
     * 1 - Mornings
     * 2 - Evenings
     */
    int shift;

    public Employee(int rol, String name, int shift) {
        super(rol, name);
        this.shift = shift;
    }


}
