package hw5.DifferentElementsPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageSteps {

    private DifferentElementsPage differentElementsPage;

    public DifferentElementsPageSteps(WebDriver driver) {
        this.differentElementsPage = new DifferentElementsPage(driver);
    }

    @Step("Number of checkboxes should be '{0}'")
    public void checkboxesOnPageShouldBe(final int expectedNumberCheckboxes) {
        assertEquals(differentElementsPage.getNumberOfCheckboxes(), expectedNumberCheckboxes);

    }

    @Step("Number of radios should be '{0}'")
    public void radiosOnPageShouldBe(final int expectedNumberRadios) {
        assertEquals(differentElementsPage.getNumberOfRadios(), expectedNumberRadios);
    }

    @Step("Dropdown should be displayed")
    public void dropdownOnPageShouldBeDisplayed() {
        assertTrue(differentElementsPage.getDropdown().isDisplayed());
    }

    @Step("Number of buttons should be '{0}'")
    public void buttonsOnPageShouldBe(final int expectedNumberRadios) {
        assertEquals(differentElementsPage.getNumberOfButtons(), expectedNumberRadios);
    }

    @Step("Left section should be displayed")
    public void leftSectionOnPageShouldBeDisplayed() {
        assertTrue(differentElementsPage.getLeftSection().isDisplayed());
    }

    @Step("Right section should be displayed")
    public void rightSectionOnPageShouldBeDisplayed() {
        assertTrue(differentElementsPage.getRightSection().isDisplayed());
    }

    @Step("I click 'Water' checkbox")
    public void clickWaterCheckbox() {
        differentElementsPage.getWaterCheckbox().click();
    }

    @Step("I click 'Wind' checkbox ")
    public void clickWindCheckbox() {
        differentElementsPage.getWindCheckbox().click();
    }

    @Step("Checkboxes status should be correspond with logs")
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

    @Step("I click 'Selen' radio")
    public void clickSelenRadio() {
        differentElementsPage.getSelenRadio().click();
    }

    @Step("Radios status should be correspond with logs")
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

    @Step("I click 'Yellow' in dropdown")
    public void clickYellowInDropdown() {
        differentElementsPage.getDropdown().click();
        differentElementsPage.getYellowColor().click();
    }

    @Step("Colors status should be correspond with logs")
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

