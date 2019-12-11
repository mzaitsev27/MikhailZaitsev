package hw5.DifferentElementsPage;

import hw3.AbstractBaseClasses.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class DifferentElementsPage extends AbstractBasePage {

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[@class = 'label-checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//label[@class = 'label-checkbox']/input")
    private List<WebElement> checkboxesInput;

    @FindBy(className = "label-radio")
    private List<WebElement> radios;

    @FindBy(tagName = "select")
    private WebElement dropdown;

    @FindBy(xpath = "//*[@class = 'uui-button']")
    private List<WebElement> buttons;

    @FindBy(id = "mCSB_2")
    private WebElement rightSection;

    @FindBy(xpath = "//label[@class = 'label-checkbox'][1]/input")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//label[@class = 'label-checkbox'][3]/input")
    private WebElement windCheckbox;

    @FindBy(xpath = "//ul[@class = 'panel-body-list logs']/li")
    private List<WebElement> logs;

    @FindBy(xpath = "//label[@class = 'label-radio']/input")
    private List<WebElement> radiosInput;

    @FindBy(xpath = "//label[@class = 'label-radio'][4]/input")
    private WebElement selenRadio;

    @FindBy(tagName = "option")
    private List<WebElement> colors;

    @FindBy(xpath = "//option[4]")
    private WebElement yellowColor;

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getCheckboxesInput() {
        return checkboxesInput;
    }

    public int getNumberOfCheckboxes() {
        return checkboxes.size();
    }

    public List<WebElement> getRadios() {
        return radios;
    }

    public List<WebElement> getRadiosInput() {
        return radiosInput;
    }

    public int getNumberOfRadios() {
        return radios.size();
    }

    public WebElement getDropdown() {
        return dropdown;
    }

    public int getNumberOfButtons() {
        return buttons.size();
    }

    public WebElement getRightSection() {
        return rightSection;
    }

    public WebElement getWaterCheckbox() {
        return waterCheckbox;
    }

    public WebElement getWindCheckbox() {
        return windCheckbox;
    }

    public List<WebElement> getLogs() {
        return logs;
    }

    public WebElement getSelenRadio() {
        return selenRadio;
    }

    public List<WebElement> getColors() {
        return colors;
    }

    public WebElement getYellowColor() {
        return yellowColor;
    }
}
