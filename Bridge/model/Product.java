package Bridge.model;

public class Product {
    
    private String name;
    private double price;
    private ProductType type;
    private int stock;
    private String supplier;

    public Product(String name, double price, ProductType type, String supplier) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.stock = 0;
        this.supplier = supplier;
    }

    public Product(String name, double price, ProductType type, int stock, String supplier) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.stock = stock;
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return String.format("%s [%s] - %.2f € (Supplier: %s)", name, type, price, supplier);
    }
}