package com.practicesoftwaretesting.user.assertions;

import com.practicesoftwaretesting.user.model.RegisterUserResponse;
import lombok.AllArgsConstructor;

import static org.assertj.core.api.Assertions.assertThat;

@AllArgsConstructor
public class RegisterUserResponseAssertions {

    private RegisterUserResponse registerUserResponse;

    public RegisterUserResponseAssertions firstNameIs(String expectedName) {
        assertThat(registerUserResponse.getFirstName())
            .withFailMessage(
                String.format(
                    "first name should be %s but is %s",
                    expectedName,
                    registerUserResponse.getFirstName()
                )
            )
            .isEqualTo(expectedName);
        return this;
    }

    public RegisterUserResponseAssertions lastNameIs(String expectedName) {
        assertThat(registerUserResponse.getLastName())
            .withFailMessage(
                String.format(
                        "last name should be %s but is %s",
                        expectedName,
                        registerUserResponse.getLastName()
                )
            )
            .isEqualTo(expectedName);
        return this;
    }

    public RegisterUserResponseAssertions addressIs(String expectedAddress) {
        assertThat(registerUserResponse.getAddress())
            .withFailMessage(
                String.format(
                        "address should be %s but is %s",
                        expectedAddress,
                        registerUserResponse.getAddress()
                )
            )
            .isEqualTo(expectedAddress);
        return this;
    }

    public RegisterUserResponseAssertions cityIs(String expectedCity) {
        assertThat(registerUserResponse.getCity())
            .withFailMessage(
                String.format(
                        "city should be %s but is %s",
                        expectedCity,
                        registerUserResponse.getCity()
                )
            )
            .isEqualTo(expectedCity);
        return this;
    }

    public RegisterUserResponseAssertions stateIs(String expectedState) {
        assertThat(registerUserResponse.getState())
            .withFailMessage(
                String.format(
                        "state should be %s but is %s",
                        expectedState,
                        registerUserResponse.getState()
                )
            )
            .isEqualTo(expectedState);
        return this;
    }

    public RegisterUserResponseAssertions countryIs(String expectedCountry) {
        assertThat(registerUserResponse.getCountry())
            .withFailMessage(
                String.format(
                        "country should be %s but is %s",
                        expectedCountry,
                        registerUserResponse.getCountry()
                )
            )
            .isEqualTo(expectedCountry);
        return this;
    }

    public RegisterUserResponseAssertions postCodeIs(String expectedPostCode) {
        assertThat(registerUserResponse.getPostcode())
            .withFailMessage(
                String.format(
                        "post code should be %s but is %s",
                        expectedPostCode,
                        registerUserResponse.getPostcode()
                )
            )
            .isEqualTo(expectedPostCode);
        return this;
    }

    public RegisterUserResponseAssertions phoneIs(String expectedPhone) {
        assertThat(registerUserResponse.getPhone())
            .withFailMessage(
                String.format(
                        "phone should be %s but is %s",
                        expectedPhone,
                        registerUserResponse.getPhone()
                )
            )
            .isEqualTo(expectedPhone);
        return this;
    }

    public RegisterUserResponseAssertions dobIs(String expectedDob) {
        assertThat(registerUserResponse.getDob())
            .withFailMessage(
                String.format(
                        "dob should be %s but is %s",
                        expectedDob,
                        registerUserResponse.getDob()
                )
            )
            .isEqualTo(expectedDob);
        return this;
    }

    public RegisterUserResponseAssertions emailIs(String expectedEmail) {
        assertThat(registerUserResponse.getEmail())
            .withFailMessage(
                String.format(
                        "email should be %s but is %s",
                        expectedEmail,
                        registerUserResponse.getDob()
                )
            )
            .isEqualTo(expectedEmail);
        return this;
    }

    public RegisterUserResponseAssertions idIs(String expectedId) {
        assertThat(registerUserResponse.getId())
            .withFailMessage(
                String.format(
                        "id should be %s but is %s",
                        expectedId,
                        registerUserResponse.getId()
                )
            )
            .isEqualTo(expectedId);
        return this;
    }

    public RegisterUserResponseAssertions createdAtIs(String expectedCreatedAt) {
        assertThat(registerUserResponse.getCreatedAt())
            .withFailMessage(
                String.format(
                        "created at date should be %s but is %s",
                        expectedCreatedAt,
                        registerUserResponse.getId()
                )
            )
            .isEqualTo(expectedCreatedAt);
        return this;
    }
}
