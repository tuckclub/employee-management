package empman;

public class EmployeeApp {
    public static void main(String[] args) {
        Employee[] emps = new Employee[6];
        emps[0] = new SalaryEmployee("Somchai", 10000.0);
        emps[1] = new SalaryEmployee("Somying", 15000.0);
        emps[2] = new HourlyEmployee("Rakdee", 100.0, 10.0);
        emps[3] = new HourlyEmployee("Raksak", 200.0, 20.0);
        emps[4] = new SalaryEmployee("Sombat", 20000.0);
        emps[5] = new HourlyEmployee("Rakthai", 300.0, 30.0);

        String tabs = "\t\t\t";
        String hr = "------------------------------------------------";
        System.out.println("Salary Report");
        System.out.println(hr);
        System.out.println("Name" + tabs + "Salary" + tabs + "Pay");
        for (Employee emp : emps) {
            if (emp instanceof SalaryEmployee) {
                SalaryEmployee sal = (SalaryEmployee) emp;
                System.out.printf(sal.getName() + tabs + sal.getSalary() + tabs + "%.2f\n", sal.computePay());
            }
        }
        System.out.println(hr);
        System.out.println();

        System.out.println("Hourly Report");
        System.out.println(hr);
        System.out.println("Name" + tabs + "Rate" + tabs + "Hours" + tabs + "Pay");
        for (Employee emp : emps) {
            if (emp instanceof HourlyEmployee) {
                HourlyEmployee hrl = (HourlyEmployee) emp;
                System.out.printf(
                        hrl.getName() + tabs + hrl.getRate() + tabs
                                + hrl.getHours() + tabs + "%.2f\n", hrl.computePay()
                );
            }
        }
        System.out.println(hr);
        System.out.println();

        System.out.println("Payment Report");
        System.out.println(hr);
        System.out.println("Name" + tabs + "Pay");
        for (Employee emp : emps) {
            if (emp instanceof SalaryEmployee) {
                SalaryEmployee sal = (SalaryEmployee) emp;
                System.out.printf(sal.getName() + tabs + "%.2f\n", sal.computePay());
            }
            if (emp instanceof HourlyEmployee) {
                HourlyEmployee hrl = (HourlyEmployee) emp;
                System.out.printf(hrl.getName() + tabs + "%.2f\n", hrl.computePay());
            }
        }
        System.out.println(hr);
        System.out.println();

        System.out.println("Print Check");
        System.out.println(hr);
        for (Employee emp : emps) {
            if (emp instanceof SalaryEmployee) {
                SalaryEmployee sal = (SalaryEmployee) emp;
                sal.printTo();
            }
        }
        System.out.println(hr);
        System.out.println();
    }
}
