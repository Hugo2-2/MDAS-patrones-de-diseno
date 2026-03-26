package Façade.model;

public class Bus {
    private String origin;
    private String destination;
    private String StartDate;
    private String EndDate;
    private double price;
    private String busCompany; // Ej: Alsa, Socibus

    public Bus(String origin, String destination, String StartDate, String EndDate, double price, String busCompany) {
        this.origin = origin;
        this.destination = destination;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.price = price;
        this.busCompany = busCompany;
    }

    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public String getStartDate() { return StartDate; }
    public String getEndDate() { return EndDate; }
    public double getPrice() { return price; }
    public String getBusCompany() { return busCompany; }

    @Override
    public String toString() {
        return String.format("[BUS - %s] %s to %s | Date: %s to %s | Price: %.2f €",
                busCompany, origin, destination, StartDate, EndDate, price);
    }
}