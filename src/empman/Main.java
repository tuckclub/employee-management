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
            System.out.println("[0] Exit Program.");
            System.out.print("Select Menu: ");
            String selection = scanner.nextLine();
            switch (selection) {
                case "1":
                    SalaryEmployee salaryEmployee = empman.addSalaryEmployee();
                    System.out.println("Salary Employee Created: ");
                    System.out.println("\t" + salaryEmployee);
                    break;
                case "2":
                    HourlyEmployee hourlyEmployee = empman.addHourlyEmployee();
                    System.out.println("Hourly Employee Created: ");
                    System.out.println("\t" + hourlyEmployee);
                    break;
                case "0":
                    exit = true;
                    break;
            }
        }
    }
}
