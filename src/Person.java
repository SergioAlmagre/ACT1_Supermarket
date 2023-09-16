public class Person {

    int rol;
    String name;
    int time = 0;

    public Person(int rol, String name) {
        this.rol = rol;
        this.name = name;
    }

    public String toString() {
        return "Person{" +
                "rol=" + rol +
                ", name='" + name + '\'' +
                ", time inside=" + time +
                '}';
    }



}
