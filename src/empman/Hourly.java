package empman;

public class Hourly extends Employee {

    private double rate = 0.0;
    private double hours = 1.0;

    public Hourly() {
        super();

    }

    public Hourly(String name, double rate, double hours) {
        super(name);
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
        return super.toString() + " Hourly [rate=" + rate + ", hours=" + hours + "]";
    }

}

