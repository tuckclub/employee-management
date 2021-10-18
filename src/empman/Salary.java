package empman;

public class Salary extends Employee implements PrintCheck {
    private double salary = 0.0;

    public Salary() {
        super("unknown");
    }

    public Salary(String name, double salary) {
        super(name);

        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double computePay() {
        return (salary / 52);

    }

    public String toString() {
        return super.toString() + " Salary = [salary=" + salary + "]";
    }

    public void printTo() {
        System.out.printf("Send %.2f$ to " + name + "\n", computePay() - extra);
    }
}
