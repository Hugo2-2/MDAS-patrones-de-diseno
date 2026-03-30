package Façade.controller;

import Façade.model.Apartment;
import Façade.model.Bus;
import Façade.model.CityDatabase;
import Façade.model.Festival;
import Façade.model.GuidedTour;
import Façade.model.Hostel;
import Façade.model.Hotel;
import Façade.model.Museum;
import Façade.model.Plane;
import Façade.model.Train;
import java.util.ArrayList;
import java.util.List;

public class TravelSearcher {

    // Base de datos de ciudades e infraestructuras
    private CityDatabase cityDatabase;

    // Las "Bases de datos" internas de transportes
    private List<Plane> availablePlanes;
    private List<Train> availableTrains;
    private List<Bus> availableBuses;

        // Bases de datos de alojamiento
    private List<Hotel> availableHotels;
    private List<Apartment> availableApartments;
    private List<Hostel> availableHostels;

    // Bases de datos de actividades
    private List<GuidedTour> availableTours;
    private List<Festival> availableFestivals;
    private List<Museum> availableMuseums;

    public TravelSearcher() {
        // Inicializamos la base de datos de ciudades
        this.cityDatabase = new CityDatabase();

        this.availablePlanes = new ArrayList<>();
        this.availableTrains = new ArrayList<>();
        this.availableBuses = new ArrayList<>();

        this.availableHotels = new ArrayList<>();
        this.availableApartments = new ArrayList<>();
        this.availableHostels = new ArrayList<>();

        this.availableTours = new ArrayList<>();
        this.availableFestivals = new ArrayList<>();
        this.availableMuseums = new ArrayList<>();

        // Cargar datos de prueba
        loadTransportData();
        loadAccommodationData();
        loadActivitiesData();
    }

    private void loadTransportData() {
        // Aviones
        availablePlanes.add(new Plane("Madrid", "Rome", "2026-05-10", "2026-05-15", 120.50, "Ryanair"));
        availablePlanes.add(new Plane("Málaga", "Paris", "2026-05-10", "2026-05-15", 85.00, "Vueling"));
        
        // Trenes
        availableTrains.add(new Train("Madrid", "Barcelona", "2026-05-10", "2026-05-15", 45.00, "Ouigo"));
        availableTrains.add(new Train("Córdoba", "Madrid", "2026-05-10", "2026-05-15", 30.00, "Renfe AVE"));
        
        // Autobuses
        availableBuses.add(new Bus("Toledo", "Madrid", "2026-05-10", "2026-05-15", 15.00, "Alsa"));
        availableBuses.add(new Bus("Madrid", "Rome", "2026-05-10", "2026-05-15", 95.00, "FlixBus"));
    }
    
    private void loadAccommodationData() {
        // ==================== HOTELES ====================
        
        // Madrid
        availableHotels.add(new Hotel("Hotel Ritz", "Plaza de la Lealtad 5", "Madrid", 5, 350.00,
            "Suite Deluxe", "2026-01-01", "2026-12-31"));
        availableHotels.add(new Hotel("NH Collection", "Calle de Zurbano 79", "Madrid", 4, 180.00,
            "Habitación Doble", "2026-01-01", "2026-12-31"));
        availableHotels.add(new Hotel("Hotel Ibis", "Calle de San Bernardo 56", "Madrid", 2, 65.00,
            "Habitación Individual", "2026-01-01", "2026-12-31"));
        
        // Barcelona
        availableHotels.add(new Hotel("Hotel Arts", "Carrer de la Marina 19", "Barcelona", 5, 450.00,
            "Habitación con vistas al mar", "2026-04-01", "2026-10-31"));
        availableHotels.add(new Hotel("W Barcelona", "Plaça de la Rosa dels Vents 1", "Barcelona", 5, 380.00,
            "Habitación Superior", "2026-01-01", "2026-12-31"));
        
        // Roma
        availableHotels.add(new Hotel("Hotel Roma", "Via del Corso 120", "Rome", 4, 150.00,
            "Habitación Doble", "2026-01-01", "2026-12-31"));
        
        // Granada
        availableHotels.add(new Hotel("Hotel Alhambra Palace", "Peña Partida 2", "Granada", 5, 220.00,
            "Habitación con vistas", "2026-01-01", "2026-12-31"));
        
        // ==================== APARTAMENTOS ====================
        
        // Madrid
        availableApartments.add(new Apartment("Calle Gran Vía 45", "Madrid", 2, 1, 120.00,
            "2026-01-01", "2026-12-31"));
        availableApartments.add(new Apartment("Plaza Mayor 3", "Madrid", 1, 1, 85.00,
            "2026-01-01", "2026-12-31"));
        
        // Barcelona
        availableApartments.add(new Apartment("Passeig de Gràcia 75", "Barcelona", 3, 2, 180.00,
            "2026-04-01", "2026-10-31"));
        
        // Roma
        availableApartments.add(new Apartment("Via del Corso 120", "Rome", 2, 1, 140.00,
            "2026-01-01", "2026-12-31"));
        
        // ==================== HOSTELS ====================
        
        // Madrid
        availableHostels.add(new Hostel("The Hat Madrid", "Calle de la Cava Baja 15", "Madrid", 28.00,
            "Dormitorio Compartido", "2026-01-01", "2026-12-31"));
        availableHostels.add(new Hostel("Hostal Central", "Calle de Atocha 45", "Madrid", 35.00,
            "Habitación Privada", "2026-01-01", "2026-12-31"));
        
        // Barcelona
        availableHostels.add(new Hostel("Casa Gracia", "Passeig de Gràcia 116", "Barcelona", 40.00,
            "Habitación Doble", "2026-03-01", "2026-11-30"));
        
        // Roma
        availableHostels.add(new Hostel("YellowSquare", "Via del Castro Pretorio 30", "Rome", 38.00,
            "Habitación Privada", "2026-01-01", "2026-12-31"));
    }

