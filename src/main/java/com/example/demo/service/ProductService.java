package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Cart;
import com.example.demo.domain.CartDetail;
import com.example.demo.domain.Product;
import com.example.demo.domain.User;
import com.example.demo.repository.CartDetailRepository;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;

    private final UserService userService;
    public ProductService(ProductRepository productRepository, 
    CartDetailRepository cartDetailRepository, 
    CartRepository cartRepository, 
    UserService userService) {
        this.productRepository = productRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.cartRepository = cartRepository;
        this.userService = userService;
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

    public void handleAddProductToCart(String email, Long productId) {
        User user = this.userService.getUserByEmail(email);
        if(user != null) {
            Cart cart = this.cartRepository.findByUser(user);

            if(cart == null) {
                // tao moi cart
                Cart otherCart = new Cart();
                otherCart.setUser(user);
                otherCart.setSum(1);
                this.cartRepository.save(otherCart);
            }

            // sava cartdetail
            // tim Product by id

            Optional<Product> p =  this.productRepository.findById(productId);
            if(p.isPresent()) {
                Product realProduct = p.get();
                CartDetail cd = new CartDetail();
                cd.setCart(cart);
                cd.setProduct(realProduct);
                cd.setPrice(realProduct.getPrice());
                cd.setQuantity(1);
            this.cartDetailRepository.save(cd);
            }
            
        }
    }
}
