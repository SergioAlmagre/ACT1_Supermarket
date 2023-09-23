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

    @Override
    public String toString() {
        return "Name employee: " + name;
    }

    @Override
    public void greet() {
        System.out.println("Hello! I'm an employee and my name is " + this.name);
    }
}
