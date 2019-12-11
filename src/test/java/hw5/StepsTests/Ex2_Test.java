package hw5.StepsTests;

import hw3.AbstractBaseClasses.AbstractBaseTest;
import hw5.DifferentElementsPage.DifferentElementsPageSteps;
import hw5.HomePage.HomePageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static hw3.ExpectedConstantForHW3.EXPECTED_SERVICE_HEADER_MENU_ITEMS;
import static hw3.ExpectedConstantForHW3.EXPECTED_SERVICE_LEFT_SECTION_MENU_ITEMS;

public class Ex2_Test extends AbstractBaseTest {
    private HomePageSteps homePageSteps;
    private DifferentElementsPageSteps differentElementsPageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
        differentElementsPageSteps = new DifferentElementsPageSteps(driver);
    }

    @Test
    public void Ex2_Test() {
        homePageSteps.open("https://epam.github.io/JDI/index.html");
        homePageSteps.login("epam", "1234");
        homePageSteps.usernameOnTheHomePageShouldBe("PITER CHAILOVSKII");

        homePageSteps.headerMenuItemClick("SERVICE");
        homePageSteps.headerMenuServiceItemsShouldBe(EXPECTED_SERVICE_HEADER_MENU_ITEMS);

        homePageSteps.leftSectionMenuItemClick("Service");
        homePageSteps.leftSectionMenuServiceItemsShouldBe(EXPECTED_SERVICE_LEFT_SECTION_MENU_ITEMS);

        homePageSteps.headerMenuItemClick("SERVICE");
        homePageSteps.headerMenuServiceItemClick("DIFFERENT ELEMENTS");

        differentElementsPageSteps.checkboxesOnPageShouldBe(4);
        differentElementsPageSteps.radiosOnPageShouldBe(4);
        differentElementsPageSteps.dropdownOnPageShouldBeDisplayed();
        differentElementsPageSteps.buttonsOnPageShouldBe(2);

        differentElementsPageSteps.leftSectionOnPageShouldBeDisplayed();
        differentElementsPageSteps.rightSectionOnPageShouldBeDisplayed();

        differentElementsPageSteps.clickWaterCheckbox();
        differentElementsPageSteps.clickWindCheckbox();
        differentElementsPageSteps.checkboxesStatusShouldBeCorrespondedWithLogs();

        differentElementsPageSteps.clickSelenRadio();
        differentElementsPageSteps.radiosStatusShouldBeCorrespondedWithLogs();

        differentElementsPageSteps.clickYellowInDropdown();
        differentElementsPageSteps.colorsStatusShouldBeCorrespondedWithLogs();

        differentElementsPageSteps.clickWaterCheckbox();
        differentElementsPageSteps.clickWindCheckbox();
        differentElementsPageSteps.checkboxesStatusShouldBeCorrespondedWithLogs();
    }
}

