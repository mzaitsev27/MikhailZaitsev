package hw_jdi.pages;


import com.epam.jdi.light.elements.composite.WebPage;
import hw_jdi.DataProvider.MetalsAndColorsData;
import hw_jdi.forms.MetalsAndColorsForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class MetalsAndColorsPage extends WebPage {

    private static MetalsAndColorsForm metalsAndColorsForm;

    @FindBy(xpath = "//ul[@class = 'panel-body-list results']/li")
    private List<WebElement> results;

    public static void fillMetalsAndColorsData(MetalsAndColorsData metalsAndColorsData) {
        metalsAndColorsForm.fillForms(metalsAndColorsData);
    }

    public void assertMetalsAndColorsData(MetalsAndColorsData metalsAndColorsData) {
        assertSummary(metalsAndColorsData.getSummary());
        assertElements(metalsAndColorsData.getElements());
        assertColor(metalsAndColorsData.getColor());
        assertMetal(metalsAndColorsData.getMetals());
        assertVegetables(metalsAndColorsData.getVegetables());
    }

    public void assertSummary(List<Integer> summary) {
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

    public void assertElements(List<String> elements) {
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).getText().contains("Elements")) {
                for (int j = 0; j < elements.size(); j++) {
                    assertTrue(results.get(i).getText().contains(elements.get(j)));
                }
            }
        }
    }


    public void assertColor(String color) {
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).getText().contains("Color")) {
                assertTrue(results.get(i).getText().contains(color));
            }
        }
    }


    public void assertMetal(String metal) {
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).getText().contains("Metal")) {
                assertTrue(results.get(i).getText().contains(metal));
            }
        }
    }


    public void assertVegetables(List<String> vegetables) {
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).getText().contains("Vegetables")) {
                for (int j = 0; j < vegetables.size(); j++) {
                    assertTrue(results.get(i).getText().contains(vegetables.get(j)));
                }
            }
        }
    }
}











