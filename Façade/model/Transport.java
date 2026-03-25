package Façade.model;

//Esto es lo que en el diagrama de clases llamamos viaje
public abstract class Transport {
    protected String origin;
    protected String destination;
    protected String StartDate;
    protected String EndDate;
    protected double price;

    public Transport(String origin, String destination, String StartDate, String EndDate, double price) {
        this.origin = origin;
        this.destination = destination;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.price = price;
    }

    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public String getStartDate() { return StartDate; }
    public String getEndDate() { return EndDate; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("%s to %s | Date: %s to %s| Price: %.2f €", origin, destination, StartDate, EndDate, price);
    }
}
