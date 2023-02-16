package com.springstarter.webrest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springstarter.webrest.models.Product;
import com.springstarter.webrest.models.ResponseObject;
import com.springstarter.webrest.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Products")
public class ProductController {
    // DI: Dependency Injecttion
    @Autowired
    private ProductRepository repository;

    @GetMapping()
    public ResponseEntity<ResponseObject> getAllProducts() {
        List<Product> products = repository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Successfully", products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findProductById(@PathVariable Long id) {
        Optional<Product> product = repository.findById(id);

        if (product.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query product successfully", product));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("false", "Cannot find product with id = " + id, ""));

    }

    @PostMapping()
    public ResponseEntity<ResponseObject> createProduct(@RequestBody Product newProduct) {
        List<Product> products = repository.findByProductName(newProduct.getProductName().trim());

        if (products.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Product name already taken", ""));
        }

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Create new product successfully", repository.save(newProduct)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        Product updatedProduct = repository.findById(id)
                .map(product -> {
                    product.setProductName(newProduct.getProductName());
                    product.setYear(newProduct.getYear());
                    product.setPrice(newProduct.getPrice());

                    return repository.save(product);
                }).orElseGet(() -> {
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update product successfully", repository.save(updatedProduct)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id) {
        boolean isExist = repository.existsById(id);

        if (isExist) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete product successfully", ""));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("false", "Cannot find product with id = " + id, ""));

    }

}
