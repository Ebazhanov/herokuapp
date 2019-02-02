package pages;

import org.testng.annotations.DataProvider;

public class DataProviderStorage {

    @DataProvider(name = "loginVerification")
    public static Object[][] loginVerification() {
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!", "You logged into a secure area!"},
                {"Invalid", "SuperSecretPassword!", "Your username is invalid!"},
                {"tomsmith", "InvalidPassword!", "Your password is invalid!"}
        };
    }

    @DataProvider(name = "avatarHover")
    public static Object[][] avatarHover() {
        return new Object[][]{
                {"3", "name: user1\nView profile"},
                {"4", "name: user2\nView profile"},
                {"5", "name: user3\nView profile"}
        };
    }

}
