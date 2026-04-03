package Bridge.controller;

import Bridge.model.Product;
import java.util.List;


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


    public abstract List<Product> searchFurniture(String criteria);
}
