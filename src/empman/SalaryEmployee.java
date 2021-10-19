package empman;

public class SalaryEmployee extends Employee {
    private double salary;
    private double hours;

    public SalaryEmployee(int id, String name, String department, double salary, double hours) {
        super(id, name, department);
        this.salary = salary;
        this.hours = hours;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double computeDailyPay() {
        return salary / 30;
    }

    public double computeHourlyPay() {
        return salary / 30 / hours;
    }

    public String toString() {
        return "SalaryEmployee[id = %s, name = %s, department = %s, salary = %.2f, dailyPay = %.2f, hourlyPay = %.2f]"
                .formatted(id, name, department, salary, computeDailyPay(), computeHourlyPay());
    }
}
