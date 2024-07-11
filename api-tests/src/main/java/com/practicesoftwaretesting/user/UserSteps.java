package com.practicesoftwaretesting.user;

import com.github.javafaker.Faker;
import com.practicesoftwaretesting.user.model.LoginUserRequest;
import com.practicesoftwaretesting.user.model.RegisterUserRequest;

public class UserSteps {

    public static final String DEFAULT_PASSWORD = "sSuper-secret22";
    public static final String EMAIL_ADMIN = "admin@practicesoftwaretesting.com";
    public static final String PASSWORD_ADMIN = "welcome01";

    public void registerUser(String userEmail, String userPassword) {
        var userController = new UserController();
        var registerUserRequest = buildUser(userEmail, userPassword);
        userController.registerUser(registerUserRequest).as();
    }

    public String loginUser(String userEmail, String userPassword) {
        var userController = new UserController();
        var userLoginResponse = userController.logInUser(new LoginUserRequest(userEmail, userPassword)).as();
        return userLoginResponse.getAccessToken();
    }

    public String registerAndLoginUser() {
        var userEmail = getUserEmail();
        registerUser(userEmail, DEFAULT_PASSWORD);
        return loginUser(userEmail, DEFAULT_PASSWORD);
    }

    public String loginAsAdmin() {
        return loginUser(EMAIL_ADMIN, PASSWORD_ADMIN);
    }

    public RegisterUserRequest buildUser(String email, String password) {
        return RegisterUserRequest.builder()
                .firstName("John")
                .lastName("Doe")
                .address("Street 1")
                .city("City").state("State")
                .country("Country")
                .postcode("1234AA")
                .phone("0987654321")
                .dob("1970-01-01")
                .password(password)
                .email(email)
                .build();
    }

    public String getUserEmail() {
        return Faker.instance()
                .friends()
                .character()
                .toLowerCase()
                .replaceAll(" ", "") + "@gmail.com";
    }
}
