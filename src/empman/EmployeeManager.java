package empman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    private List<Employee> employees = new ArrayList<Employee>();
    private Scanner scanner = new Scanner(System.in);

    private String intputText(String label) {
        System.out.print(label);
        return scanner.nextLine();
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
}
