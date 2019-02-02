package base;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.ScreenshotOnFailure;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@Listeners(ScreenshotOnFailure.class)
public class BasicUiClass {

    @BeforeMethod(alwaysRun = true)
    public void setBrowser() {
        Selenide.open("http://the-internet.herokuapp.com/login");
        clearBrowserCache();
    }

    @AfterMethod(alwaysRun = true)
    void after() {
        clearBrowserCache();
        closeWebDriver();
    }

}
