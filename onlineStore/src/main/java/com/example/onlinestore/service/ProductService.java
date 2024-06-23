package com.example.onlinestore.service;

import com.example.onlinestore.dto.ProductDTO;
import com.example.onlinestore.repository.ProductRepository;

import java.util.List;

public interface ProductService{
    List<ProductDTO> getAllProduct();
    void addToUserBucket(Long productId, String username);
    void addProduct(ProductDTO productDTO);
    ProductDTO getById(Long id);
}
