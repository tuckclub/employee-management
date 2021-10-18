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
            System.out.println("[1] Create Employee.");
            System.out.println("[0] Exit Program.");
            System.out.print("Select Menu: ");
            String selection = scanner.nextLine();
            switch (selection) {
                case "1":
                    SalaryEmployee employee = empman.addSalaryEmployee();
                    System.out.println("Salary Employee Added: ");
                    System.out.println("\t" + employee);
                    break;
                case "0":
                    exit = true;
                    break;
            }
        }
    }
}
