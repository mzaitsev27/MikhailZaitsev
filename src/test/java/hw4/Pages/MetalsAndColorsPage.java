package hw4.Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MetalsAndColorsPage {
    public MetalsAndColorsPage() {
        page(this);
    }


    @FindBy(xpath = "//section[@id = 'odds-selector']/p/label")
    private List<WebElement> oddRadios;

    @FindBy(xpath = "//section[@id = 'even-selector']/p/label")
    private List<WebElement> evensRadios;

    @FindBy(xpath = "//section[@id = 'elements-checklist']//label[@for]")
    private List<WebElement> elementsCheckboxes;

    @FindBy(xpath = "//button[@type = 'button'][@title = 'Colors']")
    private WebElement colorsMenu;

    @FindBy(xpath = "//ul[@class = 'dropdown-menu inner selectpicker'][@style]/li/a/span")
    private List<WebElement> colorsOptions;

    @FindBy(xpath = "//button[@type = 'button'][@title = 'Metals']/span[2]")
    private WebElement metalsMenu;

    @FindBy(xpath = "//ul[@class = 'dropdown-menu inner selectpicker'][@style]/li/a/span")
    private List<WebElement> metalsOptions;

    @FindBy(xpath = "//button[@type = 'button'][@aria-haspopup = 'true']")
    private WebElement vegetablesMenu;

    @FindBy(xpath = "//ul[@class = 'dropdown-menu'][@style]/li/a/input")
    private List<WebElement> vegetablesCheckboxesInput;

    @FindBy(xpath = "//ul[@class = 'dropdown-menu'][@style]/li/a/label")
    private List<WebElement> vegetablesCheckboxes;

    @FindBy(xpath = "//button[@id = 'submit-button']")
    private WebElement submitButton;

    @FindBy(xpath = "//ul[@class = 'panel-body-list results']/li")
    private List<WebElement> results;


    public void setSummaryValues(List<Integer> values) {
        if (values != null) {
            for (int i = 0; i < values.size(); i++) {
                if (values.get(i) % 2 != 0) {
                    oddRadios.get((values.get(i) / 2)).click();
                } else
                    evensRadios.get((values.get(i) / 2) - 1).click();
            }
        }
    }

    public void setElementsValues(List<String> elements) {
        if (elements != null) {
            for (int i = 0; i < elementsCheckboxes.size(); i++) {
                for (int j = 0; j < elements.size(); j++) {
                    if (elements.get(j).equals(elementsCheckboxes.get(i).getText())) {
                        elementsCheckboxes.get(i).click();
                    }
                }
            }
        }
    }

    public void setColorValue(String color) {
        if (color != null) {
            colorsMenu.click();
            for (int i = 0; i < colorsOptions.size(); i++) {
                if (color.equals(colorsOptions.get(i).getText())) {
                    colorsOptions.get(i).click();
                }
            }
        }
    }

    public void setMetalValue(String metal) {
        if (metal != null) {
            metalsMenu.click();
            for (int i = 0; i < metalsOptions.size(); i++) {
                if (metal.equals(metalsOptions.get(i).getText())) {
                    metalsOptions.get(i).click();
                }
            }
        }
    }

    public void setVegetablesValues(List<String> vegetables) {
        if (vegetables != null) {
            vegetablesMenu.click();
            for (int i = 0; i < vegetablesCheckboxes.size(); i++) {
                for (int j = 0; j < vegetables.size(); j++) {
                    if ("Vegetables".equals(vegetables.get(j))) {
                        continue;
                    }
                    if (vegetables.get(j).equals(vegetablesCheckboxes.get(i).getText())) {
                        vegetablesCheckboxes.get(i).click();
                    }
                }
            }
        }
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void assertResults(List<Integer> summary, List<String> elements, String color
            , String metal, List<String> vegetables) {

        assertSummary(summary);
        assertElements(elements);
        assertColor(color);
        assertMetal(metal);
        assertVegetables(vegetables);

    }

    public void assertSummary(List<Integer> summary) {
        if (summary != null) {
            Integer actual = 0;
            for (int j = 0; j < summary.size(); j++) {
                actual += summary.get(j);
            }

            for (int i = 0; i < results.size(); i++) {
                if (results.get(i).getText().contains("Summary")) {
                    assertTrue(results.get(i).getText().contains(actual.toString()));
                }
            }
        }
    }

    public void assertElements(List<String> elements) {
        if (elements != null) {
            for (int i = 0; i < results.size(); i++) {
                if (results.get(i).getText().contains("Elements")) {
                    for (int j = 0; j < elements.size(); j++) {
                        assertTrue(results.get(i).getText().contains(elements.get(j)));
                    }
                }
            }
        }
    }

    public void assertColor(String color) {
        if (color != null) {
            for (int i = 0; i < results.size(); i++) {
                if (results.get(i).getText().contains("Color")) {
                    assertTrue(results.get(i).getText().contains(color));
                }
            }
        }
    }

    public void assertMetal(String metal) {
        if (metal != null) {
            for (int i = 0; i < results.size(); i++) {
                if (results.get(i).getText().contains("Metal")) {
                    assertTrue(results.get(i).getText().contains(metal));
                }
            }
        }
    }

    public void assertVegetables(List<String> vegetables) {
        if (vegetables != null) {
            for (int i = 0; i < results.size(); i++) {
                if (results.get(i).getText().contains("Vegetables")) {
                    for (int j = 0; j < vegetables.size(); j++) {
                        assertTrue(results.get(i).getText().contains(vegetables.get(j)));
                    }
                }
            }
        }
    }
}










