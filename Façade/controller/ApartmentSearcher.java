package Façade.controller;

import Façade.model.Apartment;
import java.util.ArrayList;
import java.util.List;

public class ApartmentSearcher {
    private List<Apartment> availableApartments;

    public ApartmentSearcher() {
        this.availableApartments = new ArrayList<>();
        // Apartamentos de prueba
        availableApartments.add(new Apartment("Sunset Plaza", "Madrid", 2, 120.00, "2026-05-01", "2026-05-20"));
        availableApartments.add(new Apartment("Downtown Loft", "Madrid", 1, 85.00, "2026-05-01", "2026-05-20"));
        availableApartments.add(new Apartment("Colosseum View", "Rome", 2, 140.00, "2026-05-01", "2026-05-20"));
    }

    public List<Apartment> searchApartments(String city, String startDate, String endDate) {
        List<Apartment> results = new ArrayList<>();
        
        for (Apartment apartment : availableApartments) {
            if (apartment.getCity().equalsIgnoreCase(city) && apartment.isAvailable(startDate, endDate)) {
                results.add(apartment);
            }
        }
        return results;
    }
}