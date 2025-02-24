package com.questk2.warehouse;
import java.util.*;

public class TestMain {
    public static void main(String[] args) {
        // Create a map to store product inventory by product ID
        Map<Integer, List<Product>> stocklevel = new HashMap<>();

        // Create and add products for each product ID
        List<Product> product1 = new ArrayList<>();
        product1.add(new Product("Apple", 10));
        product1.add(new Product("Samsung", 7));

        List<Product> product2 = new ArrayList<>();
        product2.add(new Product("Redmi", 0));
        product2.add(new Product("Realme", 4));

        List<Product> product3 = new ArrayList<>();
        product3.add(new Product("Vivo", 3));
        product3.add(new Product("Oppo", 8));

        // Put the lists of products 
        stocklevel.put(001, product1);
        stocklevel.put(002, product2);
        stocklevel.put(003, product3);

        // Iterator to remove products with stock count of 0
        Iterator<Map.Entry<Integer, List<Product>>> iterator = stocklevel.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<Product>> entry = iterator.next();
            List<Product> productList = entry.getValue();
            
            Iterator<Product> productIterator = productList.iterator();
            while (productIterator.hasNext()) {
                Product product = productIterator.next();
                if (product.getStock() == 0) {
                    productIterator.remove(); 
                }
            }

            // Remove entry from map if product list is empty
            if (productList.isEmpty()) {
                iterator.remove();
            }
        }

        printStock(stocklevel);
    }

    /**
     * @param stocklevel The map that contains product IDs as keys and lists of products as values.
     * @return printStock This method prints the stock information to the console.
     */
    public static void printStock(Map<Integer, List<Product>> stocklevel) {       
        for (Map.Entry<Integer, List<Product>> entry : stocklevel.entrySet()) {
            System.out.println("Product ID: " + entry.getKey());
            List<Product> productList = entry.getValue();
            for (Product product : productList) {
                System.out.println("  " + product);
            }
        }
    }
}
