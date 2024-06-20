package com.practicesoftwaretesting;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.http.ContentType.JSON;

public class UserTest {

    static {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.practicesoftwaretesting.com")
                .log(LogDetail.ALL)
                .build();
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }

    @Test
    public void testUser() {
        //Register user
        var registerUserRequest = """
                {
                  "first_name": "John",
                  "last_name": "Doe",
                  "address": "Street 1",
                  "city": "City",
                  "state": "State",
                  "country": "Country",
                  "postcode": "1234AA",
                  "phone": "0987654321",
                  "dob": "1970-01-01",
                  "password": "sSuper-secret22",
                  "email": "john1234@doe.example"
                }
                """;

        var registerUserResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(registerUserRequest)
                .post("/users/register")
                .as(RegisterUserResponse.class);

        //Login
        var loginUserRequest = """
                {
                  "email": "john123@doe.example",
                  "password": "sSuper-secret22"
                }
                """;

        var loginUserResponse = RestAssured.given()
                .contentType(JSON)
                .body(loginUserRequest)
                .post("/users/login")
                .as(LoginUserResponse.class);

        //Login as admin
        var loginAdminRequest = """
                {
                  "email": "admin@practicesoftwaretesting.com",
                  "password": "welcome01"
                }
                """;

        var loginAdminResponse = RestAssured.given()
                .contentType(JSON)
                .body(loginAdminRequest)
                .post("/users/login")
                .as(LoginUserResponse.class);

        //Delete
        var userId = registerUserResponse.getId();
        var token = loginAdminResponse.getAccessToken();
        RestAssured.given()
                .contentType(JSON)
                .header("Authorization", "Bearer" + token)
                .delete("/users/" + userId)
                .then()
                .statusCode(204);
    }
}
