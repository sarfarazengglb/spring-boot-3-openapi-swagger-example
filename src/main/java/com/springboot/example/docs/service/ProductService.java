package com.springboot.example.docs.service;

import com.springboot.example.docs.vo.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    // Static list to simulate a database
    private static final List<Product> products = new ArrayList<>();

    static {
        // Realistic product data
        products.add(new Product(1L, "Apple iPhone 13", "Latest model with 128GB storage, 5G support, and improved camera.", 799.99));
        products.add(new Product(2L, "Samsung Galaxy S21", "Flagship Samsung phone with 120Hz display, 5G, and 256GB storage.", 699.99));
        products.add(new Product(3L, "Sony WH-1000XM4 Headphones", "Noise-cancelling wireless headphones with superior sound quality.", 349.99));
        products.add(new Product(4L, "Dell XPS 13 Laptop", "13-inch ultrabook with Intel i7 processor, 16GB RAM, and 512GB SSD.", 1299.99));
        products.add(new Product(5L, "Apple MacBook Pro", "16-inch MacBook Pro with M1 chip, 1TB SSD, and 16GB RAM.", 2399.99));
        products.add(new Product(6L, "Sony PlayStation 5", "Latest generation gaming console with 825GB SSD and 4K gaming support.", 499.99));
        products.add(new Product(7L, "Apple AirPods Pro", "Wireless earbuds with active noise cancellation and spatial audio.", 249.99));
        products.add(new Product(8L, "Nikon Z6 II Mirrorless Camera", "24.5MP full-frame mirrorless camera with 4K video support.", 1999.99));
        products.add(new Product(9L, "LG OLED65CXPUA TV", "65-inch 4K OLED TV with Dolby Vision, HDR10, and HDMI 2.1.", 1799.99));
        products.add(new Product(10L, "Microsoft Surface Pro 7", "2-in-1 tablet with 12.3-inch display, Intel i5, and 256GB SSD.", 899.99));
    }

    // Static method to retrieve all products
    public static List<Product> getAllProducts() {
        return products;
    }

    // Static method to retrieve a product by ID
    public static Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    // Static method to create a new product
    public static Product createProduct(Product product) {
        product.setId((long) (products.size() + 1)); // Simple ID generation
        products.add(product);
        return product;
    }

    // Static method to update an existing product
    public static Optional<Product> updateProduct(Long id, Product updatedProduct) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                product.setName(updatedProduct.getName());
                product.setDescription(updatedProduct.getDescription());
                product.setPrice(updatedProduct.getPrice());
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    // Static method to delete a product
    public static boolean deleteProduct(Long id) {
        return products.removeIf(product -> product.getId().equals(id));
    }
}
