package Façade.model;

public class Museum {
    private String name;
    private String address;
    private String city;
    private double price;
    private String theme;
    private String availableFrom;
    private String availableTo;

    // Constructor
    public Museum(String name, String address, String city, double price,
                  String theme, String availableFrom, String availableTo) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.price = price;
        this.theme = theme;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
    }

    // Getters
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public double getPrice() { return price; }
    public String getTheme() { return theme; }
    public String getAvailableFrom() { return availableFrom; }
    public String getAvailableTo() { return availableTo; }

    // Verificar disponibilidad
    public boolean isAvailable(String startDate, String endDate) {
        return startDate.compareTo(availableFrom) >= 0 && endDate.compareTo(availableTo) <= 0;
    }

    @Override
    public String toString() {
        return String.format("[MUSEO] %s | %s, %s | %s | %.2f€ | Disponible: %s - %s",
                name, address, city, theme, price, availableFrom, availableTo);
    }
}
