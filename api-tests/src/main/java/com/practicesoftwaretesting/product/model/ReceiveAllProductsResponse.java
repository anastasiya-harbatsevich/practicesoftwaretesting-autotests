package com.practicesoftwaretesting.product.model;

import java.util.List;

import lombok.Data;

@Data
public class ReceiveAllProductsResponse {

    private int currentPage;
    private int from;
    private int lastPage;
    private int perPage;
    private int to;
    private int total;
    private List<Product> data;
}