    private void loadActivitiesData() {
        // ==================== VISITAS GUIADAS ====================

        // Madrid
        availableTours.add(new GuidedTour("Tour del Madrid de los Austrias", "Madrid",
            "Recorrido histórico por el casco antiguo", 2.5, 25.00, "Español",
            "2026-01-01", "2026-12-31"));
        availableTours.add(new GuidedTour("Tour nocturno por Madrid", "Madrid",
            "Descubre la ciudad iluminada de noche", 2.0, 20.00, "Español",
            "2026-01-01", "2026-12-31"));

        // Barcelona
        availableTours.add(new GuidedTour("Ruta Gaudí", "Barcelona",
            "Visita las obras maestras de Gaudí", 3.0, 35.00, "Español",
            "2026-04-01", "2026-10-31"));

        // Roma
        availableTours.add(new GuidedTour("Coliseo y Foro Romano", "Rome",
            "Tour guiado por la Roma antigua", 3.5, 40.00, "English",
            "2026-01-01", "2026-12-31"));
        availableTours.add(new GuidedTour("Vaticano y Capilla Sixtina", "Rome",
            "Visita guiada sin colas al Vaticano", 3.0, 55.00, "English",
            "2026-01-01", "2026-12-31"));

        // Granada
        availableTours.add(new GuidedTour("Tour de la Alhambra", "Granada",
            "Recorrido completo por la Alhambra y el Generalife", 3.0, 45.00, "Español",
            "2026-01-01", "2026-12-31"));

        // ==================== FESTIVALES ====================

        // Madrid
        availableFestivals.add(new Festival("Mad Cool Festival", "Madrid",
            "Festival de música indie y rock", "2026-07-08", "2026-07-12", 180.00, "Música"));

        // Barcelona
        availableFestivals.add(new Festival("Primavera Sound", "Barcelona",
            "Festival de música alternativa", "2026-06-04", "2026-06-06", 195.00, "Música"));
        availableFestivals.add(new Festival("La Mercè", "Barcelona",
            "Fiestas mayores de Barcelona", "2026-09-20", "2026-09-24", 0.00, "Cultural"));

        // Roma
        availableFestivals.add(new Festival("Estate Romana", "Rome",
            "Festival de cine, música y teatro al aire libre", "2026-06-01", "2026-09-30", 15.00, "Cultural"));

        // ==================== MUSEOS ====================

        // Madrid
        availableMuseums.add(new Museum("Museo del Prado", "Calle de Ruiz de Alarcón 23", "Madrid",
            15.00, "Arte clásico", "2026-01-01", "2026-12-31"));
        availableMuseums.add(new Museum("Museo Reina Sofía", "Calle de Santa Isabel 52", "Madrid",
            12.00, "Arte contemporáneo", "2026-01-01", "2026-12-31"));

        // Barcelona
        availableMuseums.add(new Museum("Museo Picasso", "Carrer de Montcada 15", "Barcelona",
            12.00, "Arte", "2026-01-01", "2026-12-31"));

        // Roma
        availableMuseums.add(new Museum("Museos Vaticanos", "Viale Vaticano", "Rome",
            17.00, "Arte y religión", "2026-01-01", "2026-12-31"));
        availableMuseums.add(new Museum("Galería Borghese", "Piazzale Scipione Borghese 5", "Rome",
            13.00, "Arte renacentista y barroco", "2026-01-01", "2026-12-31"));

        // Granada
        availableMuseums.add(new Museum("Museo de la Alhambra", "Palacio de Carlos V", "Granada",
            0.00, "Arte hispanomusulmán", "2026-01-01", "2026-12-31"));
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

        // 2. Búsqueda de alojamiento
        accommodationSearch(destination, startDate, endDate);

        // 3. Búsqueda de actividades
        activitySearch(destination, startDate, endDate);

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


    // ==========================================================
    // MÉTODO DE BÚSQUEDA DE ALOJAMIENTO
    // ==========================================================

    private void accommodationSearch(String city, String startDate, String endDate) {
        System.out.println("\n🏨 ALOJAMIENTOS EN " + city.toUpperCase() + ":");
        
        // Buscar hoteles
        System.out.println("\n  HOTELES:");
        List<Hotel> hotels = findHotels(city, startDate, endDate);
        if (hotels.isEmpty()) {
            System.out.println("   No hay hoteles disponibles para estas fechas.");
        } else {
            for (Hotel h : hotels) {
                System.out.println("   " + h.toString());
            }
        }
        
        // Buscar apartamentos
        System.out.println("\n  APARTAMENTOS:");
        List<Apartment> apartments = findApartments(city, startDate, endDate);
        if (apartments.isEmpty()) {
            System.out.println("   No hay apartamentos disponibles para estas fechas.");
        } else {
            for (Apartment a : apartments) {
                System.out.println("   " + a.toString());
            }
        }
        
        // Buscar hostels
        System.out.println("\n  HOSTELS:");
        List<Hostel> hostels = findHostels(city, startDate, endDate);
        if (hostels.isEmpty()) {
            System.out.println("   No hay hostels disponibles para estas fechas.");
        } else {
            for (Hostel h : hostels) {
                System.out.println("   " + h.toString());
            }
        }
    }

    // ==========================================================
    // MÉTODOS PRIVADOS DE BÚSQUEDA DE ALOJAMIENTO
    // ==========================================================
    
    private List<Hotel> findHotels(String city, String startDate, String endDate) {
        List<Hotel> results = new ArrayList<>();
        for (Hotel hotel : availableHotels) {
            if (hotel.getCity().equalsIgnoreCase(city) && hotel.isAvailable(startDate, endDate)) {
                results.add(hotel);
            }
        }
        return results;
    }
    
    private List<Apartment> findApartments(String city, String startDate, String endDate) {
        List<Apartment> results = new ArrayList<>();
        for (Apartment apartment : availableApartments) {
            if (apartment.getCity().equalsIgnoreCase(city) && apartment.isAvailable(startDate, endDate)) {
                results.add(apartment);
            }
        }
        return results;
    }
    
    private List<Hostel> findHostels(String city, String startDate, String endDate) {
        List<Hostel> results = new ArrayList<>();
        for (Hostel hostel : availableHostels) {
            if (hostel.getCity().equalsIgnoreCase(city) && hostel.isAvailable(startDate, endDate)) {
                results.add(hostel);
            }
        }
        return results;
    }

    // ==========================================================
    // MÉTODO DE BÚSQUEDA DE ACTIVIDADES
    // ==========================================================

    private void activitySearch(String city, String startDate, String endDate) {
        System.out.println("\n🎭 ACTIVIDADES EN " + city.toUpperCase() + ":");

        // Buscar visitas guiadas
        System.out.println("\n  VISITAS GUIADAS:");
        List<GuidedTour> tours = findTours(city, startDate, endDate);
        if (tours.isEmpty()) {
            System.out.println("   No hay visitas guiadas disponibles para estas fechas.");
        } else {
            for (GuidedTour t : tours) {
                System.out.println("   " + t.toString());
            }
        }

        // Buscar festivales
        System.out.println("\n  FESTIVALES:");
        List<Festival> festivals = findFestivals(city, startDate, endDate);
        if (festivals.isEmpty()) {
            System.out.println("   No hay festivales disponibles para estas fechas.");
        } else {
            for (Festival f : festivals) {
                System.out.println("   " + f.toString());
            }
        }

        // Buscar museos
        System.out.println("\n  MUSEOS:");
        List<Museum> museums = findMuseums(city, startDate, endDate);
        if (museums.isEmpty()) {
            System.out.println("   No hay museos disponibles para estas fechas.");
        } else {
            for (Museum m : museums) {
                System.out.println("   " + m.toString());
            }
        }
    }

    // ==========================================================
    // MÉTODOS PRIVADOS DE BÚSQUEDA DE ACTIVIDADES
    // ==========================================================

    private List<GuidedTour> findTours(String city, String startDate, String endDate) {
        List<GuidedTour> results = new ArrayList<>();
        for (GuidedTour tour : availableTours) {
            if (tour.getCity().equalsIgnoreCase(city) && tour.isAvailable(startDate, endDate)) {
                results.add(tour);
            }
        }
        return results;
    }

    private List<Festival> findFestivals(String city, String startDate, String endDate) {
        List<Festival> results = new ArrayList<>();
        for (Festival festival : availableFestivals) {
            if (festival.getCity().equalsIgnoreCase(city) && festival.isAvailable(startDate, endDate)) {
                results.add(festival);
            }
        }
        return results;
    }

    private List<Museum> findMuseums(String city, String startDate, String endDate) {
        List<Museum> results = new ArrayList<>();
        for (Museum museum : availableMuseums) {
            if (museum.getCity().equalsIgnoreCase(city) && museum.isAvailable(startDate, endDate)) {
                results.add(museum);
            }
        }
        return results;
    }
}