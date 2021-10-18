package empman;

public class Main {
    public static void main(String[] args) {
        EmployeeManager empman = new EmployeeManager();
        SalaryEmployee emp = empman.addSalaryEmployee();
        System.out.println(emp);
    }
}
