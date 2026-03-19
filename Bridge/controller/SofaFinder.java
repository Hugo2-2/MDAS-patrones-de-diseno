package Bridge.controller;

import Bridge.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * ABSTRACCIÓN REFINADA (Bridge) — Búsqueda de sofás.
 *
 * Especializa FurnitureFinder para buscar sofás según el número de asientos.
 * Recorre todos los proveedores (suppliers) y agrega los resultados.
 */
public class SofaFinder extends FurnitureFinder {

    private int seats;

    public SofaFinder(List<FurnitureSupplier> suppliers, int seats) {
        super(suppliers);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    /**
     * Busca sofás delegando en cada proveedor.
     * Si el criterio es "seats", usa searchBySeats; en caso contrario
     * puede buscar por precio o stock.
     */
    @Override
    public List<Product> searchFurniture(String criteria) {
        List<Product> results = new ArrayList<>();
        for (FurnitureSupplier supplier : getSuppliers()) {
            switch (criteria.toLowerCase()) {
                case "seats":
                    results.addAll(supplier.searchBySeats(seats));
                    break;
                case "price":
                    results.addAll(supplier.searchByPrice());
                    break;
                case "stock":
                    results.addAll(supplier.searchByStock());
                    break;
                default:
                    results.addAll(supplier.searchBySeats(seats));
                    break;
            }
        }
        return results;
    }
}
