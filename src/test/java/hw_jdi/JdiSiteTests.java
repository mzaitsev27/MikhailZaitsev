package hw_jdi;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw_jdi.DataProvider.MetalsAndColorsData;
import hw_jdi.DataProvider.MetalsAndColorsDataProvider;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static hw_jdi.entities.JdiUser.ROMAN;


public class JdiSiteTests {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }


    @Test(dataProvider = "Metals And Colors Data Provider", dataProviderClass = MetalsAndColorsDataProvider.class)
    public void jdiTest(MetalsAndColorsData metalsAndColorsData) {
        JdiSite.open();
        JdiSite.login(ROMAN);
        JdiSite.openMetalsAndColorsWithHeaderMenu();
        JdiSite.metalsAndColorsPage.fillMetalsAndColorsData(metalsAndColorsData);
        JdiSite.metalsAndColorsPage.assertMetalsAndColorsData(metalsAndColorsData);
        JdiSite.logout();
    }
}
