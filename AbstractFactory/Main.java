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

        Menu menuSemanalRestaurante = restauranteFactory.crearMenuSemanal(Acompanamiento.PATATAS);
        imprimirDetallesMenu(menuSemanalRestaurante);


        // ==========================================
        // PRUEBA 2: MENÚ SEMANAL PARA LLEVAR (PICKUP)
        // ==========================================
        System.out.println("\n=== MENÚ SEMANAL PARA LLEVAR (PICKUP) ===");

        // Pasamos el postre (para cumplir la firma del método), pero la PickupFactory lo ignorará internamente
        Menu menuSemanalPickup = pickupFactory.crearMenuSemanal(Acompanamiento.ENSALADA);
        imprimirDetallesMenu(menuSemanalPickup);


        // ==========================================
        // PRUEBA 3: MENÚ DE TEMPORADA EN RESTAURANTE
        // ==========================================
        System.out.println("\n=== MENÚ DE TEMPORADA EN RESTAURANTE ===");

        Menu menuTemporadaRestaurante = restauranteFactory.crearMenuTemporada();
        imprimirDetallesMenu(menuTemporadaRestaurante);


        // ==========================================
        // PRUEBA 4: MENÚ DE TEMPORADA PARA LLEVAR
        // ==========================================
        System.out.println("\n=== MENÚ DE TEMPORADA PARA LLEVAR (PICKUP) ===");

        Menu menuTemporadaPickup = pickupFactory.crearMenuTemporada();
        imprimirDetallesMenu(menuTemporadaPickup);
    }

    /**
     * Método auxiliar para imprimir los platos y el precio total de un menú
     */
    private static void imprimirDetallesMenu(Menu menu) {
        System.out.println("Platos incluidos:");
        for (Plato p : menu.getPlatos()) {
            if(p.getTipo() == TipoPlato.PRINCIPAL)
                System.out.println(" - " + p.getNombre() + " (" + p.getTipo() + ") | Guarnición: " + p.getAcompanamiento() + " | Precio: " + String.format("%.2f", p.getPrecio()) + "€");
            else
                System.out.println(" - " + p.getNombre() + " (" + p.getTipo() + ")" + " | Precio: " + String.format("%.2f", p.getPrecio()) + "€");
        }
        System.out.println("Precio TOTAL del menú: " + String.format("%.2f", menu.calcularPrecio()) + "€");
    }
}