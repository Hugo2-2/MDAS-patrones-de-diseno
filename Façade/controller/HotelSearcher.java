package Façade.controller;

import Façade.model.Hotel;
import java.util.ArrayList;
import java.util.List;

public class HotelSearcher {
    private List<Hotel> availableHotels;

    public HotelSearcher() {
        this.availableHotels = new ArrayList<>();
        // Hoteles de prueba
        availableHotels.add(new Hotel("Hotel Ritz", "Madrid", 5, 350.00, "2026-05-01", "2026-05-20"));
        availableHotels.add(new Hotel("NH Collection", "Madrid", 4, 180.00, "2026-05-01", "2026-05-20"));
        availableHotels.add(new Hotel("Hotel Roma", "Rome", 4, 150.00, "2026-05-01", "2026-05-20"));
        availableHotels.add(new Hotel("B&B Roma Center", "Rome", 3, 90.00, "2026-05-01", "2026-05-20"));
    }

    public List<Hotel> searchHotels(String city, String startDate, String endDate) {
        List<Hotel> results = new ArrayList<>();
        
        for (Hotel hotel : availableHotels) {
            if (hotel.getCity().equalsIgnoreCase(city) && hotel.isAvailable(startDate, endDate)) {
                results.add(hotel);
            }
        }
        return results;
    }
}