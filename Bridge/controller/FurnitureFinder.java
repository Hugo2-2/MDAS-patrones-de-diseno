package Bridge.controller;

import Bridge.model.Product;
import java.util.List;

/**
 * ABSTRACCIÓN (Bridge)
 *
 * Mantiene una referencia (composición) a una lista de IMPLEMENTADORES
 * (FurnitureSupplier). No sabe qué proveedores concretos hay detrás;
 * simplemente les delega las operaciones de búsqueda.
 * Las subclases (SofaFinder, TableFinder) refinan el comportamiento
 * sin necesidad de conocer la implementación del proveedor.
 *
 *   FurnitureFinder ◆────────▷ FurnitureSupplier
 *       └─ SofaFinder               └─ SupplierA / B / C
 *       └─ TableFinder
 */
public abstract class FurnitureFinder {

    // ── EL PUENTE: composición con los implementadores ──────────────────
    private List<FurnitureSupplier> suppliers;

    public FurnitureFinder(List<FurnitureSupplier> suppliers) {
        this.suppliers = suppliers;
    }

    public List<FurnitureSupplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<FurnitureSupplier> suppliers) {
        this.suppliers = suppliers;
    }

    // ── Operación abstracta que cada subclase especializa ──────────────
    /**
     * Busca muebles según un criterio concreto delegando en los proveedores.
     *
     * @param criteria criterio de búsqueda (p.ej. "price", "stock", etc.)
     * @return lista agregada de productos de todos los proveedores
     */
    public abstract List<Product> searchFurniture(String criteria);
}
