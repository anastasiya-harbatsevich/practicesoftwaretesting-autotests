package com.practicesoftwaretesting.user;

import com.practicesoftwaretesting.user.model.RegisterUserRequest;

import static com.practicesoftwaretesting.user.UserSteps.EMAIL_ADMIN;
import static com.practicesoftwaretesting.user.UserSteps.PASSWORD_ADMIN;

abstract class BaseTest {

    UserSteps userSteps = new UserSteps();

    public void registerUser(String userEmail, String userPassword) {
       userSteps.registerUser(userEmail, userPassword);
    }

    public String loginUser(String userEmail, String userPassword) {
        return userSteps.loginUser(userEmail, userPassword);
    }

    public String loginAsAdmin() {
        return loginUser(EMAIL_ADMIN, PASSWORD_ADMIN);
    }

    public String registerAndLoginUser() {
        return userSteps.registerAndLoginUser();
    }

    public RegisterUserRequest buildUser(String email, String password) {
        return userSteps.buildUser(email, password);
    }

    public String getUserEmail() {
        return userSteps.getUserEmail();
    }
}
