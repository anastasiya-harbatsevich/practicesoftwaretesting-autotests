package com.practicesoftwaretesting.user.assertions;

import com.practicesoftwaretesting.user.model.LoginUserResponse;
import lombok.AllArgsConstructor;

import static org.assertj.core.api.Assertions.assertThat;

@AllArgsConstructor
public class LoginUserResponseAssertions {

    private LoginUserResponse loginUserResponse;

    public LoginUserResponseAssertions accessTokenNotNull() {
        assertThat(loginUserResponse.getAccessToken())
                .withFailMessage("access Token Is Null")
                .isNotNull();
        return this;
    }

    public LoginUserResponseAssertions tokenTypeIs(String expectedTokenType) {
        assertThat(loginUserResponse.getTokenType())
                .withFailMessage(
                        "token type should be %s, but was %s",
                        expectedTokenType,
                        loginUserResponse.getTokenType()
                )
                .isEqualTo(expectedTokenType);
        return this;
    }

    public LoginUserResponseAssertions isNotExpired() {
        assertThat(loginUserResponse.getExpiresIn())
                .withFailMessage("expires in should be greater than 0")
                .isGreaterThan(0);
        return this;
    }
}
