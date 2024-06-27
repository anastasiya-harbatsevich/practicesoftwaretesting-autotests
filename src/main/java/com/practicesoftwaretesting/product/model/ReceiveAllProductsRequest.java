package com.practicesoftwaretesting.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ReceiveAllProductsRequest {

    private String brand;
    private String category;
    private String isRental;
    private String between;
    private String sort;
    private int page;
}
