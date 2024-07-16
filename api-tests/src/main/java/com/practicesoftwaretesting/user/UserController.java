package com.practicesoftwaretesting.user;

import com.practicesoftwaretesting.common.BaseController;
import com.practicesoftwaretesting.common.ResponseDecorator;
import com.practicesoftwaretesting.user.model.*;

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

    public ResponseDecorator<UserSearch> searchUser(String queryPhrase, String token) {
        return new ResponseDecorator<>(
                baseController()
                        .header("Authorization", "Bearer" + token)
                        .get("/users/search?q=" + queryPhrase),
                UserSearch.class
        );
    }
}
