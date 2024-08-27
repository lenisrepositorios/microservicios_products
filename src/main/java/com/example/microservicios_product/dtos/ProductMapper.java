package com.example.microservicios_product.dtos;

import com.example.microservicios_product.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);

    Product saveDtoToEntity(ProductToSaveDto productToSaveDto);
}
