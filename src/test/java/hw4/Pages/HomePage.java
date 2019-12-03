package hw4.Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.How.ID;

public class HomePage {

    public HomePage() {
        page(this);
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
    private SelenideElement usernameLabel;

    @FindBy(xpath = "//li[@class = 'dropdown']")
    private SelenideElement dropdownHeaderService;

    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li/a")
    private List<SelenideElement> dropdownHeaderServiceCategories;

    @FindBy(xpath = "//span[text() = 'Service']")
    private SelenideElement dropdownLeftSectionService;

    @FindBy(xpath = "//ul[@class = 'sub']/li ")
    private List<SelenideElement> dropdownLeftSectionServiceCategories;

    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li[7]")
    private SelenideElement tableWithPagesFromHeaderSection;

    @FindBy(xpath = "//ul[contains(@class, 'uui-navigation nav navbar-nav')]/li[4]")
    private SelenideElement metalsAndColorsHeader;

    @FindBy(xpath = "/html/body/header/div/nav/ul[2]/li/a/span")
    private SelenideElement logoutCaret;

    @FindBy(xpath = "//i[@class = 'fa fa-sign-out']")
    private SelenideElement logoutButton;

    public void login(final String username, final String password) {
        $(userIcon).click();
        $(usernameTextField).sendKeys(username);
        $(passwordTextField).sendKeys(password);
        $(loginButton).click();
    }

    public void usernameLabelShouldBe(final String username) {
        $(usernameLabel).shouldHave(text(username));
    }

    public void dropdownHeaderServiceClick() {
        $(dropdownHeaderService).click();
    }

    public void serviceHeaderOptionsShouldHave(List<String> options) {
        $$(dropdownHeaderServiceCategories).shouldHave(textsInAnyOrder(options));
    }

    public void dropdownLeftSectionServiceClick() {
        $(dropdownLeftSectionService).click();
    }

    public void serviceLeftSectionOptionsShouldHave(List<String> options) {
        $$(dropdownLeftSectionServiceCategories).shouldHave(textsInAnyOrder(options));
    }

    public void openTableWithPagesWithHeaderSection() {
        $(tableWithPagesFromHeaderSection).click();
    }

    public void metalsAndColorsHeaderClick() {
        $(metalsAndColorsHeader).click();
    }

    public void logout() {
        $(logoutCaret).click();
        $(logoutButton).click();
    }


}
