package hw6.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.ID;

public class HomePage extends AbstractBasePage {

    private static final String URL = "https://epam.github.io/JDI/index.html";

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(how = CSS, using = "#name")
    private WebElement usernameTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(how = ID, using = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement usernameLabel;

    @FindBy(xpath = "//ul[contains(@class, 'uui-navigation nav navbar-nav')]/li/a")
    private List<WebElement> headerSections;

    @FindBy(className = "benefit-icon")
    List<WebElement> images;

    @FindBy(className = "benefit-txt")
    List<WebElement> underImagesText;

    @FindBy(name = "main-title")
    WebElement mainHeader;

    @FindBy(name = "jdi-text")
    WebElement mainHeaderText;

    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    List<WebElement> dropdownMenuHeader;

    @FindBy(xpath = "//ul[@class = 'sub']/li")
    List<WebElement> dropdownMenuLeftSection;

    @FindBy(linkText = "USER TABLE")
    WebElement userTable;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL);
    }

    public void login(final String username, final String password) {
        userIcon.click();
        usernameTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }

    public String getUsernameLabelText() {
        return usernameLabel.getText();
    }

    public int getNumberOfImages() {
        return images.size();
    }

    public boolean imagesAreDisplayed() {
        boolean result = true;
        for (int i = 0; i < images.size(); i++) {
            if (!images.get(i).isDisplayed()) {
                result = false;
            }
        }
        return result;
    }

    public List<String> getTextUnderImages() {
        List<String> underImagesTextString = new ArrayList<>();
        for (int i = 0; i < underImagesText.size(); i++) {
            underImagesTextString.add(underImagesText.get(i).getText());
        }
        return underImagesTextString;
    }

    public WebElement getMainHeader() {
        return mainHeader;
    }

    public WebElement getMainHeaderText() {
        return mainHeaderText;
    }

    public List<String> getDropdownHeader() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < dropdownMenuHeader.size(); i++) {
            result.add(dropdownMenuHeader.get(i).getText());
        }
        return result;
    }

    public List<String> getDropdownLeftSection() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < dropdownMenuLeftSection.size(); i++) {
            result.add(dropdownMenuLeftSection.get(i).getText());
        }
        return result;
    }

    public void clickServiceItem(String name) {
        headerMenuServiceClick();
        for (int i = 0; i < dropdownMenuHeader.size(); i++) {
            if (name.equals(dropdownMenuHeader.get(i).getText())) {
                dropdownMenuHeader.get(i).click();
                break;
            }
        }
    }

}
