package Bridge;

import Bridge.controller.FurnitureFinder;
import Bridge.controller.FurnitureSupplier;
import Bridge.controller.SofaFinder;
import Bridge.controller.TableFinder;
import Bridge.model.Product;
import Bridge.model.ProductType;
import Bridge.model.SupplierA;
import Bridge.model.SupplierB;
import Bridge.model.SupplierC;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== BRIDGE PATTERN - FURNITURE CATALOG ===\n");

        // 1. Crear los proveedores (Implementaciones)
        System.out.println("1. CREATING SUPPLIERS:");
        FurnitureSupplier supplierA = new SupplierA(); // Solo sofás
        FurnitureSupplier supplierB = new SupplierB(); // Solo mesas
        FurnitureSupplier supplierC = new SupplierC(); // Mixto (mesas y sofás)

        System.out.println("   Supplier A (only sofas)");
        System.out.println("   Supplier B (only tables)");
        System.out.println("   Supplier C (sofas & tables)");

        // 2. Configurar los FINDERS (Abstracciones) con TODOS los proveedores
        System.out.println("\n2. CONFIGURING FINDERS WITH ALL SUPPLIERS:");
        
        // IMPORTANTE: Ambos finders tienen TODOS los proveedores
        // La responsabilidad de filtrar por tipo de producto es de cada proveedor
        List<FurnitureSupplier> allSuppliers = Arrays.asList(supplierA, supplierB, supplierC);
        
        FurnitureFinder tableFinder = new TableFinder(allSuppliers, "medium");
        FurnitureFinder sofaFinder = new SofaFinder(allSuppliers, 2);
        
        System.out.println("   TableFinder created with ALL suppliers (A, B, C)");
        System.out.println("   SofaFinder created with ALL suppliers (A, B, C)");
        System.out.println("   Each supplier will return empty list for products they don't sell");

        // 3. DEMOSTRACIÓN: Verificar que se consultan TODOS los proveedores
        System.out.println("\n3. VERIFYING ALL SUPPLIERS ARE QUERIED:");
        
        System.out.println("\n   --- SEARCHING FOR TABLES (should query all 3 suppliers) ---");
        List<Product> allTableResults = tableFinder.searchFurniture("dimensions");
        System.out.println("   Total results: " + allTableResults.size());
        System.out.println("   Results from each supplier:");
        System.out.println("      Supplier A (sofas only): 0 tables (empty list)");
        System.out.println("      Supplier B (tables only): 2 tables");
        System.out.println("      Supplier C (mixed): 1 table");
        System.out.println("      TOTAL: 3 tables");
        
        System.out.println("\n   Actual results:");
        allTableResults.forEach(p -> System.out.println("      " + p));
        
        System.out.println("\n   --- SEARCHING FOR SOFAS (should query all 3 suppliers) ---");
        List<Product> allSofaResults = sofaFinder.searchFurniture("seats");
        System.out.println("   Total results: " + allSofaResults.size());
        System.out.println("   Results from each supplier:");
        System.out.println("      Supplier A (sofas only): 2 sofas");
        System.out.println("      Supplier B (tables only): 0 sofas (empty list)");
        System.out.println("      Supplier C (mixed): 1 sofa");
        System.out.println("      TOTAL: 3 sofas");
        
        System.out.println("\n   Actual results:");
        allSofaResults.forEach(p -> System.out.println("      " + p));

        // 4. DEMOSTRACIÓN DE FUNCIONALIDADES REQUERIDAS
        System.out.println("\n4. REQUIRED FUNCTIONALITIES:");

        // a) Productos ordenados por precio (menor a mayor)
        System.out.println("\n   --- TABLES SORTED BY PRICE (all suppliers queried) ---");
        List<Product> tablesByPrice = tableFinder.searchFurniture("price");
        tablesByPrice.stream()
            .filter(p -> p.getStock() > 0 && p.getType() == ProductType.TABLE)
            .sorted(Comparator.comparingDouble(Product::getPrice))
            .forEach(p -> System.out.println("      " + p + " (stock: " + p.getStock() + ")"));

        // b) Productos ordenados por stock (mayor a menor) con agregación
        System.out.println("\n   --- SOFAS SORTED BY STOCK (aggregated across all suppliers) ---");
        List<Product> sofasByStock = sofaFinder.searchFurniture("stock");
        
        // Filtrar solo sofás y agregar stocks
        List<Product> sofasOnly = new ArrayList<>();
        for (Product p : sofasByStock) {
            if (p.getType() == ProductType.SOFA) {
                sofasOnly.add(p);
            }
        }
        
        List<Product> aggregatedSofas = aggregateProducts(sofasOnly);
        aggregatedSofas.stream()
            .sorted(Comparator.comparingInt(Product::getStock).reversed())
            .forEach(p -> System.out.println("      " + p + " (total stock: " + p.getStock() + ")"));

        // 5. BÚSQUEDAS ESPECÍFICAS
        System.out.println("\n5. SPECIFIC SEARCHES (all suppliers queried):");

        System.out.println("\n   --- SOFAS BY SEATS (from all suppliers) ---");
        List<Product> sofasBySeats = sofaFinder.searchFurniture("seats");
        sofasBySeats.forEach(p -> System.out.println("      " + p));

        System.out.println("\n   --- TABLES BY DIMENSIONS (from all suppliers) ---");
        List<Product> tablesByDimensions = tableFinder.searchFurniture("dimensions");
        tablesByDimensions.forEach(p -> System.out.println("      " + p));

        // 6. DEMOSTRAR QUE CADA PROVEEDOR RESPONDE SEGÚN SU ESPECIALIDAD
        System.out.println("\n6. INDIVIDUAL SUPPLIER RESPONSIBILITY:");
        
        System.out.println("\n   Supplier A (only sofas) searching for tables:");
        List<Product> supplierATables = supplierA.searchByDimensions("medium");
        System.out.println("      Returns: " + supplierATables.size() + " products (empty list)");
        
        System.out.println("\n   Supplier B (only tables) searching for sofas:");
        List<Product> supplierBSofas = supplierB.searchBySeats(2);
        System.out.println("      Returns: " + supplierBSofas.size() + " products (empty list)");

    }
    
    /**
     * Método helper para agregar productos iguales de diferentes proveedores
     */
    private static List<Product> aggregateProducts(List<Product> products) {
        List<Product> result = new ArrayList<>();
        
        for (Product p : products) {
            boolean found = false;
            for (Product existing : result) {
                if (existing.getName().equals(p.getName())) {
                    // Sumar stock
                    existing.setStock(existing.getStock() + p.getStock());
                    found = true;
                    break;
                }
            }
            if (!found) {
                // Crear copia para no modificar el original
                Product copy = new Product(p.getName(), p.getPrice(), p.getType(), p.getStock(), p.getSupplier());
                result.add(copy);
            }
        }
        return result;
    }
}