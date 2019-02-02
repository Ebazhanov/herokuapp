package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.ScreenshotOnFailure;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static utils.BrowserSelection.selectBrowser;

@Listeners(ScreenshotOnFailure.class)
public class BasicUiClass {

    @BeforeMethod(alwaysRun = true)
    public void setBrowser() {
        baseUrl = "http://the-internet.herokuapp.com";
        selectBrowser("Chrome");
        clearBrowserCache();
    }

    @AfterMethod(alwaysRun = true)
    void after() {
        clearBrowserCache();
        closeWebDriver();
    }

}
