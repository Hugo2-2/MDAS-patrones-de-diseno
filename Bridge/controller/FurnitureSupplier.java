package Bridge.controller;

import java.util.List;

import Bridge.model.Product;

public interface FurnitureSupplier {
    List<Product> searchByPrice();

    List<Product> searchByStock();

    List<Product> searchBySeats(int seats);

    List<Product> searchByDimensions(String dimensions);
}
