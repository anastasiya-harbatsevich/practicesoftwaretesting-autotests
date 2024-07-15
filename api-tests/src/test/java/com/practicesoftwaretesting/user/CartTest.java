package com.practicesoftwaretesting.user;

import com.practicesoftwaretesting.cart.CartController;
import com.practicesoftwaretesting.cart.model.*;
import com.practicesoftwaretesting.product.ProductController;
import com.practicesoftwaretesting.product.model.ReceiveAllProductsRequest;
import com.practicesoftwaretesting.product.model.ReceiveAllProductsResponse;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CartTest extends BaseTest {

    private String authToken;

    CartController cartController = new CartController();
    ProductController productController = new ProductController();

    @BeforeEach
    void beforeEach() {
        authToken = registerAndLoginUser();
    }

    @Test
    public void cartTest() {
        receiveProductId();
        var createdCart = cartController.createCart()
                .assertStatusCode(201)
                .as();
        assertNotNull(createdCart.getId());

        var cartId = createdCart.getId();
        var addItemToCartResponse = cartController.addItemToCart(cartId, new AddCartItemRequest(receiveProductId(), 1))
                .assertStatusCode(200)
                .as();
        assertNotNull(addItemToCartResponse.getResult());

        var cartDetails = cartController.retrieveSpecificCart(cartId)
                .assertStatusCode(200)
                .as();
        var productIds = cartDetails.getCartItems().stream().map(CartItem::getProductId).toList();
        assertTrue(productIds.contains(receiveProductId()));

        cartController.deleteCart(cartId)
                .assertStatusCode(204);
    }

    String receiveProductId() {
        var parameters = new ReceiveAllProductsRequest("", "", "", "", "", 0);
        var productList = productController.receiveListProducts(parameters)
                .as(ReceiveAllProductsResponse.class);
        return productList.getData().get(0).getId();
    }
}
