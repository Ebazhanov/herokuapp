package pages;

import com.codeborne.selenide.Condition;

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

    public LoginPage verifyFlashMessageText(String messageText) {
        $("#flash").shouldHave(Condition.text(messageText)).isDisplayed();
        return this;
    }

}
