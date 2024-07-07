package com.practicesoftwaretesting;

import com.practicesoftwaretesting.pages.CustomerRegistrationPage;
import com.practicesoftwaretesting.pages.Header;
import com.practicesoftwaretesting.pages.HomePage;
import com.practicesoftwaretesting.pages.LoginPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class UserTest {

    HomePage homePage = new HomePage();
    Header header = new Header();
    LoginPage loginPage = new LoginPage();
    CustomerRegistrationPage customerRegistrationPage = new CustomerRegistrationPage();

    @Test
    public void registerNewUserAndLogin() {
        open("https://practicesoftwaretesting.com/#/");
        homePage.isLoaded();
        header.clickSignInMenuItem();

        loginPage.isLoaded()
                .clickRegisterYourAccount();

        customerRegistrationPage.isLoaded()
                .assertThat()
                .hasCorrectInfo();
    }
}
