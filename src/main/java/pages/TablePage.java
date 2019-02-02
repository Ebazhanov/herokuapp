package pages;

import edu.emory.mathcs.backport.java.util.Collections;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static jdk.nashorn.internal.objects.Global.println;
import static org.testng.Assert.assertEquals;

public class TablePage {

    private static final String FIRST_NAME_HEADER_COLUMN = "#table2 tr th:nth-child(2)";
    public static final String TABLE_2_FIRST_NAME_COLUMN = "#table2 > tbody .first-name";

    @Step
    public TablePage openTablePage(String tableUrl) {
        open(tableUrl);
        return this;
    }

    @Step
    public TablePage sortResultsByAsceding(List<String> firstNameColumnExpectedSort) {

        return this;
    }

    @Step
    public TablePage clickOnHeaderToSortByAscending() {
        $(FIRST_NAME_HEADER_COLUMN).click();
        return this;
    }

    @Step
    public TablePage assertResultHaveTheSameSorting(List<String> firstNameColumnExpectedSort,
                                                    List<String> firstNameColumnActualSort) {
        assertEquals(firstNameColumnExpectedSort, firstNameColumnActualSort);
        return this;
    }

    @Step
    public TablePage sortResultsByDescending(List<String> firstNameColumnExpectedSort) {

        return this;
    }

    @Step
    public TablePage clickOnHeaderToSortByDescending() {
        $(FIRST_NAME_HEADER_COLUMN).click();
        return this;
    }

}
