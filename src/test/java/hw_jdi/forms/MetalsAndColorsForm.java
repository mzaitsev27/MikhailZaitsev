package hw_jdi.forms;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw_jdi.DataProvider.MetalsAndColorsData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class MetalsAndColorsForm extends Form<MetalsAndColorsData> {
    @XPath("//div[@id='colors']//span[@class='caret']")
    private UIElement colorsMenu;

    @XPath("//div[@id='colors']//a")
    private List<WebElement> colorsOptions;

    @XPath("//div[@id='metals']//span[@class='caret']")
    private UIElement metalsMenu;

    @XPath("//ul[@class = 'dropdown-menu inner selectpicker'][@style]/li/a/span")
    private List<UIElement> metalsOptions;

    @XPath("//button[@class='btn btn-default dropdown-toggle']//span[@class='caret']")
    private UIElement vegetablesButton;

    @XPath("//div[@id = 'vegetables']//li")
    private List<UIElement> vegetablesCheckboxes;

    @FindBy(xpath = "//section[@id = 'odds-selector']/p/label")
    private List<WebElement> oddRadios;

    @FindBy(xpath = "//section[@id = 'even-selector']/p/label")
    private List<WebElement> evensRadios;

    @XPath("//section[@id = 'elements-checklist']//label[@for]")
    private List<UIElement> elementsCheckboxes;

    @XPath("//button[@id='submit-button']")
    private Button submitButton;

    private void fillColor(String color) {
        colorsMenu.click();
        for (int i = 0; i < colorsOptions.size(); i++) {
            if (color.equals(colorsOptions.get(i).getText())) {
                colorsOptions.get(i).click();
            }
        }
    }

    private void fillMetals(String metals) {
        metalsMenu.click();
        for (int i = 0; i < metalsOptions.size(); i++) {
            if (metals.equals(metalsOptions.get(i).getText())) {
                metalsOptions.get(i).click();
            }
        }
    }

    private void fillSummary(List<Integer> summary) {
        for (int i = 0; i < summary.size(); i++) {
            if (summary.get(i) % 2 != 0) {
                oddRadios.get((summary.get(i) / 2)).click();
            } else
                evensRadios.get((summary.get(i) / 2) - 1).click();
        }
    }

    private void fillElements(List<String> elements) {
        for (int i = 0; i < elementsCheckboxes.size(); i++) {
            for (int j = 0; j < elements.size(); j++) {
                if (elements.get(j).equals(elementsCheckboxes.get(i).getText())) {
                    elementsCheckboxes.get(i).click();
                }
            }
        }
    }

    private void fillVegetables(List<String> vegetables) {
        vegetablesButton.click();
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

    public void fillForms(MetalsAndColorsData metalsAndColorsData) {
        fillColor(metalsAndColorsData.getColor());
        fillSummary(metalsAndColorsData.getSummary());
        fillElements(metalsAndColorsData.getElements());
        fillVegetables(metalsAndColorsData.getVegetables());
        fillMetals(metalsAndColorsData.getMetals());
        submitButton.click();
    }
}

