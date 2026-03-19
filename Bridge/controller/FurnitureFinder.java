package Bridge.controller;


import Bridge.model.Product;
import java.util.List;

/**
 * ABSTRACCIÓN (Bridge)
 *
 * Mantiene una referencia al IMPLEMENTADOR (FurnitureSupplier).
 * No sabe qué proveedor concreto hay detrás; simplemente le delega
 * las operaciones de búsqueda. Las subclases refinan el comportamiento
 * sin necesidad de conocer la implementación del proveedor.
 *
 *   FurnitureFinder ◇────────▷ FurnitureSupplier
 *       └─ SofaFinder               └─ SupplierA / B / C
 *       └─ TableFinder
 */
public abstract class FurnitureFinder {

    // ── EL PUENTE: referencia al implementador ──────────────────────────
    private FurnitureSupplier supplier;

    public FurnitureFinder(FurnitureSupplier supplier) {
        this.supplier = supplier;
    }

    // Permite cambiar el proveedor en tiempo de ejecución (otro beneficio del Bridge)
    public void setSupplier(FurnitureSupplier supplier) {
        this.supplier = supplier;
    }

    public FurnitureSupplier getSupplier() {
        return supplier;
    }

    // ── Método plantilla: las subclases llaman a supplier para buscar ──
    protected List<Product> searchByPrice() {
        return supplier.searchByPrice();
    }

    protected List<Product> searchByStock() {
        return supplier.searchByStock();
    }

    protected List<Product> searchBySeats(int seats) {
        return supplier.searchBySeats(seats);
    }

    protected List<Product> searchByDimensions(String dimensions) {
        return supplier.searchByDimensions(dimensions);
    }

    // ── Operación abstracta que cada subclase especializa ──────────────
    public abstract List<Product> find();
}
