package com.practicesoftwaretesting.user;

import com.practicesoftwaretesting.user.assertions.LoginUserResponseAssertions;
import com.practicesoftwaretesting.user.assertions.RegisterUserResponseAssertions;
import com.practicesoftwaretesting.user.model.LoginUserRequest;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import static org.junit.Assert.assertNotNull;

public class UserTest extends BaseTest {

    private String userEmail;
    private String userId;

    UserController userController = new UserController();

    @Test
    public void testUser() {
        userEmail = getUserEmail();
        //Register user
        var expectedUser = buildUser(userEmail, DEFAULT_PASSWORD);
        var registerUserResponse = userController
                .registerUser(expectedUser)
                .assertStatusCode(201)
                .as();
        new RegisterUserResponseAssertions(registerUserResponse)
                .firstNameIs(expectedUser.getFirstName())
                .lastNameIs(expectedUser.getLastName())
                .addressIs(expectedUser.getAddress())
                .cityIs(expectedUser.getCity())
                .stateIs(expectedUser.getState())
                .countryIs(expectedUser.getCountry())
                .postCodeIs(expectedUser.getPostcode())
                .phoneIs(expectedUser.getPhone())
                .dobIs(expectedUser.getDob())
                .emailIs(expectedUser.getEmail())
                .idIs(registerUserResponse.getId())
                .createdAtIs(registerUserResponse.getCreatedAt());

        //Login
        var loginUserRequest = new LoginUserRequest(userEmail, DEFAULT_PASSWORD);
        var loginUserResponse = userController
                .logInUser(loginUserRequest)
                .assertStatusCode(200)
                .as();
        assertNotNull(loginUserResponse.getAccessToken());
        new LoginUserResponseAssertions(loginUserResponse)
                .isNotExpired()
                .accessTokenNotNull()
                .tokenTypeIs("bearer");
        userId = registerUserResponse.getId();
    }

    @AfterEach
    void deleteUser() {
        var token = loginAsAdmin();
        userController.deleteUser(userId, token)
                .assertStatusCode(204);
    }
}
