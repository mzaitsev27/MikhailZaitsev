package hw6.steps.Ex2_steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hw6.steps.AbstractBaseStep;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionStep extends AbstractBaseStep {

    @Then("^'([^\"]+)' page is opened$")
    public void pageIsOpened(final String pageTitle) {
        assertEquals(userTablePage.getPageTitle(), pageTitle);
    }

    @And("^(\\d+) NumberType Dropdowns should be displayed$")
    public void numbertypeDropdownsShouldBeDisplayed(int expected) {
        assertEquals(userTablePage.getNumberTypeDropdowns().size(), expected);
    }

    @And("^(\\d+) User names should be displayed$")
    public void userNamesShouldBeDisplayed(int expected) {
        assertEquals(userTablePage.getUserNames().size(), expected);
    }

    @And("^(\\d+) Description images should be displayed$")
    public void descriptionimagesShouldBeDisplayed(int expected) {
        assertEquals(userTablePage.getDescriptionImages().size(), expected);
    }

    @And("^(\\d+) Description texts under images should be displayed$")
    public void descriptionTextsUndermagesShouldBeDisplayed(int expected) {
        assertEquals(userTablePage.getDescriptionTextsUnderImages().size(), expected);
    }

    @And("^(\\d+) checkboxes should be displayed$")
    public void checkboxesShouldBeDisplayed(int expected) {
        assertEquals(userTablePage.getCheckboxes().size(), expected);
    }

    @And("^User table contains following values:$")
    public void userTableContainsFollowingValues(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < table.size(); i++) {
            assertEquals(userTablePage.getNumbers().get(i).getText(), table.get(i).get("Number"));
            assertEquals(userTablePage.getUserNames().get(i).getText(), table.get(i).get("User"));
            assertEquals(userTablePage.getDescriptionTextsUnderImages().get(i).getText().trim().replaceAll("\\n", " "),
                    table.get(i).get("Description").trim());
        }
    }

    @Then("^(\\d+) log row has \"([^\"]*)\" text in log section$")
    public void logRowHasTextInLogSection(int logsRow, String logsText) {
        assertEquals(userTablePage.getLogs().size(), logsRow);
        assertTrue(userTablePage.getLogs().get(0).getText().contains(logsText));
    }

    @Then("^droplist contains values$")
    public void droplistContainsValues(List<String> expected) {
        assertTrue(expected.containsAll(userTablePage.getDroplistValues()));
    }
}
