package hw4;


import hw4.AbstractBaseTest.AbstractBaseTest;
import hw4.Pages.HomePage;
import hw4.Pages.TableWithPagesPage;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.*;

public class Ex_1 extends AbstractBaseTest {


    @Test
    public void Ex_1_Test() {
        open("https://epam.github.io/JDI/index.html");
        HomePage homePage = new HomePage();


        homePage.login("epam", "1234");
        homePage.usernameLabelShouldBe("PITER CHAILOVSKII");
        homePage.dropdownHeaderServiceClick();
        homePage.serviceHeaderOptionsShouldHave
                (Arrays.asList("SUPPORT", "DATES", "SEARCH", "COMPLEX TABLE", "SIMPLE TABLE",
                        "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));

        homePage.dropdownLeftSectionServiceClick();
        homePage.serviceLeftSectionOptionsShouldHave
                (Arrays.asList("Support", "Dates", "Complex Table", "Simple Table", "Search",
                        "User Table", "Table with pages", "Different elements", "Performance"));

        homePage.dropdownHeaderServiceClick();
        homePage.openTableWithPagesWithHeaderSection();

        TableWithPagesPage tableWithPagesPage = new TableWithPagesPage();
        tableWithPagesPage.showEntriesByDefaultShouldBeFive();

        tableWithPagesPage.leftSectionShouldBe();
        tableWithPagesPage.rightSectionShouldBe();

        tableWithPagesPage.selectTenValueForEntries();
        tableWithPagesPage.showEntriesValueShouldCorrespondWithLogs();
        tableWithPagesPage.amountOfEntriesShouldBeCorrect();
        tableWithPagesPage.typeInSearchField("Custom");
        tableWithPagesPage.tableShouldContainsOnlyRecordsWithSearchValue("Custom");
    }
}
