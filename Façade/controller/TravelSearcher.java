package Façade.controller;

import Façade.model.Plane;
import Façade.model.Train;
import java.util.List;

public class TravelSearcher {

    private PlaneSearcher planeSearcher;
    private TrainSearcher trainSearcher;

    public TravelSearcher() {
        this.planeSearcher = new PlaneSearcher();
        this.trainSearcher = new TrainSearcher();
    }

    //Buscardor de viajes (todo lo relacionado con transporte)
    public void searchTrip(String origin, String destination, String startDate, String endDate) {

        System.out.println("=========================================================");
        System.out.println(" TRIP SEARCH: " + origin + " -> " + destination);
        System.out.println(" Dates: " + startDate + " to " + endDate);
        System.out.println("=========================================================\n");

        // Paso 1: Buscar en el subsistema de Aviones
        System.out.println("AVAILABLE FLIGHTS:");
        List<Plane> flights = planeSearcher.searchFlights(origin, destination, startDate, endDate);
        if (flights.isEmpty()) {
            System.out.println("   No flights found for these criteria.");
        } else {
            for (Plane p : flights) {
                System.out.println("   " + p.toString());
            }
        }

        // Paso 2: Buscar en el subsistema de Trenes
        System.out.println("\nVAILABLE TRAINS:");
        List<Train> trains = trainSearcher.searchTrains(origin, destination, startDate, endDate);
        if (trains.isEmpty()) {
            System.out.println("   No trains found for these criteria.");
        } else {
            for (Train t : trains) {
                System.out.println("   " + t.toString());
            }
        }

        // Paso 3: Buscar Alojamientos (Cumpliendo la regla "b" del PDF)
        System.out.println("\nACCOMMODATION IN " + destination.toUpperCase() + ":");
        System.out.println("   [Pending: Implementation of HotelSearcher...]"); //Esto no esta implementado

        // Paso 4: Buscar Actividades (Cumpliendo la regla "c" del PDF)
        System.out.println("\nACTIVITIES IN " + destination.toUpperCase() + ":");
        System.out.println("   [Pending: Implementation of TouristOffices...]"); //Esto no está implementado

        System.out.println("\n=========================================================");
    }

    //Aqui faltan los hoteles y las actividades a realizar
}