package Façade.model;

public class Plane extends Transport {
    private String airline;

    public Plane(String origin, String destination, String StartDate, String EndDate, double price, String airline) {
        super(origin, destination, StartDate, EndDate,  price);
        this.airline = airline;
    }

    public String getAirline() { return airline; }

    @Override
    public String toString() {
        return "[PLANE - " + airline + "] " + super.toString();
    }
}
