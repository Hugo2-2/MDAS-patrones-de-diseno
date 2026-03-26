package Façade.controller;

import Façade.model.Plane;
import Façade.model.Train;
import Façade.model.Bus;
import Façade.model.CityDatabase;

import java.util.ArrayList;
import java.util.List;

public class TravelSearcher {

    // Base de datos de ciudades e infraestructuras
    private CityDatabase cityDatabase;

    // Las "Bases de datos" internas de transportes
    private List<Plane> availablePlanes;
    private List<Train> availableTrains;
    private List<Bus> availableBuses;

    public TravelSearcher() {
        // Inicializamos la base de datos de ciudades
        this.cityDatabase = new CityDatabase();

        this.availablePlanes = new ArrayList<>();
        this.availableTrains = new ArrayList<>();
        this.availableBuses = new ArrayList<>();

        // Rellenamos con datos de prueba
        availablePlanes.add(new Plane("Madrid", "Rome", "2026-05-10", "2026-05-15", 120.50, "Ryanair"));
        availablePlanes.add(new Plane("Málaga", "Paris", "2026-05-10", "2026-05-15", 85.00, "Vueling"));
        availableTrains.add(new Train("Madrid", "Barcelona", "2026-05-10", "2026-05-15", 45.00, "Ouigo"));
        availableTrains.add(new Train("Córdoba", "Madrid", "2026-05-10", "2026-05-15", 30.00, "Renfe AVE"));
        availableBuses.add(new Bus("Toledo", "Madrid", "2026-05-10", "2026-05-15", 15.00, "Alsa"));
        availableBuses.add(new Bus("Madrid", "Rome", "2026-05-10", "2026-05-15", 95.00, "FlixBus"));
    }

    // ==========================================================
    // MÉTODO PRINCIPAL (El que ve el cliente)
    // ==========================================================
    public void completeSearch(String origin, String destination, String startDate, String endDate) {
        System.out.println("=========================================================");
        System.out.println(" BÚSQUEDA DE VIAJE: " + origin + " -> " + destination);
        System.out.println(" Fechas: " + startDate + " al " + endDate);
        System.out.println("=========================================================\n");

        // Verificamos primero si las ciudades existen en nuestra base de datos
        if (!cityDatabase.cityExists(origin) || !cityDatabase.cityExists(destination)) {
            System.out.println("⚠️ ADVERTENCIA: Una de las ciudades (o ambas) no están en nuestra base de datos.");
            System.out.println("Intentaremos buscar de todos modos, pero los resultados pueden ser limitados.\n");
        }

        // 1. Invocamos al buscador general de transportes con la validación de ciudades
        transportSearch(origin, destination, startDate, endDate);

        // 2. Aquí invocaremos a accommodationSearch() en el futuro
        System.out.println("\n🏨 ALOJAMIENTOS EN " + destination.toUpperCase() + " [Pendiente]");

        // 3. Aquí invocaremos a activitySearch() en el futuro
        System.out.println("\n🎭 ACTIVIDADES EN " + destination.toUpperCase() + " [Pendiente]");

        System.out.println("\n=========================================================");
    }

    // ==========================================================
    // MÉTODOS AGRUPADORES (Invocados internamente)
    // ==========================================================
    private void transportSearch(String origin, String destination, String startDate, String endDate) {

        // --- BÚSQUEDA DE VUELOS ---
        System.out.println("✈️ VUELOS DISPONIBLES:");
        //Solo buscamos si ambas ciudades tienen aeropuerto
        if (cityDatabase.hasAirport(origin) && cityDatabase.hasAirport(destination)) {
            List<Plane> flights = searchPlanes(origin, destination, startDate, endDate);
            if (flights.isEmpty()) System.out.println("   No se han encontrado vuelos para estas fechas.");
            else for (Plane p : flights) System.out.println("   " + p.toString());
        } else {
            System.out.println("   Búsqueda omitida: " + origin + " o " + destination + " no disponen de aeropuerto.");
        }

        // --- BÚSQUEDA DE TRENES ---
        System.out.println("\n🚆 TRENES DISPONIBLES:");
        if (cityDatabase.hasTrainStation(origin) && cityDatabase.hasTrainStation(destination)) {
            List<Train> trains = searchTrains(origin, destination, startDate, endDate);
            if (trains.isEmpty()) System.out.println("   No se han encontrado trenes para estas fechas.");
            else for (Train t : trains) System.out.println("   " + t.toString());
        } else {
            System.out.println("   Búsqueda omitida: " + origin + " o " + destination + " no disponen de estación de tren.");
        }

        // --- BÚSQUEDA DE AUTOBUSES ---
        System.out.println("\n🚌 AUTOBUSES DISPONIBLES:");
        if (cityDatabase.hasBusStation(origin) && cityDatabase.hasBusStation(destination)) {
            List<Bus> buses = searchBuses(origin, destination, startDate, endDate);
            if (buses.isEmpty()) System.out.println("   No se han encontrado autobuses para estas fechas.");
            else for (Bus b : buses) System.out.println("   " + b.toString());
        } else {
            System.out.println("   Búsqueda omitida: " + origin + " o " + destination + " no disponen de estación de autobuses.");
        }
    }

    // ==========================================================
    // MÉTODOS DE FILTRADO ESPECÍFICOS (Ocultos al cliente)
    // ==========================================================
    private List<Plane> searchPlanes(String origin, String destination, String startDate, String endDate) {
        List<Plane> results = new ArrayList<>();
        for (Plane plane : availablePlanes) {
            if (plane.getOrigin().equalsIgnoreCase(origin) &&
                    plane.getDestination().equalsIgnoreCase(destination) &&
                    plane.getStartDate().equals(startDate) &&
                    plane.getEndDate().equals(endDate)) {
                results.add(plane);
            }
        }
        return results;
    }

    private List<Train> searchTrains(String origin, String destination, String startDate, String endDate) {
        List<Train> results = new ArrayList<>();
        for (Train train : availableTrains) {
            if (train.getOrigin().equalsIgnoreCase(origin) &&
                    train.getDestination().equalsIgnoreCase(destination) &&
                    train.getStartDate().equals(startDate) &&
                    train.getEndDate().equals(endDate)) {
                results.add(train);
            }
        }
        return results;
    }

    private List<Bus> searchBuses(String origin, String destination, String startDate, String endDate) {
        List<Bus> results = new ArrayList<>();
        for (Bus bus : availableBuses) {
            if (bus.getOrigin().equalsIgnoreCase(origin) &&
                    bus.getDestination().equalsIgnoreCase(destination) &&
                    bus.getStartDate().equals(startDate) &&
                    bus.getEndDate().equals(endDate)) {
                results.add(bus);
            }
        }
        return results;
    }
}