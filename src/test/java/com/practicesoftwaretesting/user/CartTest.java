package com.practicesoftwaretesting.user;

import com.practicesoftwaretesting.cart.CartController;
import com.practicesoftwaretesting.cart.model.*;
import com.practicesoftwaretesting.product.ProductController;
import com.practicesoftwaretesting.product.model.ReceiveAllProductsRequest;
import com.practicesoftwaretesting.product.model.ReceiveAllProductsResponse;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CartTest extends BaseTest{

    CartController cartController = new CartController();
    ProductController productController = new ProductController();

    @Test
    public void cartTest() {
        receiveProductId();
        var createdCart = cartController.createCart()
                .as(CreateCartResponse.class);
        assertNotNull(createdCart.getId());

        var cartId = createdCart.getId();
        var addItemToCartResponse = cartController.addItemToCart(cartId, new AddCartItemRequest(receiveProductId(), 1))
                .as(AddCartItemResponse.class);
        assertNotNull(addItemToCartResponse.getResult());

        var cartDetails = cartController.retrieveSpecificCart(cartId)
                .as(CartItemsInfoResponse.class);
        var productIds = cartDetails.getCartItems().stream().map(CartItem::getProductId).toList();
        assertTrue(productIds.contains(receiveProductId()));

        cartController.deleteCart(cartId)
                .then()
                .statusCode(204);
    }

    String receiveProductId() {
        var parameters = new ReceiveAllProductsRequest("", "", "", "", "", 0);
        var productList = productController.receiveListProducts(parameters)
                .as(ReceiveAllProductsResponse.class);
        return productList.getData().get(0).getId();
    }
}
