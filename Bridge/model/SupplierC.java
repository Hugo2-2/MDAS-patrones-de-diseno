package Bridge.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SupplierC implements FurnitureSupplier {

    private List<Product> inventory;

    public SupplierC() {
        this.inventory = new ArrayList<>();
        // Vende mesas
        inventory.add(new Product("Mesa de Roble", 300.00, ProductType.TABLE, 4));
        // Vende sofás.
        inventory.add(new Product("Sofa Minimalista", 299.50, ProductType.SOFA, 3));
    }

    @Override
    public List<Product> searchByPrice() {
        List<Product> sortedList = new ArrayList<>(inventory);
        sortedList.sort(Comparator.comparingDouble(Product::getPrice));
        return sortedList;
    }

    @Override
    public List<Product> searchByStock() {
        List<Product> sortedList = new ArrayList<>(inventory);
        sortedList.sort(Comparator.comparingInt(Product::getStock).reversed());
        return sortedList;
    }

    @Override
    public List<Product> searchBySeats(int seats) {
        List<Product> result = new ArrayList<>();
        for (Product p : inventory) {
            if (p.getType() == ProductType.SOFA) result.add(p);
        }
        return result;
    }

    @Override
    public List<Product> searchByDimensions(String dimensions) {
        List<Product> result = new ArrayList<>();
        for (Product p : inventory) {
            if (p.getType() == ProductType.TABLE) result.add(p);
        }
        return result;
    }
}