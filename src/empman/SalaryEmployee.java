package empman;

public class SalaryEmployee extends Employee {
    private double salary;
    private double otHourlyWage;
    private double currentMonthOtHours;

    public SalaryEmployee(int id, String name, String department,
                          double salary, double otHourlyWage, double currentMonthOtHours) {
        super(id, name, department);
        this.salary = salary;
        this.otHourlyWage = otHourlyWage;
        this.currentMonthOtHours = currentMonthOtHours;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getOtHourlyWage() {
        return otHourlyWage;
    }

    public void setOtHourlyWage(double otHourlyWage) {
        this.otHourlyWage = otHourlyWage;
    }

    public double getCurrentMonthOtHours() {
        return currentMonthOtHours;
    }

    public void setCurrentMonthOtHours(double currentMonthOtHours) {
        this.currentMonthOtHours = currentMonthOtHours;
    }

    public double computeDailyPay() {
        return salary / 30;
    }

    public double computeHourlyPay() {
        return salary / 30 / currentMonthOtHours;
    }

    public String toString() {
        return ("SalaryEmployee[id = %s, name = %s, department = %s, salary = %.2f, hours = %s, "
            + "dailyPay = %.2f, hourlyPay = %.2f]")
            .formatted(id, name, department, salary, currentMonthOtHours, computeDailyPay(), computeHourlyPay());
    }
}
