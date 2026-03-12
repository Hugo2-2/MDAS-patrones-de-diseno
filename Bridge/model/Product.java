package Bridge.model;

public class Product {
    
    private String name;
    private double price;
    private ProductType type;
    private int stock;

    public Product(String name, double price, ProductType type) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.stock = 0;
    }

    public Product(String name, double price, ProductType type, int stock) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.stock = stock;
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

    @Override
    public String toString() {
        return String.format("%s [%s] - %.2f €", name, type, price);
    }
}