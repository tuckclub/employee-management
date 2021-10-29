package empman;

public class Payslip {
    private int employeeId;
    private String employeeName;
    private String department;
    private double salary;
    private double otHourlyWage;
    private double currentMonthOtHours;
    private int month;
    private int year;

    public Payslip(int employeeId, String employeeName, String department,
                   double salary, double otHourlyWage, double currentMonthOtHours,
                   int month, int year) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
        this.otHourlyWage = otHourlyWage;
        this.currentMonthOtHours = currentMonthOtHours;
        this.month = month;
        this.year = year;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public double getOtHourlyWage() {
        return otHourlyWage;
    }

    public double getCurrentMonthOtHours() {
        return currentMonthOtHours;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
