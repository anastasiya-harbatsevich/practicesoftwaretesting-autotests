package com.practicesoftwaretesting.cart;

import com.practicesoftwaretesting.cart.model.AddCartItemRequest;
import com.practicesoftwaretesting.cart.model.AddCartItemResponse;
import com.practicesoftwaretesting.cart.model.CartItemsInfoResponse;
import com.practicesoftwaretesting.cart.model.CreateCartResponse;
import com.practicesoftwaretesting.common.BaseController;
import com.practicesoftwaretesting.common.ResponseDecorator;

public class CartController extends BaseController {

    public ResponseDecorator<CreateCartResponse> createCart() {
        return new ResponseDecorator<>(
                baseController().post("/carts"),
                CreateCartResponse.class
        );
    }

    public ResponseDecorator<AddCartItemResponse> addItemToCart(String cartId, AddCartItemRequest cartItem) {
        return new ResponseDecorator<>(
                baseController()
                        .body(cartItem)
                        .post("/carts/" + cartId),
                AddCartItemResponse.class
        );
    }

    public ResponseDecorator<CartItemsInfoResponse> retrieveSpecificCart(String cartId) {
        return new ResponseDecorator<>(
                baseController()
                        .get("/carts/" + cartId),
                CartItemsInfoResponse.class
        );
    }

    public ResponseDecorator<Void> deleteCart(String cartId) {
        return new ResponseDecorator<>(
                baseController()
                        .delete("/carts/" + cartId),
                Void.class
        );
    }
}
