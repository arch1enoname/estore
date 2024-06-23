package com.example.onlinestore.repository;

import com.example.onlinestore.Entity.Bucket;
import com.example.onlinestore.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketRepository extends JpaRepository<Bucket, Long> {
    Bucket findFirstByUser(User user);
}
