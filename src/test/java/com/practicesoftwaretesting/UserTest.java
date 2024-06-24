package com.practicesoftwaretesting;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.http.ContentType.JSON;
import static org.junit.Assert.assertNotNull;

public class UserTest {

    private String userEmail;
    public static final String USER_PASSWORD = "sSuper-secret22";

    static {
        configureRestAssured();
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.practicesoftwaretesting.com")
                .log(LogDetail.ALL)
                .build();
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }

    private static void configureRestAssured() {
        var objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        RestAssured.config = RestAssured.config()
                .objectMapperConfig(
                        RestAssured.config()
                                .getObjectMapperConfig()
                                .jackson2ObjectMapperFactory((cls, charset) -> objectMapper)
                );
    }

    @Test
    public void testUser() {
        userEmail = getUserEmail();
        //Register user
        var registerUserRequest = buildUser();
        var registerUserResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(registerUserRequest)
                .post("/users/register")
                .as(RegisterUserResponse.class);
        assertNotNull(registerUserResponse.getId());

        //Login
        var loginUserRequest = new LoginUserRequest(userEmail, USER_PASSWORD);
        var loginUserResponse = loginUser(loginUserRequest);
        assertNotNull(loginUserResponse.getAccessToken());

        //Login as admin
        var loginAdminRequest = new LoginUserRequest("admin@practicesoftwaretesting.com", "welcome01");
        var loginAdminResponse = loginUser(loginAdminRequest);

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

    private RegisterUserRequest buildUser() {
        return RegisterUserRequest.builder()
                .firstName("John")
                .lastName("Doe")
                .address("Street 1")
                .city("City")
                .state("State")
                .country("Country")
                .postcode("1234AA")
                .phone("0987654321")
                .dob("1970-01-01")
                .password(USER_PASSWORD)
                .email(userEmail)
                .build();
    }

    private static LoginUserResponse loginUser(LoginUserRequest loginUserRequest) {
        return RestAssured.given()
                .contentType(JSON)
                .body(loginUserRequest)
                .post("/users/login")
                .as(LoginUserResponse.class);
    }


    private String getUserEmail() {
        return Faker.instance()
                .friends()
                .character()
                .toLowerCase()
                .replaceAll(" ", "") + "@gmail.com";
    }
}
