package com.practicesoftwaretesting.cart.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartItemsInfoResponse{

	private String id;
	private Object additionalDiscountPercentage;
	private Object lat;
	private Object lng;
	private List<CartItem> cartItems;
}