package com.practicesoftwaretesting.cart.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product{

	private String name;
	private String description;
	private double price;
	private boolean isLocationOffer;
	private boolean isRental;
	private boolean inStock;
	private String id;
}