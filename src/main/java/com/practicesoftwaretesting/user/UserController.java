package com.practicesoftwaretesting.user;

import com.practicesoftwaretesting.common.BaseController;
import com.practicesoftwaretesting.user.model.LoginUserRequest;
import com.practicesoftwaretesting.user.model.RegisterUserRequest;
import io.restassured.response.Response;

public class UserController extends BaseController {

    public Response registerUser(RegisterUserRequest registerUserRequest) {
        return baseController()
                .body(registerUserRequest)
                .post("/users/register");
    }

    public Response logInUser(LoginUserRequest loginUserRequest) {
        return baseController()
                .body(loginUserRequest)
                .post("/users/login");
    }

    public Response deleteUser(String userId, String token) {
        return baseController()
                .header("Authorization", "Bearer" + token)
                .delete("/users/" + userId);
    }
}
