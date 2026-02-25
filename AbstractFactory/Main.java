package AbstractFactory;

import AbstractFactory.controller.FactoryAbstract;
import AbstractFactory.controller.PickupFactory;
import AbstractFactory.controller.RestauranteFactory;
import AbstractFactory.model.Acompanamiento;
import AbstractFactory.model.Menu;
import AbstractFactory.model.Plato;
import AbstractFactory.model.TipoPlato;

public class Main {

    public static void main(String[] args) {

        // 1. Instanciamos las dos factorías concretas pero las tratamos
        // a través de su abstracción (FactoryAbstract)
        FactoryAbstract restauranteFactory = new RestauranteFactory();
        FactoryAbstract pickupFactory = new PickupFactory();

        // ==========================================
        // PRUEBA 1: MENÚ SEMANAL EN RESTAURANTE
        // ==========================================
        System.out.println("=== MENÚ SEMANAL EN RESTAURANTE ===");
        Plato entranteRest = new Plato("Ensalada César", TipoPlato.ENTRANTE, 5.0f);
        Plato principalRest = new Plato("Entrecot", TipoPlato.PRINCIPAL, 15.0f);
        Plato postreRest = new Plato("Tarta de Queso", TipoPlato.POSTRE, 4.0f);

        Menu menuSemanalRestaurante = restauranteFactory.crearMenuSemanal(entranteRest, principalRest, postreRest, Acompanamiento.PATATAS);
        imprimirDetallesMenu(menuSemanalRestaurante);


        // ==========================================
        // PRUEBA 2: MENÚ SEMANAL PARA LLEVAR (PICKUP)
        // ==========================================
        System.out.println("\n=== MENÚ SEMANAL PARA LLEVAR (PICKUP) ===");
        // Creamos nuevos objetos plato para que el recargo del precio no afecte a los anteriores
        Plato entrantePick = new Plato("Sopa de Picadillo", TipoPlato.ENTRANTE, 5.0f);
        Plato principalPick = new Plato("Pollo asado", TipoPlato.PRINCIPAL, 10.0f);
        Plato postrePick = new Plato("Helado", TipoPlato.POSTRE, 3.0f);

        // Pasamos el postre (para cumplir la firma del método), pero la PickupFactory lo ignorará internamente
        Menu menuSemanalPickup = pickupFactory.crearMenuSemanal(entrantePick, principalPick, postrePick, Acompanamiento.ENSALADA);
        imprimirDetallesMenu(menuSemanalPickup);


        // ==========================================
        // PRUEBA 3: MENÚ DE TEMPORADA EN RESTAURANTE
        // ==========================================
        System.out.println("\n=== MENÚ DE TEMPORADA EN RESTAURANTE ===");
        Plato temporadaRest = new Plato("Guiso especial de invierno", TipoPlato.PRINCIPAL, 12.0f);

        Menu menuTemporadaRestaurante = restauranteFactory.crearMenuTemporada(temporadaRest);
        imprimirDetallesMenu(menuTemporadaRestaurante);


        // ==========================================
        // PRUEBA 4: MENÚ DE TEMPORADA PARA LLEVAR
        // ==========================================
        System.out.println("\n=== MENÚ DE TEMPORADA PARA LLEVAR (PICKUP) ===");
        Plato temporadaPick = new Plato("Guiso especial de invierno", TipoPlato.PRINCIPAL, 12.0f);

        Menu menuTemporadaPickup = pickupFactory.crearMenuTemporada(temporadaPick);
        imprimirDetallesMenu(menuTemporadaPickup);
    }

    /**
     * Método auxiliar para imprimir los platos y el precio total de un menú
     */
    private static void imprimirDetallesMenu(Menu menu) {
        System.out.println("Platos incluidos:");
        for (Plato p : menu.getPlatos()) {
            System.out.println(" - " + p.getNombre() + " (" + p.getTipo() + ") | Guarnición: " + p.getAcompanamiento() + " | Precio: " + String.format("%.2f", p.getPrecio()) + "€");
        }
        System.out.println("Precio TOTAL del menú: " + String.format("%.2f", menu.calcularPrecio()) + "€");
    }
}