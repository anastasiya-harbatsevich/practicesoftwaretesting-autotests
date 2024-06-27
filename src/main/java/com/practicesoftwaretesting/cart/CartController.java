package com.practicesoftwaretesting.cart;

import com.practicesoftwaretesting.cart.model.AddCartItemRequest;
import com.practicesoftwaretesting.common.BaseController;
import io.restassured.response.Response;

public class CartController extends BaseController {

    public Response createCart() {
        return baseController()
                .post("/carts");
    }

    public Response addItemToCart(String cartId, AddCartItemRequest cartItem) {
        return baseController()
                .body(cartItem)
                .post("/carts/" + cartId);
    }

    public Response retrieveSpecificCart(String cartId) {
        return baseController()
                .get("/carts/" + cartId);
    }

    public Response deleteCart(String cartId) {
        return baseController()
                .delete("/carts/" + cartId);
    }
}
