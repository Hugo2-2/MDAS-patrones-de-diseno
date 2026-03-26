package Façade.model;

public class Plane {
    private String origin;
    private String destination;
    private String StartDate;
    private String EndDate;
    private double price;
    private String airline;

    public Plane(String origin, String destination, String StartDate, String EndDate, double price, String airline) {
        this.origin = origin;
        this.destination = destination;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.price = price;
        this.airline = airline;
    }

    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public String getStartDate() { return StartDate; }
    public String getEndDate() { return EndDate; }
    public double getPrice() { return price; }
    public String getAirline() { return airline; }

    @Override
    public String toString() {
        return String.format("[PLANE - %s] %s to %s | Date: %s to %s | Price: %.2f €",
                airline, origin, destination, StartDate, EndDate, price);
    }
}