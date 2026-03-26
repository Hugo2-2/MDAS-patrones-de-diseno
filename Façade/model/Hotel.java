package Façade.model;

public class Hotel {
    private String name;
    private String city;
    private int stars;
    private double pricePerNight;
    private String availableFrom;
    private String availableTo;

    public Hotel(String name, String city, int stars, double pricePerNight, String availableFrom, String availableTo) {
        this.name = name;
        this.city = city;
        this.stars = stars;
        this.pricePerNight = pricePerNight;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
    }

    public String getName(){ 
        return name; 
    }
    
    public String getCity(){ 
        return city; 
    }
    
    public int getStars(){ 
        return stars; 
    }
    
    public double getPricePerNight(){ 
        return pricePerNight; 
    }
    
    public String getAvailableFrom(){ 
        return availableFrom; 

    }
    
    public String getAvailableTo(){ 
        return availableTo; 
    }

    public boolean isAvailable(String startDate, String endDate) {
        // Comparación simple de strings (en un caso real se usarían fechas)
        return startDate.compareTo(availableFrom) >= 0 && endDate.compareTo(availableTo) <= 0;
    }

    @Override
    public String toString() {
        return String.format("[HOTEL - %s] %s stars | %.2f €/night | Available: %s to %s", 
                name, stars, pricePerNight, availableFrom, availableTo);
    }
}