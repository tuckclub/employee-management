package empman;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    private List<Employee> employees = new ArrayList<Employee>();
    private Scanner scanner = new Scanner(System.in);

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
        Employee result = null;
        Iterator<Employee> iterator = employees.iterator();
        while (result == null && iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                result = employee;
            }
        }
        return result;
    }

    public SalaryEmployee addSalaryEmployee() {
        String name = intputText("Enter Employee Name: ");
        String department = intputText("Enter Employee Department: ");
        double salary = inputDouble("Enter Employee Salary: ");
        int id = getNextEmployeeId();
        SalaryEmployee employee = new SalaryEmployee(id, name, department, salary);
        employees.add(employee);
        return employee;
    }

    public HourlyEmployee addHourlyEmployee() {
        String name = intputText("Enter Employee Name: ");
        String department = intputText("Enter Employee Department: ");
        double rate = inputDouble("Enter Employee Pay Rate: ");
        double hours = inputDouble("Enter Employee Hours of Work: ");
        int id = getNextEmployeeId();
        HourlyEmployee employee = new HourlyEmployee(id, name, department, rate, hours);
        employees.add(employee);
        return employee;
    }

    public Employee editEmployeeName() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            String newName = intputText("Enter New Name: ");
            employee.setName(newName);
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
            return salaryEmployee;
        } else {
            System.out.println("Employee Does Not Have Salary.");
            return null;
        }
    }
}
