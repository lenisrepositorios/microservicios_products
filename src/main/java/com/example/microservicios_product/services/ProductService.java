package com.example.microservicios_product.services;

import com.example.microservicios_product.dtos.ProductDto;
import com.example.microservicios_product.dtos.ProductToSaveDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductService {
    ProductDto saveProduct(ProductToSaveDto productToSaveDto);

    ProductDto getProductbyID(Long id);

    ProductDto updateProductbyID(Long id, ProductToSaveDto product);

    void deleteProductbyID(Long id);
}
