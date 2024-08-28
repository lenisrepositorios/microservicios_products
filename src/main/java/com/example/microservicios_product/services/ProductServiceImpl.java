package com.example.microservicios_product.services;

import com.example.microservicios_product.dtos.ProductDto;
import com.example.microservicios_product.dtos.ProductMapper;
import com.example.microservicios_product.dtos.ProductToSaveDto;
import com.example.microservicios_product.models.Product;
import com.example.microservicios_product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto saveProduct(ProductToSaveDto productToSaveDto){
        Product product = productMapper.saveDtoToEntity(productToSaveDto);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public ProductDto getProductbyID(Long id){
        Product product = productRepository.findById(id).orElseThrow();
        return productMapper.toDto(product);
    }

    @Override
    public ProductDto updateProductbyID(Long id, ProductToSaveDto product){
        return productRepository.findById(id).map(product1 ->{
            product1.setName(product.name());
            Product savedProduct = productRepository.save(product1);
            return productMapper.toDto(savedProduct);
        }).orElseThrow();
    }

    @Override
    public void deleteProductbyID(Long id){
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
    }

}
