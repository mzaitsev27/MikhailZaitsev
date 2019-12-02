package hw3.Pages.HomePage;

import org.openqa.selenium.WebDriver;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class HomePageSteps {

    private HomePage homePage;

    public HomePageSteps(WebDriver driver) {
        this.homePage = new HomePage(driver);
    }

    public void open(String URL) {
        homePage.open(URL);
        assertEquals(homePage.getPageTitle().trim(), "Home Page");
    }

    public void login(final String username, final String password) {
        homePage.userIconClick();
        homePage.setTextUsernameTextField("epam");
        homePage.setTextPasswordTextField("1234");
        homePage.clickLoginButton();
    }

    public void usernameOnTheHomePageShouldBe(final String expectedUsername) {
        assertEquals(homePage.getUsernameLabelText(), expectedUsername);
    }

    public void headerMenuItemClick(final String headerMenuItem) {
        homePage.headerMenuItemClick(headerMenuItem);
    }

    public void headerMenuServiceItemsShouldBe(List expectedServiceHeaderMenuItems) {
        assertEquals(homePage.headerMenuServiceItems(), expectedServiceHeaderMenuItems);
    }

    public void headerMenuServiceItemClick(final String serviceItemName) {
        homePage.headerMenuServiceItemClick(serviceItemName);
    }

    public void leftSectionMenuItemClick(final String leftSectionMenuItem) {
        homePage.leftSectionMenuItemClick(leftSectionMenuItem);
    }

    public void leftSectionMenuServiceItemsShouldBe(List expectedServiceLeftSectionMenuItems) {
        assertEquals(homePage.leftSectionMenuServiceItems(), expectedServiceLeftSectionMenuItems);
    }


    public void pageTitleShouldBe(final String expectedPageTitle) {
        assertEquals(homePage.getPageTitle(), expectedPageTitle);
    }

    public void headerSectionsShouldBe(List<String> expectedHeaderSections) {
        for (int i = 0; i < homePage.getHeaderSections().size(); i++) {
            assertEquals(homePage.getHeaderSections().get(i), expectedHeaderSections.get(i));
        }
    }

    public void numberOfImagesShouldBe(final int expectedNumber) {
        assertEquals(homePage.getNumberOfImages(), expectedNumber);
    }

    public void textUnderImagesShouldBe(List<String> expectedTextUnderImages) {
        for (int i = 0; i < homePage.getNumberOfImages(); i++) {
            assertEquals(homePage.getTextUnderImages().get(i), expectedTextUnderImages.get(i));
        }
    }

    public void mainHeaderShouldBe(final String expectedMainHeader) {
        assertEquals(homePage.getMainHeader(), expectedMainHeader);
    }

    public void textUnderMainHeader(final String expectedMainHeaderText) {
        assertEquals(homePage.getMainHeaderText(), expectedMainHeaderText);
    }

    public void iFrameShouldBeDisplayed() {
        assertTrue(homePage.getFrame().isDisplayed());
    }

    public void epamLogoIntoFrameShouldBeDisplayed() {
        homePage.switchToFrame();
        assertTrue(homePage.getEpamLogo().isDisplayed());
        homePage.switchToDefaultContent();
    }

    public void subHeaderShouldBeDisplayed() {
        assertTrue(homePage.getSubHeader().isDisplayed());
    }

    public void leftSectionShouldBeDisplayed() {
        assertTrue(homePage.getLeftSection().isDisplayed());
    }

    public void footerShouldBeDisplayed() {
        assertTrue(homePage.getFooter().isDisplayed());
    }
}

