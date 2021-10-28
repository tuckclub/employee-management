package empman;

import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    private DataStore dataStore = new DataStore("data.txt");
    private List<Employee> employees = dataStore.readEmployees();
    private Scanner scanner = new Scanner(System.in);

    private void writeFile() {
        dataStore.writeEmployees(employees);
    }

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

    private int getNextEmployeeId() {
        int maxId = 0;
        for (Employee emp : employees) {
            int currentId = emp.getId();
            if (currentId > maxId) {
                maxId = currentId;
            }
        }
        return maxId + 1;
    }

    private Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
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
        employees.add(employee);
        writeFile();
        System.out.println("Salary Employee Created: ");
        System.out.println("\t" + employee);
    }

    public void editEmployeeName() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            String newName = intputText("Enter New Name: ");
            employee.setName(newName);
            writeFile();
            System.out.println("Employee Name Edited: ");
            System.out.println("\t" + employee);
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
            writeFile();
            System.out.println("Employee Department Edited: ");
            System.out.println("\t" + employee);
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
            writeFile();
            System.out.println("Employee Salary Edited: ");
            System.out.println("\t" + employee);
        } else {
            System.out.println("Employee Does Not Have Salary.");
        }
    }

    public void editEmployeeHoursOfWork() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee ID Not Found.");
        } else if (employee instanceof SalaryEmployee) {
            SalaryEmployee salaryEmployee = (SalaryEmployee) employee;
            double newHours = inputDouble("Enter New Hours of Work: ");
            salaryEmployee.setCurrentMonthOtHours(newHours);
            writeFile();
            System.out.println("Employee Hours of Work Edited: ");
            System.out.println("\t" + employee);
        } else {
            System.out.println("Employee Does Not Have Hours of Work.");
        }
    }

    public void deleteEmployee() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employees.remove(employee);
            writeFile();
            System.out.println("Employee Deleted: ");
            System.out.println("\t" + employee);
        } else {
            System.out.println("Employee ID Not Found.");
        }
    }

    private String tabs = "\t\t\t";
    private String hr = "========================================================================================";

    public void showEmployeeRecords() {
        System.out.println();
        System.out.println("Salary Employee Records");
        System.out.println(hr);
        System.out.println("ID" + tabs + "Name" + tabs + "Department" + tabs
            + "Salary" + tabs + "Hours" + tabs + "Daily Pay" + tabs + "Hourly Pay");
        for (Employee emp : employees) {
            if (emp instanceof SalaryEmployee) {
                SalaryEmployee sal = (SalaryEmployee) emp;
                System.out.printf(
                    sal.getId() + tabs + sal.getName() + tabs + sal.getDepartment() + tabs
                        + sal.getSalary() + tabs + sal.getCurrentMonthOtHours() + tabs + "%.2f" + tabs + "%.2f\n",
                    sal.computeDailyPay(), sal.computeHourlyPay()
                );
            }
        }
        System.out.println(hr);
    }
}
