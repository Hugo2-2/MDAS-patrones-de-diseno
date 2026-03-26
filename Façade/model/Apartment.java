package Façade.model;

public class Apartment {
    private String name;
    private String city;
    private int rooms;
    private double pricePerNight;
    private String availableFrom;
    private String availableTo;

    public Apartment(String name, String city, int rooms, double pricePerNight, String availableFrom, String availableTo) {
        this.name = name;
        this.city = city;
        this.rooms = rooms;
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
    public int getRooms(){
        return rooms; 
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
        return startDate.compareTo(availableFrom) >= 0 && endDate.compareTo(availableTo) <= 0;
    }

    @Override
    public String toString() {
        return String.format("[APARTMENT - %s] %d rooms | %.2f €/night | Available: %s to %s", 
                name, rooms, pricePerNight, availableFrom, availableTo);
    }
}