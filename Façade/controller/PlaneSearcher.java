package Façade.controller;

import Façade.model.Plane;
import java.util.ArrayList;
import java.util.List;

public class PlaneSearcher {

    private List<Plane> availableFlights;

    public PlaneSearcher() {
        this.availableFlights = new ArrayList<>();
        //Vuelos de prueba
        availableFlights.add(new Plane("Madrid", "Rome", "2026-05-10", "2026-05-15", 120.50, "Ryanair"));
        availableFlights.add(new Plane("Madrid", "Rome", "2026-05-10", "2026-05-15", 180.00, "Iberia"));
        availableFlights.add(new Plane("Barcelona", "Paris", "2026-06-01", "2026-06-07", 95.00, "Vueling"));
    }

    //Metodo que será invocado por Façade
    public List<Plane> searchFlights(String origin, String destination, String startDate, String endDate) {
        List<Plane> results = new ArrayList<>();

        for (Plane flight : availableFlights) {
            // Filtramos asegurándonos de que coincidan todos los parámetros
            if (flight.getOrigin().equalsIgnoreCase(origin) &&
                    flight.getDestination().equalsIgnoreCase(destination) &&
                    flight.getStartDate().equals(startDate) &&
                    flight.getEndDate().equals(endDate)) {

                results.add(flight);
            }
        }
        return results;
    }

}
