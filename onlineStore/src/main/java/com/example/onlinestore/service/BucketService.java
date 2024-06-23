package com.example.onlinestore.service;

import com.example.onlinestore.Entity.Bucket;
import com.example.onlinestore.Entity.User;
import com.example.onlinestore.dto.BucketDTO;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productIds);
    void addProducts(Bucket bucket, List<Long> productIds);
    BucketDTO getBucketByUser(String name);

    void commitBucketToOrder(String username);
}
