package com.practicesoftwaretesting.product;

import com.practicesoftwaretesting.common.BaseController;
import com.practicesoftwaretesting.product.model.ReceiveAllProductsRequest;
import io.restassured.response.Response;

public class ProductController extends BaseController {

    public Response receiveListProducts(ReceiveAllProductsRequest receiveAllProductsRequest) {
        return baseController()
                .body(receiveAllProductsRequest)
                .get("/products");
    }
}
