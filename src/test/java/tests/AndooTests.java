package tests;

import base.BasicUiClass;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.LoginPage;

@Feature("Login functionality")
public class AndooTests extends BasicUiClass {

    @Test
    @Story("#1 Scenario Login Success")
    public void loginSuccess() {
        new LoginPage()
                .enterUserName("tomsmith")
                .enterPassword("SuperSecretPassword!")
                .clickOnSubmitButton()
                .verifyFlashMessageText("You logged into a secure area!");
    }

}
