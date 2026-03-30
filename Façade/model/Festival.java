package Façade.model;

public class Festival {
    private String name;
    private String city;
    private String description;
    private String startDate;
    private String endDate;
    private double price;
    private String genre;

    // Constructor
    public Festival(String name, String city, String description, String startDate,
                    String endDate, double price, String genre) {
        this.name = name;
        this.city = city;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.genre = genre;
    }

    // Getters
    public String getName() { return name; }
    public String getCity() { return city; }
    public String getDescription() { return description; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public double getPrice() { return price; }
    public String getGenre() { return genre; }

    // Verificar disponibilidad
    public boolean isAvailable(String startDate, String endDate) {
        return startDate.compareTo(this.startDate) <= 0 && endDate.compareTo(this.endDate) >= 0
                || startDate.compareTo(this.endDate) <= 0 && endDate.compareTo(this.startDate) >= 0;
    }

    @Override
    public String toString() {
        return String.format("[FESTIVAL] %s | %s | %s | %s | Fechas: %s - %s | %.2f€",
                name, city, description, genre, startDate, endDate, price);
    }
}
