package hw3.StepsTests;

import hw3.AbstractBaseClasses.AbstractBaseTest;
import hw3.Pages.HomePage.HomePageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static hw3.ExpectedConstantForHW3.*;

public class Ex1_Test extends AbstractBaseTest {
    private HomePageSteps homePageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
    }

    @Test
    public void Ex1_Test() {
        homePageSteps.open("https://epam.github.io/JDI/index.html");
        homePageSteps.login("epam", "1234");
        homePageSteps.usernameOnTheHomePageShouldBe("PITER CHAILOVSKII");
        homePageSteps.pageTitleShouldBe("Home Page");
        homePageSteps.headerSectionsShouldBe(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
        homePageSteps.numberOfImagesShouldBe(4);
        homePageSteps.textUnderImagesShouldBe(EXPECTED_UNDER_IMAGES_TEXT);
        homePageSteps.mainHeaderShouldBe(EXPECTED_MAIN_HEADER);
        homePageSteps.textUnderMainHeader(EXPECTED_MAIN_HEADER_TEXT);
        homePageSteps.iFrameShouldBeDisplayed();
        homePageSteps.epamLogoIntoFrameShouldBeDisplayed();
        homePageSteps.subHeaderShouldBeDisplayed();
        homePageSteps.leftSectionShouldBeDisplayed();
        homePageSteps.footerShouldBeDisplayed();


    }
}

