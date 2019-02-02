package utils;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;

public class BrowserSelection {

    public static void selectBrowser(String browser) {
        if (browser.equals("Chrome")) {
            Configuration.browser = "Chrome";
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        } else if (browser.equals("firefox")) {
            Configuration.browser = "Firefox";
            ChromeDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        } else {
            throw new IllegalStateException("Browser " + browser + " not supported in tests");
        }
    }

}
