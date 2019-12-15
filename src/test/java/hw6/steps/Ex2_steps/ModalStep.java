package hw6.steps.Ex2_steps;

import cucumber.api.java.en.Given;
import hw6.Pages.DifferentElementsPage;
import hw6.Pages.HomePage;
import hw6.WebDriverSingleton.WebDriverSingleton;
import hw6.steps.AbstractBaseStep;


public class ModalStep extends AbstractBaseStep {

    @Given("^I am on Home Page$")
    public void iAmOnHomePage() {
        homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());
        homePage.open();
    }
}
