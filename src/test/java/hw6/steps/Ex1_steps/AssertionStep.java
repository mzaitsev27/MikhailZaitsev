package hw6.steps.Ex1_steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import hw6.steps.AbstractBaseStep;


import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionStep extends AbstractBaseStep {

    @Then("^username should be '([^\"]+)' on the Home page$")
    public void usernameShouldBeOnTheHomePage(String expectedUsername) {
        assertEquals(homePage.getUsernameLabelText(), expectedUsername);
    }

    @And("^4 images should be displayed$")
    public void imagesShouldBeDisplayed() {
        assertEquals(homePage.getNumberOfImages(), 4);
        assertTrue(homePage.imagesAreDisplayed());
    }

    @And("^4 texts under pictures should be displayed$")
    public void textsUnderPicturesShouldBeDisplayed() {
        assertEquals(homePage.getTextUnderImages().size(), 4);
    }

    @And("^main header should be displayed")
    public void mainHeaderHeadlineShouldbeDisplayed() {
        assertTrue(homePage.getMainHeader().isDisplayed());
    }

    @And("^main header text should be displayed$")
    public void mainHeaderDecriptionShouldbe() {
        assertTrue(homePage.getMainHeaderText().isDisplayed());
    }

    @Then("^Service dropdown should contain options$")
    public void serviceDropdownHeaderOptions(List<String> expected) {
        assertEquals(homePage.getDropdownHeader(), expected);
    }

    @Then("^Service dropdown should contain options in the left section$")
    public void serviceDropdownLeftSectionOptions(List<String> expected) {
        assertEquals(homePage.getDropdownLeftSection(), expected);
    }

    @Then("^4 Checkboxes should be displayed$")
    public void checkboxesShouldBeDisplayed() {
        assertEquals(differentElementsPage.getNumberOfCheckboxes(), 4);
    }

    @Then("^4 radios should be displayed$")
    public void radiosShouldBeDisplayed() {
        assertEquals(differentElementsPage.getNumberOfRadios(), 4);
    }

    @Then("^2 buttons should be displayed$")
    public void buttonsShouldBeDisplayed() {
        assertEquals(differentElementsPage.getNumberOfButtons(), 2);
    }

    @Then("^1 dropdown should be displayed$")
    public void dropdownShouldBeDisplayed() {
        assertTrue(differentElementsPage.getDropdown().isDisplayed());
    }

    @Then("^Right section should be displayed$")
    public void rightSectionShouldBeDisplayed() {
        assertTrue(differentElementsPage.getRightSection().isDisplayed());
    }

    @Then("^Left section should be displayed$")
    public void leftSectionShouldBeDisplayed() {
        assertTrue(differentElementsPage.getLeftSection().isDisplayed());
    }

    @Then("^Logs are displayed , checkbox name corresponding to selected$")
    public void checkboxesStatusShouldBeCorrespondedWithLogs() {
        for (int i = 0; i < differentElementsPage.getCheckboxes().size(); i++) {
            for (int j = 0; j < differentElementsPage.getLogs().size(); j++) {
                if (differentElementsPage.getLogs().get(j).getText().contains(differentElementsPage.getCheckboxes().get(i).getText())) {
                    if (differentElementsPage.getLogs().get(j).getText().endsWith("true")) {

                        assertEquals(differentElementsPage.getCheckboxesInput().get(i).isSelected(), true);
                    } else
                        assertEquals(differentElementsPage.getCheckboxesInput().get(i).isSelected(), false);
                }
                break;
            }
        }
    }

    @Then("^Logs are displayed , radio name corresponding to selected$")
    public void radiosStatusShouldBeCorrespondedWithLogs() {
        for (int i = 0; i < differentElementsPage.getRadios().size(); i++) {
            for (int j = 0; j < differentElementsPage.getLogs().size(); j++) {
                if (differentElementsPage.getLogs().get(j).getText().contains(differentElementsPage.getRadios().get(i).getText())) {
                    assertEquals(differentElementsPage.getRadiosInput().get(i).isSelected(), true);
                }
                break;
            }
            break;
        }
    }

    @Then("^Logs are displayed , color name corresponding to selected$")
    public void colorsStatusShouldBeCorrespondedWithLogs() {
        for (int i = 0; i < differentElementsPage.getColors().size(); i++) {
            for (int j = 0; j < differentElementsPage.getLogs().size(); j++) {
                if (differentElementsPage.getLogs().get(j).getText().contains(differentElementsPage.getColors().get(i).getText())) {
                    assertEquals(differentElementsPage.getColors().get(i).getText(), "Yellow");
                }
                break;
            }
        }
    }


}
