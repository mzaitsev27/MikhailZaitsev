package hw3.Pages.HomePage;

import hw3.AbstractBaseClasses.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.ID;

public class HomePage extends AbstractBasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


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

    @FindBy(id = "iframe")
    WebElement frame;

    @FindBy(xpath = "//div[@class='epam-logo']//a//img")
    WebElement epam_logo;

    @FindBy(xpath = "//a[@href = 'https://github.com/epam/JDI']")
    WebElement subHeader;

    @FindBy(name = "navigation-sidebar")
    WebElement leftSection;

    @FindBy(tagName = "footer")
    WebElement footer;

    public String getUsernameLabelText() {
        return usernameLabel.getText();
    }

    public void open(String URL) {
        driver.get(URL);
    }

    public void userIconClick() {
        userIcon.click();
    }

    public void setTextUsernameTextField(final String username) {
        usernameTextField.sendKeys(username);
    }

    public void setTextPasswordTextField(final String password) {
        passwordTextField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public List<String> getHeaderSections() {
        List<String> headerSectionsTextString = new ArrayList<>();
        for (int i = 0; i < headerSections.size(); i++) {
            headerSectionsTextString.add(headerSections.get(i).getText());
        }
        return headerSectionsTextString;
    }

    public int getNumberOfImages() {
        return images.size();
    }

    public List<String> getTextUnderImages() {
        List<String> underImagesTextString = new ArrayList<>();
        for (int i = 0; i < underImagesText.size(); i++) {
            underImagesTextString.add(underImagesText.get(i).getText());
        }
        return underImagesTextString;
    }

    public String getMainHeader() {
        return mainHeader.getText();
    }

    public String getMainHeaderText() {
        return mainHeaderText.getText();
    }

    public WebElement getFrame() {
        return frame;
    }

    public void switchToFrame() {
        driver.switchTo().frame("iframe");
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public WebElement getEpamLogo() {
        return epam_logo;
    }

    public WebElement getSubHeader() {
        return subHeader;
    }


    public WebElement getLeftSection() {
        return leftSection;
    }

    public WebElement getFooter() {
        return footer;
    }
}
