package hw_jdi;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw_jdi.DataProvider.Data;
import hw_jdi.entities.JdiUser;
import hw_jdi.pages.JdiHomePage;
import hw_jdi.pages.MetalsAndColorsPage;
import org.openqa.selenium.WebElement;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("index.html")
    public static JdiHomePage jdiHomePage;

    @Url("metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;

    @XPath("//a[contains(text(),'Metals & Colors')]")
    private static WebElement metalsAndColorsButton;

    @XPath("/html/body/header/div/nav/ul[2]/li/a/span")
    private static Button logoutCaret;

    @XPath("//i[@class = 'fa fa-sign-out']")
    private static Button logoutButton;

    public static void open() {
        jdiHomePage.open();
    }

    public static void login(JdiUser jdiUser) {
        jdiHomePage.login(jdiUser);
    }

    public static void logout() {
        logoutCaret.click();
        logoutButton.click();
    }

    public static void openMetalsAndColorsWithHeaderMenu() {
        metalsAndColorsButton.click();
    }

    public static void fillMetalsAndColorsData(Data data) {
        metalsAndColorsPage.setColorValue(data.getColor());
        metalsAndColorsPage.setElementsValues(data.getElements());
        metalsAndColorsPage.setMetalValue(data.getMetal());
        metalsAndColorsPage.setSummaryValues(data.getSummary());
        metalsAndColorsPage.setVegetablesValues(data.getVegetables());
        metalsAndColorsPage.clickSubmitButton();
    }

    public static void assertMetalsAndColorsData(Data data) {
        metalsAndColorsPage.assertSummary(data.getSummary());
        metalsAndColorsPage.assertColor(data.getColor());
        metalsAndColorsPage.assertElements(data.getElements());
        metalsAndColorsPage.assertMetal(data.getMetal());
        metalsAndColorsPage.assertVegetables(data.getVegetables());
    }
}
