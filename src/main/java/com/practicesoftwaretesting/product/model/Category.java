package com.practicesoftwaretesting.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category{

	private String id;
	private String parentId;
	private String name;
	private String slug;
}