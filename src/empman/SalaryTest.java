package empman;

public class SalaryTest {
    public static void main(String[] args) {
        SalaryEmployee s1 = new SalaryEmployee();
        System.out.println(s1);
        s1.setName("Somchai");
        s1.setSalary(20000.0);
        System.out.println("Name: " + s1.getName());
        System.out.println("Salary: " + s1.getSalary());
        System.out.println("Pay: " + s1.computePay());
        s1.printTo();
        SalaryEmployee s2 = new SalaryEmployee("Somsri", 30000.0);
        System.out.println(s2);
        s2.printTo();
    }
}
