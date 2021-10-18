package empman;

public class EmployeeAppTest1 {
    public static void main(String[] args) {
        Employee[] emps = new Employee[6];
        emps[0] = new Salary("Somchai", 10000.0);
        emps[1] = new Salary("Somying", 15000.0);
        emps[2] = new Hourly("Rakdee", 100.0, 10.0);
        emps[3] = new Hourly("Raksak", 200.0, 20.0);
        emps[4] = new Salary("Sombat", 20000.0);
        emps[5] = new Hourly("Rakthai", 300.0, 30.0);
    }
}
