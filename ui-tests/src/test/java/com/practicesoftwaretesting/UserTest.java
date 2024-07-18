package com.practicesoftwaretesting;

import com.practicesoftwaretesting.pages.*;
import com.practicesoftwaretesting.user.model.RegisterUserRequest;
import org.junit.Test;

public class UserTest extends BaseTest {

    private static final String LAST_NAME = "Lindeman";

    HomePage homePage = new HomePage();
    Header header = new Header();
    LoginPage loginPage = new LoginPage();
    CustomerRegistrationPage customerRegistrationPage = new CustomerRegistrationPage();
    ContactPage contactPage = new ContactPage();
    AccountPage accountPage = new AccountPage();


    @Test
    public void registerNewUserAndLogin() {
        homePage.open()
                .isLoaded();
        header.clickSignInMenuItem();

        loginPage.isLoaded()
                .clickRegisterYourAccount();

        customerRegistrationPage.isLoaded()
                .assertThat()
                .hasCorrectInfo();

        var user = getUser();
        customerRegistrationPage.registerNewUser(user);

        loginPage.isLoaded()
                .login(user.getEmail(), user.getPassword());

        accountPage.isLoaded();
        header.assertThat().isSignedIn(user.getFirstName() + " " + user.getLastName());

        var users = searchUsers(LAST_NAME);
        users.getData().forEach(userToDelete -> deleteUser(userToDelete.getId()));
    }

    private RegisterUserRequest getUser() {
        return RegisterUserRequest.builder()
                .firstName("Denis")
                .lastName(LAST_NAME)
                .dob("12.12.2000")
                .address("12 aleja Jerozolimskich")
                .city("Bristol")
                .state("California")
                .country("Albania")
                .postcode("12345")
                .phone("12121212")
                .email("den@test.test")
                .password("sSuper-secret22")
                .build();
    }

    @Test
    public void contact() {
        homePage.open()
                .isLoaded();
        header.clickContactMenuItem();

        contactPage.isLoaded()
                .assertThat()
                .hasCorrectInfo();
    }
}