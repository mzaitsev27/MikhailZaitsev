package hw6.steps.Ex2_steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import hw6.Pages.UserTablePage;
import hw6.WebDriverSingleton.WebDriverSingleton;
import hw6.steps.AbstractBaseStep;


public class ActionStep extends AbstractBaseStep {

    @And("^I login as user Piter Chailovskii$")
    public void iLoginAsUser() {
        homePage.login("epam", "1234");
    }

    @When("I click on Service button in Header$")
    public void clickOnServiceInTheHeader() {
        homePage.headerMenuServiceClick();
    }

    @And("^I click on '([^\"]+)' button in Service dropdown$")
    public void clickUserTable(String name) {
        homePage.clickServiceItem(name);
        userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
    }

    @When("^I select 'vip' checkbox for \"([^\"]*)\"$")
    public void iSelectVipCheckboxFor(String username) {
        for (int i = 0; i < userTablePage.getUserNames().size(); i++) {
            if (username.equals(userTablePage.getUserNames().get(i).getText())) {
                userTablePage.getCheckboxes().get(i).click();
            }
        }
    }


    @When("^I click on dropdown in column Type for user '([^\"]+)'$")
    public void iClickOnDropdownInColumnTypeForUserRoman(String name) {
        for (int i = 0; i < userTablePage.getUserNames().size(); i++) {
            if (name.equals(userTablePage.getUserNames().get(i).getText())) {
                userTablePage.getNumberTypeDropdowns().get(i).click();
            }
        }
    }
}
