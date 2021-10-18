package empman;

public class SalaryEmployee extends Employee implements PrintCheck {
    private double salary;

    public SalaryEmployee(int id, String name, String department, double salary) {
        super(id, name, department);
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
        return "SalaryEmployee[id = %s, name = %s, department = %s, salary = %.2f]"
                .formatted(id, name, department, salary);
    }

    public void printTo() {
        System.out.printf("Send %.2f$ to " + name + "\n", computePay() - extra);
    }
}
