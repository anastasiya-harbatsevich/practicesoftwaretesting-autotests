package com.practicesoftwaretesting.common;

import io.restassured.response.Response;

public class ResponseDecorator<T> {

    private Response targetResponse;
    private final Class<T> targetClass;

    public ResponseDecorator(Response targetResponse, Class<T> targetClass) {
        this.targetClass = targetClass;
        this.targetResponse = targetResponse;
    }

    public Response get() {
        return this.targetResponse;
    }

    public T as() {
        return targetResponse.as(targetClass);
    }

    public ResponseDecorator<T> assertStatusCode (int statusCode) {
        this.targetResponse.then().statusCode(statusCode);
        return this;
    }
}
