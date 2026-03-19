package Bridge.controller;

import Bridge.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * ABSTRACCIÓN REFINADA (Bridge) — Búsqueda de mesas.
 *
 * Especializa FurnitureFinder para buscar mesas según sus dimensiones.
 * Recorre todos los proveedores (suppliers) y agrega los resultados.
 */
public class TableFinder extends FurnitureFinder {

    private String dimensions;

    public TableFinder(List<FurnitureSupplier> suppliers, String dimensions) {
        super(suppliers);
        this.dimensions = dimensions;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * Busca mesas delegando en cada proveedor.
     * Si el criterio es "dimensions", usa searchByDimensions; en caso contrario
     * puede buscar por precio o stock.
     */
    @Override
    public List<Product> searchFurniture(String criteria) {
        List<Product> results = new ArrayList<>();
        for (FurnitureSupplier supplier : getSuppliers()) {
            switch (criteria.toLowerCase()) {
                case "dimensions":
                    results.addAll(supplier.searchByDimensions(dimensions));
                    break;
                case "price":
                    results.addAll(supplier.searchByPrice());
                    break;
                case "stock":
                    results.addAll(supplier.searchByStock());
                    break;
                default:
                    results.addAll(supplier.searchByDimensions(dimensions));
                    break;
            }
        }
        return results;
    }
}
