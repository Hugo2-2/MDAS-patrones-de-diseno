package Façade;

import Façade.controller.TravelSearcher;

public class Main {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║          PATRÓN FAÇADE - BUSCADOR DE VIAJES          ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝\n");

        // El cliente solo necesita conocer la FACHADA (TravelSearcher).
        // No interactúa directamente con Plane, Train, Bus, Hotel, Hostel,
        // Apartment, GuidedTour, Festival, Museum ni CityDatabase.
        TravelSearcher searcher = new TravelSearcher();

        // ===================================================================
        // BÚSQUEDA 1: Madrid → Rome (ciudad con aeropuerto → ciudad con aeropuerto)
        // Demuestra: vuelos, trenes (omitidos por no haber ruta directa),
        //            autobuses, alojamiento y actividades en Roma.
        // ===================================================================
        System.out.println("\n>>> CASO 1: Viaje con vuelo disponible\n");
        searcher.completeSearch("Madrid", "Rome", "2026-05-10", "2026-05-15");

        // ===================================================================
        // BÚSQUEDA 2: Madrid → Barcelona (conexión nacional por tren)
        // Demuestra: vuelos (sin resultados), tren Ouigo disponible,
        //            alojamiento y actividades en Barcelona.
        // ===================================================================
        System.out.println("\n\n>>> CASO 2: Viaje nacional con tren disponible\n");
        searcher.completeSearch("Madrid", "Barcelona", "2026-05-10", "2026-05-15");

        // ===================================================================
        // BÚSQUEDA 3: Toledo → Madrid (ciudad sin aeropuerto ni estación de tren)
        // Demuestra: la fachada detecta que Toledo no tiene aeropuerto ni
        //            estación de tren y omite esas búsquedas automáticamente.
        //            Solo muestra autobuses + alojamiento + actividades en Madrid.
        // ===================================================================
        System.out.println("\n\n>>> CASO 3: Ciudad pequeña sin aeropuerto ni tren\n");
        searcher.completeSearch("Toledo", "Madrid", "2026-05-10", "2026-05-15");

        // ===================================================================
        // BÚSQUEDA 4: Madrid → Rome filtrando museos por temática "religión"
        // Demuestra: la sobrecarga de completeSearch que permite filtrar
        //            museos por temática (solo mostrará Museos Vaticanos).
        // ===================================================================
        System.out.println("\n\n>>> CASO 4: Búsqueda con filtro de temática en museos\n");
        searcher.completeSearch("Madrid", "Rome", "2026-05-10", "2026-05-15", "religión");

        // ===================================================================
        // BÚSQUEDA 5: Madrid → Madrid filtrando museos por "contemporáneo"
        // Demuestra: filtro de temática en destino nacional (solo mostrará
        //            el Museo Reina Sofía).
        // ===================================================================
        System.out.println("\n\n>>> CASO 5: Filtro de temática 'contemporáneo' en Madrid\n");
        searcher.completeSearch("Madrid", "Madrid", "2026-05-10", "2026-05-15", "contemporáneo");

        // ===================================================================
        // BÚSQUEDA 6: Fechas sin resultados
        // Demuestra: la fachada maneja correctamente cuando no hay datos
        //            para las fechas solicitadas.
        // ===================================================================
        System.out.println("\n\n>>> CASO 6: Fechas sin disponibilidad\n");
        searcher.completeSearch("Madrid", "Rome", "2027-08-01", "2027-08-10");

    }
}
