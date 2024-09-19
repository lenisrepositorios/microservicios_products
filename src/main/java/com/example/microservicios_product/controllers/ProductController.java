package com.example.microservicios_product.controllers;

import com.example.microservicios_product.dtos.ProductDto;
import com.example.microservicios_product.dtos.ProductToSaveDto;
import com.example.microservicios_product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductToSaveDto productToSaveDto) {
        ProductDto savedProduct = productService.saveProduct(productToSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        ProductDto productDto = productService.getProductbyID(id);
        return ResponseEntity.ok(productDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProductById(@PathVariable Long id, @RequestBody ProductToSaveDto productToSaveDto) {
        ProductDto updatedProduct = productService.updateProductbyID(id, productToSaveDto);
        return ResponseEntity.ok(updatedProduct);
    }

    // Endpoint para eliminar un producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        productService.deleteProductbyID(id);
        return ResponseEntity.noContent().build();
    }


}
