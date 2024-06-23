package com.example.onlinestore.service;

import com.example.onlinestore.Entity.Bucket;
import com.example.onlinestore.Entity.User;
import com.example.onlinestore.dto.BucketDTO;
import com.example.onlinestore.repository.BucketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BucketServiceImpl implements BucketService{

    private BucketRepository bucketRepository;
    private UserServiceImpl userService;

    @Autowired
    public BucketServiceImpl(BucketRepository bucketRepository, UserServiceImpl userService) {
        this.bucketRepository = bucketRepository;
        this.userService = userService;
    }

    @Override
    public Bucket createBucket(User user, List<Long> productIds) {
        Bucket bucket = new Bucket();
        return null;
    }

    @Override
    public void addProducts(Bucket bucket, List<Long> productIds) {

    }

    @Override
    public BucketDTO getBucketByUser(String name) {
        return null;
    }

    @Override
    public void commitBucketToOrder(String username) {

    }
}
