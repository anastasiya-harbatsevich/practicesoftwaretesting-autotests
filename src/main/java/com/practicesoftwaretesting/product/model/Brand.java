package com.practicesoftwaretesting.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    private String id;
    private String name;
    private String slug;
}