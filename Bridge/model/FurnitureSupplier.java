package Bridge.model;

import java.util.List;

public interface FurnitureSupplier {
    List<Product> searchByPrice();

    List<Product> searchByStock();

    List<Product> searchBySeats(int seats);

    List<Product> searchByDimensions(String dimensions);
}