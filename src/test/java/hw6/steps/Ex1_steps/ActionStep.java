package hw6.steps.Ex1_steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import hw6.steps.AbstractBaseStep;


public class ActionStep extends AbstractBaseStep {

    @When("^I login as user '([^\"]+)' with password '([^\"]+)' on the Home page$")
    public void login(String username, String password) {
        homePage.login(username, password);
    }

    @When("^I click on Service subcategory in the header$")
    public void clickOnServiceInTheHeader() {
        homePage.headerMenuServiceClick();
    }

    @When("^I click on Service subcategory in the left section$")
    public void clickOnServiceInTheLeftSection() {
        homePage.leftSectionMenuServiceClick();
    }

    @When("^I select Water and Wind checkboxes$")
    public void selectOnWaterAndWindCheckboxes() {
        differentElementsPage.getWaterCheckbox().click();
        differentElementsPage.getWindCheckbox().click();
    }

    @When("^I select Selen radio$")
    public void clickOnSelenRadio() {
        differentElementsPage.getSelenRadio().click();
    }

    @When("^I select Yellow in dropdown$")
    public void clickOnYellowInDropdown() {
        differentElementsPage.getDropdown().click();
        differentElementsPage.getYellowColor().click();
    }

    @When("^I unselect Water and Wind checkboxes$")
    public void unselectWaterAndWindCheckboxes() {
        differentElementsPage.getWaterCheckbox().click();
        differentElementsPage.getWindCheckbox().click();
    }

}
