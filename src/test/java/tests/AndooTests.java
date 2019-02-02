package tests;

import base.BasicUiClass;
import edu.emory.mathcs.backport.java.util.Collections;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.AvatarPage;
import pages.DataProviderStorage;
import pages.LoginPage;
import pages.TablePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static pages.TablePage.TABLE_2_FIRST_NAME_COLUMN;

@Feature("All test scenarios")
public class AndooTests extends BasicUiClass {

    @Test(dataProvider = "loginVerification", dataProviderClass = DataProviderStorage.class)
    @Story("#1,2,3 Scenario Login Success & Failure")
    public void loginSuccess(String loginName, String password, String flashMessage) {
        new LoginPage()
                .openLoginPage("/login")
                .enterUserName(loginName)
                .enterPassword(password)
                .clickOnSubmitButton()
                .verifyFlashMessageText(flashMessage);
    }

    @Test(dataProvider = "avatarHover", dataProviderClass = DataProviderStorage.class)
    @Story("#4 scenario Hovers 3 avatars")
    public void hover(String avatarNumber, String nameOfAvatar) {
        new AvatarPage()
                .openAvatarPage("/hovers")
                .hoverOverAvatarNumber(avatarNumber)
                .verifyTextUnderAvatar(avatarNumber, nameOfAvatar);
    }


    @Test
    @Story("#5 scenario sortable data table")
    public void sortableDataTable() {
        TablePage tablePage = new TablePage();
        tablePage.openTablePage("/tables");

        List<String> expectedSorting = $$(TABLE_2_FIRST_NAME_COLUMN).texts();
        Collections.sort(expectedSorting);

        tablePage.clickOnHeaderToSortByAscending();
        List<String> actualAscendingSort = $$(TABLE_2_FIRST_NAME_COLUMN).texts();
        tablePage.assertResultHaveTheSameSorting(expectedSorting, actualAscendingSort);

        tablePage.clickOnHeaderToSortByDescending();
        Collections.reverse(expectedSorting);
        List<String> actualDescendingSort = $$(TABLE_2_FIRST_NAME_COLUMN).texts();
        tablePage.assertResultHaveTheSameSorting(expectedSorting, actualDescendingSort);
    }

}
