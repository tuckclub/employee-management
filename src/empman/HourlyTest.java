package empman;

public class HourlyTest {
    public static void main(String[] args) {
        HourlyEmployee h1 = new HourlyEmployee();
        System.out.println(h1);
        h1.setName("Somchai");
        h1.setHours(100);
        h1.setRate(40.0);
        System.out.println("Name: " + h1.getName());
        System.out.println("Rate: " + h1.getRate());
        System.out.println("Hour: " + h1.getHours());
        System.out.println("Pay: " + h1.computePay());
        HourlyEmployee h2 = new HourlyEmployee("Somsri", 30.0, 150);
        System.out.println(h2);
        System.out.println("Pay: " + h2.computePay());
    }
}
