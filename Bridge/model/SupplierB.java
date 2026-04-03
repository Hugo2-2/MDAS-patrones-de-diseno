package Bridge.model;
import Bridge.controller.FurnitureSupplier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SupplierB implements FurnitureSupplier {

    private List<Product> inventory;

    public SupplierB() {
        this.inventory = new ArrayList<>();
        // Empresa B solo vende mesas
        inventory.add(new Product("Mesa de Cristal", 150.00, ProductType.TABLE, 8, "Supplier B"));
        inventory.add(new Product("Mesa de Oficina", 210.00, ProductType.TABLE, 20, "Supplier B"));
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
        // La Empresa B no vende sofás
        return new ArrayList<>();
    }

    @Override
    public List<Product> searchByDimensions(String dimensions) {
        List<Product> result = new ArrayList<>();
        for (Product p : inventory) {
            if (p.getType() == ProductType.TABLE) {
                result.add(p);
            }
        }
        return result;
    }
}