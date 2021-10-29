package empman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManager empman = new EmployeeManager();
        boolean exit = false;
        while (exit == false) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Menus List");
            System.out.println(" [1] Create Employee.");
            System.out.println(" [2] Edit Employee Name.");
            System.out.println(" [3] Edit Employee Department.");
            System.out.println(" [4] Edit Employee Salary.");
            System.out.println(" [5] Edit Employee OT Hourly Wage.");
            System.out.println(" [6] Edit Employee Current Month OT Hours.");
            System.out.println(" [7] Delete Employee.");
            System.out.println(" [8] Show Employees.");
            System.out.println(" [9] Create Payslip.");
            System.out.println("[10] Show Payslips.");
            System.out.println(" [0] Exit Program.");
            System.out.print("Select Menu: ");
            String selection = scanner.nextLine();
            switch (selection) {
                case "1" -> empman.addSalaryEmployee();
                case "2" -> empman.editEmployeeName();
                case "3" -> empman.editEmployeeDepartment();
                case "4" -> empman.editEmployeeSalary();
                case "5" -> empman.editEmployeeOtHourlyWage();
                case "6" -> empman.editEmployeeCurrentMonthOtHours();
                case "7" -> empman.deleteEmployee();
                case "8" -> empman.showEmployees();
                case "9" -> empman.createPayslip();
                case "10" -> empman.showPayslips();
                case "0" -> {
                    exit = true;
                    continue;
                }
                default -> {
                    System.out.println("*** Please Select A Valid Memu Item. ***");
                    continue;
                }
            }
            System.out.println("#".repeat(50));
            System.out.print("Press Enter Key To Continue...");
            scanner.nextLine();
        }
    }
}
