package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product createProduct(Product product) {
        return this.productRepository.save(product);

    }
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }
    public Optional<Product> getProductById(Long id) {
        return this.productRepository.findById(id);
    }
    public void deleteProduct(long id) {
        this.productRepository.deleteById(id);
    }
}
