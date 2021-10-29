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

    public String toString() {
        String template = "SalaryEmployee[id = %s, name = %s, department = %s, salary = %.2f, "
            + "otHourlyWage = %.2f, currentMonthOtHours = %.2f]";
        return template.formatted(id, name, department, salary, otHourlyWage, currentMonthOtHours);
    }
}
