package com.example.onlinestore.service;

import com.example.onlinestore.Entity.Product;
import com.example.onlinestore.dto.ProductDTO;
import com.example.onlinestore.mapper.ProductMapper;
import com.example.onlinestore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductMapper mapper = ProductMapper.MAPPER;
    private final ProductRepository productRepository;

    private final BucketService bucketService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, BucketService bucketService) {
        this.productRepository = productRepository;
        this.bucketService = bucketService;
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        return mapper.fromProductList(productRepository.findAll());
    }

    @Override
    public void addToUserBucket(Long productId, String username) {

    }

    @Override
    public void addProduct(ProductDTO productDTO) {

    }

    @Override
    public ProductDTO getById(Long id) {
        return null;
    }
}
