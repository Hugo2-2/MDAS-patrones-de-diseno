package Façade.model;

public class GuidedTour {
    private String name;
    private String city;
    private String description;
    private double durationHours;
    private double price;
    private String language;
    private String availableFrom;
    private String availableTo;

    // Constructor
    public GuidedTour(String name, String city, String description, double durationHours,
                      double price, String language, String availableFrom, String availableTo) {
        this.name = name;
        this.city = city;
        this.description = description;
        this.durationHours = durationHours;
        this.price = price;
        this.language = language;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
    }

    // Getters
    public String getName() { return name; }
    public String getCity() { return city; }
    public String getDescription() { return description; }
    public double getDurationHours() { return durationHours; }
    public double getPrice() { return price; }
    public String getLanguage() { return language; }
    public String getAvailableFrom() { return availableFrom; }
    public String getAvailableTo() { return availableTo; }

    // Verificar disponibilidad
    public boolean isAvailable(String startDate, String endDate) {
        return startDate.compareTo(availableFrom) >= 0 && endDate.compareTo(availableTo) <= 0;
    }

    @Override
    public String toString() {
        return String.format("[TOUR] %s | %s | %s | %.1fh | %.2f€ | Idioma: %s | Disponible: %s - %s",
                name, city, description, durationHours, price, language, availableFrom, availableTo);
    }
}
