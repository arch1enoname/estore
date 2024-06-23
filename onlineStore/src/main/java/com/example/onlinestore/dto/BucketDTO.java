package com.example.onlinestore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BucketDTO {
    private Long amountProducts;
    private Double sum;
    private List<BucketDetailDTO> bucketDetailDTOList = new ArrayList<>();
}
