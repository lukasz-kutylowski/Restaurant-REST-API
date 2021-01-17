package pl.lukaszkutylowski.barapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lukaszkutylowski.barapp.dao.ProductRepository;
import pl.lukaszkutylowski.barapp.model.Product;

@RestController
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/product")
    public ResponseEntity saveProduct(@RequestBody Product product) {
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/product/:id")
    public Product getProductById(@RequestParam Long id) {
        return productRepository.findById(id).get();
    }
}
