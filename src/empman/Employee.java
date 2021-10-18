package empman;

public abstract class Employee {
    protected String name;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Employee [name=" + name + "]";
    }

    public abstract double computePay();
}