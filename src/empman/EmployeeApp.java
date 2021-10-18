package empman;

public class EmployeeApp {
    public static void main(String[] args) {
        Employee[] emps = new Employee[6];
        emps[0] = new Salary("Somchai", 10000.0);
        emps[1] = new Salary("Somying", 15000.0);
        emps[2] = new Hourly("Rakdee", 100.0, 10.0);
        emps[3] = new Hourly("Raksak", 200.0, 20.0);
        emps[4] = new Salary("Sombat", 20000.0);
        emps[5] = new Hourly("Rakthai", 300.0, 30.0);

        String tabs = "\t\t\t";
        String hr = "------------------------------------------------";
        System.out.println("Salary Report");
        System.out.println(hr);
        System.out.println("Name" + tabs + "Salary" + tabs + "Pay");
        for (Employee emp : emps) {
            if (emp instanceof Salary) {
                Salary sal = (Salary) emp;
                System.out.printf(sal.getName() + tabs + sal.getSalary() + tabs + "%.2f\n", sal.computePay());
            }
        }
        System.out.println(hr);
        System.out.println();

        System.out.println("Hourly Report");
        System.out.println(hr);
        System.out.println("Name" + tabs + "Rate" + tabs + "Hours" + tabs + "Pay");
        for (Employee emp : emps) {
            if (emp instanceof Hourly) {
                Hourly hrl = (Hourly) emp;
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
            if (emp instanceof Salary) {
                Salary sal = (Salary) emp;
                System.out.printf(sal.getName() + tabs + "%.2f\n", sal.computePay());
            }
            if (emp instanceof Hourly) {
                Hourly hrl = (Hourly) emp;
                System.out.printf(hrl.getName() + tabs + "%.2f\n", hrl.computePay());
            }
        }
        System.out.println(hr);
        System.out.println();

        System.out.println("Print Check");
        System.out.println(hr);
        for (Employee emp : emps) {
            if (emp instanceof Salary) {
                Salary sal = (Salary) emp;
                sal.printTo();
            }
        }
        System.out.println(hr);
        System.out.println();
    }
}
