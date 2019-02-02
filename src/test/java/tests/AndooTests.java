package tests;

import base.BasicUiClass;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Feature("Login functionality")
public class AndooTests extends BasicUiClass {

    @Test
    @Story("#1 Scenario Login Success")
    public void loginSuccess() {
        new LoginPage()
                .enterUserName("tomsmith")
                .enterPassword("SuperSecretPassword!")
                .clickOnSubmitButton()
                .verifySuccessFlashMessageText("You logged into a secure area!");
    }

    @Test
    @Story("#2 scenario Login failure 2")
    public void loginInvalid1() {
        new LoginPage()
                .enterUserName("invalidsmith")
                .enterPassword("SuperSecretPassword!")
                .clickOnSubmitButton()
                .verifyErrorFlashMessageText("Your username is invalid!");
    }

    @Test
    @Story("#3 scenario Login failure 3")
    public void loginInvalid2() {
        new LoginPage()
                .enterUserName("tomsmith")
                .enterPassword("InvalidPassword!")
                .clickOnSubmitButton()
                .verifyErrorFlashMessageText("Your password is invalid!");
    }

    @Test
    @Story("#4 scenario Hovers")
    public void hover() {
        Selenide.open("http://the-internet.herokuapp.com/hovers");
/*
        $("div:nth-child(3) > img").hover();
        $(".figcaption").#content > div > div:nth-child(4) > imgshouldHave(Condition.text("name: user1\nView profile"));
*/

/*
        $("div:nth-child(4) > img").hover();
        $(".figcaption").waitUntil(Condition.visible, 1000).shouldHave(Condition.text("name: user2\nView profile"));
*/

        $("div:nth-child(5) > img").hover();
        $(".figcaption").shouldHave(Condition.text("name: user3\nView profile"));
    }

    @Test
    @Story("#5 scenario sortable data table")
    public void sortableDataTable() {
        Selenide.open("http://the-internet.herokuapp.com/tables");
        ArrayList firstNameColumnData = (ArrayList) $$("#table2 > tbody .first-name").texts();
        
    }


}
