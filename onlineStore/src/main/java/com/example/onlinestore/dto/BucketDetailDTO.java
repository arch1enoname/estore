package com.example.onlinestore.dto;

import com.example.onlinestore.Entity.Product;
import com.example.onlinestore.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BucketDetailDTO {
    private String title;
    private Long productId;
    private Double price;
    private Double amount;
    private Double sum;

    public BucketDetailDTO(Product product){
        this.title = product.getTitle();
        this.productId = product.getId();
        this.price = product.getPrice();
        this.amount = 1.0;
        this.sum = product.getPrice();
    }

}
