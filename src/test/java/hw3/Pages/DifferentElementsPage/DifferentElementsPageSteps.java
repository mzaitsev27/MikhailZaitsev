package hw3.Pages.DifferentElementsPage;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageSteps {

    private DifferentElementsPage differentElementsPage;

    public DifferentElementsPageSteps(WebDriver driver) {
        this.differentElementsPage = new DifferentElementsPage(driver);
    }

    public void checkboxesOnPageShouldBe(final int expectedNumberCheckboxes) {
        assertEquals(differentElementsPage.getNumberOfCheckboxes(), expectedNumberCheckboxes);

    }

    public void radiosOnPageShouldBe(final int expectedNumberRadios) {
        assertEquals(differentElementsPage.getNumberOfRadios(), expectedNumberRadios);
    }

    public void dropdownOnPageShouldBeDisplayed() {
        assertTrue(differentElementsPage.getDropdown().isDisplayed());
    }

    public void buttonsOnPageShouldBe(final int expectedNumberRadios) {
        assertEquals(differentElementsPage.getNumberOfButtons(), expectedNumberRadios);
    }

    public void leftSectionOnPageShouldBeDisplayed() {
        assertTrue(differentElementsPage.getLeftSection().isDisplayed());
    }

    public void rightSectionOnPageShouldBeDisplayed() {
        assertTrue(differentElementsPage.getRightSection().isDisplayed());
    }

    public void clickWaterCheckbox() {
        differentElementsPage.getWaterCheckbox().click();
    }

    public void clickWindCheckbox() {
        differentElementsPage.getWindCheckbox().click();
    }


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

    public void clickSelenRadio() {
        differentElementsPage.getSelenRadio().click();
    }

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

    public void clickYellowInDropdown() {
        differentElementsPage.getDropdown().click();
        differentElementsPage.getYellowColor().click();
    }

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

