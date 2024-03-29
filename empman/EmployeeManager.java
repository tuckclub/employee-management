package empman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    private DataStore dataStore = new DataStore("data-employees.json", "data-payslips.json");
    private List<Employee> allEmployees = dataStore.readEmployees();
    private List<Payslip> allPayslips = dataStore.readPayslips();
    private Scanner scanner = new Scanner(System.in);

    // Section 1: User Input Operations

    private String intputText(String label) {
        System.out.print(label);
        return scanner.nextLine();
    }

    private int inputInt(String label) {
        String text = intputText(label);
        return Integer.parseInt(text);
    }

    private double inputDouble(String label) {
        String text = intputText(label);
        return Double.parseDouble(text);
    }

    // Section 2: Employee Operations

    private void writeEmployees() {
        dataStore.writeEmployees(allEmployees);
    }

    private int getNextEmployeeId() {
        int maxId = 0;
        for (Employee emp : allEmployees) {
            int currentId = emp.getId();
            if (currentId > maxId) {
                maxId = currentId;
            }
        }
        return maxId + 1;
    }

    private Employee findEmployeeById(int id) {
        for (Employee employee : allEmployees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void addSalaryEmployee() {
        String name = intputText("Enter Employee Name: ");
        String department = intputText("Enter Employee Department: ");
        double salary = inputDouble("Enter Employee Salary: ");
        double otHourlyWage = inputDouble("Enter Employee OT Hourly Wage: ");
        double currentMonthOtHours = inputDouble("Enter Employee Current Month OT Hours: ");
        int id = getNextEmployeeId();
        SalaryEmployee employee = new SalaryEmployee(id, name, department, salary, otHourlyWage, currentMonthOtHours);
        allEmployees.add(employee);
        writeEmployees();
        System.out.println("Salary Employee Created: ");
        showEmployee(employee);
    }

    public void editEmployeeName() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            String newName = intputText("Enter New Name: ");
            employee.setName(newName);
            writeEmployees();
            System.out.println("Employee Name Edited: ");
            showEmployee(employee);
        } else {
            System.out.println("Employee ID Not Found.");
        }
    }

    public void editEmployeeDepartment() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            String newDepartment = intputText("Enter New Department: ");
            employee.setDepartment(newDepartment);
            writeEmployees();
            System.out.println("Employee Department Edited: ");
            showEmployee(employee);
        } else {
            System.out.println("Employee ID Not Found.");
        }
    }

    public void editEmployeeSalary() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee ID Not Found.");
        } else if (employee instanceof SalaryEmployee) {
            SalaryEmployee salaryEmployee = (SalaryEmployee) employee;
            double newSalary = inputDouble("Enter New Salary: ");
            salaryEmployee.setSalary(newSalary);
            writeEmployees();
            System.out.println("Employee Salary Edited: ");
            showEmployee(employee);
        } else {
            System.out.println("Employee Does Not Have Salary.");
        }
    }

    public void editEmployeeOtHourlyWage() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee ID Not Found.");
        } else if (employee instanceof SalaryEmployee) {
            SalaryEmployee salaryEmployee = (SalaryEmployee) employee;
            double newOtHourlyWage = inputDouble("Enter New OT Hourly Wage: ");
            salaryEmployee.setOtHourlyWage(newOtHourlyWage);
            writeEmployees();
            System.out.println("Employee OT Hourly Wage Edited: ");
            showEmployee(employee);
        } else {
            System.out.println("Employee Does Not Have OT Hourly Wage.");
        }
    }

    public void editEmployeeCurrentMonthOtHours() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee ID Not Found.");
        } else if (employee instanceof SalaryEmployee) {
            SalaryEmployee salaryEmployee = (SalaryEmployee) employee;
            double newOtHours = inputDouble("Enter New Current Month OT Hours: ");
            salaryEmployee.setCurrentMonthOtHours(newOtHours);
            writeEmployees();
            System.out.println("Employee Current Month OT Hours Edited: ");
            showEmployee(employee);
        } else {
            System.out.println("Employee Does Not Have Current Month OT Hours.");
        }
    }

    public void deleteEmployee() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            allEmployees.remove(employee);
            writeEmployees();
            System.out.println("Employee Deleted: ");
            showEmployee(employee);
        } else {
            System.out.println("Employee ID Not Found.");
        }
    }

    public void showEmployees() {
        System.out.println();
        System.out.println("Employees");
        showEmployees(allEmployees);
        System.out.println();
    }

    private void showEmployee(Employee employee) {
        List<Employee> list = new ArrayList<Employee>();
        list.add(employee);
        showEmployees(list);
    }

    private void showEmployees(List<Employee> employees) {
        int lineLength = 5 + 20 + 15 + 15 + 20 + 30;
        String thinLine = "-".repeat(lineLength);
        String thickLine = "=".repeat(lineLength);
        System.out.println(thickLine);
        System.out.printf(
            "%5s%20s%15s%15s%20s%30s\n",
            "ID",
            "Name",
            "Department",
            "Salary",
            "OT Hourly Wage",
            "Current Month OT Hours"
        );
        System.out.println(thinLine);
        for (Employee emp : employees) {
            if (emp instanceof SalaryEmployee) {
                SalaryEmployee sal = (SalaryEmployee) emp;
                System.out.printf(
                    "%5d%20s%15s%,15.2f%,20.2f%,30.2f\n",
                    sal.getId(),
                    sal.getName(),
                    sal.getDepartment(),
                    sal.getSalary(),
                    sal.getOtHourlyWage(),
                    sal.getCurrentMonthOtHours()
                );
            }
        }
        System.out.println(thickLine);
    }

    // Section 3: Payslip Operations

    private void writePayslips() {
        dataStore.writePayslips(allPayslips);
    }

    private Payslip findPayslip(int employeeId, int month, int year) {
        for (Payslip payslip : allPayslips) {
            if (payslip.getEmployeeId() == employeeId && payslip.getMonth() == month && payslip.getYear() == year) {
                return payslip;
            }
        }
        return null;
    }

    private List<Payslip> findPayslipsByEmployeeId(int employeeId) {
        List<Payslip> list = new ArrayList<Payslip>();
        for (Payslip payslip : allPayslips) {
            if (payslip.getEmployeeId() == employeeId) {
                list.add(payslip);
            }
        }
        return list;
    }

    public void createPayslip() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee instanceof SalaryEmployee) {
            SalaryEmployee sal = (SalaryEmployee) employee;
            int month = inputInt("Enter Current Month (Number 1 - 12): ");
            int year = inputInt("Enter Current Year (4-Digit Number e.g. 2021): ");
            Payslip existingPayslip = findPayslip(employee.getId(), month, year);
            if (existingPayslip == null) {
                Payslip newPayslip = new Payslip(
                    sal.getId(),
                    sal.getName(),
                    sal.getDepartment(),
                    sal.getSalary(),
                    sal.getOtHourlyWage(),
                    sal.getCurrentMonthOtHours(),
                    month,
                    year
                );
                allPayslips.add(newPayslip);
                writePayslips();
                showPayslip(newPayslip);
            } else {
                System.out.println("*** Payslip Already Exists. Cannot Create A New One. ***");
                showPayslip(existingPayslip);
            }
        } else {
            System.out.println("Employee ID Not Found.");
        }
    }

    public void showPayslips() {
        int employeeId = inputInt("Enter Employee ID (Enter 0 To Show All Payslips): ");
        if (employeeId == 0) {
            showPayslips(allPayslips);
        } else {
            List<Payslip> payslips = findPayslipsByEmployeeId(employeeId);
            payslips.sort(this::compareTwoPayslips);
            showPayslips(payslips);
        }
    }

    private int compareTwoPayslips(Payslip p1, Payslip p2) {
        int yearMonth1 = p1.getYear() * 100 + p1.getMonth();
        int yearMonth2 = p2.getYear() * 100 + p2.getMonth();
        return yearMonth1 - yearMonth2;
    }

    private void showPayslips(List<Payslip> payslips) {
        for (Payslip payslip : payslips) {
            showPayslip(payslip);
        }
    }

    private void showPayslip(Payslip payslip) {
        int lineLength = 20 + 50 + 30;
        String thinLine = "-".repeat(lineLength);
        String thickLine = "=".repeat(lineLength);
        System.out.println(thickLine);
        System.out.printf("Payslip For The Month Of %s %d\n", getMonthName(payslip.getMonth()), payslip.getYear());
        System.out.printf("Employee ID:   %04d\n", payslip.getEmployeeId());
        System.out.printf("Employee Name: %s\n", payslip.getEmployeeName());
        System.out.println(thinLine);
        System.out.printf("%20s%50s%30s\n", "Earnings", "Details", "Amount");
        System.out.println(thinLine);
        double salary = payslip.getSalary();
        double otRate = payslip.getOtHourlyWage();
        double otHours = payslip.getCurrentMonthOtHours();
        double ot = otRate * otHours;
        double total = salary + ot;
        String salaryDetails = "1 Month";
        String otDetails = "Rate: %,.2f, Hours: %,.2f".formatted(otRate, otHours);
        System.out.printf("%20s%50s%,30.2f\n", "Salary", salaryDetails, salary);
        System.out.printf("%20s%50s%,30.2f\n", "OT", otDetails, ot);
        System.out.println(thinLine);
        System.out.printf("%70s%,30.2f\n", "Total", total);
        System.out.println(thickLine);
        System.out.println();
    }

    private String getMonthName(int month) {
        String[] names = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
        };
        return names[month - 1];
    }
}
