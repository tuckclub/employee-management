package empman;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Hourly();
        System.out.println(e1);
        e1.setName("Somchai");
        System.out.println("Name: " + e1.getName());
        Employee e2 = new Salary("Somsri", 10000);
        System.out.println(e2);
    }
}
