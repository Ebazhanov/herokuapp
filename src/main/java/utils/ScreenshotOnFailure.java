package utils;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;

public class ScreenshotOnFailure extends TestListenerAdapter {

    @Attachment(value = "Screenshot on Failed step", type = "image/png")
    static byte[] attachBrowserScreenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return Files.toByteArray(screenshot);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            attachBrowserScreenshot();
            onTestSuccess(iTestResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
