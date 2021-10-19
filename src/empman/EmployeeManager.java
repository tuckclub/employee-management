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

    public SalaryEmployee addSalaryEmployee() {
        String name = intputText("Enter Employee Name: ");
        String department = intputText("Enter Employee Department: ");
        double salary = inputDouble("Enter Employee Salary: ");
        double hours = inputDouble("Enter Employee Hours of Work: ");
        int id = getNextEmployeeId();
        SalaryEmployee employee = new SalaryEmployee(id, name, department, salary, hours);
        employees.add(employee);
        writeFile();
        return employee;
    }

    public Employee editEmployeeName() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            String newName = intputText("Enter New Name: ");
            employee.setName(newName);
            writeFile();
        } else {
            System.out.println("Employee ID Not Found.");
        }
        return employee;
    }

    public Employee editEmployeeDepartment() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            String newDepartment = intputText("Enter New Department: ");
            employee.setDepartment(newDepartment);
            writeFile();
        } else {
            System.out.println("Employee ID Not Found.");
        }
        return employee;
    }

    public SalaryEmployee editEmployeeSalary() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee ID Not Found.");
            return null;
        } else if (employee instanceof SalaryEmployee) {
            SalaryEmployee salaryEmployee = (SalaryEmployee) employee;
            double newSalary = inputDouble("Enter New Salary: ");
            salaryEmployee.setSalary(newSalary);
            writeFile();
            return salaryEmployee;
        } else {
            System.out.println("Employee Does Not Have Salary.");
            return null;
        }
    }

    public SalaryEmployee editEmployeeHoursOfWork() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee ID Not Found.");
            return null;
        } else if (employee instanceof SalaryEmployee) {
            SalaryEmployee salaryEmployee = (SalaryEmployee) employee;
            double newHours = inputDouble("Enter New Hours of Work: ");
            salaryEmployee.setHours(newHours);
            writeFile();
            return salaryEmployee;
        } else {
            System.out.println("Employee Does Not Have Hours of Work.");
            return null;
        }
    }

    public Employee deleteEmployee() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employees.remove(employee);
            writeFile();
        } else {
            System.out.println("Employee ID Not Found.");
        }
        return employee;
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
                                + sal.getSalary() + tabs + sal.getHours() + tabs + "%.2f" + tabs + "%.2f\n",
                        sal.computeDailyPay(), sal.computeHourlyPay()
                );
            }
        }
        System.out.println(hr);
    }
}
