package com.practicesoftwaretesting.user;

import com.github.javafaker.Faker;
import com.practicesoftwaretesting.user.model.LoginUserRequest;
import com.practicesoftwaretesting.user.model.LoginUserResponse;
import com.practicesoftwaretesting.user.model.RegisterUserRequest;
import com.practicesoftwaretesting.user.model.RegisterUserResponse;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class UserTest extends BaseTest {

    private String userEmail;
    public static final String USER_PASSWORD = "sSuper-secret22";

    UserController userController = new UserController();

    @Test
    public void testUser() {
        userEmail = getUserEmail();
        //Register user
        var registerUserRequest = buildUser();
        var registerUserResponse = userController
                .registerUser(registerUserRequest)
                .as(RegisterUserResponse.class);
        assertNotNull(registerUserResponse.getId());

        //Login
        var loginUserRequest = new LoginUserRequest(userEmail, USER_PASSWORD);
        var loginUserResponse = userController
                .logInUser(loginUserRequest)
                .as(LoginUserResponse.class);
        assertNotNull(loginUserResponse.getAccessToken());

        //Login as admin
        var loginAdminRequest = new LoginUserRequest("admin@practicesoftwaretesting.com", "welcome01");
        var loginAdminResponse = userController
                .logInUser(loginAdminRequest)
                .as(LoginUserResponse.class);

        //Delete
        var userId = registerUserResponse.getId();
        var token = loginAdminResponse.getAccessToken();
        userController.deleteUser(userId, token)
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

    private String getUserEmail() {
        return Faker.instance()
                .friends()
                .character()
                .toLowerCase()
                .replaceAll(" ", "") + "@gmail.com";
    }
}
