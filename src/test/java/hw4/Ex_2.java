package hw4;

import hw4.AbstractBaseTest.AbstractBaseTest;
import hw4.DataProvider.TestDataProvider;
import hw4.Pages.HomePage;
import hw4.Pages.MetalsAndColorsPage;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class Ex_2 extends AbstractBaseTest {


    @Test(dataProvider = "Data Provider",
            dataProviderClass = TestDataProvider.class)
    public void Ex_2_Test(List<Integer> summary, List<String> elements, String color
            , String metal, List<String> vegetables) {

        open("https://epam.github.io/JDI/index.html");
        HomePage homePage = new HomePage();

        homePage.login("epam", "1234");
        homePage.metalsAndColorsHeaderClick();


        MetalsAndColorsPage metalsAndColorsPage = new MetalsAndColorsPage();
        metalsAndColorsPage.setSummaryValues(summary);
        metalsAndColorsPage.setElementsValues(elements);
        metalsAndColorsPage.setColorValue(color);
        metalsAndColorsPage.setMetalValue(metal);
        metalsAndColorsPage.setVegetablesValues(vegetables);
        metalsAndColorsPage.clickSubmitButton();
        metalsAndColorsPage.assertResults(summary, elements, color, metal, vegetables);

        homePage.logout();
    }
}