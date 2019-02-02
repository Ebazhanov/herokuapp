package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    @Step
    public LoginPage enterUserName(String loginName) {
        $("#username").setValue(loginName);
        return this;
    }

    @Step
    public LoginPage enterPassword(String password) {
        $("#password").setValue(password);
        return this;
    }

    @Step
    public LoginPage clickOnSubmitButton() {
        $("[class*='sign-in'").click();
        return this;
    }

    @Step
    public LoginPage verifyFlashMessageText(String messageText) {
        $("#flash").shouldHave(text(messageText));
        return this;
    }

    @Step
    public LoginPage openLoginPage(String url) {
        open(url);
        return this;
    }

}
