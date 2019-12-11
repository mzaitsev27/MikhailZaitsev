package hw5.HomePage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class HomePageSteps {

    private HomePage homePage;

    public HomePageSteps(WebDriver driver) {
        this.homePage = new HomePage(driver);
    }

    @Step("I open Epam JDI site")
    public void open(String URL) {
        homePage.open(URL);
        assertEquals(homePage.getPageTitle().trim(), "Home Page");
    }

    @Step("I login as '{0}' with password '{1}")
    public void login(final String username, final String password) {
        homePage.userIconClick();
        homePage.setTextUsernameTextField("epam");
        homePage.setTextPasswordTextField("1234");
        homePage.clickLoginButton();
    }

    @Step("Username should be '{0}' on the Home Page")
    public void usernameOnTheHomePageShouldBe(final String expectedUsername) {
        assertEquals(homePage.getUsernameLabelText(), expectedUsername);
    }

    @Step("I click at header menu item '{0}'")
    public void headerMenuItemClick(final String headerMenuItem) {
        homePage.headerMenuItemClick(headerMenuItem);
    }

    @Step("Items at service should be as expected")
    public void headerMenuServiceItemsShouldBe(List expectedServiceHeaderMenuItems) {
        assertEquals(homePage.headerMenuServiceItems(), expectedServiceHeaderMenuItems);
    }

    @Step("I click at service menu '{0}'")
    public void headerMenuServiceItemClick(final String serviceItemName) {
        homePage.headerMenuServiceItemClick(serviceItemName);
    }

    @Step("I click at left section menu item '{0}'")
    public void leftSectionMenuItemClick(final String leftSectionMenuItem) {
        homePage.leftSectionMenuItemClick(leftSectionMenuItem);
    }

    @Step("Items at left menu service should be as expected")
    public void leftSectionMenuServiceItemsShouldBe(List expectedServiceLeftSectionMenuItems) {
        assertEquals(homePage.leftSectionMenuServiceItems(), expectedServiceLeftSectionMenuItems);
    }

    @Step("Page title should be '{0}'")
    public void pageTitleShouldBe(final String expectedPageTitle) {
        assertEquals(homePage.getPageTitle(), expectedPageTitle);
    }

    @Step("Header sections should be as expected")
    public void headerSectionsShouldBe(List<String> expectedHeaderSections) {
        for (int i = 0; i < homePage.getHeaderSections().size(); i++) {
            assertEquals(homePage.getHeaderSections().get(i), expectedHeaderSections.get(i));
        }
    }

    @Step("Number of images should be '{0}'")
    public void numberOfImagesShouldBe(final int expectedNumber) {
        assertEquals(homePage.getNumberOfImages(), expectedNumber);
    }

    @Step("Text under images should be as expected")
    public void textUnderImagesShouldBe(List<String> expectedTextUnderImages) {
        for (int i = 0; i < homePage.getNumberOfImages(); i++) {
            assertEquals(homePage.getTextUnderImages().get(i), expectedTextUnderImages.get(i));
        }
    }

    @Step("Main header should be '{0}'")
    public void mainHeaderShouldBe(final String expectedMainHeader) {
        assertEquals(homePage.getMainHeader(), expectedMainHeader);
    }

    @Step("Text under main header should be '{0}'")
    public void textUnderMainHeader(final String expectedMainHeaderText) {
        assertEquals(homePage.getMainHeaderText(), expectedMainHeaderText);
    }

    @Step("Frame should be displayed")
    public void iFrameShouldBeDisplayed() {
        assertTrue(homePage.getFrame().isDisplayed());
    }

    @Step("Epam logo into frame should be displayed")
    public void epamLogoIntoFrameShouldBeDisplayed() {
        homePage.switchToFrame();
        assertTrue(homePage.getEpamLogo().isDisplayed());
        homePage.switchToDefaultContent();
    }

    @Step("Sub header should be displayed")
    public void subHeaderShouldBeDisplayed() {
        assertTrue(homePage.getSubHeader().isDisplayed());
    }

    @Step("Left section should be displayed")
    public void leftSectionShouldBeDisplayed() {
        assertTrue(homePage.getLeftSection().isDisplayed());
    }

    @Step("Footer should be displayed")
    public void footerShouldBeDisplayed() {
        assertTrue(homePage.getFooter().isDisplayed());
    }
}

