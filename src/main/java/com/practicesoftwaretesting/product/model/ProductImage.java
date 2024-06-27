package com.practicesoftwaretesting.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {

    private String byName;
    private String byUrl;
    private String sourceName;
    private String sourceUrl;
    private String fileName;
    private String title;
    private String id;
}