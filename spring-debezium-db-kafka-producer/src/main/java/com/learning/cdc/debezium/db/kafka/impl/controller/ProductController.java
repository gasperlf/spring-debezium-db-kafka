package com.learning.cdc.debezium.db.kafka.impl.controller;

import com.learning.cdc.debezium.db.kafka.impl.api.ProductsApi;
import com.learning.cdc.debezium.db.kafka.impl.api.dtos.ProductRequest;
import com.learning.cdc.debezium.db.kafka.impl.api.dtos.ProductResponse;
import com.learning.cdc.debezium.db.kafka.impl.entity.Product;
import com.learning.cdc.debezium.db.kafka.impl.mapper.ProductResourceMapper;
import com.learning.cdc.debezium.db.kafka.impl.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController implements ProductsApi {

    private final ProductService productService;
    private final ProductResourceMapper productResourceMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(name = "id") Long id) {
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Override
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        Product product = productResourceMapper.mapAsProduct(productRequest);
        Product productResponse = productService.createProduct(product);
        ProductResponse response = productResourceMapper.mapAsProductResponse(productResponse);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(name = "id") Long id ,@RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }
}
