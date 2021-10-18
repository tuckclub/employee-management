package empman;

public class EmployeeAppTest1 {
    public static void main(String[] args) {
        Employee[] emp = new Employee[10];
        emp[0] = new Salary("Somchai", 10000.0);
        emp[1] = new Salary("Somying", 15000.0);
        emp[2] = new Hourly("Rakdee", 100.0, 10.0);
        emp[3] = new Hourly("Raksak", 200.0, 20.0);
        emp[4] = new Salary("Sombat", 20000.0);
        emp[5] = new Hourly("Rakthai", 300.0, 30.0);
// Your code here

    }
}
