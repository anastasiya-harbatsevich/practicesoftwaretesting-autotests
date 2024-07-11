package com.practicesoftwaretesting.pages;

import com.codeborne.selenide.Selenide;
import com.practicesoftwaretesting.asserts.RegisterPageAsserts;
import com.practicesoftwaretesting.user.model.RegisterUserRequest;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.practicesoftwaretesting.utils.SelectorUtils.*;

public class CustomerRegistrationPage {

    protected static final By FIRST_NAME_LABEL = byFor("first_name");
    protected static final By FIRST_NAME_INPUT = byId("first_name");
    protected static final By LAST_NAME_LABEL = byFor("last_name");
    protected static final By LAST_NAME_INPUT = byId("last_name");
    protected static final By DOB_LABEL = byFor("dob");
    protected static final By DOB_INPUT = byId("dob");
    protected static final By ADDRESS_LABEL = byFor("address");
    protected static final By ADDRESS_INPUT = byId("address");
    protected static final By POSTCODE_LABEL = byFor("postcode");
    protected static final By POSTCODE_INPUT = byId("postcode");
    protected static final By CITY_LABEL = byFor("city");
    protected static final By CITY_INPUT = byId("city");
    protected static final By STATE_LABEL = byFor("state");
    protected static final By STATE_INPUT = byId("state");
    protected static final By COUNTRY_LABEL = byFor("country");
    protected static final By COUNTRY_INPUT = byId("country");
    protected static final By PHONE_LABEL = byFor("phone");
    protected static final By PHONE_INPUT = byId("phone");
    protected static final By EMAIL_LABEL = byFor("email");
    protected static final By EMAIL_INPUT = byId("email");
    protected static final By PASSWORD_LABEL = byFor("password");
    protected static final By PASSWORD_INPUT = byId("password");
    public static final String REGISTER_BUTTON = "register-submit";

    public CustomerRegistrationPage isLoaded() {
        $("h3").shouldHave(text("Customer registration"));
        return this;
    }

    public RegisterPageAsserts assertThat() {
        return new RegisterPageAsserts();
    }

    public void registerNewUser(RegisterUserRequest user) {
        $(FIRST_NAME_INPUT).setValue(user.getFirstName());
        $(LAST_NAME_INPUT).setValue(user.getLastName());
        $(DOB_INPUT).setValue(user.getDob());
        $(ADDRESS_INPUT).setValue(user.getAddress());
        $(CITY_INPUT).setValue(user.getCity());
        $(STATE_INPUT).setValue(user.getState());
        $(COUNTRY_INPUT).selectOption(user.getCountry());
        $(POSTCODE_INPUT).setValue(user.getPostcode());
        $(PHONE_INPUT).setValue(user.getPhone());
        $(EMAIL_INPUT).setValue(user.getEmail());
        $(PASSWORD_INPUT).setValue(user.getPassword());
        $(byDataTest(REGISTER_BUTTON)).click();
    }

    public CustomerRegistrationPage open() {
        Selenide.open("/contact");
        return this;
    }
}
