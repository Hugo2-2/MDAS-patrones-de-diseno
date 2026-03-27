package Façade.model;

public class Hostel {
    private String name;
    private String address;
    private String city;
    private double pricePerNight;
    private String roomType;
    private String availableFrom;
    private String availableTo;
    
    // Constructor
    public Hostel(String name, String address, String city, double pricePerNight,
                  String roomType, String availableFrom, String availableTo) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.pricePerNight = pricePerNight;
        this.roomType = roomType;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
    }
    
    // Getters
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public double getPricePerNight() { return pricePerNight; }
    public String getRoomType() { return roomType; }
    public String getAvailableFrom() { return availableFrom; }
    public String getAvailableTo() { return availableTo; }
    
    // Verificar disponibilidad
    public boolean isAvailable(String startDate, String endDate) {
        return startDate.compareTo(availableFrom) >= 0 && endDate.compareTo(availableTo) <= 0;
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s, %s | %s | %.2f€/night | Available: %s → %s", 
                getName(), getAddress(), getCity(), getRoomType(), getPricePerNight(), getAvailableFrom(), getAvailableTo());
    }
}