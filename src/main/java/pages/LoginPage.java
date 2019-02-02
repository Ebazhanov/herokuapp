package pages;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public LoginPage enterUserName(String loginName) {
        $("#username").setValue(loginName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $("#password").setValue(password);
        return this;
    }

    public LoginPage clickOnSubmitButton() {
        $("[class*='sign-in'").click();
        return this;
    }

    public LoginPage verifySuccessFlashMessageText(String messageText) {
        $(".flash.success").shouldHave(text(messageText));
        return this;
    }

    public LoginPage verifyErrorFlashMessageText(String messageText) {
        $(".flash.error").shouldHave(text(messageText));
        return this;
    }

}
