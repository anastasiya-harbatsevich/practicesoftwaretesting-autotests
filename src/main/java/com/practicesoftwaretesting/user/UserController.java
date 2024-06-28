package com.practicesoftwaretesting.user;

import com.practicesoftwaretesting.common.BaseController;
import com.practicesoftwaretesting.common.ResponseDecorator;
import com.practicesoftwaretesting.user.model.LoginUserRequest;
import com.practicesoftwaretesting.user.model.LoginUserResponse;
import com.practicesoftwaretesting.user.model.RegisterUserRequest;
import com.practicesoftwaretesting.user.model.RegisterUserResponse;

public class UserController extends BaseController {

    public ResponseDecorator<RegisterUserResponse> registerUser(RegisterUserRequest registerUserRequest) {
        return new ResponseDecorator<>(
                baseController()
                        .body(registerUserRequest)
                        .post("/users/register"),
                RegisterUserResponse.class
        );
    }

    public ResponseDecorator<LoginUserResponse> logInUser(LoginUserRequest loginUserRequest) {
        return new ResponseDecorator<>(
                baseController()
                        .body(loginUserRequest)
                        .post("/users/login"),
                LoginUserResponse.class
        );
    }

    public ResponseDecorator<Void> deleteUser(String userId, String token) {
        return new ResponseDecorator<>(
                baseController()
                        .header("Authorization", "Bearer" + token)
                        .delete("/users/" + userId),
                Void.class
        );
    }
}
