package hw5.StepsTests;

import hw3.AbstractBaseClasses.AbstractBaseTest;
import hw5.AttachmentListener;
import hw5.HomePage.HomePageSteps;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({AllureTestNg.class, AttachmentListener.class})
public class FailTest extends AbstractBaseTest {

    private HomePageSteps homePageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
        WebDriverSingleton.INSTANCE.setDriver(driver);
    }

    @Test
    public void FailTest() {
        homePageSteps.open("https://epam.github.io/JDI/index.html");
        homePageSteps.login("epam", "1234");
        homePageSteps.usernameOnTheHomePageShouldBe("PITER CHAILOVSKII55");
    }
}
