package com.example.microservicios_product.dtos;

public record ProductDto(Long id,
        String name,
        String description,
        double price,
        int stock) {
}
