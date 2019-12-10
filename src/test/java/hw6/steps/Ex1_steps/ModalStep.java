package hw6.steps.Ex1_steps;

import cucumber.api.java.en.Given;
import hw6.Pages.DifferentElementsPage;
import hw6.Pages.HomePage;
import hw6.WebDriverSingleton.WebDriverSingleton;
import hw6.steps.AbstractBaseStep;


public class ModalStep extends AbstractBaseStep {

    @Given("^I open EPAM JDI Site$")
    public void iOpenEpamJdiSite() {
        homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());
        homePage.open();
    }

    @Given("^I click on '([^\"]+)' option in the header$")
    public void clickOnDifferentElementsInTheHeader(String name) {
        homePage.clickServiceItem(name);
        differentElementsPage = new DifferentElementsPage(WebDriverSingleton.INSTANCE.getDriver());
    }

}
