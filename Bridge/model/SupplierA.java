package Bridge.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SupplierA implements FurnitureSupplier {

    private List<Product> inventory;

    public SupplierA() {
        this.inventory = new ArrayList<>();
        // Empresa A solo vende sofás
        inventory.add(new Product("Sofa de Cuero", 499.99, ProductType.SOFA, 5));
        // OJO a este producto, también lo venderá la Empresa C
        inventory.add(new Product("Sofa Minimalista", 299.50, ProductType.SOFA, 12));
    }

    @Override
    public List<Product> searchByPrice() {
        List<Product> sortedList = new ArrayList<>(inventory);
        // Ordenamos de menor a mayor precio
        sortedList.sort(Comparator.comparingDouble(Product::getPrice));
        return sortedList;
    }

    @Override
    public List<Product> searchByStock() {
        List<Product> sortedList = new ArrayList<>(inventory);
        // Ordenamos por stock de mayor a menor (reversed)
        sortedList.sort(Comparator.comparingInt(Product::getStock).reversed());
        return sortedList;
    }

    @Override
    public List<Product> searchBySeats(int seats) {
        List<Product> result = new ArrayList<>();
        // Como nuestra clase Product no tiene "seats", filtramos por tipo SOFA para
        // simularlo
        for (Product p : inventory) {
            if (p.getType() == ProductType.SOFA) {
                result.add(p); // En un caso real, aquí comprobaríamos p.getSeats() == seats
            }
        }
        return result;
    }

    @Override
    public List<Product> searchByDimensions(String dimensions) {
        // La Empresa A no vende mesas, así que devuelve una lista vacía
        return new ArrayList<>();
    }
}