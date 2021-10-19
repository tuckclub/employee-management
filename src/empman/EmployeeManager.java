package empman;

import java.util.Iterator;
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
        writeFile();
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

    public HourlyEmployee editEmployeePayRate() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee ID Not Found.");
            return null;
        } else if (employee instanceof HourlyEmployee) {
            HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;
            double newRate = inputDouble("Enter New Pay Rate: ");
            hourlyEmployee.setRate(newRate);
            writeFile();
            return hourlyEmployee;
        } else {
            System.out.println("Employee Does Not Have Pay Rate.");
            return null;
        }
    }

    public HourlyEmployee editEmployeeHoursOfWork() {
        int id = inputInt("Enter Employee ID: ");
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee ID Not Found.");
            return null;
        } else if (employee instanceof HourlyEmployee) {
            HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;
            double newHours = inputDouble("Enter New Hours of Work: ");
            hourlyEmployee.setHours(newHours);
            writeFile();
            return hourlyEmployee;
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
        showSalaryEmployeeRecords();
        showHourlyEmployeeRecords();
    }

    public void showSalaryEmployeeRecords() {
        System.out.println();
        System.out.println("Salary Employee Records");
        System.out.println(hr);
        System.out.println("ID" + tabs + "Name" + tabs + "Department" + tabs + "Salary" + tabs + "Pay");
        for (Employee emp : employees) {
            if (emp instanceof SalaryEmployee) {
                SalaryEmployee sal = (SalaryEmployee) emp;
                System.out.printf(
                        sal.getId() + tabs + sal.getName() + tabs + sal.getDepartment() + tabs
                                + sal.getSalary() + tabs + "%.2f\n",
                        sal.computePay()
                );
            }
        }
        System.out.println(hr);
    }

    public void showHourlyEmployeeRecords() {
        System.out.println();
        System.out.println("Hourly Employee Records");
        System.out.println(hr);
        System.out.println("ID" + tabs + "Name" + tabs + "Department" + tabs + "Rate" + tabs + "Hours" + tabs + "Pay");
        for (Employee emp : employees) {
            if (emp instanceof HourlyEmployee) {
                HourlyEmployee hrl = (HourlyEmployee) emp;
                System.out.printf(
                        hrl.getId() + tabs + hrl.getName() + tabs + hrl.getDepartment() + tabs +
                                hrl.getRate() + tabs + hrl.getHours() + tabs + "%.2f\n",
                        hrl.computePay()
                );
            }
        }
        System.out.println(hr);
    }
}
