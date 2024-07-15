package com.practicesoftwaretesting.asserts;

import com.practicesoftwaretesting.pages.ContactPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ContactPageAsserts extends ContactPage {

    public ContactPageAsserts hasCorrectInfo() {
        $(FIRST_NAME_LABEL).shouldHave(text("First name"));
        $(FIRST_NAME_INPUT).shouldHave(attribute("placeholder", "Your first name *"));

        $(LAST_NAME_LABEL).shouldHave(text("Last Name"));
        $(LAST_NAME_INPUT).shouldHave(attribute("placeholder", "Your last name *"));

        $(EMAIL_LABEL).shouldHave(text("Email address"));
        $(EMAIL_INPUT).shouldHave(attribute("placeholder", "Your email *"));

        $(SUBJECT_LABEL).shouldHave(text("Subject"));
        $(SUBJECT_INPUT).shouldHave(tagName("select"));
        $(SUBJECT_INPUT).findAll("option")
                .filter(text("Select a subject *"))
                .shouldHave(size(1))
                .get(0)
                .shouldBe(selected);

        $(MESSAGE_LABEL).shouldHave(text("Message *"));
        $(MESSAGE_INPUT).shouldHave(tagName("textarea"));

        $(ATTACHMENT_LABEL).shouldHave(text("Attachment"));
        $(ATTACHMENT_INPUT).shouldHave(attribute("type", "file"));

        return this;
    }
}
