package empman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManager empman = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);
        String hr = "----------------------------------------------------------------------------------------";
        boolean exit = false;
        while (!exit) {
            System.out.println(hr);
            System.out.println("Menus List");
            System.out.println("[1] Create Salary Employee.");
            System.out.println("[2] Create Hourly Employee.");
            System.out.println("[3] Edit Employee Name.");
            System.out.println("[4] Edit Employee Department.");
            System.out.println("[5] Edit Employee Salary.");
            System.out.println("[6] Edit Employee Pay Rate.");
            System.out.println("[7] Edit Employee Hours of Work.");
            System.out.println("[8] Delete Employee.");
            System.out.println("[0] Exit Program.");
            System.out.print("Select Menu: ");
            String selection = scanner.nextLine();
            switch (selection) {
                case "1":
                    SalaryEmployee employee1 = empman.addSalaryEmployee();
                    System.out.println("Salary Employee Created: ");
                    System.out.println("\t" + employee1);
                    break;
                case "2":
                    HourlyEmployee employee2 = empman.addHourlyEmployee();
                    System.out.println("Hourly Employee Created: ");
                    System.out.println("\t" + employee2);
                    break;
                case "3":
                    Employee employee3 = empman.editEmployeeName();
                    if (employee3 != null) {
                        System.out.println("Employee Name Edited: ");
                        System.out.println("\t" + employee3);
                    }
                    break;
                case "4":
                    Employee employee4 = empman.editEmployeeDepartment();
                    if (employee4 != null) {
                        System.out.println("Employee Department Edited: ");
                        System.out.println("\t" + employee4);
                    }
                    break;
                case "5":
                    Employee employee5 = empman.editEmployeeSalary();
                    if (employee5 != null) {
                        System.out.println("Employee Salary Edited: ");
                        System.out.println("\t" + employee5);
                    }
                    break;
                case "6":
                    Employee employee6 = empman.editEmployeePayRate();
                    if (employee6 != null) {
                        System.out.println("Employee Pay Rate Edited: ");
                        System.out.println("\t" + employee6);
                    }
                    break;
                case "7":
                    Employee employee7 = empman.editEmployeeHoursOfWork();
                    if (employee7 != null) {
                        System.out.println("Employee Hours of Work Edited: ");
                        System.out.println("\t" + employee7);
                    }
                    break;
                case "8":
                    Employee employee8 = empman.deleteEmployee();
                    if (employee8 != null) {
                        System.out.println("Employee Deleted: ");
                        System.out.println("\t" + employee8);
                    }
                    break;
                case "0":
                    exit = true;
                    break;
            }
        }
    }
}
