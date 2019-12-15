package hw6.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class UserTablePage extends AbstractBasePage {

    @FindBy(xpath = "//select")
    List<WebElement> numberTypeDropdowns;

    @FindBy(xpath = "//select/option")
    List<WebElement> droplistValues;

    @FindBy(xpath = "//tbody/tr/td[1]")
    List<WebElement> numbers;

    @FindBy(xpath = "//tbody/tr/td/a")
    List<WebElement> userNames;

    @FindBy(xpath = "//tr/td/img")
    List<WebElement> descriptionImages;

    @FindBy(xpath = "//tr/td/div/span")
    List<WebElement> descriptionTextsUnderImages;

    @FindBy(xpath = "//tr/td/div/input")
    List<WebElement> checkboxes;

    @FindBy(xpath = "//ul[@class = 'panel-body-list logs']/li")
    List<WebElement> logs;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getNumbers() {
        return numbers;
    }

    public List<WebElement> getNumberTypeDropdowns() {
        return numberTypeDropdowns;
    }

    public List<WebElement> getUserNames() {
        return userNames;
    }

    public List<WebElement> getDescriptionImages() {
        return descriptionImages;
    }

    public List<WebElement> getDescriptionTextsUnderImages() {
        return descriptionTextsUnderImages;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getLogs() {
        return logs;
    }

    public List<String> getDroplistValues() {
        List<String> droplistValuesString = new ArrayList<>();
        for (int i = 0; i < droplistValues.size(); i++) {
            droplistValuesString.add(droplistValues.get(i).getText());
        }
        return droplistValuesString;
    }
}
