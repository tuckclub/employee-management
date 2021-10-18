package empman;

public class EmployeeAppTest1 {
    public static void main(String[] args) {
        Employee[] emps = new Employee[6];
        emps[0] = new SalaryEmployee("Somchai", 10000.0);
        emps[1] = new SalaryEmployee("Somying", 15000.0);
        emps[2] = new HourlyEmployee("Rakdee", 100.0, 10.0);
        emps[3] = new HourlyEmployee("Raksak", 200.0, 20.0);
        emps[4] = new SalaryEmployee("Sombat", 20000.0);
        emps[5] = new HourlyEmployee("Rakthai", 300.0, 30.0);
    }
}
