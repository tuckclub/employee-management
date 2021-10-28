package empman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManager empman = new EmployeeManager();
        String hr = "----------------------------------------------------------------------------------------";
        boolean exit = false;
        while (exit == false) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Menus List");
            System.out.println("[1] Create Employee.");
            System.out.println("[2] Edit Employee Name.");
            System.out.println("[3] Edit Employee Department.");
            System.out.println("[4] Edit Employee Salary.");
            System.out.println("[5] Edit Employee Current Month OT Hours.");
            System.out.println("[6] Delete Employee.");
            System.out.println("[7] Show Employee Records.");
            System.out.println("[0] Exit Program.");
            System.out.print("Select Menu: ");
            String selection = scanner.nextLine();
            switch (selection) {
                case "1" -> empman.addSalaryEmployee();
                case "2" -> empman.editEmployeeName();
                case "3" -> empman.editEmployeeDepartment();
                case "4" -> empman.editEmployeeSalary();
                case "5" -> empman.editEmployeeCurrentMonthOtHours();
                case "6" -> empman.deleteEmployee();
                case "7" -> empman.showEmployeeRecords();
                case "0" -> {
                    exit = true;
                    continue;
                }
            }
            System.out.println(hr);
            System.out.println("Press Enter key to continue...");
            scanner.nextLine();
        }
    }
}
