package empman;

public class HourlyEmployee extends Employee {
    private double rate;
    private double hours;

    public HourlyEmployee(int id, String name, String department, double rate, double hours) {
        super(id, name, department);
        this.rate = rate;
        this.hours = hours;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double computePay() {
        return (rate * hours);
    }

    public String toString() {
        return "HourlyEmployee[id = %s, name = %s, department = %s, rate = %.2f, hours = %.2f]"
                .formatted(id, name, department, rate, hours);
    }
}
